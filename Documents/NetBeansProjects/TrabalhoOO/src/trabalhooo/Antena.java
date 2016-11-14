/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author user
 */
public class Antena {
    
    private int localizacao;
    private String nome;
    private int capacidadeAtendimentos;
    private int tempoTransmissao;
    private int capacidadeFila;
    
    private Queue<Mensagem> mensagens = new LinkedList<Mensagem>();
    private int numTransmissoesEmAndamento = 0;
    
    
    public Antena(int localizacao, String nome, int capacidadeAtendimentos, int tempoTransmissao, int capacidadeFila){
        this.localizacao = localizacao;
        this.nome = nome;
        this.capacidadeAtendimentos = capacidadeAtendimentos;
        this.tempoTransmissao = tempoTransmissao;
        this.capacidadeFila = capacidadeFila;
    }
    
    public int getLocalizacao(){
        return localizacao;
    }
    
    public void solicitarCentral(Central central, Mensagem mensagem) throws InterruptedException{
        if(numTransmissoesEmAndamento < capacidadeAtendimentos){
            numTransmissoesEmAndamento = numTransmissoesEmAndamento + 1;
            System.out.println("transmissoes em andamento: " + numTransmissoesEmAndamento);
            sleep(tempoTransmissao);
            System.out.println(nome + " enviando mensagem para central.");
            central.transmitirMensagem(mensagem);
            numTransmissoesEmAndamento = numTransmissoesEmAndamento - 1;
        }
        else if(inserirTransmissaoNaFila(mensagem)){
            System.out.println("tamanho da fila: " + mensagens.size());
            sleep(tempoTransmissao);
            System.out.println(nome + " enviando mensagem para central.");
            central.transmitirMensagem(mensagem);
        }
        else{
            //mensagem de erro
        }
            
    }
    
    public void enviarMensagem(Celular celularDesejado, String mensagem) throws InterruptedException{
        sleep(tempoTransmissao);
        System.out.println(nome + " enviando mensagem para celular");
        celularDesejado.receberMensagem(mensagem);
    }
    
    public boolean inserirTransmissaoNaFila(Mensagem mensagem){
        if(mensagens.size() < capacidadeFila){
            mensagens.add(mensagem);
            return true;
        }
        else
            return false;
    }
}
