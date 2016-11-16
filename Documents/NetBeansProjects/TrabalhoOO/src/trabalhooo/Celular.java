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
    private List<String> mensagens = new ArrayList<String>();
    
    public Celular(String numero, Antena antenaMaisProxima){
        this.numero = numero;
        this.antenaMaisProxima = antenaMaisProxima;
    }
    
    public void enviarMensagem(String numCelularDesejado,  String mensagemTexto, Central central) throws InterruptedException{
        Mensagem mensagem = new Mensagem(mensagemTexto, numCelularDesejado, numero);
        antenaMaisProxima.solicitarCentral(central, mensagem, this);
    }
    
    public void receberMensagem(String mensagem, String numCelularEnviando){
        mensagens.add(mensagem);
        System.out.println(this.getNumero() +  " recebeu a mensagem" + ": " + mensagem + " de " + numCelularEnviando);
    }
    
    public String getNumero(){
        return numero;
    }
    
    public Antena getAntenaMaisProxima(){
        return antenaMaisProxima;
    }
    
//    public Mensagem escreverMensagem(String texto, String numCelularDesejado){
//        return new Mensagem(texto, numCelularDesejado, numero);
//    }
    
    public int distancia(int local1, int local2){
        return Math.abs(local1 - local2); //math.abs faz o modulo de tal numero, assim mesmo se a subtracao der valor negativo, vai retornar um valor positivo
    }
    
}
