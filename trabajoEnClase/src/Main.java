import java.util.Arrays;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el número de palabras que desea ordenar: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    String[] palabras = new String[n];

    System.out.println("\n--- Ingreso de Palabras ---");
    for (int i = 0; i < n; i++) {
        System.out.print("Palabra [" + i + "]: ");
        palabras[i] = scanner.nextLine();
    }

    System.out.println("\n=================================");
    System.out.println("   MENÚ DE ALGORITMOS DE ORDEN   ");
    System.out.println("=================================");
    System.out.println("1. Selección");
    System.out.println("2. Inserción");
    System.out.println("3. Burbuja");
    System.out.println("4. Mezcla (Merge Sort)");
    System.out.println("5. Rápido (Quick Sort)");
    System.out.print("Elija una opción (1-5): ");
    int opcion = scanner.nextInt();
    scanner.nextLine();

    switch (opcion) {
        case 1:
            seleccion.ordenar(palabras);
            break;
        case 2:
            insercion.ordenar(palabras);
            break;
        case 3:
            burbuja.ordenar(palabras);
            break;
        case 4:
            mezcla.mezcla(palabras, 0, palabras.length - 1);
            break;
        case 5:
            rapides.rapides(palabras, 0, palabras.length - 1);
            break;
        default:
            System.out.println("Opción no válida. Se ejecutará Selección por defecto.");
            seleccion.ordenar(palabras);
            break;
    }

    System.out.println("\nArreglo ordenado:");
    System.out.println(Arrays.toString(palabras));

    System.out.println("\n--- Búsqueda Binaria ---");
    System.out.print("Ingrese la palabra a buscar: ");
    String palabraBuscada = scanner.nextLine();

    busquedaBinaria(palabras, palabraBuscada);

    scanner.close();
}
public static void busquedaBinaria(String[] cadenas, String valorBuscado) {
    int limiteMenor = 0;
    int limiteMayor = cadenas.length - 1;

    while (limiteMenor <= limiteMayor) {
        int pivote = limiteMenor + (limiteMayor - limiteMenor) / 2;
        int comparacion = cadenas[pivote].compareTo(valorBuscado);

        if (comparacion == 0) {
            System.out.println("El dato se encontró en la casilla: " + pivote);
            return;
        } else if (comparacion < 0) {
            limiteMenor = pivote + 1;
        } else {
            limiteMayor = pivote - 1;
        }
    }

    System.out.println("El dato no se encontró en la estructura.");
}

