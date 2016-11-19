/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import static java.lang.Thread.sleep;
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
    private boolean transmissaoEmAndamento = false;

    
    public Central(List<Celular> celulares, List<Antena> antenas){
        this.celulares = celulares;
        this.antenas = antenas;
    }
    
    public void transmitirMensagem(Mensagem mensagem) throws InterruptedException{
        if(!transmissaoEmAndamento){
            Celular celularDesejado = identificarCelular(mensagem.getNumCelularDesejado()); 
            Antena antenaMaisProxima = celularDesejado.getAntenaMaisProxima();
            transmissaoEmAndamento = true;
            System.out.println("TRANSMISSOES NA CENTRAL: " + transmissaoEmAndamento);
            sleep(8);
            antenaMaisProxima.enviarMensagem(celularDesejado, mensagem);
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
}
