/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;

import java.lang.Thread;

/**
 *
 * @author oliver
 */
public class NineManMorris extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
//        testeThread th = new testeThread();
//        Thread teste = new Thread(th);
//        teste.start();
        
        TabuleiroTeste tabuleiro = new TabuleiroTeste();
        tabuleiro.addButtons();
        tabuleiro.addListener();
        
        Thread threadTabuleiro = new Thread(tabuleiro);
        threadTabuleiro.start();
        
    }
    
}
