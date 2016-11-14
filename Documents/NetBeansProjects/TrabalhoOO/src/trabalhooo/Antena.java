/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

/**
 *
 * @author user
 */
public class Antena {
    
    private int localizacao;
    private String nome;
    
    public Antena(int localizacao, String nome){
        this.localizacao = localizacao;
        this.nome = nome;
    }
    
    public int getLocalizacao(){
        return localizacao;
    }
    
    public void solicitarCentral(String numCelularDesejado, Central central, String mensagem){
        System.out.println(nome + " enviando mensagem para central.");
        central.transmitirMensagem(numCelularDesejado, mensagem);
    }
    
    public void enviarMensagem(Celular celularDesejado, String mensagem){
        System.out.println(nome + " enviando mensagem para celular");
        celularDesejado.receberMensagem(mensagem);
    }
}
