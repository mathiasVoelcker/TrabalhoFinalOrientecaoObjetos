/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
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
public class CentralTest {
    
    public CentralTest() {
    }
    

    /**
     * Test of transmitirMensagem method, of class Central.
     */
    @Test
    public void testTransmitirMensagem() throws Exception {
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
        
        Central central = new Central(celulares, antenas, 1);       
        central.transmitirMensagem(mensagem);
        assertEquals(mensagem, c2.getUltimaMensagem());
    }

    /**
     * Test of identificarCelular method, of class Central.
     */
    @Test
    public void testIdentificarCelular() {
        System.out.println("identificarCelular");
        Map<String, Celular> celulares = new HashMap<String, Celular>();
        Map<String, Antena> antenas = new HashMap<String, Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.put("antena1", a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.put("99994438", c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.put("99932438", c2);
        
        Central central = new Central(celulares, antenas, 1);

        
        assertEquals(c1, central.identificarCelular("99994438"));
        assertEquals(c2, central.identificarCelular("99932438"));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAntenas method, of class Central.
     */
    @Test
    public void testGetAntenas() {
        System.out.println("getAntenas");
        Map<String, Celular> celulares = new HashMap<String, Celular>();
        Map<String, Antena> antenas = new HashMap<String, Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.put("antena1", a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.put("99994438", c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.put("99932438", c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        Central central = new Central(celulares, antenas, 1);
        assertEquals(antenas, central.getMapAntenas());
        
    }
    
}
