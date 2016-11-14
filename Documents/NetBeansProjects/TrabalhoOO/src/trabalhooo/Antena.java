/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;

/**
 *
 * @author user
 */
public class Antena {
    
    private int localizacao;
    private String nome;
    private int capacidadeAtendimentos;
    private int tempoTransmissao;
    
    public Antena(int localizacao, String nome, int capacidadeAtendimentos, int tempoTransmissao){
        this.localizacao = localizacao;
        this.nome = nome;
        this.capacidadeAtendimentos = capacidadeAtendimentos;
        this.tempoTransmissao = tempoTransmissao;
    }
    
    public int getLocalizacao(){
        return localizacao;
    }
    
    public void solicitarCentral(String numCelularDesejado, Central central, String mensagem) throws InterruptedException{
        sleep(tempoTransmissao);
        System.out.println(nome + " enviando mensagem para central.");
        central.transmitirMensagem(numCelularDesejado, mensagem);
    }
    
    public void enviarMensagem(Celular celularDesejado, String mensagem) throws InterruptedException{
        sleep(tempoTransmissao);
        System.out.println(nome + " enviando mensagem para celular");
        celularDesejado.receberMensagem(mensagem);
    }
}
