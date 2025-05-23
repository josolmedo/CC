package mx.unam.ciencias.icc;

/**
 * Clase para bases de datos de estudiantes.
 */
public class BaseDeDatosPerros extends BaseDeDatos {

    /**
     * Crea un estudiante en blanco.
     * @return un estudiante en blanco.
     */
    @Override public Registro creaRegistro() {
        return new Perro(null, null, 0, 0.0, 0.0);
    }
}
