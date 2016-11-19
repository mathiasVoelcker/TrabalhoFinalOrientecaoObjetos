/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Cronometro cronometro = new Cronometro();
        
        //========================DEVE SER LIDO DE UM ARQUIVO TEXTO==============================================
        List<Celular> celulares = new ArrayList<Celular>();
        List<Antena> antenas = new ArrayList<Antena>();
                
        Antena a1 = new Antena("antena1", 4, 4000, 5);
        antenas.add(a1);
        Antena a2 = new Antena("antena2", 3, 3000, 4);
        antenas.add(a2);
        Antena a3 = new Antena("antena3", 3, 5000, 3);
        antenas.add(a3);
        Antena a4 = new Antena("antena4", 6, 2000, 6);
        antenas.add(a4);
        
        Celular c1 = new Celular("99994438", a3);
        celulares.add(c1);
        Celular c2 = new Celular("99932438", a1);
        celulares.add(c2);
        Celular c3 = new Celular("94432438", a2);
        celulares.add(c3);
        Celular c4 = new Celular("99126438", a3);
        celulares.add(c4);
        Celular c5 = new Celular("99997796", a4);
        celulares.add(c5);
        Celular c6 = new Celular("99243565", a4);
        celulares.add(c6);
        
        Central central = new Central(celulares, antenas);
        //=======================================================================================================
        
        cronometro.iniciaCronometro(central);
        System.out.println("Seja bem vindo!");
        System.out.println("Por favor, insira o numero do comando desejado");
        System.out.println("1 - Cadastrar um celular");
        System.out.println("2 - Enviar uma mensagem");
        System.out.println("3 - Imprimir dados da Central");
        System.out.println("4 - Imprimir dados das Antenas");
        System.out.println("5 - Imprimir dados dos Celulares");
        
        
        //=====================================DEVE SER LIDO DE UM ARQUIVO TEXTO==========================================
        Thread thread1 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99932438", "0pa, tudo bom1?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread2 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99997796", "0pa, tudo bom2?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread3 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99997796", "0pa, tudo bom3?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread4 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("94432438", "0pa, tudo bom4?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread5 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99243565", "0pa, tudo bom5?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread6 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99243565", "0pa, tudo bom6?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread7 = new Thread(){
            public void run(){
                try {
                    c1.enviarMensagem("99243565", "0pa, tudo bom7?", central);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread thread8 = new Thread(){
            public void run(){
                while(cronometro.getCurrentSegundo() < 30){
                    if(cronometro.getCurrentSegundo() == 5 && cronometro.getCurrentSegundo() != 0)
                        System.out.println(cronometro.getCurrentSegundo() + "=================================");
                        
                }
            }
        };
        
        thread8.start();
        thread1.start();
        sleep(1000);
        thread2.start();
        sleep(1000);
        thread3.start();
        sleep(1000);
        thread4.start();
        sleep(1000);
        thread5.start();
        sleep(1000);
        thread6.start();
        sleep(1000);
        thread7.start();
        
        //=====================================================================================
    }  
    
//
}
