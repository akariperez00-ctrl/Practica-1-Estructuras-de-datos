import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ColaDinamica colaPendientes = new ColaDinamica();
        ListaEnlazadaSimple listaResueltos = new ListaEnlazadaSimple();
        Scanner entrada = new Scanner(System.in);

        int opcionPrincipal = 0;

        do {
            System.out.println("========================================");
            System.out.println("   SISTEMA DE GESTIÓN DE TICKETS EN LÍNEA");
            System.out.println("========================================");
            System.out.println("1. Menú de Usuario");
            System.out.println("2. Menú de Administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcionPrincipal = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcionPrincipal = 0;
            }

            switch (opcionPrincipal) {
                case 1:
                    menuUsuario(colaPendientes, listaResueltos, entrada);
                    break;
                case 2:
                    menuAdministrador(colaPendientes, listaResueltos, entrada);
                    break;
                case 3:
                    System.out.println("\n¡Gracias por utilizar el sistema!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.\n");
            }

        } while (opcionPrincipal != 3);

        entrada.close();
    }


    private static void menuUsuario(ColaDinamica cola, ListaEnlazadaSimple lista, Scanner entrada) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE USUARIO ---");
            System.out.println("1. Crear un ticket");
            System.out.println("2. Buscar ticket por ID");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre completo: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Ingrese la descripción del problema: ");
                    String descripcion = entrada.nextLine();

                    Ticket nuevoTicket = new Ticket(nombre, descripcion);
                    cola.insertar(nuevoTicket);

                    System.out.println("\nTicket creado con éxito.");
                    System.out.println("Su número de ID para darle seguimiento es: " + nuevoTicket.getId() + "\n");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del ticket que desea consultar: ");
                    int idBusqueda;
                    try {
                        idBusqueda = Integer.parseInt(entrada.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("El ID ingresado no es válido.\n");
                        break;
                    }

                    Ticket ticketEncontrado = lista.buscarPorId(idBusqueda);
                    if (ticketEncontrado != null) {
                        System.out.println("\n¡El ticket ha sido RESUELTO! Información del ticket:");
                        System.out.println(ticketEncontrado);
                    } else {
                        System.out.println("\nEl ticket con ID " + idBusqueda + " se encuentra PENDIENTE de resolución.\n");
                    }
                    break;

                case 3:
                    System.out.println("Regresando al menú principal...\n");
                    break;

                default:
                    System.out.println("Opción no válida.\n");
            }
        } while (opcion != 3);
    }

    private static void menuAdministrador(ColaDinamica cola, ListaEnlazadaSimple lista, Scanner entrada) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE ADMINISTRADOR ---");
            System.out.println("1. Ver ticket al frente de la cola");
            System.out.println("2. Resolver ticket al frente de la cola");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    Ticket frente = cola.verFrente();
                    if (frente != null) {
                        System.out.println("\nTicket al frente de la cola de pendientes:");
                        System.out.println(frente);
                    }
                    break;

                case 2:
                    if (cola.estaVacia()) {
                        System.out.println("\nNo hay tickets pendientes para resolver.\n");
                    } else {
                        Ticket ticketAResolver = cola.eliminar();
                        ticketAResolver.resolverTicket();
                        lista.insertarFin(ticketAResolver);

                        System.out.println("\nEl siguiente ticket ha sido resuelto y movido a la lista de resueltos:");
                        System.out.println(ticketAResolver);
                    }
                    break;

                case 3:
                    System.out.println("Regresando al menú principal...\n");
                    break;

                default:
                    System.out.println("Opción no válida.\n");
            }
        } while (opcion != 3);
    }
}
