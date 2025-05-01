package mx.unam.ciencias.icc;

/**
 * Clase para representar estudiantes. Un estudiante tiene nombre, número de
 * cuenta, promedio y edad.
 */
public class Estudiante { //Definimos la clase Estudiante, serà de acceso pùblico por lo que podremos acceder en cualquier parte del programa

    /* Nombre del estudiante. */
    private String nombre; //Tipo cadena, de acceso privado
    /* Número de cuenta. */
    private int cuenta; //Tipo entero de acceso privado
    /* Promedio del estudiante. */
    private double promedio; //Tipo doble de acceso privado
    /* Edad del estudiante.*/
    private int edad; //Tipo entero de acceso privado

    /**
     * Define el estado inicial de un estudiante.
     * @param nombre el nombre del estudiante.
     * @param cuenta el número de cuenta del estudiante.
     * @param promedio el promedio del estudiante.
     * @param edad la edad del estudiante.
     */
    public Estudiante(String nombre, //Definimos al constructor de mi clase Estudiante con los parametros especificados.
                      int    cuenta,
                      double promedio,
                      int    edad) {
        this.nombre=nombre; //Hacemos referencia a la variable de clase = Hacemos referencia al atributo del constructor.
        this.cuenta=cuenta; //Hacemos referencia a la variable de clase = Hacemos referencia al atributo del constructor.
        this.promedio=promedio; //Hacemos referencia a la variable de clase = Hacemos referencia al atributo del constructor.
        this.edad=edad; // Hacemos referencia a la variable de clase = Hacemos referencia al atributo del constructor.
        // Aquí va su código.
    }

    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getNombre() { //Getter, es un mètodo pùblico que devuelve una cadena, por eso usamos la palabra reservada return.
        return nombre; //Regresa el nombre
    }

    /**
     * Define el nombre del estudiante.
     * @param nombre el nuevo nombre del estudiante.
     */
    public void setNombre(String nombre) { //Setter, es un mètodo pùblico que no devuelve nada, tiene como argumento el nombre (cadena)
        this.nombre = nombre; //Referencia al nombre.
    }

    /**
     * Regresa el número de cuenta del estudiante.
     * @return el número de cuenta del estudiante.
     */
    public int getCuenta() { //Getter, es un mètodo pùblico que devuelve un entero y no recibe argumentos
        return cuenta;// Aquí va su código.  Devuelve el nùmero de cuenta.
    }

    /**
     * Define el número cuenta del estudiante.
     * @param cuenta el nuevo número de cuenta del estudiante.
     */
    public void setCuenta(int cuenta) { //Setter, es un mètodo pùblico que no devuelve nada, recibe como argumentos el nùmero de cuenta
        this.cuenta=cuenta;// Aquí va su código  Asigna el nùmero de cuenta en caso de querer modificar la referencia a un objeto.
    }

    /**
     * Regresa el promedio del estudiante.
     * @return el promedio del estudiante.
     */
    public double getPromedio() {  //Getter, mètodo pùblico que devuelve un dobule, es decir, el promedio
        return promedio;// Aquí va su código. Devuelve el promedio
    }

    /**
     * Define el promedio del estudiante.
     * @param promedio el nuevo promedio del estudiante.
     */
    public void setPromedio(double promedio) { //Setter, mètodo pùblico que no devuelve nada, tiene como argumento el promedio, permite modificar un atributo del objeto.
        this.promedio=promedio;// Aquí va su código.
    }

    /**
     * Regresa la edad del estudiante.
     * @return la edad del estudiante.
     */
    public int getEdad() { //Getter, mètodo pùblico que devuelve un entero, sin argumentos y sirve para acceder a la edad del estudiante
        return edad;// Aquí va su código.
    }

    /**
     * Define la edad del estudiante.
     * @param edad la nueva edad del estudiante.
     */
    public void setEdad(int edad) { //Setter, mètodo pùblico que no devuelve nada, recibe como argumentos la edad y sirve para modificar dicho atributo del objeto.
        this.edad=edad;// Aquí va su código.
    }

    /**
     * Regresa una representación en cadena del estudiante.
     * @return una representación en cadena del estudiante.
     */
    public String toString() { //Metodo toString, mètodo pùblico que devolverá una cadena acorde al formato solictado en los test unitarios
        String cadena = String.format("Nombre   : %s\n" +
                               "Cuenta   : %09d\n" +
                               "Promedio : %2.2f\n" +
                               "Edad     : %d",
                               nombre, cuenta, promedio, edad);
	 /**
     * %s Regresa un String, %09d regresa 9 digitos, %2.2f regresa dos numeros antes y despues del punto, %d devuelve el entero.
     * @return una representación en cadena del estudiante.
     */
	
	return  cadena;

// return "Nombre : " + nombre + ", Cuenta : " + cuenta + ", Promedio : " + promedio + ", Edad : " + edad; este no paso la prueba unitaria
    }

    /**
     * Nos dice si el estudiante recibido es igual al que manda llamar el
     * método.
     * @param estudiante el estudiante con el cual comparar.
     * @return <code>true</code> si el estudiante recibido tiene las mismas
     *         propiedades que el estudiante que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    public boolean equals(Estudiante estudiante) { //Método equals, devuelve True o False, recibe como parametro un objeto de la clase estudiante 
        if (estudiante == null) {  //Devolverá false en caso de que el objeto sea nulo (o sea no tenga nada)
            return false;
        }
        return this.nombre.equals(estudiante.nombre) &&                        
               this.cuenta == estudiante.cuenta &&                              
               this.promedio == estudiante.promedio &&                          
               this.edad == estudiante.edad;// Aquí va su código.              
    }                                                                
}
