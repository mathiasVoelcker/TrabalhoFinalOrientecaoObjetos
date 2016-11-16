/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CelularTest {
    
    public CelularTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enviarMensagem method, of class Celular.
     */
    @Test
    public void testEnviarMensagem() throws Exception {
        System.out.println("enviarMensagem");
        String numCelularDesejado = "";
        String mensagemTexto = "";
        Central central = null;
        Celular instance = null;
        instance.enviarMensagem(numCelularDesejado, mensagemTexto, central);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarAntena method, of class Celular.
     */
    @Test
    public void testProcurarAntena() {
        System.out.println("procurarAntena");
        List<Antena> antenas = null;
        Celular instance = null;
        instance.procurarAntena(antenas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receberMensagem method, of class Celular.
     */
    @Test
    public void testReceberMensagem() {
        System.out.println("receberMensagem");
        String mensagem = "";
        String numCelularEnviando = "";
        Celular instance = null;
        instance.receberMensagem(mensagem, numCelularEnviando);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Celular.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Celular instance = null;
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalizacao method, of class Celular.
     */
    @Test
    public void testGetLocalizacao() {
        System.out.println("getLocalizacao");
        Celular instance = null;
        int expResult = 0;
        int result = instance.getLocalizacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAntenaMaisProxima method, of class Celular.
     */
    @Test
    public void testGetAntenaMaisProxima() {
        System.out.println("getAntenaMaisProxima");
        Celular instance = null;
        Antena expResult = null;
        Antena result = instance.getAntenaMaisProxima();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distancia method, of class Celular.
     */
    @Test
    public void testDistancia() {
        System.out.println("distancia");
        int local1 = 0;
        int local2 = 0;
        Celular instance = null;
        int expResult = 0;
        int result = instance.distancia(local1, local2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
