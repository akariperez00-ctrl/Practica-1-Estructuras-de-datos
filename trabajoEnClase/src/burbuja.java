public class burbuja {

    public static void ordenar(String[] cadenas) {
        int n = cadenas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (cadenas[j].compareTo(cadenas[j + 1]) > 0) {
                    String temporal = cadenas[j];
                    cadenas[j] = cadenas[j + 1];
                    cadenas[j + 1] = temporal;
                }
            }
        }
    }
}
