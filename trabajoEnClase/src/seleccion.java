public class seleccion {

    public static void ordenar(String[] cadenas) {
        int n = cadenas.length;
        int menor;
        String temp;

        for (int i = 0; i < n - 1; i++) {
            menor = i;

            for (int j = i + 1; j < n; j++) {
                if (cadenas[j].compareTo(cadenas[menor]) < 0) {
                    menor = j;
                }
            }

            temp = cadenas[i];
            cadenas[i] = cadenas[menor];
            cadenas[menor] = temp;
        }
    }
}



