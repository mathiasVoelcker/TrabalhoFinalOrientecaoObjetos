/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
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
public class AntenaTest {
    
    public AntenaTest() {
    }
    

    /**
     * Test of solicitarCentral method, of class Antena.
     */
    @Test
    public void testSolicitarCentral() throws Exception {
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        Central central = new Central(celulares, antenas, 8);
        a1.solicitarCentral(central, mensagem, c1);
        assertEquals(mensagem, c2.getUltimaMensagem());
    }
    
    public void testSolicitarCentral1() throws Exception {
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        Central central = new Central(celulares, antenas, 8);
        a1.solicitarCentral(central, mensagem, c1);
        a1.solicitarCentral(central, mensagem, c2);
        assertEquals(mensagem, a1.getMensagens().poll());
    }

//    /**
//     * Test of esvaziarFila method, of class Antena.
//     */
    @Test
    public void testEsvaziarFila() throws Exception {
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        Central central = new Central(celulares, antenas, 8);
        a1.inserirTransmissaoNaFila(mensagem);
        Mensagem mensagemNaFila = a1.getMensagens().element();
        a1.esvaziarFila(central, c1);
        assertEquals(mensagemNaFila, c2.getUltimaMensagem());
    }
//
//    /**
//     * Test of enviarMensagem method, of class Antena.
//     */
    
    @Test
    public void testEnviarMensagem() throws Exception {
        System.out.println("enviarMensagem");
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        Celular c1 = new Celular("99994438", a1);
        Celular c2 = new Celular("99932438", a1);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        a1.enviarMensagem(c1, mensagem, null);
        assertEquals(mensagem, c1.getUltimaMensagem());
    }
//
//    /**
//     * Test of inserirTransmissaoNaFila method, of class Antena.
//     */
    @Test
    public void testInserirTransmissaoNaFila() {
        System.out.println("enviarMensagem");
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Celular c1 = new Celular("99994438", a1);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        Mensagem mensagem = new Mensagem("testeAntena1", c2.getNumero(), c1.getNumero());
        
        a1.inserirTransmissaoNaFila(mensagem);
        assertEquals(mensagem, a1.getMensagens().poll());
    }
//
    /**
     * Test of getNome method, of class Antena.
     */
    @Test
    public void testGetNome() {
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        String antenaNome = a1.getNome();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(antenaNome, "antena1");
    }
    
}
