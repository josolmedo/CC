public class Main{

    public static void saltoDeLinea(){
        System.out.printf("\n");
    }
    public static void main(String[] args){
        Pilas<Integer> pila = new Pilas<Integer>();

        for(int i = 1; i < 11; i++){
            pila.agregar(i);
        }

        saltoDeLinea();
        int longitud = pila.getLongitud();

        System.out.println(pila.observa());
        saltoDeLinea();

        System.out.println(pila.posicion(5));
        saltoDeLinea();

        for(int i = 0; i < longitud; i++){            
            System.out.println(pila.desapilar());
        }

        saltoDeLinea();
        


    }
}