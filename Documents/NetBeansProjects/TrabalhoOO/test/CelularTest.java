/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import trabalhooo.Antena;
import trabalhooo.Celular;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author user
 */
public class CelularTest {
//    
    @Test
    public void procurarAntenaTest(){
        Celular celular = new Celular("97847382", 4);
        celular.procurarAntena(criarListaAntenas());
        assertEquals("antena2", celular.getAntenaMaisProxima().getNome(), 0.1);
    }
    
    public List<Antena> criarListaAntenas(){
        List<Antena> antenas = new ArrayList<Antena>();
        Antena a1 = new Antena(4, "antena1", 4, 4000, 5);
        antenas.add(a1);
        Antena a2 = new Antena(13, "antena2", 3, 3000, 4);
        antenas.add(a2);
        Antena a3 = new Antena(1, "antena3", 3, 5000, 3);
        antenas.add(a3);
        return antenas;
    }
}
