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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.Timer;
import static trabalhooo.Aplicacao.simulacao;

/**
 *
 * @author user
 */
public class Central {
    private Map<String, Antena> mapAntenas = new HashMap<String, Antena>();
    private Map<String, Celular> mapCelulares = new HashMap<String, Celular>();
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    private List<Mensagem> mensagensDeErro = new ArrayList<Mensagem>();
    private List<Mensagem> mensagensNaoEnviadas = new ArrayList<Mensagem>();
    private Stack pilhaMensagens = new Stack();
    private boolean transmissaoEmAndamento = false;
    private int tempoDeTransmissao;

    
    public Central(Map<String, Celular> celulares, Map<String, Antena> antenas, int tempoDeTransmissao){
        this.mapCelulares = celulares;
        this.mapAntenas = antenas;
        this.tempoDeTransmissao = tempoDeTransmissao;
    }
    
    public void transmitirMensagem(Mensagem mensagem) throws InterruptedException{
        mensagem.passarPelaCentral();
        if(!transmissaoEmAndamento){
            Celular celularDesejado = identificarCelular(mensagem.getNumCelularDesejado()); 
            Antena antenaMaisProxima = celularDesejado.getAntenaMaisProxima();
            transmissaoEmAndamento = true;
            sleep(tempoDeTransmissao);
            System.out.println("Enviando mensagem de " + mensagem.getNumCelularEnviando() + " da central para antena " + antenaMaisProxima.getNome());
            simulacao = simulacao + "Enviando mensagem de " + mensagem.getNumCelularEnviando() + " da central para antena " + antenaMaisProxima.getNome() + "\n";
            transmissaoEmAndamento = false;
            antenaMaisProxima.enviarMensagem(celularDesejado, mensagem, this); 
            if(!pilhaMensagens.isEmpty()){
                transmitirMensagem((Mensagem) pilhaMensagens.pop());
                System.out.println("Numero de mensagens na PILHA: " + pilhaMensagens.size());
                simulacao = simulacao + "Numero de mensagens na PILHA: " + pilhaMensagens.size() + "\n";
            }
        }
        else{
            pilhaMensagens.push(mensagem);
            System.out.println("Inserir na pilha mensagem de " + mensagem.getNumCelularEnviando());
            simulacao = simulacao + "Inserir na pilha mensagem de " + mensagem.getNumCelularEnviando() + "\n";
            System.out.println("Numero de mensagens na PILHA: " + pilhaMensagens.size());
            simulacao = simulacao + "Numero de mensagens na PILHA: " + pilhaMensagens.size() + "\n";
        }
    }
    
    public Celular identificarCelular(String numCelularDesejado){
//        Celular celularDesejado = new Celular("98745678", new Antena("antena2", 3, 3000, 4)); //linha de codigo so para funcionar a aplicacao, depois com a implementacao dos casos de erro essa linha sai
        Celular celularDesejado = mapCelulares.get(numCelularDesejado);
//        for(Celular celular : celulares){
//            if(celular.getNumero().equals(numCelularDesejado))
//                celularDesejado = celular;
//        }
        return celularDesejado;
    }
    

    
    public Map<String, Antena> getMapAntenas(){
        return mapAntenas;
    }
    
    public Map<String, Celular> getMapCelulares(){
        return mapCelulares;
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
    
    public void interromperCronometro(){
        cronometro.interromperCronometro();
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
    
    public double getTempoMedioMensagens(){
        double somatorioTempoDeEntrega = 0;
        double numCelulares = 0;
        for(Mensagem mensagem: mensagens){
            if(mensagem.getEnviada()){
                somatorioTempoDeEntrega = somatorioTempoDeEntrega + (double)mensagem.getTempoDeEntrega();
                numCelulares = numCelulares + 1;
            }
        }
        double media = somatorioTempoDeEntrega/numCelulares;
        return media;
    }
    
    public String getString(){
        return "Central com " + mapAntenas.size() + " antenas, " + mapCelulares.size() + " celulares e tempo de transmissao de " + tempoDeTransmissao + " segundos";
    }
}

