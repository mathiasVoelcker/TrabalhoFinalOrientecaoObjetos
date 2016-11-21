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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       
        //========================DEVE SER LIDO DE UM ARQUIVO TEXTO==============================================
        Map<String, Celular> mapCelulares = new HashMap<String, Celular>();
        Map<String, Antena> mapAntenas = new HashMap<String, Antena>();
        Map<String, Central> mapCentral = new HashMap<String, Central>();
                
        Arquivos a = new Arquivos();
        a.leituraArquivo(mapAntenas);
        
//        System.out.println(mapAntenas.containsKey("a1"));
//        System.out.println(mapAntenas.containsKey("a2"));
//        System.out.println(mapAntenas.containsKey("a3"));
//        System.out.println(mapAntenas.containsKey("a4"));
//        System.out.println(mapAntenas.containsKey("a5"));
//        System.out.println(mapAntenas.containsKey("a6"));
        //==========================MUDAR ADD PARA PUT
//        Antena a1 = new Antena("antena1", 4, 4000, 5);
//        mapAntenas.put("antena1", a1);
//        Antena a2 = new Antena("antena2", 3, 3000, 4);
//        mapAntenas.put("antena2", a2);
//        Antena a3 = new Antena("antena3", 3, 5000, 3);
//        antenas.add(a3);
//        Antena a4 = new Antena("antena4", 6, 2000, 6);
//        antenas.add(a4);
//        
     
          a.leituraArquivoCelular(mapCelulares, mapAntenas);
//        Celular c1 = new Celular("999943338", a1);
//        mapCelulares.put("999943338", c1);
//        Celular c2 = new Celular("9915326295", a1);
//        mapCelulares.put("991536295", c2);
        
        
//        Celular c2 = new Celular("99932438", a1);
//        celulares.add(c2);
//        Celular c3 = new Celular("94432438", a2);
//        celulares.add(c3);
//        Celular c4 = new Celular("99126438", a3);
//        celulares.add(c4);
//        Celular c5 = new Celular("99997796", a4);
//        celulares.add(c5);
//        Celular c6 = new Celular("99243565", a4);
//        celulares.add(c6);
        
        Central central = new Central(mapCelulares, mapAntenas, 4);
                mapCentral.put("Central", central);
        
        
        a.escritaArquivo();
        central.iniciarCronometro();
        a.leituraArquivoEventos(mapCelulares, mapCentral);
        
        //=======================================================================================================
        
        
//        =====================================DEVE SER LIDO DE UM ARQUIVO TEXTO==========================================
//        Thread thread1 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99994438", "0pa, tudo bom1?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread2 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99126438", "0pa, tudo bom2?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread3 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99243565", "0pa, tudo bom3?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread4 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("94432438", "0pa, tudo bom4?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread5 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99243565", "0pa, tudo bom5?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread6 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99994438", "0pa, tudo bom6?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread7 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99243565", "0pa, tudo bom7?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread8 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99243565", "0pa, tudo bom6?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        Thread thread9 = new Thread(){
//            public void run(){
//                try {
//                    c1.enviarMensagem("99994438", "0pa, tudo bom7?", central);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//                    interfaceComUsuario(central);
//                }
//            }
//        };
//        
//        central.iniciarCronometro();
//        thread1.start();
//        sleep(100);
//        thread2.start();
//        sleep(100);
//        thread3.start();
//        sleep(100);
//        thread4.start();
//        sleep(100);
//        thread5.start();
//        sleep(100);
//        thread6.start();
//        sleep(100);
//        thread7.start();
//        sleep(100);
//        thread8.start();
//        sleep(100);
//        thread9.start();
        
        //=====================================================================================
        
     //  a.escritaArquivo();
        
    }  
    
    public static void interfaceComUsuario(Central central){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Seja bem vindo!");
        System.out.println("Por favor, insira o numero do comando desejado");
        System.out.println("1 - Rodar Simulacao");
        System.out.println("2 - Imprimir dados dos Celulares");
        System.out.println("3 - Imprimir dados das Antenas");
        System.out.println("4 - Imprimir dados da Central");
        
        String texto = entrada.next();
        System.out.println(texto);
        
        switch(texto){
            case "1": break;
            case "2": imprimirDadosCelulares();
            break;
            case "3": imprimirDadosAntenas();
            break;
            case "4": imprimirDadosCentral();
            break;  
        }
    }
    
    public static void listarParametros(){
        
    }
    
    public static void mostrarEventos(){
        
    }
    
    public static void mostrarResultadoSimulacao(){
        
    }
    
    public static void imprimirDadosCelulares(){

    }
    
    public static void imprimirDadosAntenas(){
        
    }
    
    public static void imprimirDadosCentral(){
        
    }
//
}
