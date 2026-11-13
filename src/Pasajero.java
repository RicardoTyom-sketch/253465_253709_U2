public class Pasajero {
    private final String nombre;
    private final int asiento;
    private boolean enFila;
    private boolean abordo;

    public Pasajero(String nombre, int asiento) {
        this.nombre = nombre.trim();
        this.asiento = asiento;
        this.enFila = false;
        this.abordo = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAsiento() {
        return asiento;
    }

    public boolean isEnFila() {
        return enFila;
    }

    public void setEnFila(boolean enFila) {
        this.enFila = enFila;
    }

    public boolean isAbordo() {
        return abordo;
    }

    public void setAbordo(boolean abordo) {
        this.abordo = abordo;
    }
}
