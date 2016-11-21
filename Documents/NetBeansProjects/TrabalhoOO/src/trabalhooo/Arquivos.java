/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Arquivos {
    int qntCelulares = 0;
    int qntAntenas = 0;
    
    public void leituraArquivoAntenas(Map<String, Antena> mapAntenas){
		BufferedReader br = null;
		try {
			String linha = null;
			br = new BufferedReader(new FileReader("D:\\Temp\\antenas.txt"));
			while ((linha = br.readLine()) != null) {
                                Scanner sc = new Scanner(linha).useDelimiter(";");
				String antenaNome = sc.next();
                                int capacidadeAntena = Integer.parseInt(sc.next());
                                int tempoTransmissao = Integer.parseInt(sc.next());
                                int capacidadeFila = Integer.parseInt(sc.next());
                                System.out.println(antenaNome + ", " + capacidadeAntena + ", " + tempoTransmissao + ", " + capacidadeFila);
//                              System.out.println(antenaNome + " " + capacidadeAntena + " "+tempoTransmissao + " " + capacidadeFila);
                                mapAntenas.put(antenaNome, new Antena(antenaNome, capacidadeAntena, tempoTransmissao, capacidadeFila));
                                qntAntenas = qntAntenas + 1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                System.out.println("qnt antenas="+qntAntenas);               
    }
    
    
    public void leituraArquivoEventos(Map<String, Celular> mapCelulares, Map<String, Central> mapCentral) throws InterruptedException{
        BufferedReader br = null;

		try {

			String linha = null;
                        

			br = new BufferedReader(new FileReader("D:\\Temp\\eventos.txt"));

			while ((linha = br.readLine()) != null) {
                                Scanner sc = new Scanner(linha).useDelimiter(";");
				String numCelularEnviando = sc.next();
                                String numCelularDesejado = sc.next();
                                String mensagemTexto = sc.next();
                                String nomeCentral = sc.next();
                                System.out.println(numCelularEnviando);
                                Thread thread = new Thread(){
                                    @Override
                                    public void run(){
                                        try {
                                            mapCelulares.get(numCelularEnviando).enviarMensagem(numCelularDesejado, mensagemTexto,  mapCentral.get(nomeCentral));
                                            
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                };
                                thread.start();
                                sleep(200);
      
//                                System.out.println(antenaNome + " " + capacidadeAntena + " "+tempoTransmissao + " " + capacidadeFila);   
			}
                        

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                
    }
    
    //ARMAZENAMENTO DE CELULARES
    public void leituraArquivoCelular(Map<String, Celular> mapCelulares, Map<String, Antena> mapAntenas) throws InterruptedException{
         BufferedReader br = null;

		try {
                   	String linha = null;
                        
			br = new BufferedReader(new FileReader("D:\\Temp\\celulares.txt"));

			while ((linha = br.readLine()) != null) {
                            Scanner sc = new Scanner(linha).useDelimiter(";");
                            String numero = sc.next();
                            Antena antenaMaisProxima = mapAntenas.get(sc.next());
                            System.out.println(numero + ", " + antenaMaisProxima.getNome());
                            mapCelulares.put(numero, new Celular (numero, antenaMaisProxima));
                            qntCelulares = qntCelulares + 1;
                        }
                }catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
             
                        System.out.println("qnt celulares="+qntCelulares);
    }
    }

    public static void escritaArquivo(){
        try {
            PrintStream out = new PrintStream(new FileOutputStream("D:\\Temp\\log.txt"));
            System.setOut(out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Log registrado");
      }
}

