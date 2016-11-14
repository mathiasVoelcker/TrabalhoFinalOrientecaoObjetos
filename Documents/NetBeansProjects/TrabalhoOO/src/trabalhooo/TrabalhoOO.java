/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class TrabalhoOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
        int tempoMensagem = 5000;
        
        Celular c1 = new Celular("99994438", 2);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", 7);
        celulares.add(c2);
        Celular c3 = new Celular("94432438", 9);
        celulares.add(c3);
        Celular c4 = new Celular("99126438", 6);
        celulares.add(c4);
        Celular c5 = new Celular("99997796", 4);
        celulares.add(c5);
        Celular c6 = new Celular("99243565", 11);
        celulares.add(c6);
                
        Antena a1 = new Antena(4, "antena1", 4, 4000);
        antenas.add(a1);
        Antena a2 = new Antena(13, "antena2", 3, 3000);
        antenas.add(a2);
        Antena a3 = new Antena(1, "antena3", 3, 5000);
        antenas.add(a3);
        Antena a4 = new Antena(8, "antena4", 6, 2000);
        antenas.add(a4);
        
        Central central = new Central(celulares, antenas);
        
        c1.enviarMensagem("99997796", central, "0pa, tudo bom?");
    }
    
}