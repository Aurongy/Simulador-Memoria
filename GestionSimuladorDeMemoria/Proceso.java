public class Proceso {
    private String nombre;
    private int tamano;
    private int tiempo; 
    public Proceso(String nombre, int tamano, int tiempo) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.tiempo = tiempo;
    }

    public String getNombre() { return nombre; }
    public int getTamano() { return tamano; }
    public int getTiempo() { return tiempo; }

    @Override
    public String toString() {
        return nombre + " (" + tamano + " MB, " + tiempo + "s)";
    }
}
