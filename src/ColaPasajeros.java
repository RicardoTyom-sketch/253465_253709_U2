public class ColaPasajeros {
    private Nodo frente;
    private Nodo fin;
    private int cantidad;

    public ColaPasajeros() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    public void encolar(Pasajero pasajero) {
        Nodo nuevo = new Nodo(pasajero);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        cantidad++;
    }

    public Pasajero desencolar() {
        if (estaVacia()) {
            return null;
        }
        Pasajero primero = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        cantidad--;
        return primero;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String mostrarFila() {
        if (estaVacia()) {
            return "La fila esta vacia.";
        }
        StringBuilder texto = new StringBuilder("\nFILA DE ABORDAJE (frente -> fin)\n");
        Nodo actual = frente;
        int posicion = 1;
        while (actual != null) {
            texto.append(posicion).append(". ")
                 .append(actual.dato.getNombre())
                 .append(" | Asiento ")
                 .append(actual.dato.getAsiento()).append('\n');
            actual = actual.siguiente;
            posicion++;
        }
        return texto.toString();
    }
}
