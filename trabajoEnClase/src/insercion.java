public class insercion {
    public static void ordenar(String[] cadenas) {
        int n = cadenas.length;
        String[] cadenasNuevo = new String[n];
        int posicionInsertar = 0;
        int cantidadInsertados = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cadenasNuevo[i] = cadenas[i];
            } else {
                for (int j = 0; j <= cantidadInsertados; j++) {
                    if (cadenas[i].compareTo(cadenasNuevo[j]) <= 0) {
                        posicionInsertar = j;
                        break;
                    }
                    posicionInsertar = cantidadInsertados;
                }

                for (int k = n - 1; k >= posicionInsertar + 1; k--) {
                    cadenasNuevo[k] = cadenasNuevo[k - 1];
                }

                cadenasNuevo[posicionInsertar] = cadenas[i];
            }

            posicionInsertar = 0;
            cantidadInsertados++;
        }

        for (int c = 0; c < cadenas.length; c++) {
            cadenas[c] = cadenasNuevo[c];
        }
    }

}
