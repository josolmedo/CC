public class Arreglos {

    public static void saltoDeLinea(){
        System.out.printf("\n");
    }
    public static void main(String[] args){

        /*Los arreglos usarlos preferentemente cuando:
         * Es una colección de elementos del mismo tipo.
         * Tiene tamaño fijo: no se puede cambiar después de creado.
         * Permite acceso rápido por índice.
         */

         /*Declaración*/
         int[] numeros = new int[5];  // crea un arreglo de 5 enteros, por defecto vacío
         int[] pares = {2, 4, 6, 8, 10}; // declarar e inicializar directamente

         /*Acceso*/
         System.out.printf("\n %d \n",numeros[2]);
         System.out.printf("\n %d \n\n",pares[2]);

         /*Iteracion*/
         for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
         }

         saltoDeLinea();

         for(int numero: pares){
            System.out.println(numero);
         }

         saltoDeLinea();

         /*Extra: Arreglos multidimensionales 
         (cada elemento del arreglo es otro arreglo (recursivo), no usa el poninomio de redireccionamiento) */

         int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        System.out.println(matriz[1][2]); 
        
        saltoDeLinea();
        
    }
    
}
