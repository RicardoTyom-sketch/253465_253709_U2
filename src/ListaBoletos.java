public class ListaBoletos {
    private Nodo inicio;
    private int cantidad;

    public ListaBoletos() {
        inicio = null;
        cantidad = 0;
    }
    public boolean agregar(Pasajero pasajero) {
        int asiento = pasajero.getAsiento();
        Nodo anterior = null;
        Nodo actual = inicio;

        while (actual != null && actual.dato.getAsiento() < asiento) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null && actual.dato.getAsiento() == asiento) {
            return false;
        }

        Nodo nuevo = new Nodo(pasajero);
        nuevo.siguiente = actual;
        if (anterior == null) {
            inicio = nuevo;
        } else {
            anterior.siguiente = nuevo;
        }
        cantidad++;
        return true;
    }
    public Pasajero buscarPorAsiento(int asiento) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato.getAsiento() == asiento) {
                return actual.dato;
            }
            if (actual.dato.getAsiento() > asiento) {
                return null;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String listar() {
        if (inicio == null) {
            return "Aun no hay boletos vendidos.";
        }
        StringBuilder salida = new StringBuilder("\nREGISTRO DE BOLETOS VENDIDOS\n");
        Nodo actual = inicio;
        while (actual != null) {
            Pasajero pasajero = actual.dato;
            salida.append("Asiento ").append(pasajero.getAsiento())
                  .append(" | ").append(pasajero.getNombre()).append('\n');
            actual = actual.siguiente;
        }
        return salida.toString();
    }

    public String generarFilasChecklist() {
        StringBuilder salida = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null) {
            Pasajero pasajero = actual.dato;
            String estado;
            if (pasajero.isAbordo()) {
                estado = "PRESENTE";
            } else if (pasajero.isEnFila()) {
                estado = "EN FILA";
            } else {
                estado = "AUSENTE";
            }
            salida.append(String.format("%-10d %-20s %-12s%n",
                    pasajero.getAsiento(), pasajero.getNombre(), estado));
            actual = actual.siguiente;
        }
        return salida.toString();
    }
}
