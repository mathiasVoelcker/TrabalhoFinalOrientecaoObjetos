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
    
    private String nome;
    private int capacidadeAtendimentos;
    private int capacidadeFila;
    private int tempoTransmissao;
    private Queue<Mensagem> mensagens = new LinkedList<Mensagem>();
    private int numTransmissoesEmAndamento = 0;
    
    
    public Antena(String nome, int capacidadeAtendimentos, int tempoTransmissao, int capacidadeFila){
        this.nome = nome;
        this.capacidadeAtendimentos = capacidadeAtendimentos;
        this.tempoTransmissao = tempoTransmissao;
        this.capacidadeFila = capacidadeFila;
    }
   
    
    public void solicitarCentral(Central central, Mensagem mensagem, Celular celularEnviando) throws InterruptedException{
        if(numTransmissoesEmAndamento < capacidadeAtendimentos){
            numTransmissoesEmAndamento = numTransmissoesEmAndamento + 1;
            System.out.println("transmissoes em andamento: " + numTransmissoesEmAndamento);
            System.out.println("tamanho da fila: " + mensagens.size());
            sleep(tempoTransmissao);
            System.out.println(nome + " enviando mensagem para central.");
            central.transmitirMensagem(mensagem);
            numTransmissoesEmAndamento = numTransmissoesEmAndamento - 1;
            esvaziarFila(central, celularEnviando);
        }
        else if(inserirTransmissaoNaFila(mensagem)){
            System.out.println("tamanho da fila: " + mensagens.size());
            sleep(tempoTransmissao);
        }
        else{
            Mensagem mensagemDeErro = new Mensagem("Desculpe, mensagem nao enviada.", celularEnviando.getNumero(), "Erro");
            mensagem.setEnviada(false);
            central.addMensagemDeErro(mensagemDeErro);
            enviarMensagem(celularEnviando, mensagemDeErro, new Central(null, null, 8));
        }
    }
    
    public void esvaziarFila(Central central, Celular celular) throws InterruptedException{
        while(numTransmissoesEmAndamento < capacidadeAtendimentos  && !mensagens.isEmpty()){
            if(mensagens.peek().getPassouPelaCentral())
                enviarMensagem(celular, mensagens.poll(), central);
            else
                solicitarCentral(central, mensagens.poll(), celular);
            System.out.println("transmissoes em andamento: " + numTransmissoesEmAndamento);
        }
    }
    
    public void enviarMensagem(Celular celularDesejado, Mensagem mensagem, Central central) throws InterruptedException{
        if(numTransmissoesEmAndamento < capacidadeAtendimentos){
            numTransmissoesEmAndamento = numTransmissoesEmAndamento + 1;
            System.out.println("transmissoes em andamento: " + numTransmissoesEmAndamento);
            System.out.println("tamanho da fila: " + mensagens.size());
            sleep(tempoTransmissao);
            celularDesejado.receberMensagem(mensagem, central);
            numTransmissoesEmAndamento = numTransmissoesEmAndamento - 1;
            esvaziarFila(central, celularDesejado);
        }
        else if(inserirTransmissaoNaFila(mensagem)){
            System.out.println("tamanho da fila: " + mensagens.size());
            sleep(tempoTransmissao);
        }
        else{
            mensagem.setEnviada(false);
            central.addMensagemNaoEnviada(mensagem);
            System.out.println("MENSAGEM PERDIDA!!!");
        }
    }
    
    public boolean inserirTransmissaoNaFila(Mensagem mensagem){
        if(mensagens.size() < capacidadeFila){
            mensagens.add(mensagem);
            return true;
        }
        else
            return false;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Queue<Mensagem> getMensagens(){
        return mensagens;
    }
}
