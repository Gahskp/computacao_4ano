/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

/**
 *
 * @author oliver
 */
public class NineManMorrisGameGUI {

    /**
     * @param args the command line arguments
     */
    
    private static class NineManMorrisPanel extends JPanel implements ActionListener {
        
        public JRadioButton check [][] = new JRadioButton[7][7];
        
        public NineManMorrisPanel(){
            check[0][0] = new JRadioButton();
            check[3][0] = new JRadioButton();
            check[6][0] = new JRadioButton();

            check[1][1] = new JRadioButton();
            check[3][1] = new JRadioButton();
            check[5][1] = new JRadioButton();

            check[2][2] = new JRadioButton();
            check[3][2] = new JRadioButton();
            check[4][2] = new JRadioButton();

            check[0][3] = new JRadioButton();
            check[1][3] = new JRadioButton();
            check[2][3] = new JRadioButton();
            check[4][3] = new JRadioButton();
            check[5][3] = new JRadioButton();
            check[6][3] = new JRadioButton();

            check[2][4] = new JRadioButton();
            check[3][4] = new JRadioButton();
            check[4][4] = new JRadioButton();

            check[1][5] = new JRadioButton();
            check[3][5] = new JRadioButton();
            check[5][5] = new JRadioButton();

            check[0][6] = new JRadioButton();
            check[3][6] = new JRadioButton();
            check[6][6] = new JRadioButton();
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
			
	}
    }
    
    public JFrame constructApplicationFrame() {
        JFrame frame = new JFrame();
        JPanel panel = new NineManMorrisPanel();
        frame.add(panel, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new NineManMorrisGameGUI().constructApplicationFrame();
        frame.setSize(300, 300);
	frame.setVisible(true);
    }
    
}
