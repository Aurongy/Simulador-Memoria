public class BloqueMemoria {

    private int id;
    private int tamano;
    private boolean ocupado;
    private String proceso;
    private int memoriaUsada;

    public BloqueMemoria(int id, int tamano) {

        this.id = id;
        this.tamano = tamano;
        this.ocupado = false;
        this.proceso = "Libre";
        this.memoriaUsada = 0;
    }

    public int getId() {
        return id;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getProceso() {
        return proceso;
    }

    public int getMemoriaUsada() {
        return memoriaUsada;
    }

    public void setMemoriaUsada(int memoriaUsada) {
        this.memoriaUsada = memoriaUsada;
    }


    public void setOcupado(boolean ocupado, String proceso) {

        this.ocupado = ocupado;
        this.proceso = proceso;
    }

    @Override
    public String toString() {

        return "Bloque " + id +
                " | Tamaño: " + tamano + " MB" +
                " | Estado: " +
                (ocupado ? "Ocupado por " + proceso : "Libre");
    }
}