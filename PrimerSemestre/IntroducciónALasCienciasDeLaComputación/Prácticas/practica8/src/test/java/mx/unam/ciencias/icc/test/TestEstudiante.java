package mx.unam.ciencias.icc.test;

import java.util.Random;
import mx.unam.ciencias.icc.CampoEstudiante;
import mx.unam.ciencias.icc.Estudiante;
import mx.unam.ciencias.icc.ExcepcionLineaInvalida;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Clase para pruebas unitarias de la clase {@link Estudiante}.
 */
public class TestEstudiante {

    /** Expiración para que ninguna prueba tarde más de 5 segundos. */
    @Rule public Timeout expiracion = Timeout.seconds(5);

    /* Nombres. */
    private static final String[] NOMBRES = {
        "José Arcadio", "Úrsula", "Aureliano", "Amaranta", "Rebeca",
        "Remedios", "Aureliano José", "Gerinaldo", "Mauricio", "Petra"
    };

    /* Apellidos. */
    private static final String[] APELLIDOS = {
        "Buendía", "Iguarán", "Cotes", "Ternera", "Moscote",
        "Brown", "Carpio", "Piedad", "Crespi", "Babilonia"
    };

    /* Generador de números aleatorios. */
    private static Random random;

    /**
     * Genera un nombre aleatorio.
     * @return un nombre aleatorio.
     */
    public static String nombreAleatorio() {
        int n = random.nextInt(NOMBRES.length);
        int ap = random.nextInt(APELLIDOS.length);
        int am = random.nextInt(APELLIDOS.length);
        return NOMBRES[n] + " " + APELLIDOS[ap] + " " + APELLIDOS[am];
    }

    /**
     * Genera un número de cuenta aleatorio.
     * @return un número de cuenta aleatorio.
     */
    public static int cuentaAleatoria() {
        return 10000000 + random.nextInt(10000000);
    }

    /**
     * Genera un promedio aleatorio.
     * @return un promedio aleatorio.
     */
    public static double promedioAleatorio() {
        /* Estúpida precisión. */
        return random.nextInt(100) / 10.0;
    }

    /**
     * Genera una edad aleatoria.
     * @return una edad aleatoria.
     */
    public static int edadAleatoria() {
        return 17 + random.nextInt(73);
    }

    /**
     * Genera un estudiante aleatorio.
     * @return un estudiante aleatorio.
     */
    public static Estudiante estudianteAleatorio() {
        return new Estudiante(nombreAleatorio(),
                              cuentaAleatoria(),
                              promedioAleatorio(),
                              edadAleatoria());
    }

    /**
     * Genera un estudiante aleatorio con un número de cuenta dado.
     * @param cuenta el número de cuenta del nuevo estudiante.
     * @return un estudiante aleatorio.
     */
    public static Estudiante estudianteAleatorio(int cuenta) {
        return new Estudiante(nombreAleatorio(),
                              cuenta,
                              promedioAleatorio(),
                              edadAleatoria());
    }

    /* El estudiante. */
    private Estudiante estudiante;

    /**
     * Prueba unitaria para {@link
     * Estudiante#Estudiante(String,int,double,int)}.
     */
    @Test public void testConstructor() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getNombre().equals(nombre));
        Assert.assertTrue(estudiante.getCuenta() == cuenta);
        Assert.assertTrue(estudiante.getPromedio() == promedio);
        Assert.assertTrue(estudiante.getEdad() == edad);
    }

    /**
     * Prueba unitaria para {@link Estudiante#getNombre}.
     */
    @Test public void testGetNombre() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getNombre().equals(nombre));
        Assert.assertFalse(estudiante.getNombre().equals(nombre + " X"));
    }

    /**
     * Prueba unitaria para {@link Estudiante#setNombre}.
     */
    @Test public void testSetNombre() {
        String nombre = nombreAleatorio();
        String nuevoNombre = nombre + " X";
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getNombre().equals(nombre));
        Assert.assertFalse(estudiante.getNombre().equals(nuevoNombre));
        estudiante.setNombre(nuevoNombre);
        Assert.assertFalse(estudiante.getNombre().equals(nombre));
        Assert.assertTrue(estudiante.getNombre().equals(nuevoNombre));
    }

    /**
     * Prueba unitaria para {@link Estudiante#getCuenta}.
     */
    @Test public void testGetCuenta() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getCuenta() == cuenta);
        Assert.assertFalse(estudiante.getCuenta() == cuenta + 100);
    }

    /**
     * Prueba unitaria para {@link Estudiante#setCuenta}.
     */
    @Test public void testSetCuenta() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        int nuevaCuenta = cuenta + 100;
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getCuenta() == cuenta);
        Assert.assertFalse(estudiante.getCuenta() == cuenta + 100);
        estudiante.setCuenta(nuevaCuenta);
        Assert.assertFalse(estudiante.getCuenta() == cuenta);
        Assert.assertTrue(estudiante.getCuenta() == nuevaCuenta);
    }

    /**
     * Prueba unitaria para {@link Estudiante#getPromedio}.
     */
    @Test public void testGetPromedio() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getPromedio() == promedio);
        Assert.assertFalse(estudiante.getPromedio() == promedio + 1.0);
    }

    /**
     * Prueba unitaria para {@link Estudiante#setPromedio}.
     */
    @Test public void testSetPromedio() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        double nuevoPromedio = promedio + 1.0;
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getPromedio() == promedio);
        Assert.assertFalse(estudiante.getPromedio() == nuevoPromedio);
        estudiante.setPromedio(nuevoPromedio);
        Assert.assertFalse(estudiante.getPromedio() == promedio);
        Assert.assertTrue(estudiante.getPromedio() == nuevoPromedio);
    }

    /**
     * Prueba unitaria para {@link Estudiante#getEdad}.
     */
    @Test public void testGetEdad() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getEdad() == edad);
        Assert.assertFalse(estudiante.getEdad() == edad + 50);
    }

    /**
     * Prueba unitaria para {@link Estudiante#setEdad}.
     */
    @Test public void testSetEdad() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        int nuevaEdad = edad + 50;
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.getEdad() == edad);
        Assert.assertFalse(estudiante.getEdad() == nuevaEdad);
        estudiante.setEdad(nuevaEdad);
        Assert.assertFalse(estudiante.getEdad() == edad);
        Assert.assertTrue(estudiante.getEdad() == nuevaEdad);
    }

    /**
     * Prueba unitaria para {@link Estudiante#toString}.
     */
    @Test public void testToString() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        String cadena = String.format("Nombre   : %s\n" +
                                      "Cuenta   : %09d\n" +
                                      "Promedio : %2.2f\n" +
                                      "Edad     : %d",
                                      nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.toString().equals(cadena));
        cuenta = 213;
        promedio = 0.99;
        estudiante.setCuenta(cuenta);
        estudiante.setPromedio(promedio);
        cadena = String.format("Nombre   : %s\n" +
                               "Cuenta   : %09d\n" +
                               "Promedio : %2.2f\n" +
                               "Edad     : %d",
                               nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.toString().equals(cadena));
    }

    /**
     * Prueba unitaria para {@link Estudiante#equals}.
     */
    @Test public void testEquals() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        Estudiante igual = new Estudiante(new String(nombre),
                                          cuenta, promedio, edad);
        Assert.assertTrue(estudiante.equals(igual));
        String otroNombre = nombre + " Segundo";
        int otraCuenta = cuenta + 1;
        double otroPromedio = (promedio != 0.0) ? promedio / 10.0 : 10.0;
        int otraEdad = edad + 1;
        Estudiante distinto =
            new Estudiante(otroNombre, cuenta, promedio, edad);
        Assert.assertFalse(estudiante.equals(distinto));
        distinto = new Estudiante(nombre, otraCuenta, promedio, edad);
        Assert.assertFalse(estudiante.equals(distinto));
        distinto = new Estudiante(nombre, cuenta, otroPromedio, edad);
        Assert.assertFalse(estudiante.equals(distinto));
        distinto = new Estudiante(nombre, cuenta, promedio, otraEdad);
        Assert.assertFalse(estudiante.equals(distinto));
        distinto = new Estudiante(otroNombre, otraCuenta,
                                  otroPromedio, otraEdad);
        Assert.assertFalse(estudiante.equals(distinto));
        Assert.assertFalse(estudiante.equals("Una cadena"));
        Assert.assertFalse(estudiante.equals(null));
    }

    /**
     * Prueba unitaria para {@link Estudiante#seria}.
     */
    @Test public void testSeria() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);
        String linea = String.format("%s\t%d\t%2.2f\t%d\n",
                                     nombre, cuenta, promedio, edad);
        Assert.assertTrue(estudiante.seria().equals(linea));
    }

    /**
     * Prueba unitaria para {@link Estudiante#deseria}.
     */
    @Test public void testDeseria() {
        estudiante = new Estudiante(null, 0, 0.0, 0);

        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();

        String linea = String.format("%s\t%d\t%2.2f\t%d\n",
                                     nombre, cuenta, promedio, edad);

        try {
            estudiante.deseria(linea);
        } catch (ExcepcionLineaInvalida eli) {
            Assert.fail();
        }

        Assert.assertTrue(estudiante.getNombre().equals(nombre));
        Assert.assertTrue(estudiante.getCuenta() == cuenta);
        Assert.assertTrue(estudiante.getPromedio() == promedio);
        Assert.assertTrue(estudiante.getEdad() == edad);

        String[] invalidas = {"", " ", "\t", "  ", "\t\t",
                              " \t", "\t ", "\n", "a\ta\ta",
                              "a\ta\ta\ta"};

        for (int i = 0; i < invalidas.length; i++) {
            linea = invalidas[i];
            try {
                estudiante.deseria(linea);
                Assert.fail();
            } catch (ExcepcionLineaInvalida eli) {}
        }
    }

    /**
     * Prueba unitaria para {@link Estudiante#actualiza}.
     */
    @Test public void testActualiza() {
        estudiante = new Estudiante("A", 1, 1, 1);
        Estudiante e = new Estudiante("B", 2, 2, 2);
        Assert.assertFalse(estudiante == e);
        Assert.assertFalse(estudiante.equals(e));
        estudiante.actualiza(e);
        Assert.assertFalse(estudiante == e);
        Assert.assertTrue(estudiante.equals(e));
        Assert.assertTrue(estudiante.getNombre().equals("B"));
        try {
            estudiante.actualiza(null);
            Assert.fail();
        } catch (IllegalArgumentException iae) {}
    }

    /**
     * Prueba unitaria para {@link Estudiante#casa}.
     */
    @Test public void testCasa() {
        String nombre = nombreAleatorio();
        int cuenta = cuentaAleatoria();
        double promedio = promedioAleatorio();
        int edad = edadAleatoria();
        estudiante = new Estudiante(nombre, cuenta, promedio, edad);

        String n = estudiante.getNombre();
        int m = estudiante.getNombre().length();
        Assert.assertTrue(estudiante.casa(CampoEstudiante.NOMBRE, n));
        n = estudiante.getNombre().substring(0, m/2);
        Assert.assertTrue(estudiante.casa(CampoEstudiante.NOMBRE, n));
        n = estudiante.getNombre().substring(m/2, m);
        Assert.assertTrue(estudiante.casa(CampoEstudiante.NOMBRE, n));
        n = estudiante.getNombre().substring(m/3, 2*(m/3));
        Assert.assertTrue(estudiante.casa(CampoEstudiante.NOMBRE, n));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.NOMBRE, ""));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.NOMBRE, "XXX"));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.NOMBRE, 1000));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.NOMBRE, null));

        int c = estudiante.getCuenta();
        Assert.assertTrue(estudiante.casa(CampoEstudiante.CUENTA, c));
        c = estudiante.getCuenta() - 100;
        Assert.assertTrue(estudiante.casa(CampoEstudiante.CUENTA, c));
        c = estudiante.getCuenta() + 100;
        Assert.assertFalse(estudiante.casa(CampoEstudiante.CUENTA, c));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.CUENTA, "XXX"));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.CUENTA, null));

        double p = estudiante.getPromedio();
        Assert.assertTrue(estudiante.casa(CampoEstudiante.PROMEDIO, p));
        p = estudiante.getPromedio() - 5.0;
        Assert.assertTrue(estudiante.casa(CampoEstudiante.PROMEDIO, p));
        p = estudiante.getPromedio() + 5.0;
        Assert.assertFalse(estudiante.casa(CampoEstudiante.PROMEDIO, p));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.PROMEDIO, "XXX"));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.PROMEDIO, null));

        int e = estudiante.getEdad();
        Assert.assertTrue(estudiante.casa(CampoEstudiante.EDAD, e));
        e = estudiante.getEdad() - 10;
        Assert.assertTrue(estudiante.casa(CampoEstudiante.EDAD, e));
        e = estudiante.getEdad() + 10;
        Assert.assertFalse(estudiante.casa(CampoEstudiante.EDAD, e));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.EDAD, "XXX"));
        Assert.assertFalse(estudiante.casa(CampoEstudiante.EDAD, null));

        try {
            estudiante.casa(null, null);
            Assert.fail();
        } catch (IllegalArgumentException iae) {}
    }

    /* Inicializa el generador de números aleatorios. */
    static {
        random = new Random();
    }
}
