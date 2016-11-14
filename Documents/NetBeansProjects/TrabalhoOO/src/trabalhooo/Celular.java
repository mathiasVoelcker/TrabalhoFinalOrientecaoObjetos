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
    private int localizacao;
    private Antena antenaMaisProxima;
    private List<String> mensagens = new ArrayList<String>();
    
    public Celular(String numero, int localizacao){
        this.numero = numero;
        this.localizacao = localizacao;
    }
    
    public void enviarMensagem(String numCelularDesejado, Central central, String mensagem) throws InterruptedException{
        procurarAntena(central.getAntenas());
        antenaMaisProxima.solicitarCentral(numCelularDesejado, central, mensagem);
    }
    
    public void procurarAntena(List<Antena> antenas){
        antenaMaisProxima = antenas.get(0);
        for(Antena antena: antenas){
            if((antenaMaisProxima.getLocalizacao() - localizacao) > (antena.getLocalizacao() - localizacao))
                antenaMaisProxima = antena;
        }
    }
    
    public void receberMensagem(String mensagem){
        mensagens.add(mensagem);
        System.out.println(this.getNumero() + ": " + mensagem);
    }
    
    public String getNumero(){
        return numero;
    }
    
    public int getLocalizacao(){
        return localizacao;
    }
    
}
