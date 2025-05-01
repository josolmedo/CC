package mx.unam.ciencias.icc;

import java.util.NoSuchElementException;

/**
 * <p>Clase para listas genéricas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas son iterables utilizando sus nodos. Las listas no aceptan a
 * <code>null</code> como elemento.</p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            this.elemento = elemento;
        }

        /**
         * Regresa el nodo anterior del nodo.
         * @return el nodo anterior del nodo.
         */
        public Nodo getAnterior() {
            return anterior;
        }

        /**
         * Regresa el nodo siguiente del nodo.
         * @return el nodo siguiente del nodo.
         */
        public Nodo getSiguiente() {
            return siguiente;
        }

        /**
         * Regresa el elemento del nodo.
         * @return el elemento del nodo.
         */
        public T get() {
            return elemento;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        return longitud == 0;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) throws IllegalArgumentException {
        if (elemento == null){
            throw new IllegalArgumentException("El estudiante a ingresar es nulo");
        }
        Nodo n = new Nodo(elemento);
        if (longitud == 0){
            cabeza=rabo=n;
            longitud = longitud + 1;
        }
        else{
            rabo.siguiente = n;
            n.anterior = rabo;
            rabo = n;
            longitud = longitud + 1;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) throws IllegalArgumentException{
        if (elemento == null){
            throw new IllegalArgumentException("El estudiante a ingresar es nulo"); 
        }
        Nodo n = new Nodo(elemento);
        if (longitud == 0){
            cabeza=rabo=n;
            longitud = longitud + 1;
        }
        else{
            n.anterior = null;
            n.siguiente = cabeza;
            cabeza.anterior = n;
            cabeza = n;
            longitud = longitud + 1;
        }
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) throws IllegalArgumentException {
        if(elemento == null){
            throw new IllegalArgumentException("El registro que quieres ingresar está vacío");            
        }
        if(i <= 0){
            agregaInicio(elemento);
        }
        else if(i >= longitud){
            agregaFinal(elemento);
        }else{
            Nodo insertar=new Nodo(elemento);
            Nodo iterable=cabeza;
            for(int j=0; j<i; j++){
                iterable=iterable.siguiente;
            }
                insertar.anterior=iterable.anterior; 
                insertar.siguiente=iterable; 
                iterable.anterior.siguiente=insertar; 
                iterable.anterior=insertar; 
                longitud++;
            
        }
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
        Nodo iterable = cabeza; 
        while (iterable != null) { 
            if (iterable.elemento.equals(elemento)){ 
                if (iterable==cabeza) { 
                    eliminaPrimero(); 
                } else if (iterable==rabo) { 
                    eliminaUltimo(); 
                } else {
                   iterable.anterior.siguiente = iterable.siguiente; 
                   iterable.siguiente.anterior = iterable.anterior;  
          
                   longitud--;
               }       
                return; 
            }
            iterable=iterable.siguiente;
        }
    }


    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() throws NoSuchElementException{
        if(longitud == 0){
            throw new NoSuchElementException("No hay registros");
        }
        Nodo n = cabeza;

        if(cabeza == rabo){
            cabeza = rabo = null;            
        } else {
            cabeza.siguiente.anterior = null;
            cabeza = cabeza.siguiente;            
        }

        longitud = longitud - 1;

        return n.elemento;

    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() throws NoSuchElementException{
        if(longitud == 0){
            throw new NoSuchElementException("No hay registros");
        }
        Nodo n = rabo;

        if(cabeza == rabo){
            cabeza = rabo = null;            
        } else {
            rabo.anterior.siguiente = null;
            rabo = rabo.anterior;            
        }

        longitud = longitud - 1;

        return n.elemento;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(T elemento) {
        if(longitud == 0){
            return false;
        }
        
        Nodo iterador = cabeza;

        while(iterador != null){

            if(iterador.elemento.equals(elemento)){
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista<T> reversa() {
        Lista<T> alreves = new Lista<T>();
        Nodo n = cabeza;
        while(n != null){
            alreves.agregaInicio(n.elemento);
            n = n.siguiente;
        }
        return alreves;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
        Lista<T> copiona = new Lista<T>();
        Nodo n = cabeza;
        while(n != null){
            copiona.agregaFinal(n.elemento);
            n = n.siguiente;
        }
        return copiona;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        cabeza=rabo=null;
        longitud = 0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() throws NoSuchElementException {
        if(esVacia()){
            throw new NoSuchElementException("La lista está vacía");
        }else{
            return cabeza.elemento;
        }
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() throws NoSuchElementException {
        if(esVacia()){
            throw new NoSuchElementException("La lista está vacía");
        }else{
            return rabo.elemento;
        }
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) throws ExcepcionIndiceInvalido{
        if(i<0 || i>=longitud){
            throw new ExcepcionIndiceInvalido("Has ingresado un índice inválido");
        }
        Nodo n = cabeza;        
        for(int contador = 0; contador<i; contador++){
            n = n.siguiente;
        }
        return n.elemento;
            
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        if(esVacia()){
            return -1;
        }
        int contador = 0;
        Nodo iterador = cabeza;
        while (iterador != null){
            if(iterador.elemento.equals(elemento)){
                return contador;
            }
            contador = contador + 1;
            iterador = iterador.siguiente;
        }
        return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        if (esVacia()){
           return "[]";
        }
        String s = "[";
        Nodo iterador = cabeza;
        while(iterador!= null){
            s += String.format("%s", iterador.elemento);
            if(iterador.siguiente != null){
                s+=", ";
            }
            iterador=iterador.siguiente;
        }
        s+="]";
        return s;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;
        if(lista==null){
            return false;
        }
        if(this.longitud!=lista.longitud){
            return false;
        }
        Nodo nodo1 = this.cabeza;
        Nodo nodo2 = lista.cabeza;
        while (nodo1 != null && nodo2 != null) {
            if (!nodo1.elemento.equals(nodo2.elemento)){
                return false;
            }
            nodo1 = nodo1.siguiente; 
            nodo2 = nodo2.siguiente;
        }
        return true;
    }


    /**
     * Regresa el nodo cabeza de la lista.
     * @return el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Regresa el nodo rabo de la lista.
     * @return el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        return rabo;
    }
}
