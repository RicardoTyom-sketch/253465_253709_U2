import java.util.Scanner;
public class Main {
    private static final int CAPACIDAD_AUTOBUS = 30;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        RegistroAutobus sistema = new RegistroAutobus(CAPACIDAD_AUTOBUS);
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(teclado, "Elige una opcion: ");
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del pasajero: ");
                    String nombre = teclado.nextLine();
                    int asiento = leerEntero(teclado, "Numero de asiento: ");
                    System.out.println(sistema.venderBoleto(nombre, asiento));
                    break;
                case 2:
                    int llegada = leerEntero(teclado, "Asiento del pasajero que llego: ");
                    System.out.println(sistema.registrarLlegada(llegada));
                    break;
                case 3:
                    System.out.println(sistema.mostrarFila());
                    break;
                case 4:
                    System.out.println(sistema.abordarSiguiente());
                    break;
                case 5:
                    System.out.println(sistema.listarBoletos());
                    break;
                case 6:
                    System.out.println(sistema.generarChecklist());
                    break;
                case 7:
                    System.out.println(sistema.abordarTodos());
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
        teclado.close();
    }

    private static int leerEntero(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n========== LINEA DE AUTOBUSES ==========");
        System.out.println("1. Vender boleto");
        System.out.println("2. Registrar llegada a la fila");
        System.out.println("3. Mostrar fila de pasajeros");
        System.out.println("4. Abordar siguiente pasajero");
        System.out.println("5. Mostrar boletos vendidos");
        System.out.println("6. Inspeccion final / checklist de asistencia");
        System.out.println("7. Abordar a todos los que estan en fila");
        System.out.println("0. Salir");
    }
}
