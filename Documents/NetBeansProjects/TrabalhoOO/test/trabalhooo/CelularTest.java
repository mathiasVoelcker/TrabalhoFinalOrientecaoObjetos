/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
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


    /**
     * Test of enviarMensagem method, of class Celular.
     */
    @Test
    public void testEnviarMensagem() throws Exception {
        System.out.println("enviarMensagem");
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        String numCelularDesejado = c2.getNumero();
        String mensagemTexto = "Mensagem de teste1";
        
        Central central = new Central(celulares, antenas);
        
        c1.enviarMensagem(numCelularDesejado, mensagemTexto, central);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Mensagem de teste1", c2.getUltimaMensagem());
    }



//    /**
//     * Test of receberMensagem method, of class Celular.
//     */
    @Test
    public void testReceberMensagem() {
        System.out.println("receberMensagem");
        String mensagem = "Mensagem de teste2";
        String numCelularEnviando = "99932543";
        Celular c1 = new Celular("99994438", new Antena("antena1", 4, 4000, 5));
        c1.receberMensagem(mensagem, numCelularEnviando);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(mensagem, c1.getUltimaMensagem());
    }
//
//    /**
//     * Test of getNumero method, of class Celular.
//     */
//    @Test
//    public void testGetNumero() {
//        System.out.println("getNumero");
//        Celular instance = null;
//        String expResult = "";
//        String result = instance.getNumero();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//
//    /**
//     * Test of getAntenaMaisProxima method, of class Celular.
//     */
//    @Test
//    public void testGetAntenaMaisProxima() {
//        System.out.println("getAntenaMaisProxima");
//        Celular instance = null;
//        Antena expResult = null;
//        Antena result = instance.getAntenaMaisProxima();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


}

