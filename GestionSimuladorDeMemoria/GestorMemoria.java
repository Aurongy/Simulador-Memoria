import java.util.*;

public class GestorMemoria {

    private List<BloqueMemoria> bloques;
    private Queue<Proceso> colaEspera;
    private int memoriaTotal;
    private int contadorBloques = 1;
    private int contadorProcesos = 1;
    private Runnable onUpdate;

    public GestorMemoria() {

        bloques = new ArrayList<>();
        colaEspera = new LinkedList<>();

        generarBloquesAleatorios();
    }
    private void generarBloquesAleatorios() {

        Random random = new Random();

        // Cantidad de bloques entre 5 y 10
        int cantidadBloques = random.nextInt(6) + 5;

        memoriaTotal = 0;

        for (int i = 0; i < cantidadBloques; i++) {

            // Tamaño aleatorio entre 10 y 120 MB
            int tamano = random.nextInt(111) + 10;

            memoriaTotal += tamano;

            bloques.add(new BloqueMemoria(contadorBloques++, tamano));
        }
    }
    public void setOnUpdate(Runnable onUpdate) {
        this.onUpdate = onUpdate;
    }
    public synchronized boolean asignarProceso(int tamanoProceso) {

        String nombreProceso = "P" + contadorProcesos++;

        for (int i = 0; i < bloques.size(); i++) {

            BloqueMemoria bloque = bloques.get(i);

            // PRIMER AJUSTE
            if (!bloque.isOcupado() &&
                    bloque.getTamano() >= tamanoProceso) {

                // ============================
                // PARTICIÓN DINÁMICA
                // ============================

                // Si el bloque es más grande
                // se divide
                if (bloque.getTamano() > tamanoProceso) {

                    int restante =
                            bloque.getTamano() - tamanoProceso;

                    // NUEVO BLOQUE OCUPADO
                    BloqueMemoria ocupado =
                            new BloqueMemoria(
                                    bloque.getId(),
                                    tamanoProceso);

                    ocupado.setOcupado(true, nombreProceso);
                    ocupado.setMemoriaUsada(tamanoProceso);

                    // NUEVO BLOQUE LIBRE
                    BloqueMemoria libre =
                            new BloqueMemoria(
                                    contadorBloques++,
                                    restante);

                    // Reemplazar bloque actual
                    bloques.set(i, ocupado);

                    // Insertar bloque libre restante
                    bloques.add(i + 1, libre);

                } else {

                    // Ajuste exacto
                    bloque.setOcupado(true, nombreProceso);
                    bloque.setMemoriaUsada(tamanoProceso);
                }

                actualizar();
                return true;
            }
        }

        actualizar();
        return false;
    }

    public synchronized void liberarBloque(int id) {

        for (BloqueMemoria bloque : bloques) {

            if (bloque.getId() == id) {

                bloque.setOcupado(false, "Libre");
                bloque.setMemoriaUsada(0);
            }
        }

        actualizar();
    }
    private void actualizar() {

        if (onUpdate != null) {
            onUpdate.run();
        }
    }

    public List<BloqueMemoria> getBloques() {
        return bloques;
    }

    public int getCapacidadTotal() {
        return memoriaTotal;
    }

    public int getMemoriaUsada() {

        int suma = 0;

        for (BloqueMemoria b : bloques) {
            suma += b.getMemoriaUsada();
        }

        return suma;
    }

    public int getMemoriaLibre() {
        return memoriaTotal - getMemoriaUsada();
    }

    public int getTotalProcesos() {

        int contador = 0;

        for (BloqueMemoria b : bloques) {
            if (b.isOcupado()) {
                contador++;
            }
        }

        return contador;
    }

    public String obtenerResumen() {

        StringBuilder sb = new StringBuilder();

        sb.append("ESTADO ACTUAL DE MEMORIA\n\n");

        for (BloqueMemoria b : bloques) {
            sb.append(b.toString()).append("\n");
        }

        sb.append("\nMemoria Total: ")
                .append(memoriaTotal)
                .append(" MB\n");

        sb.append("Memoria Usada: ")
                .append(getMemoriaUsada())
                .append(" MB\n");

        sb.append("Memoria Libre: ")
                .append(getMemoriaLibre())
                .append(" MB\n");

        return sb.toString();
    }
}
