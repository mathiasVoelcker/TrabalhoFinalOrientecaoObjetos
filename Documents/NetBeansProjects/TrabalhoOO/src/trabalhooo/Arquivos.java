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
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Arquivos {
    
    
    public Antena leituraArquivo(List<Antena> listaAntenas){

		BufferedReader br = null;

		try {

			String linha = null;

			br = new BufferedReader(new FileReader("D:\\Tempt\\testing.txt"));

			while ((linha = br.readLine()) != null) {
                                Scanner sc = new Scanner(linha).useDelimiter(";");
				String antenaNome = sc.next();
                                int capacidadeAntena = Integer.parseInt(sc.next());
                                int tempoTransmissao = Integer.parseInt(sc.next());
                                int capacidadeFila = Integer.parseInt(sc.next());
//                              System.out.println(antenaNome + " " + capacidadeAntena + " "+tempoTransmissao + " " + capacidadeFila);
                                listaAntenas.add(new Antena(antenaNome, capacidadeAntena, tempoTransmissao, capacidadeFila));
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
                
               return null; 
    }
    
    
    public void leituraArquivoEventos(List<Celular> celulares){
        BufferedReader br = null;

		try {

			String linha = null;

			br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\testing.txt"));

			while ((linha = br.readLine()) != null) {
                                Scanner sc = new Scanner(linha).useDelimiter(";");
				String antenaNome = sc.next();
                                int capacidadeAntena = Integer.parseInt(sc.next());
                                int tempoTransmissao = Integer.parseInt(sc.next());
                                int capacidadeFila = Integer.parseInt(sc.next());
//                                System.out.println(antenaNome + " " + capacidadeAntena + " "+tempoTransmissao + " " + capacidadeFila);
                                Antena a1 = new Antena(antenaNome, capacidadeAntena, tempoTransmissao, capacidadeFila);
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
