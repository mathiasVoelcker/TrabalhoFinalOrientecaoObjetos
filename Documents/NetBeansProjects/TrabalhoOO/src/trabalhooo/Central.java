/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class Central {
    private List<Antena> antenas = new ArrayList<Antena>();
    private List<Celular> celulares = new ArrayList<Celular>();
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    private List<Mensagem> mensagensDeErro = new ArrayList<Mensagem>();
    private List<Mensagem> mensagensNaoEnviadas = new ArrayList<Mensagem>();
    private Stack pilhaMensagens = new Stack();
    private boolean transmissaoEmAndamento = false;
    private int tempoDeTransmissao;

    
    public Central(List<Celular> celulares, List<Antena> antenas, int tempoDeTransmissao){
        this.celulares = celulares;
        this.antenas = antenas;
        this.tempoDeTransmissao = tempoDeTransmissao;
    }
    
    public void transmitirMensagem(Mensagem mensagem) throws InterruptedException{
        mensagem.passarPelaCentral();
        if(!transmissaoEmAndamento){
            Celular celularDesejado = identificarCelular(mensagem.getNumCelularDesejado()); 
            Antena antenaMaisProxima = celularDesejado.getAntenaMaisProxima();
            transmissaoEmAndamento = true;
            sleep(tempoDeTransmissao);
            antenaMaisProxima.enviarMensagem(celularDesejado, mensagem, this);
            transmissaoEmAndamento = false;
            if(!pilhaMensagens.isEmpty()){
                transmitirMensagem((Mensagem) pilhaMensagens.pop());
                System.out.println("Numero de mensagens na PILHA: " + pilhaMensagens.size());
            }
        }
        else{
            pilhaMensagens.push(mensagem);
            System.out.println("Numero de mensagens na PILHA: " + pilhaMensagens.size());
        }
    }
    
    public Celular identificarCelular(String numCelularDesejado){
        Celular celularDesejado = new Celular("98745678", new Antena("antena2", 3, 3000, 4)); //linha de codigo so para funcionar a aplicacao, depois com a implementacao dos casos de erro essa linha sai
        for(Celular celular : celulares){
            if(celular.getNumero().equals(numCelularDesejado))
                celularDesejado = celular;
        }
        return celularDesejado;
    }
    

    
    public List<Antena> getAntenas(){
        return antenas;
    }
    
    public Stack getPilha(){
        return pilhaMensagens;
    }
    
    
    Cronometro cronometro = new Cronometro();
    
    public int getSegundosCronometro(){
        return cronometro.getCurrentSegundo();
    }
    
    public void iniciarCronometro(){
        cronometro.iniciarCronometro();
    }
    
    public void addMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
    }
    
    public List<Mensagem> getMensagens(){
        return mensagens;
    }
    
    public void addMensagemDeErro(Mensagem mensagem){
        mensagensDeErro.add(mensagem);
    }
    
    public List<Mensagem> getMensagensDeErro(){
        return mensagensDeErro;
    }
    
    public void addMensagemNaoEnviada(Mensagem mensagem){
        mensagensNaoEnviadas.add(mensagem);
    }
    
    public List<Mensagem> getMensagensNaoEnviadas(){
        return mensagensNaoEnviadas;
    }
    
}

