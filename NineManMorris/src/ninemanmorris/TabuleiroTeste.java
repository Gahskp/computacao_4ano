/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ninemanmorris;

import javax.swing.JRadioButton;
import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author oliver
 */

public class TabuleiroTeste extends JFrame {
    
    private JRadioButton check1, check2, check3, check4, check5, check6,
        check7, check8, check9, check10, check11, check12, check13, check14, check15, 
        check16, check17, check18, check19, check20, check21, check22, check23, check24;
    
    public TabuleiroTeste() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
    
        setVisible(true);
    }
    
    public void addButtons(){
        

        check1 = new JRadioButton();
        check2 = new JRadioButton();
        check3 = new JRadioButton();
        check4 = new JRadioButton();
        check5 = new JRadioButton();
        check6 = new JRadioButton();
        check7 = new JRadioButton();
        check8 = new JRadioButton();
        check9 = new JRadioButton();
        check10 = new JRadioButton();
        check11 = new JRadioButton();
        check12 = new JRadioButton();
        check13 = new JRadioButton();
        check14 = new JRadioButton();
        check15 = new JRadioButton();
        check16 = new JRadioButton();
        check17 = new JRadioButton();
        check18 = new JRadioButton();
        check19 = new JRadioButton();
        check20 = new JRadioButton();
        check21 = new JRadioButton();
        check22 = new JRadioButton();
        check23 = new JRadioButton();
        check24 = new JRadioButton();
        
        check1.setBounds(10, 10, 20, 30);
        check2.setBounds(10, 220, 20, 30);
        check3.setBounds(10, 430, 20, 30);
        
        check4.setBounds(80, 80, 20, 30);
        check5.setBounds(80, 220, 20, 30);
        check6.setBounds(80, 360, 20, 30);
        
        check7.setBounds(150, 150, 20, 30);
        check8.setBounds(150, 220, 20, 30);
        check9.setBounds(150, 290, 20, 30);
        
        check10.setBounds(220, 10, 20, 30);
        check11.setBounds(220, 80, 20, 30);
        check12.setBounds(220, 150, 20, 30);
        check13.setBounds(220, 290, 20, 30);
        check14.setBounds(220, 360, 20, 30);
        check15.setBounds(220, 430, 20, 30);
        
        check16.setBounds(290, 150, 20, 30);
        check17.setBounds(290, 220, 20, 30);
        check18.setBounds(290, 290, 20, 30);
        
        check19.setBounds(360, 80, 20, 30);
        check20.setBounds(360, 220, 20, 30);
        check21.setBounds(360, 360, 20, 30);
        
        check22.setBounds(430, 10, 20, 30);
        check23.setBounds(430, 220, 20, 30);
        check24.setBounds(430, 430, 20, 30);
        
        add(check1);
        add(check2);
        add(check3);
        add(check4);
        add(check5);
        add(check6);
        add(check7);
        add(check8);
        add(check9);
        add(check10);
        add(check11);
        add(check12);
        add(check13);
        add(check14);
        add(check15);
        add(check16);
        add(check17);
        add(check18);
        add(check19);
        add(check20);
        add(check21);
        add(check22);
        add(check23);
        add(check24);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(10, 25, 445, 25);
        g2.draw(lin);
        lin.setLine(10, 445, 445, 445);
        g2.draw(lin);
        lin.setLine(10, 235, 150, 235);
        g2.draw(lin);
        lin.setLine(290, 235, 445, 235);
        g2.draw(lin);
        lin.setLine(80, 95, 360, 95);
        g2.draw(lin);
        lin.setLine(80, 375, 360, 375);
        g2.draw(lin);
        lin.setLine(150, 165, 290, 165);
        g2.draw(lin);
        lin.setLine(150, 305, 290, 305);
        g2.draw(lin);
        lin.setLine(20, 10, 20, 430);
        g2.draw(lin);
        lin.setLine(440, 10, 440, 430);
        g2.draw(lin);
        lin.setLine(90, 80, 90, 360);
        g2.draw(lin);
        lin.setLine(370, 80, 370, 360);
        g2.draw(lin);
        lin.setLine(160, 150, 160, 290);
        g2.draw(lin);
        lin.setLine(300, 150, 300, 290);
        g2.draw(lin);
    }
}