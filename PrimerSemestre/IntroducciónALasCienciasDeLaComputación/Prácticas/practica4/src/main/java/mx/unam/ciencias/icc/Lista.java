package mx.unam.ciencias.icc;

/**
 * <p>Clase para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas son iterables utilizando sus nodos. Las listas no aceptan a
 * <code>null</code> como elemento.</p>
 */
public class Lista {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Object elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(Object elemento) {
            this.elemento=elemento; //Construye al nodo (un objeto de la clase Object)
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
        public Object get() {
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
        return longitud==0;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaFinal(Object elemento) {
        if(elemento==null){ //Si el elemento es null (vacío)
	    return;//no hacer nada xD
	}
	if(esVacia()){//Si la lista es vacìa

	    Nodo n=new Nodo(elemento); //Creamos un nuevo objeto nodo 
	    cabeza=n;
	    rabo=n;
	    longitud=longitud+1;
	}
	else{//Osea si la lista no es vacìa
	    Nodo n = new Nodo(elemento);
	    rabo.siguiente = n; // Enlaza el último nodo al nuevo
	    n.anterior = rabo;  // El nuevo nodo apunta al antiguo rabo
	    rabo = n;           // Actualiza rabo al nuevo nodo
	    longitud++;
	}
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaInicio(Object elemento) {
        if(elemento==null){
	    return; //no hacer nada xD
	}// Aquí va su código.
	if(esVacia()){//si la lista es vacìa
	    Nodo n=new Nodo(elemento); //Creamos un nuevo objeto nodo 
	    cabeza=n;
	    rabo=n;
	    longitud=longitud+1;
	}
	else{//Osea si la lista no es vacìa
	    Nodo n=new Nodo(elemento);
	    cabeza.anterior=n;
	    n.siguiente=cabeza;
	    cabeza=n;
	    longitud=longitud+1;
	    
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
     * @param elemento el elemento a insertar. El elemento se inserta únicamente
     *                 si es distinto de <code>null</code>.
     */

    public void auxiliarInserta(int i, Nodo iterable, Nodo insertar){
	if(i==0){
	    insertar.anterior=iterable.anterior; //hago que mi elemento anterior al nuevo elemento que voy a insertar sea el elemento anterior del nodo (elemento) con el que iteré
            insertar.siguiente=iterable; //hago que mi elemento siguiente al nuevo elemento que voy a insertar sea igual al elemento (nodo) con el que iteré (terminé en la posición que deseo que esté mi nuevo elemento)
            iterable.anterior.siguiente=insertar; //hago que el elemento (nodo) que precedía al iterable ahora tenga como siguiente al nodo que estamos insertando.
            iterable.anterior=insertar; //hago que el elemento (nodo) anterior a mi nodo de iteración sea el elemento (nodo) que quiero insertar.
            longitud++; //actualizo la longitud de mi lista.
	    return;
	}
	auxiliarInserta(i-1,iterable.siguiente,insertar);
    }
    
    public void inserta(int i, Object elemento) {
        if(elemento==null){
	    return;
	}
	if(i<=0){
	    agregaInicio(elemento);//Llamamos al método anterior para colocarlo en el inicio
	    return;
	    
	}
	else if(i>=longitud){
	    agregaFinal(elemento); //Llamamos al método anterior para colocarlo al final
	    return;
	}
	else{
	    Nodo insertar=new Nodo(elemento);
	    auxiliarInserta(i-1, cabeza.siguiente,insertar);
	}
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */

    public void auxiliarElimina(Object elemento, Nodo iterable) {
	if (iterable == null) { // Caso base: llegamos al final sin encontrar el elemento
	    return;
	}
	if (iterable.elemento.equals(elemento)) {
	    iterable.anterior.siguiente = iterable.siguiente; // Enlaza el nodo actual sea el nodo siguiente (desligamos una parte del nodo)
	    if (iterable.siguiente != null) { // Verificamos que el contenido del nodo de iteración no sea el siguiente, porque sino sería el rabo
		iterable.siguiente.anterior = iterable.anterior; // Enlaza el nodo siguiente con el anterior
	    } else { //En caso de que el elemento del nodo siguiente sea nulo significa que estamos en el rabo
		rabo = iterable.anterior; // Actualiza el rabo si el nodo que queremos eliminar es el el último (asi si pasa las pruebas)
	    }
	    longitud--; // Disminuimos la longitud 1 unidad
	    return;
	}
	auxiliarElimina(elemento, iterable.siguiente); // Iteramos al siguiente nodo
    }



    
    public void elimina(Object elemento) {
        if (esVacia() || elemento == null) {
	    return;
	}
	if (cabeza.elemento.equals(elemento)) { //En caso de que el elemento a eliminar sea el primero de mi lista
	    eliminaPrimero();
	    return;
	}
	auxiliarElimina(elemento, cabeza); // Busca desde la cabeza para ver sino hay elementos repetidos
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Object eliminaPrimero() {
        if(longitud==0){ //Si la lista es vacía
	    return null; //Regresaremos null
	}
	Object e=cabeza.elemento;//accedo al elemento de cabeza, (ya que es un objeto de la clase Nodo y contiene como atributo a elemento) 
	if(cabeza==rabo){//En dado caso que la lista tenga solo un elemento
	    cabeza=null; //eliminamos el primer elemento de la cabeza y
	    rabo=null; //elminamos el último elemento de la cabeza.
	}
	else{
	    cabeza=cabeza.siguiente; //Hacemos que la nueva cabeza (primer elemento de la lista) sea ahora el segundo elemento de la lista
	    cabeza.anterior=null; //eliminamos el elemento anterior a la nueva cabeza de la lista.
	}
	longitud=longitud-1; //reducimos la longitud de la lista en 1
	return e; //regresamos el elemento a eliminar
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Object eliminaUltimo() {
        if(esVacia()){ //Si la lista es vacía
	    return null; //Regresaremos null
	}
	Object e=rabo.elemento;//accedo al elemento de rabo, (ya que es un objeto de la clase Nodo y contiene como atributo a elemento) 
	if(cabeza==rabo){//En dado caso que la lista tenga solo un elemento
	    cabeza=null; //eliminamos el primer elemento de la cabeza y
	    rabo=null; //elminamos el último elemento de la cabeza.
	}
	else{
	    rabo=rabo.anterior; //Hacemos que el nuevo rabo (último elemento de la lista) sea ahora el penúltimo elemento de la lista.
	    rabo.siguiente=null; //eliminamos el elemento siguiente al nuevo rabo de la lista.
	}
	longitud=longitud-1; //reducimos la longitud de la lista en 1
	return e; //regresamos el elemento a eliminar
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */

    public boolean auxiliarContiene(Object elemento, Nodo iterable){

	if(iterable==null){
	    return false;
	}
	if(iterable.elemento.equals(elemento)){
	    return true;
	}
	
	return auxiliarContiene(elemento, iterable.siguiente);


    }
    
    public boolean contiene(Object elemento) {
        return auxiliarContiene(elemento, cabeza);
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */

     public Lista auxiliarReversa(Lista alreves, Nodo iterable){
	if(iterable==null){//Caso Base
	    return alreves;
	}
	alreves.agregaInicio(iterable.elemento);
	return auxiliarReversa(alreves, iterable.siguiente);
     }
    
    public Lista reversa() {
        Lista inversa=new Lista(); //Creamos un objeto de tipo Lista estudiante para devolver la reversa
	return auxiliarReversa(inversa, cabeza); //Devolvemos la lista volteada
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */

     public Lista auxiliarCopia(Lista copia, Nodo iterable){
	if (iterable==null){//Caso base
	    return copia;
	}
	copia.agregaFinal(iterable.elemento);//Agrega al final de mi copia de la lista los elementos de mi lista original
	return auxiliarCopia(copia, iterable.siguiente);
     }
    
    public Lista copia() {
        Lista copia = new Lista(); //Creamos un nuevo objeto de tipo ListaEstudiante
        return auxiliarCopia(copia, cabeza);//Recursión  
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        cabeza=rabo=null;
	longitud=0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Object getPrimero() {
        return esVacia()?null:cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el último elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Object getUltimo() {
        return esVacia()?null:rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, o <code>null</code> si
     *         <em>i</em> es menor que cero o mayor o igual que el número de
     *         elementos en la lista.
     */
    public Object auxiliarGet(int i, Nodo iterable){
	if(i==0){
	    return iterable.elemento;
	}
	return auxiliarGet(i-1,iterable.siguiente);
    }
    
    public Object get(int i) {
	if(i<0 || i>=longitud){
	    return null;
	}
	return auxiliarGet(i,cabeza);
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */

    public int auxiliarIndiceDe(Object elemento, Nodo iterable, int indice){
	if(iterable==null){
	    return -1;
	}
	if(iterable.elemento.equals(elemento)){
	    return indice;
	}
	return auxiliarIndiceDe(elemento,iterable.siguiente,indice+1);
    }
	

	
    public int indiceDe(Object elemento) {
        int indice=0;
	return auxiliarIndiceDe(elemento,cabeza,indice);
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
     public String auxiliarToString(String s, Nodo iterable){
	 if(iterable==null){
	     s+="]";
	     return s;
	 }
	 s += String.format("%s", iterable.elemento);
	 if(iterable.siguiente!=null){
	     s+=", ";
	 }
	 return auxiliarToString(s, iterable.siguiente);
     }

    @Override public String toString() {
	if (esVacia()){
            return "[]";
	}
	String s = "[";
	return auxiliarToString(s, cabeza); //Recursión      
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
       public boolean auxiliarEquals(Lista lista, Nodo nodo1, Nodo nodo2){
	   if(nodo1==null && nodo2==null){
	       return true;
	   }
	   if (!nodo1.elemento.equals(nodo2.elemento)){
	       return false; //Devuelve false
	   }
	   return auxiliarEquals(lista, nodo1.siguiente, nodo2.siguiente);
       }
    
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Lista))
            return false;
        Lista lista = (Lista)objeto;
        if(lista==null){
	    return false;
	}
        if(this.longitud!=lista.longitud){
	    return false;
	}
	Nodo nodo1 = this.cabeza; 
        Nodo nodo2 = lista.cabeza;
        return auxiliarEquals(lista, nodo1, nodo2);
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
