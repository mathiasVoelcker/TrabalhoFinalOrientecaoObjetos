/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Queue;
import static trabalhooo.Aplicacao.simulacao;

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
            sleep(tempoTransmissao);
            System.out.println(nome + " enviando mensagem para central.");
            simulacao = simulacao + nome + " enviando mensagem para central." + "\n";
            central.transmitirMensagem(mensagem);
            numTransmissoesEmAndamento = numTransmissoesEmAndamento - 1;
            esvaziarFila(central, celularEnviando);
        }
        else if(inserirTransmissaoNaFila(mensagem)){
            System.out.println("inserir mensagem de " + mensagem.getNumCelularEnviando() + " na fila");
            simulacao = simulacao + "inserir mensagem de " + mensagem.getNumCelularEnviando() + " na fila" + "\n";
            System.out.println("tamanho da fila: " + mensagens.size());
            simulacao = simulacao + "tamanho da fila: " + mensagens.size() + "\n";
            sleep(tempoTransmissao);
        }
        else{
            Mensagem mensagemDeErro = new Mensagem("Desculpe, mensagem nao enviada.", celularEnviando.getNumero(), "erro");
            mensagem.setEnviada(false);
            central.addMensagemDeErro(mensagemDeErro);
            enviarMensagem(celularEnviando, mensagemDeErro, new Central(null, null, 8));
        }
    }
    
    public void esvaziarFila(Central central, Celular celular) throws InterruptedException{
        while(numTransmissoesEmAndamento < capacidadeAtendimentos  && !mensagens.isEmpty()){
            System.out.println("Tirar da fila a mensagem de " + mensagens.peek().getNumCelularEnviando());
            simulacao = simulacao + "Tirar da fila a mensagem de " + mensagens.peek().getNumCelularEnviando() + "\n";
            if(mensagens.peek().getPassouPelaCentral())
                enviarMensagem(celular, mensagens.poll(), central);
            else
                solicitarCentral(central, mensagens.poll(), celular);
            
        }
    }
    
    public void enviarMensagem(Celular celularDesejado, Mensagem mensagem, Central central) throws InterruptedException{
        sleep(tempoTransmissao);
        if(numTransmissoesEmAndamento < capacidadeAtendimentos){
            numTransmissoesEmAndamento = numTransmissoesEmAndamento + 1;
            sleep(tempoTransmissao);
            System.out.println(nome + " enviando mensagem para o celular de numero " + celularDesejado.getNumero());
            simulacao = simulacao + nome + " enviando mensagem para o celular de numero " + celularDesejado.getNumero() + "\n";
            celularDesejado.receberMensagem(mensagem, central);
            numTransmissoesEmAndamento = numTransmissoesEmAndamento - 1;
            esvaziarFila(central, celularDesejado);
        }
        else if(inserirTransmissaoNaFila(mensagem)){
            System.out.println("inserir mensagem de " + mensagem.getNumCelularEnviando() + " na fila");
            simulacao = simulacao + "inserir mensagem de " + mensagem.getNumCelularEnviando() + " na fila" + "\n";
            System.out.println("tamanho da fila: " + mensagens.size());
            simulacao = simulacao + "tamanho da fila: " + mensagens.size() + "\n";
            sleep(tempoTransmissao);
        }
        else{
            mensagem.setEnviada(false);
            central.addMensagemNaoEnviada(mensagem);
            System.out.println("MENSAGEM PERDIDA!!!");
            simulacao = simulacao + "MENSAGEM PERDIDA!!!" + "\n";
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
    
    public String getString(){
        return "Antena " + nome + " de capacidade " + capacidadeAtendimentos + " e capacidade de fila " + capacidadeFila + " e tempo de transmissao de " + tempoTransmissao + " milisegundos";
    }
}
