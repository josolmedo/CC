package mx.unam.ciencias.icc;

/**
 * <p>Clase para listas de estudiantes doblemente ligadas.</p>
 *
 * <p>Las listas de estudiantes nos permiten agregar elementos al inicio o final
 * de la lista, eliminar elementos de la lista, comprobar si un elemento está o
 * no en la lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas de estudiantes son iterables utilizando sus nodos. Las listas
 * no aceptan a <code>null</code> como elemento.</p>
 *
 * <p>Los elementos en una lista de estudiantes siempre son instancias de la
 * clase {@link Estudiante}.</p>
 */

/**Comentario personal, al parecer la práctica implementa listas doblemente ligadas, cada elemento de la lista tiene una referencia tanto al elemento anterior como al elemento siguiente.

Practica realizada por: José Ángel Olmedo Guevara**/

public class ListaEstudiante {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Estudiante elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(Estudiante elemento) {

   this.elemento=elemento; // Construye al nodo con el parámetro recibido (un objeto de la clase estudiante)
           
        }

        /**
         * Regresa el nodo anterior del nodo.
         * @return el nodo anterior del nodo.
         */
        public Nodo getAnterior() {

   return anterior; //Devuelve el elemento anterior
           
        }

        /**
         * Regresa el nodo siguiente del nodo.
         * @return el nodo siguiente del nodo.
         */
        public Nodo getSiguiente() {
            return siguiente;// Devuelve el elemento siguiente
        }

        /**
         * Regresa el elemento del nodo.
         * @return el elemento del nodo.
         */
        public Estudiante get() {
            return elemento;// Devuelve el elemento.
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
        return longitud;// Devuelve la longitud de la lista.
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
   
    public boolean esVacia() {
return longitud==0; //Si su longitud es vacía devolvera True
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
   
    public void agregaFinal(Estudiante elemento) {
        if(elemento==null){ //Si el elemento es null (vacío)
   return;//no hacer nada xD
}
if(esVacia()){//Usamos el mètodo anterior, en otras palabras si la lista es vacìa

   Nodo n=new Nodo(elemento); //Creamos un nuevo objeto nodo (contiene al nuevo elemento (estudiante) para poder iterar sobre la lista)
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
    public void agregaInicio(Estudiante elemento) {
if(elemento==null){
   return; //no hacer nada xD
}// Aquí va su código.
if(esVacia()){//Usamos el mètodo anterior, en otras palabras si la lista es vacìa
   Nodo n=new Nodo(elemento); //Creamos un nuevo objeto nodo (contiene al nuevo elemento (estudiante) para poder iterar sobre la lista)
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
   // Aquí va su código.
}
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al final de la misma. En otro caso,
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
   
    public void inserta(int i, Estudiante elemento) {

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
    public void auxiliarElimina(Estudiante elemento, Nodo iterable) {
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

    public void elimina(Estudiante elemento) {
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
    public Estudiante eliminaPrimero() {
        if(longitud==0){ //Si la lista es vacía
   return null; //Regresaremos null
}
Estudiante e=cabeza.elemento;//accedo al elemento de cabeza, (ya que es un objeto de la clase Nodo y contiene como atributo a elemento) el elemento será el parámetro del objeto e de la clase estudiante
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
    public Estudiante eliminaUltimo() {
        if(esVacia()){ //Si la lista es vacía
   return null; //Regresaremos null
}
Estudiante e=rabo.elemento;//accedo al elemento de rabo, (ya que es un objeto de la clase Nodo y contiene como atributo a elemento) el elemento será el parámetro del objeto e de la clase estudiante
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
    public boolean auxiliarContiene(Estudiante elemento, Nodo iterable){

if(iterable==null){
   return false;
}
if(iterable.elemento.equals(elemento)){
   return true;
}

return auxiliarContiene(elemento, iterable.siguiente);


    }
   
    public boolean contiene(Estudiante elemento) {
return auxiliarContiene(elemento, cabeza);
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */

    public ListaEstudiante auxiliarReversa(ListaEstudiante alreves, Nodo iterable){
if(iterable==null){//Caso Base
   return alreves;
}
alreves.agregaInicio(iterable.elemento);
return auxiliarReversa(alreves, iterable.siguiente);


    }
   
    public ListaEstudiante reversa() {
ListaEstudiante inversa=new ListaEstudiante(); //Creamos un objeto de tipo Lista estudiante para devolver la reversa
return auxiliarReversa(inversa, cabeza); //Devolvemos la lista volteada
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */

    public ListaEstudiante auxiliarCopia(ListaEstudiante copia, Nodo iterable){
if (iterable==null){//Caso base
   return copia;
}
copia.agregaFinal(iterable.elemento);//Agrega al final de mi copia de la lista los elementos de mi lista original
return auxiliarCopia(copia, iterable.siguiente);


    }
    public ListaEstudiante copia() {
ListaEstudiante copia = new ListaEstudiante(); //Creamos un nuevo objeto de tipo ListaEstudiante
        return auxiliarCopia(copia, cabeza);//Recursión        
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
rabo=cabeza=null; //Borramos el primer y último elemento de la lista (referencia)
longitud=0; //Hacemos que la longitud sea de 0
       
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getPrimero() {
        if(esVacia()){
   return null;
}
else{

   return cabeza.elemento;
}
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el último elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getUltimo() {
if(esVacia()){
   return null;
}
else{
   return rabo.elemento;
}
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, o <code>null</code> si
     *         <em>i</em> es menor que cero o mayor o igual que el número de
     *         elementos en la lista.
     */

    public Estudiante auxiliarGet(int i, Nodo iterable){
if(i==0){
   return iterable.elemento;
}
return auxiliarGet(i-1,iterable.siguiente);
    }
   
    public Estudiante get(int i){
if(i<0 || i>=longitud){ //si i es menor 0 y mayor que longitud devolvemos null
   return null;
}

return auxiliarGet(i, cabeza); //Devolvemos el iesimo elemento de la lista  
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */

    public int auxiliarIndiceDe(Estudiante elemento, Nodo iterable, int indice){
if(iterable==null){
   return -1;
}
if(iterable.elemento.equals(elemento)){
   return indice;
}
return auxiliarIndiceDe(elemento,iterable.siguiente,indice+1);
    }
   
    public int indiceDe(Estudiante elemento) {
int indice = 0; //Inicializamos el índice en 0, ya que las listas en java inician en indice 0
       
        return auxiliarIndiceDe(elemento,cabeza,indice); //Si el elemento no está en la lista devuelve -1
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
s += String.format("%s", iterable.elemento); //esto lo saque de los tests, es el formato que pide, se añadira a mi lista el elemento de mi nodo de iteración
if(iterable.siguiente!=null){
   s+=", ";
}
return auxiliarToString(s, iterable.siguiente);
    }

    public String toString() {
        if (esVacia()) //Si la lista es vacía devolvera corchetes vacíos, que corresponde a una lista vacía
            return "[]";
String s = "[";
return auxiliarToString(s, cabeza); //Recursión        
    }

    /**
     * Nos dice si la lista es igual a la lista recibida.
     * @param lista la lista con la que hay que comparar.
     * @return <code>true</code> si la lista es igual a la recibida;
     *         <code>false</code> en otro caso.
     */

    public boolean auxiliarEquals(ListaEstudiante lista, Nodo nodo1, Nodo nodo2){
if(nodo1==null && nodo2==null){
   return true;
}
if (!nodo1.elemento.equals(nodo2.elemento)){ //Devuelve el elemento negado si mi elemento actual del nodo es diferente a mi elemento actual de la lista que ingrese como parámetro
                return false; //Devuelve false
}
return auxiliarEquals(lista, nodo1.siguiente, nodo2.siguiente);
    }
   
    public boolean equals(ListaEstudiante lista) {
if(lista==null){
   return false;
}
        if(this.longitud!=lista.longitud){ //Si la longitud de las listas difiere, devolverá false
   return false;
}
Nodo nodo1 = this.cabeza; //Creamos un objeto de tipo nodo que contendrá el primer elemento de la lista original
        Nodo nodo2 = lista.cabeza; //Creamos un objeto de tipo nodo que contendrá el primer elemento de la lista ingresada como parámetro
        return auxiliarEquals(lista, nodo1, nodo2); //Si las listas son iguales devolverá true
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
