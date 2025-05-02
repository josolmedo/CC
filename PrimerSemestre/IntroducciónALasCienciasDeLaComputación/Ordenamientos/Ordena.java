public class Ordena {
    public static void quickSort(int[] arreglo, int start, int end){
        if(start >= end){
            return;
        }

        int pivote = arreglo[end];
        int contador = start;

        for(int i = start; i<end; i++){
            if(arreglo[i]<pivote){
                intercambia(arreglo, i, contador);
                contador++;
            }
        }
       
        intercambia(arreglo, contador, end);
        quickSort(arreglo, start, contador-1);
        quickSort(arreglo, contador+1, end);
    }
    
    private static void intercambia(int[] arreglo, int origen, int destino){
        int temporal = arreglo[origen];
        arreglo[origen] = arreglo[destino];
        arreglo[destino] = temporal;        
    }
}
