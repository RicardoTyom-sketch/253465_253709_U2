public class RegistroAutobus {
    private final int capacidad;
    private final ListaBoletos boletos;
    private final ColaPasajeros fila;
    private int abordados;

    public RegistroAutobus(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        this.capacidad = capacidad;
        boletos = new ListaBoletos();
        fila = new ColaPasajeros();
        abordados = 0;
    }

    public String venderBoleto(String nombre, int asiento) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "ERROR: El nombre del pasajero no puede estar vacio.";
        }
        if (asiento < 1 || asiento > capacidad) {
            return "ERROR: El asiento debe estar entre 1 y " + capacidad + ".";
        }
        Pasajero nuevo = new Pasajero(nombre, asiento);
        if (!boletos.agregar(nuevo)) {
            return "ERROR: El asiento " + asiento + " ya tiene un boleto vendido.";
        }
        return "Boleto registrado: " + nuevo.getNombre() + " | Asiento " + asiento + ".";
    }

    public String registrarLlegada(int asiento) {
        Pasajero pasajero = boletos.buscarPorAsiento(asiento);
        if (pasajero == null) {
            return "ERROR: No existe un boleto vendido para ese asiento.";
        }
        if (pasajero.isAbordo()) {
            return "ERROR: Este pasajero ya abordo el autobus.";
        }
        if (pasajero.isEnFila()) {
            return "ERROR: El pasajero ya esta formado.";
        }
        fila.encolar(pasajero);
        pasajero.setEnFila(true);
        return "Se formo: " + pasajero.getNombre() + " (asiento " + asiento + ").";
    }

    public String abordarSiguiente() {
        Pasajero pasajero = fila.desencolar();
        if (pasajero == null) {
            return "No hay pasajeros en la fila.";
        }
        pasajero.setEnFila(false);
        pasajero.setAbordo(true);
        abordados++;
        return "Abordo: " + pasajero.getNombre() + " | Asiento " + pasajero.getAsiento() + ".";
    }

    public String abordarTodos() {
        if (fila.estaVacia()) {
            return "No hay pasajeros en la fila.";
        }
        StringBuilder salida = new StringBuilder("\nABORDAJE EN ORDEN DE LLEGADA\n");
        while (!fila.estaVacia()) {
            salida.append(abordarSiguiente()).append('\n');
        }
        return salida.toString();
    }

    public String mostrarFila() {
        return fila.mostrarFila();
    }

    public String listarBoletos() {
        return boletos.listar();
    }

    public String generarChecklist() {
        int vendidos = boletos.getCantidad();
        if (vendidos == 0) {
            return "No se puede generar el checklist: aun no hay boletos vendidos.";
        }
        StringBuilder salida = new StringBuilder();
        salida.append("\n========== INSPECCION FINAL / CHECKLIST ==========\n");
        salida.append(String.format("%-10s %-20s %-12s%n", "ASIENTO", "PASAJERO", "ESTADO"));
        salida.append("--------------------------------------------\n");
        salida.append(boletos.generarFilasChecklist());
        salida.append("--------------------------------------------\n");
        salida.append("Boletos vendidos: ").append(vendidos).append('\n');
        int esperando = fila.getCantidad();
        int ausentes = vendidos - abordados - esperando;
        salida.append("Pasajeros a bordo: ").append(abordados).append('\n');
        salida.append("Pasajeros ausentes: ").append(ausentes).append('\n');
        salida.append("Pasajeros aun en fila: ").append(esperando).append('\n');
        if (vendidos == abordados) {
            salida.append("RESULTADO: COINCIDE. Todos los pasajeros con boleto estan a bordo.\n");
        } else if (esperando > 0 && ausentes > 0) {
            salida.append("RESULTADO: INSPECCION PENDIENTE. Hay pasajeros en fila y ausentes.\n");
        } else if (esperando > 0) {
            salida.append("RESULTADO: INSPECCION PENDIENTE. Aun hay pasajeros en fila.\n");
        } else {
            salida.append("RESULTADO: NO COINCIDE. Hay boletos vendidos sin pasajero a bordo.\n");
        }
        return salida.toString();
    }

    public int getVendidos() {
        return boletos.getCantidad();
    }

    public int getAbordados() {
        return abordados;
    }

    public int getEnFila() {
        return fila.getCantidad();
    }
}
