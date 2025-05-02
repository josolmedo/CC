public class Main{
    public static void saltoDeLinea(){
        System.out.print("\n");
    }
    public static void main(String[] args){

        int[] arregloDeNumerosAleatorios = GenerarArregloDeEnterosAleatorios.generar(19);
        saltoDeLinea();
        System.out.println("Antes de ordenar: ");
        saltoDeLinea();

        for(int numero: arregloDeNumerosAleatorios){
            System.out.print(numero + " ");
        }
        saltoDeLinea();
        saltoDeLinea();   

        System.out.println("Después de ordenar: ");
        saltoDeLinea();        

        Ordena.quickSort(arregloDeNumerosAleatorios, 0, arregloDeNumerosAleatorios.length-1);
        for(int numero: arregloDeNumerosAleatorios){
            System.out.print(numero + " ");
        }
        saltoDeLinea();
        saltoDeLinea();
    }
}