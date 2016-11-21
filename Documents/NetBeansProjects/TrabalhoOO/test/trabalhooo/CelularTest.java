/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Map<String, Celular> celulares = new HashMap<String, Celular>();
        Map<String, Antena> antenas = new HashMap<String, Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.put("antena1", a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.put("99994438", c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.put("99932438", c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        Central central = new Central(celulares, antenas, 8);
        String numCelularDesejado = c2.getNumero();
        String mensagemTexto = "Mensagem de teste1";
                
        c1.enviarMensagem(numCelularDesejado, mensagemTexto, central);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Mensagem de teste1", c2.getUltimaMensagem().getTexto());
    }



//    /**
//     * Test of receberMensagem method, of class Celular.
//     */
    @Test
    public void testReceberMensagem() {
        System.out.println("receberMensagem");
        String texto = "Mensagem de teste2";
        String numCelularEnviando = "99932543";
        Map<String, Celular> celulares = new HashMap<String, Celular>();
        Map<String, Antena> antenas = new HashMap<String, Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.put("antena1", a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.put("99994438", c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.put("99932438", c2);
        Mensagem mensagem = new Mensagem(texto, c1.getNumero(), numCelularEnviando);
        
        Central central = new Central(celulares, antenas, 8);
    
        c1.receberMensagem(mensagem, central);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(mensagem, c1.getUltimaMensagem());
    }

//
    /**
     * Test of getNumero method, of class Celular.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        String numero = "99943368";
        Celular c1 = new Celular(numero, new Antena("antena1", 4, 4000, 5));
        String result = c1.getNumero();
        assertEquals(result, numero);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
  /**
     * Test of getNumero method, of class Celular.
     */
    @Test
    public void testGetAntenaMaisProxima() {
        System.out.println("getAntenaMaisProxima");
        Antena antena = new Antena("antena1", 4, 4000, 5);
        Celular c1 = new Celular("99943368", antena);
        Antena result = c1.getAntenaMaisProxima();
        assertEquals(result, antena);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }




}


