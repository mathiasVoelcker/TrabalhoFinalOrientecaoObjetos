/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.TimerTask;

/**
 *
 * @author user
 */
public class Cronometro {
    
    private Timer cronometro;
    private int currentSegundo = 0;
    private int velocidade = 1000;
    
    public void iniciaCronometro(){
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentSegundo++;
                if(currentSegundo == 2){
                    System.out.println(currentSegundo);
                }
                
                
            }
        }; 
        this.cronometro = new Timer(velocidade, action);
        this.cronometro.start();
    }
    
    public int getCurrentSegundo(){
        return currentSegundo;
    }
    
    
}
