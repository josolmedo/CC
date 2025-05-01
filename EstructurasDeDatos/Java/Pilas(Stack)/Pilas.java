public class Pilas<T>{ //LIFO

    private class Nodo {

        private T elemento;
        private Nodo anterior;
        private Nodo siguiente;
    
        private Nodo(T elemento){
            this.elemento = elemento;
        }    
    
    }
    
   
    private Nodo cabeza;       
    private int longitud;

    public int getLongitud(){
        return this.longitud;
    }

    public boolean esVacia(){
        return longitud == 0;
    }

    public void agregar(T elemento){
        Nodo nuevo = new Nodo(elemento);
        
        if(esVacia()){
            cabeza = nuevo;
            cabeza.siguiente = null;
            cabeza.anterior = null;
            longitud++;
            return;            
        }
        nuevo.anterior = cabeza;
        nuevo.siguiente = null;
        cabeza.siguiente = nuevo;
        cabeza = nuevo;
        cabeza.siguiente = null;

        longitud++;
    }

    public T desapilar(){
        if(esVacia()){
            return null;
        }

        T elementito = cabeza.elemento;
        cabeza = cabeza.anterior;
        
        longitud--;

        return elementito;
        
    }

    public T observa(){
        if(esVacia()){
            return null;
        }
        return cabeza.elemento;
    }

    public int posicion(T elemento){
        if(esVacia()){
            return -1;
        }
        
        Nodo buscador = cabeza;
        for(int i = 0; i < longitud; i++){
            if(elemento == buscador.elemento){
                return i;
            }
            buscador = buscador.anterior;
        }
        return -1;
    }


    
}
