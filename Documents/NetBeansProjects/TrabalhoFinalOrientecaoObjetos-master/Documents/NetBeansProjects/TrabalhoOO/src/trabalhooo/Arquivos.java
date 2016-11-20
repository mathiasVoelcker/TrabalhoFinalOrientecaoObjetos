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
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class Arquivos {
    
    
    public void leituraArquivo(Map<String, Antena> mapAntenas){

		BufferedReader br = null;

		try {

			String linha = null;

			br = new BufferedReader(new FileReader("D:\\Temp\\testing.txt"));

			while ((linha = br.readLine()) != null) {
                                Scanner sc = new Scanner(linha).useDelimiter(";");
				String antenaNome = sc.next();
                                int capacidadeAntena = Integer.parseInt(sc.next());
                                int tempoTransmissao = Integer.parseInt(sc.next());
                                int capacidadeFila = Integer.parseInt(sc.next());
//                              System.out.println(antenaNome + " " + capacidadeAntena + " "+tempoTransmissao + " " + capacidadeFila);
                                mapAntenas.put(antenaNome, new Antena(antenaNome, capacidadeAntena, tempoTransmissao, capacidadeFila));
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
                               
                                Thread thread1 = new Thread(){
                                    public void run(){
                                        try {
                                            mapCelulares.get(numCelularEnviando).enviarMensagem(numCelularDesejado, mensagemTexto,  mapCentral.get(nomeCentral));
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                };
                                thread1.start();
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
                            mapCelulares.put(numero, new Celular (numero, antenaMaisProxima));
                        }
                }catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
    }
    }
    public void escritaArquivo(){
        try {

			String content = "This is the content to write into file";

			File file = new File("/users/mkyong/filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

