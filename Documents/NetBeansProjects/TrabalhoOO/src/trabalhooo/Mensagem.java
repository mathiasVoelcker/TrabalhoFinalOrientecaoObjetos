/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

/**
 *
 * @author user
 */
public class Mensagem {
    
    private String texto;
    private String numCelularDesejado;
    private String numCelularEnviando;
    private int tempoDoEnvio;
    private int tempoDeEntrega;
    private boolean enviada;
    private boolean passouPelaCentral = false;
    
    public Mensagem(String texto, String numCelularDesejado, String numCelularEnviando){
        this.texto = texto;
        this.numCelularDesejado = numCelularDesejado;
        this.numCelularEnviando = numCelularEnviando;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public String getNumCelularDesejado(){
        return numCelularDesejado;
    }
    
    public String getNumCelularEnviando(){
        return numCelularEnviando;
    }
    
    public int getTempoDoEnvio(){
        return tempoDoEnvio;
    }
    
    public void setTempoDeEnvio(int segundos){
        tempoDoEnvio = segundos;
    }
    
    public void setTempoDeEntrega(int segundos){
        tempoDeEntrega = segundos - tempoDoEnvio;
    }
    
    public int getTempoDeEntrega(){
        return tempoDeEntrega;
    }
    
    public void setEnviada(boolean estado){
        enviada = estado;
    }
    
    public void passarPelaCentral(){
        passouPelaCentral = true;
    }
    
    public boolean getPassouPelaCentral(){
        return passouPelaCentral;
    }
}
