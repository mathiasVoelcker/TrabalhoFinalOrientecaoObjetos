/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Celular {
    
    private String numero;
    private Antena antenaMaisProxima;
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    
    public Celular(String numero, Antena antenaMaisProxima){
        this.numero = numero;
        this.antenaMaisProxima = antenaMaisProxima;
    }
    
    public void enviarMensagem(String numCelularDesejado,  String mensagemTexto, Central central) throws InterruptedException{
        Mensagem mensagem = new Mensagem(mensagemTexto, numCelularDesejado, numero);
        mensagem.setTempoDeEnvio(central.getSegundosCronometro());
        antenaMaisProxima.solicitarCentral(central, mensagem, this);
    }
    
    public void receberMensagem(Mensagem mensagem, Central central){
        mensagens.add(mensagem);
        if(central != null){
            mensagem.setTempoDeEntrega(central.getSegundosCronometro());
            System.out.println("================================================================================");
            System.out.println("Tempo para mensagem chegar: " + mensagem.getTempoDeEntrega());
            System.out.println("================================================================================");

        }
        System.out.println(this.getNumero() +  " recebeu a mensagem" + ": " + mensagem.getTexto() + " de " + mensagem.getNumCelularEnviando());
    }
    
    public String getNumero(){
        return numero;
    }
    
    public Antena getAntenaMaisProxima(){
        return antenaMaisProxima;
    }
        
    public Mensagem getUltimaMensagem(){
        return mensagens.get((mensagens.size())-1);
    }
    
}
