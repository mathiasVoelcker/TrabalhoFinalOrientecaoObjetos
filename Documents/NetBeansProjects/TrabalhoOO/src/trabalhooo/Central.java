/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Central {
    private List<Antena> antenas = new ArrayList<Antena>();
    private List<Celular> celulares = new ArrayList<Celular>();
    private Stack pilhaMensagens = new Stack();

    
    public Central(List<Celular> celulares, List<Antena> antenas){
        this.celulares = celulares;
        this.antenas = antenas;
    }
    
    public void empilharMensagem(Mensagem mensagem){
        pilhaMensagens.push(mensagem);
    }
    
    public void transmitirMensagem(Mensagem mensagem) throws InterruptedException{
        Celular celularDesejado = identificarCelular(mensagem.getNumCelularDesejado()); 
        Antena antenaMaisProxima = celularDesejado.getAntenaMaisProxima();
        antenaMaisProxima.enviarMensagem(celularDesejado, mensagem.getTexto(), mensagem.getNumCelularEnviando());
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
    
}
