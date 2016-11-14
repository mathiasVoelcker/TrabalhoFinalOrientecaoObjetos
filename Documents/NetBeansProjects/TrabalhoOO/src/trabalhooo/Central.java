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
public class Central {
    private List<Antena> antenas = new ArrayList<Antena>();
    private List<Celular> celulares = new ArrayList<Celular>();

    
    public Central(List<Celular> celulares, List<Antena> antenas){
        this.celulares = celulares;
        this.antenas = antenas;
    }
    
    public void transmitirMensagem(String numCelularDesejado, String mensagem){
        Celular celularDesejado = identificarCelular(numCelularDesejado); 
        Antena antenaMaisProxima = antenas.get(0);
        
        for(Antena antena : antenas){
            if(distancia(celularDesejado, antena) < distancia(celularDesejado, antenaMaisProxima))
                antenaMaisProxima = antena;
        }
        
        antenaMaisProxima.enviarMensagem(celularDesejado, mensagem);
    }
    
    public Celular identificarCelular(String numCelularDesejado){
        Celular celularDesejado = new Celular("98745678", 5, 2); //linha de codigo so para funcionar a aplicacao, depois com a implementacao dos casos de erro essa linha sai
        for(Celular celular : celulares){
            if(celular.getNumero().equals(numCelularDesejado))
                celularDesejado = celular;
        }
        return celularDesejado;
    }
    
    public int distancia(Celular celular, Antena antena){
        return Math.abs(celular.getLocalizacao() - antena.getLocalizacao()); //math.abs faz o modulo de tal numero, assim mesmo se a subtracao der valor negativo, vai retornar um valor positivo
    }
    
    public List<Antena> getAntenas(){
        return antenas;
    }
    
}
