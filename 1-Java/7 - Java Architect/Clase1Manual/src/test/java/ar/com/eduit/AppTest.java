package ar.com.eduit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static String prueba;
    @Before
    public void before(){
        if(prueba == null) {
            System.out.println("SETEANDO IF");
            prueba = "Hola";
        }

        System.out.println("Antes del test");
    }

    @After
    public void after(){
        System.out.println("Despues del test");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Ejecutando test true");
        assertTrue( true );
    }

    @Test
    public void shouldAnswerWithFalse(){
        System.out.println("Ejecutando test false");
        assertFalse(false);
    }
}
