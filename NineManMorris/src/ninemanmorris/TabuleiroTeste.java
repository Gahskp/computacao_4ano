/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ninemanmorris;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author oliver
 */

public class TabuleiroTeste extends JFrame implements ActionListener, Runnable{

    private final JRadioButton check1, check2, check3, check4, check5, check6,
        check7, check8, check9, check10, check11, check12, check13, check14, check15,
        check16, check17, check18, check19, check20, check21, check22, check23, check24;

    private final int LC1 = 20, LC2=50, LC3=80, LC4=110, LC5=140, LC6=170, LC7=200;
    private final int W = 16, H = 15;

    Stats stats = new Stats();

    public TabuleiroTeste()
    {
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
        new Thread();
    }

    public void addButtons(){
        check1.setBounds(LC1, LC1, W, H);
        check2.setBounds(LC1, LC4, W, H);
        check3.setBounds(LC1, LC7, W, H);

        check4.setBounds(LC2, LC2, W, H);
        check5.setBounds(LC2, LC4, W, H);
        check6.setBounds(LC2, LC6, W, H);

        check7.setBounds(LC3, LC3, W, H);
        check8.setBounds(LC3, LC4, W, H);
        check9.setBounds(LC3, LC5, W, H);

        check10.setBounds(LC4, LC1, W, H);
        check11.setBounds(LC4, LC2, W, H);
        check12.setBounds(LC4, LC3, W, H);
        check13.setBounds(LC4, LC5, W, H);
        check14.setBounds(LC4, LC6, W, H);
        check15.setBounds(LC4, LC7, W, H);

        check16.setBounds(LC5, LC3, W, H);
        check17.setBounds(LC5, LC4, W, H);
        check18.setBounds(LC5, LC5, W, H);

        check19.setBounds(LC6, LC2, W, H);
        check20.setBounds(LC6, LC4, W, H);
        check21.setBounds(LC6, LC6, W, H);

        check22.setBounds(LC7, LC1, W, H);
        check23.setBounds(LC7, LC4, W, H);
        check24.setBounds(LC7, LC7, W, H);

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

    public void addListener(){
        check1.addActionListener(this);
        check2.addActionListener(this);
        check3.addActionListener(this);
        check4.addActionListener(this);
        check5.addActionListener(this);
        check6.addActionListener(this);
        check7.addActionListener(this);
        check8.addActionListener(this);
        check9.addActionListener(this);
        check10.addActionListener(this);
        check11.addActionListener(this);
        check12.addActionListener(this);
        check13.addActionListener(this);
        check14.addActionListener(this);
        check15.addActionListener(this);
        check16.addActionListener(this);
        check17.addActionListener(this);
        check18.addActionListener(this);
        check19.addActionListener(this);
        check20.addActionListener(this);
        check21.addActionListener(this);
        check22.addActionListener(this);
        check23.addActionListener(this);
        check24.addActionListener(this);
    }

    public void paint(Graphics g) {
        int adjvx1 = 18, adjvy1 = 44, adjvy2 = 32;
        addButtons();
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(10, 25, 445, 25);
        //g2.draw(lin);
        lin.setLine(LC1+adjvx1, LC1+adjvy1, LC1+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC1+adjvx1, LC4+adjvy1, LC1+adjvx1, LC7+adjvy2);
        g2.draw(lin);

        lin.setLine(LC2+adjvx1, LC2+adjvy1, LC2+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC2+adjvx1, LC4+adjvy1, LC2+adjvx1, LC6+adjvy2);
        g2.draw(lin);

        lin.setLine(LC3+adjvx1, LC3+adjvy1, LC3+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC3+adjvx1, LC4+adjvy1, LC3+adjvx1, LC5+adjvy2);
        g2.draw(lin);

        // ----------------

        lin.setLine(LC7+adjvx1, LC1+adjvy1, LC7+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC7+adjvx1, LC4+adjvy1, LC7+adjvx1, LC7+adjvy2);
        g2.draw(lin);

        lin.setLine(LC6+adjvx1, LC2+adjvy1, LC6+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC6+adjvx1, LC4+adjvy1, LC6+adjvx1, LC6+adjvy2);
        g2.draw(lin);

        lin.setLine(LC5+adjvx1, LC3+adjvy1, LC5+adjvx1, LC4+adjvy2);
        g2.draw(lin);
        lin.setLine(LC5+adjvx1, LC4+adjvy1, LC5+adjvx1, LC5+adjvy2);
        g2.draw(lin);


        //--------------------

        lin.setLine(LC4+adjvx1, LC1+adjvy1, LC4+adjvx1, LC2+adjvy2);
        g2.draw(lin);
        lin.setLine(LC4+adjvx1, LC2+adjvy1, LC4+adjvx1, LC3+adjvy2);
        g2.draw(lin);

        lin.setLine(LC4+adjvx1, LC5+adjvy1, LC4+adjvx1, LC6+adjvy2);
        g2.draw(lin);
        lin.setLine(LC4+adjvx1, LC6+adjvy1, LC4+adjvx1, LC7+adjvy2);
        g2.draw(lin);

        //-------------------

        //------------------

        int adjhx1=25, adjhy1 = 37, adjhx2 = 10;

        lin.setLine(LC1+adjhx1, LC1+adjhy1, LC4+adjhx2, LC1+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC1+adjhy1, LC7+adjhx2, LC1+adjhy1);
        g2.draw(lin);

        lin.setLine(LC2+adjhx1, LC2+adjhy1, LC4+adjhx2, LC2+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC2+adjhy1, LC6+adjhx2, LC2+adjhy1);
        g2.draw(lin);

        lin.setLine(LC3+adjhx1, LC3+adjhy1, LC4+adjhx2, LC3+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC3+adjhy1, LC5+adjhx2, LC3+adjhy1);
        g2.draw(lin);

        // ----------------

        lin.setLine(LC1+adjhx1, LC7+adjhy1, LC4+adjhx2, LC7+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC7+adjhy1, LC7+adjhx2, LC7+adjhy1);
        g2.draw(lin);

        lin.setLine(LC2+adjhx1, LC6+adjhy1, LC4+adjhx2, LC6+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC6+adjhy1, LC6+adjhx2, LC6+adjhy1);
        g2.draw(lin);

        lin.setLine(LC3+adjhx1, LC5+adjhy1, LC4+adjhx2, LC5+adjhy1);
        g2.draw(lin);
        lin.setLine(LC4+adjhx1, LC5+adjhy1, LC5+adjhx2, LC5+adjhy1);
        g2.draw(lin);


        //--------------------

        lin.setLine(LC1+adjhx1, LC4+adjhy1, LC2+adjhx2, LC4+adjhy1);
        g2.draw(lin);
        lin.setLine(LC2+adjhx1, LC4+adjhy1, LC3+adjhx2, LC4+adjhy1);
        g2.draw(lin);

        lin.setLine(LC5+adjhx1, LC4+adjhy1, LC6+adjhx2, LC4+adjhy1);
        g2.draw(lin);
        lin.setLine(LC6+adjhx1, LC4+adjhy1, LC7+adjhx2, LC4+adjhy1);
        g2.draw(lin);

        //-------------------

        int adjtx1 = 23,  adjty1 = 43,adjtx2 = 13, adjty2 = 33;

        lin.setLine(LC1+adjtx1, LC1+adjty1, LC2+adjtx2, LC2+adjty2);
        g2.draw(lin);
        lin.setLine(LC2+adjtx1, LC2+adjty1, LC3+adjtx2, LC3+adjty2);
        g2.draw(lin);

        lin.setLine(LC5+adjtx1, LC5+adjty1, LC6+adjtx2, LC6+adjty2);
        g2.draw(lin);
        lin.setLine(LC6+adjtx1, LC6+adjty1, LC7+adjtx2, LC7+adjty2);
        g2.draw(lin);

        int adjttx1 = 23, adjtty1 =33, adjttx2=13, adjtty2=43;

        lin.setLine(LC1+adjttx1, LC7+adjtty1, LC2+adjttx2, LC6+adjtty2);
        g2.draw(lin);
        lin.setLine(LC2+adjttx1, LC6+adjtty1, LC3+adjttx2, LC5+adjtty2);
        g2.draw(lin);

        lin.setLine(LC5+adjttx1, LC3+adjtty1, LC6+adjttx2, LC2+adjtty2);
        g2.draw(lin);
        lin.setLine(LC6+adjttx1, LC2+adjtty1, LC7+adjttx2, LC1+adjtty2);
        g2.draw(lin);
    }
    
//    public void threadIsTrilha(){
//        new Thread(){
//            @Override
//            public void run(){
//                if(stats.isTrilha()){
//                    System.out.println("TRILHA");
//                }
//            }
//        }.start();
//    }
    @Override
    public void run(){
        if(stats.isTrilha()){
            System.out.println("TRILHA");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(stats.getPieces() < 18){
            if(e.getSource() == check1){
                stats.setMatrix(0, 0);
            }
            if(e.getSource() == check2){
                stats.setMatrix(3, 0);
            }
            if(e.getSource() == check3){
                stats.setMatrix(6, 0);
            }
            if(e.getSource() == check4){
                stats.setMatrix(1, 1);
            }
            if(e.getSource() == check5){
                stats.setMatrix(3, 1);
            }
            if(e.getSource() == check6){
                stats.setMatrix(5, 1);
            }
            if(e.getSource() == check7){
                stats.setMatrix(2, 2);
                return;
            }
            if(e.getSource() == check8){
                stats.setMatrix(3, 2);
            }
            if(e.getSource() == check9){
                stats.setMatrix(4, 2);
            }
            if(e.getSource() == check10){
                stats.setMatrix(0, 3);
            }
            if(e.getSource() == check11){
                stats.setMatrix(1, 3);
            }
            if(e.getSource() == check12){
                stats.setMatrix(2, 3);
            }
            if(e.getSource() == check13){
                stats.setMatrix(4, 3);
            }
            if(e.getSource() == check14){
                stats.setMatrix(5, 3);
            }
            if(e.getSource() == check15){
                stats.setMatrix(6, 3);
            }
            if(e.getSource() == check16){
                stats.setMatrix(2, 4);
            }
            if(e.getSource() == check17){
                stats.setMatrix(3, 4);
            }
            if(e.getSource() == check18){
                stats.setMatrix(4, 4);
            }
            if(e.getSource() == check19){
                stats.setMatrix(1, 5);
            }
            if(e.getSource() == check20){
                stats.setMatrix(3, 5);
            }
            if(e.getSource() == check21){
                stats.setMatrix(5, 5);
            }
            if(e.getSource() == check22){
                stats.setMatrix(0, 6);
            }
            if(e.getSource() == check23){
                stats.setMatrix(3, 6);
            }
            if(e.getSource() == check24){
                stats.setMatrix(6, 6);
            }
        }
        if(stats.isTrilha()){
            System.out.println("TRILHA");
            System.out.println(stats.getPlayer1());
        }
        stats.getMatrix();
    }

}
