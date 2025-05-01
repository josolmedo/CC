package mx.unam.ciencias.icc;

import java.util.Comparator;

/**
 * Clase para ordenar y buscar arreglos genéricos.
 */
public class Arreglos {

    /* Constructor privado para evitar instanciación. */
    private Arreglos() {}

    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo un arreglo cuyos elementos son comparables.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arreglo) {
        selectionSort(arreglo, (a, b) -> a.compareTo(b));
    }

    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo el arreglo a ordenar.
     * @param comparador el comparador para ordernar el arreglo.
     */
    public static <T> void selectionSort(T[] arreglo, Comparator<T> comparador) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (comparador.compare(arreglo[j], arreglo[min]) < 0) {
                    min = j;
                }
            }
            // Intercambiamos arreglo[i] y arreglo[min]
            T tmp = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = tmp;
        }
    }

    /**
     * Ordena el arreglo recibido usando QuickSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo un arreglo cuyos elementos son comparables.
     */
    public static <T extends Comparable<T>> void quickSort(T[] arreglo) {
        quickSort(arreglo, (a, b) -> a.compareTo(b));
    }

    /**
     * Ordena el arreglo recibido usando QuickSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo el arreglo a ordenar.
     * @param comparador el comparador para ordenar el arreglo.
     */
    public static <T> void quickSort(T[] arreglo, Comparator<T> comparador) {
        quickSortRec(arreglo, 0, arreglo.length - 1, comparador);
    }

    /* Método recursivo auxiliar para QuickSort. */
    private static <T> void quickSortRec(T[] arreglo, int inicio, int fin, Comparator<T> comparador) {
        if (inicio < fin) {
            int p = particion(arreglo, inicio, fin, comparador);
            quickSortRec(arreglo, inicio, p - 1, comparador);
            quickSortRec(arreglo, p + 1, fin, comparador);
        }
    }

    /* Partición usando como pivote el último elemento */
    private static <T> int particion(T[] arreglo, int inicio, int fin, Comparator<T> comparador) {
        T pivote = arreglo[fin];
        int i = inicio;
        for (int j = inicio; j < fin; j++) {
            if (comparador.compare(arreglo[j], pivote) <= 0) {
                // swap arreglo[i] y arreglo[j]
                T tmp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = tmp;
                i++;
            }
        }
        // swap arreglo[i] y arreglo[fin] (coloca pivote en su lugar)
        T tmp = arreglo[i];
        arreglo[i] = arreglo[fin];
        arreglo[fin] = tmp;
        return i;
    }

    /**
     * Hace una búsqueda binaria del elemento en el arreglo. Regresa el índice
     * del elemento en el arreglo, o -1 si no se encuentra.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo un arreglo cuyos elementos son comparables.
     * @param elemento el elemento a buscar.
     * @return el índice del elemento en el arreglo, o -1 si no se encuentra.
     */
    public static <T extends Comparable<T>> int
    busquedaBinaria(T[] arreglo, T elemento) {
        return busquedaBinaria(arreglo, elemento, (a, b) -> a.compareTo(b));
    }

    /**
     * Hace una búsqueda binaria del elemento en el arreglo. Regresa el índice
     * del elemento en el arreglo, o -1 si no se encuentra.
     * @param <T> tipo del que puede ser el arreglo.
     * @param arreglo el arreglo dónde buscar.
     * @param elemento el elemento a buscar.
     * @param comparador el comparador para hacer la búsqueda.
     * @return el índice del elemento en el arreglo, o -1 si no se encuentra.
     */
    public static <T> int
    busquedaBinaria(T[] arreglo, T elemento, Comparator<T> comparador) {
        int izq = 0;
        int der = arreglo.length - 1;
        while (izq <= der) {
            int medio = izq + (der - izq) / 2;
            int cmp = comparador.compare(arreglo[medio], elemento);
            if (cmp == 0) {
                return medio;
            } else if (cmp < 0) {
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }
        return -1;
    }
}

