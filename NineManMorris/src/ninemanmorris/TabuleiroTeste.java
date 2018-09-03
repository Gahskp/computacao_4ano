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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author oliver
 */

public class TabuleiroTeste extends JFrame implements ActionListener, Runnable{



    private final int LC1 = 20, LC2=50, LC3=80, LC4=110, LC5=140, LC6=170, LC7=200;
    private final int W = 20, H = 15;

    public JRadioButton check [][] = new JRadioButton[7][7];

    Stats stats = new Stats();

    public int fase = 1;
    public boolean trilha [] = new boolean[16];

    public final int numeroPecas = 18;

    public TabuleiroTeste()
    {
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

        for(int i = 0; i<16; i++) trilha[i] = false;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void addButtons(){
        
        check[0][0].setBounds(LC1, LC1, W, H);
        check[3][0].setBounds(LC1, LC4, W, H);
        check[6][0].setBounds(LC1, LC7, W, H);

        check[1][1].setBounds(LC2, LC2, W, H);
        check[3][1].setBounds(LC2, LC4, W, H);
        check[5][1].setBounds(LC2, LC6, W, H);

        check[2][2].setBounds(LC3, LC3, W, H);
        check[3][2].setBounds(LC3, LC4, W, H);
        check[4][2].setBounds(LC3, LC5, W, H);

        check[0][3].setBounds(LC4, LC1, W, H);
        check[1][3].setBounds(LC4, LC2, W, H);
        check[2][3].setBounds(LC4, LC3, W, H);
        check[4][3].setBounds(LC4, LC5, W, H);
        check[5][3].setBounds(LC4, LC6, W, H);
        check[6][3].setBounds(LC4, LC7, W, H);

        check[2][4].setBounds(LC5, LC3, W, H);
        check[3][4].setBounds(LC5, LC4, W, H);
        check[4][4].setBounds(LC5, LC5, W, H);

        check[1][5].setBounds(LC6, LC2, W, H);
        check[3][5].setBounds(LC6, LC4, W, H);
        check[5][5].setBounds(LC6, LC6, W, H);

        check[0][6].setBounds(LC7, LC1, W, H);
        check[3][6].setBounds(LC7, LC4, W, H);
        check[6][6].setBounds(LC7, LC7, W, H);

        add(check[0][0]);
        add(check[3][0]);
        add(check[6][0]);

        add(check[1][1]);
        add(check[3][1]);
        add(check[5][1]);

        add(check[2][2]);
        add(check[3][2]);
        add(check[4][2]);

        add(check[0][3]);
        add(check[1][3]);
        add(check[2][3]);
        add(check[4][3]);
        add(check[5][3]);
        add(check[6][3]);

        add(check[2][4]);
        add(check[3][4]);
        add(check[4][4]);

        add(check[1][5]);
        add(check[3][5]);
        add(check[5][5]);

        add(check[0][6]);
        add(check[3][6]);
        add(check[6][6]);
    }

    public void addListener(){
        check[0][0].addActionListener(this);
        check[3][0].addActionListener(this);
        check[6][0].addActionListener(this);

        check[1][1].addActionListener(this);
        check[3][1].addActionListener(this);
        check[5][1].addActionListener(this);

        check[2][2].addActionListener(this);
        check[3][2].addActionListener(this);
        check[4][2].addActionListener(this);

        check[0][3].addActionListener(this);
        check[1][3].addActionListener(this);
        check[2][3].addActionListener(this);
        check[4][3].addActionListener(this);
        check[5][3].addActionListener(this);
        check[6][3].addActionListener(this);

        check[2][4].addActionListener(this);
        check[3][4].addActionListener(this);
        check[4][4].addActionListener(this);

        check[1][5].addActionListener(this);
        check[3][5].addActionListener(this);
        check[5][5].addActionListener(this);

        check[0][6].addActionListener(this);
        check[3][6].addActionListener(this);
        check[6][6].addActionListener(this);
    }

    private void blockRadioButton(){
        check[0][0].setEnabled(false);
        check[3][0].setEnabled(false);
        check[6][0].setEnabled(false);

        check[1][1].setEnabled(false);
        check[3][1].setEnabled(false);
        check[5][1].setEnabled(false);

        check[2][2].setEnabled(false);
        check[3][2].setEnabled(false);
        check[4][2].setEnabled(false);

        check[0][3].setEnabled(false);
        check[1][3].setEnabled(false);
        check[2][3].setEnabled(false);
        check[4][3].setEnabled(false);
        check[5][3].setEnabled(false);
        check[6][3].setEnabled(false);

        check[2][4].setEnabled(false);
        check[3][4].setEnabled(false);
        check[4][4].setEnabled(false);

        check[1][5].setEnabled(false);
        check[3][5].setEnabled(false);
        check[5][5].setEnabled(false);

        check[0][6].setEnabled(false);
        check[3][6].setEnabled(false);
        check[6][6].setEnabled(false);
    }


    public void paint(Graphics g) {
        int adjvx1 = 18, adjvy1 = 44, adjvy2 = 32;
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

    @Override
    public void run(){
//        while(true){
//
//            if(stats.getMatrix(0, 0) == stats.getMatrix(3, 0) && stats.getMatrix(3, 0) == stats.getMatrix(6, 0)
//                    && stats.getMatrix(3, 0) != 0 && trilha[0] == false){
//                try {
//                    removePedra(0);
//                    Thread.sleep(10000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(TabuleiroTeste.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    public boolean isTrilha(){
        if(stats.getMatrix(0, 0) == stats.getMatrix(3, 0) && stats.getMatrix(3, 0) == stats.getMatrix(6, 0)
                    && stats.getMatrix(3, 0) != 0 && trilha[0] == false){
            trilha[0] = true;
            return true;
        }
        if(stats.getMatrix(0, 0) == stats.getMatrix(0, 3) && stats.getMatrix(0, 3) == stats.getMatrix(0, 6)
                    && stats.getMatrix(0, 3) != 0 && trilha[1] == false){
            trilha[1] = true;
            return true;
        }
        if(stats.getMatrix(0, 6) == stats.getMatrix(3, 6) && stats.getMatrix(3, 6) == stats.getMatrix(6, 6)
                    && stats.getMatrix(3, 6) != 0 && trilha[2] == false){
            trilha[2] = true;
            return true;
        }
        if(stats.getMatrix(6, 0) == stats.getMatrix(6, 3) && stats.getMatrix(6, 3) == stats.getMatrix(6, 6)
                    && stats.getMatrix(6, 3) != 0 && trilha[3] == false){
            trilha[3] = true;
            return true;
        }
        if(stats.getMatrix(1, 1) == stats.getMatrix(3, 1) && stats.getMatrix(3, 1) == stats.getMatrix(5, 1)
                    && stats.getMatrix(3, 1) != 0 && trilha[4] == false){
            trilha[4] = true;
            return true;
        }
        if(stats.getMatrix(1, 1) == stats.getMatrix(1, 3) && stats.getMatrix(1, 3) == stats.getMatrix(1, 5)
                    && stats.getMatrix(1, 3) != 0 && trilha[5] == false){
            trilha[5] = true;
            return true;
        }
        if(stats.getMatrix(1, 5) == stats.getMatrix(3, 5) && stats.getMatrix(3, 5) == stats.getMatrix(5, 5)
                    && stats.getMatrix(3, 5) != 0 && trilha[6] == false){
            trilha[6] = true;
            return true;
        }
        if(stats.getMatrix(5, 1) == stats.getMatrix(5, 3) && stats.getMatrix(5, 3) == stats.getMatrix(5, 5)
                    && stats.getMatrix(5, 3) != 0 && trilha[7] == false){
            trilha[7] = true;
            return true;
        }
        if(stats.getMatrix(2, 2) == stats.getMatrix(3, 2) && stats.getMatrix(3, 2) == stats.getMatrix(4, 2)
                    && stats.getMatrix(3, 2) != 0 && trilha[8] == false){
            trilha[8] = true;
            return true;
        }
        if(stats.getMatrix(2, 2) == stats.getMatrix(2, 3) && stats.getMatrix(2, 3) == stats.getMatrix(2, 4)
                    && stats.getMatrix(2, 3) != 0 && trilha[9] == false){
            trilha[9] = true;
            return true;
        }
        if(stats.getMatrix(2, 4) == stats.getMatrix(3, 4) && stats.getMatrix(3, 4) == stats.getMatrix(4, 4)
                    && stats.getMatrix(3, 4) != 0 && trilha[1] == false){
            trilha[10] = true;
            return true;
        }
        if(stats.getMatrix(4, 2) == stats.getMatrix(4, 3) && stats.getMatrix(4, 3) == stats.getMatrix(4, 4)
                    && stats.getMatrix(4, 3) != 0 && trilha[11] == false){
            trilha[11] = true;
            return true;
        }
        if(stats.getMatrix(3, 0) == stats.getMatrix(3, 1) && stats.getMatrix(3, 1) == stats.getMatrix(3, 2)
                    && stats.getMatrix(3, 1) != 0 && trilha[12] == false){
            trilha[12] = true;
            return true;
        }
        if(stats.getMatrix(0, 3) == stats.getMatrix(1, 3) && stats.getMatrix(1, 3) == stats.getMatrix(2, 3)
                    && stats.getMatrix(1, 3) != 0 && trilha[13] == false){
            trilha[13] = true;
            return true;
        }
        if(stats.getMatrix(3, 4) == stats.getMatrix(3, 5) && stats.getMatrix(3, 5) == stats.getMatrix(3, 6)
                    && stats.getMatrix(3, 5) != 0 && trilha[14] == false){
            trilha[14] = true;
            return true;
        }
        if(stats.getMatrix(4, 3) == stats.getMatrix(5, 3) && stats.getMatrix(5, 3) == stats.getMatrix(6, 3)
                    && stats.getMatrix(5, 3) != 0 && trilha[15] == false){
            trilha[15] = true;
            return true;
        }
        return false;
    }

    public void resetTrilha(){
        if((stats.getMatrix(0, 0) != stats.getMatrix(3, 0) || stats.getMatrix(3, 0) != stats.getMatrix(6, 0))
                    && trilha[0] == true) trilha[0] = false;

        if((stats.getMatrix(0, 0) != stats.getMatrix(0, 3) || stats.getMatrix(0, 3) != stats.getMatrix(0, 6))
                    && trilha[1] == true) trilha[1] = false;

        if((stats.getMatrix(0, 6) != stats.getMatrix(3, 6) || stats.getMatrix(3, 6) != stats.getMatrix(6, 6))
                    && trilha[2] == true) trilha[2] = false;

        if((stats.getMatrix(6, 0) != stats.getMatrix(6, 3) || stats.getMatrix(6, 3) != stats.getMatrix(6, 6))
                    && trilha[3] == true) trilha[3] = false;

        if((stats.getMatrix(1, 1) != stats.getMatrix(3, 1) || stats.getMatrix(3, 1) != stats.getMatrix(5, 1))
                    && trilha[4] == true) trilha[4] = false;

        if((stats.getMatrix(1, 1) != stats.getMatrix(1, 3) || stats.getMatrix(1, 3) != stats.getMatrix(1, 5))
                    && trilha[5] == true) trilha[5] = false;

        if((stats.getMatrix(1, 5) != stats.getMatrix(3, 5) || stats.getMatrix(3, 5) != stats.getMatrix(5, 5))
                    && trilha[6] == true) trilha[6] = false;

        if((stats.getMatrix(5, 1) != stats.getMatrix(5, 3) || stats.getMatrix(5, 3) != stats.getMatrix(5, 5))
                    && trilha[7] == true) trilha[7] = false;

        if((stats.getMatrix(2, 2) != stats.getMatrix(3, 2) || stats.getMatrix(3, 2) != stats.getMatrix(4, 2))
                    && trilha[8] == true) trilha[8] = false;

        if((stats.getMatrix(2, 2) != stats.getMatrix(2, 3) || stats.getMatrix(2, 3) != stats.getMatrix(2, 4))
                    && trilha[9] == true) trilha[9] = false;

        if((stats.getMatrix(2, 4) != stats.getMatrix(3, 4) || stats.getMatrix(3, 4) != stats.getMatrix(4, 4))
                    && trilha[1] == true) trilha[10] = false;

        if((stats.getMatrix(4, 2) != stats.getMatrix(4, 3) || stats.getMatrix(4, 3) != stats.getMatrix(4, 4))
                    && trilha[11] == true) trilha[11] = false;

        if((stats.getMatrix(3, 0) != stats.getMatrix(3, 1) || stats.getMatrix(3, 1) != stats.getMatrix(3, 2))
                    && trilha[12] == true) trilha[12] = false;

        if((stats.getMatrix(0, 3) != stats.getMatrix(1, 3) || stats.getMatrix(1, 3) != stats.getMatrix(2, 3))
                    && trilha[13] == true) trilha[13] = false;

        if((stats.getMatrix(3, 4) != stats.getMatrix(3, 5) || stats.getMatrix(3, 5) != stats.getMatrix(3, 6))
                    && trilha[14] == true) trilha[14] = false;

        if((stats.getMatrix(4, 3) != stats.getMatrix(5, 3) || stats.getMatrix(5, 3) != stats.getMatrix(6, 3))
                    && trilha[15] == true) trilha[15] = false;

    }

    public void removePedra(){
        System.out.println("removendo uma pedra");
        blockRadioButton();
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(stats.getPlayer1()){
                    if(stats.getMatrix(i, j) == -1) check[i][j].setEnabled(true);
                } else if(stats.getMatrix(i, j) == 1) check[i][j].setEnabled(true);
            }
        }

        fase = 4;
    }

    public void setRadioAfterRemove(){

        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(stats.getMatrix(i, j) == 0){
                    try {
                        check[i][j].setEnabled(true);
                    } catch (NullPointerException ex) {
                        //tratamento do erro
                    }

                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(fase){

            /*************************************************/
            /* Fase 1 do jogo: colocar as peças no tabuleiro */
            /*************************************************/
            case 1:

                System.out.println("estamos na fase 1");
                if(e.getSource() == check[0][0]){
                    stats.setMatrix(0, 0);
                    check[0][0].setEnabled(false);
                }
                if(e.getSource() == check[3][0]){
                    stats.setMatrix(3, 0);
                    check[3][0].setEnabled(false);
                }
                if(e.getSource() == check[6][0]){
                    stats.setMatrix(6, 0);
                    check[6][0].setEnabled(false);
                }
                if(e.getSource() == check[1][1]){
                    stats.setMatrix(1, 1);
                    check[1][1].setEnabled(false);
                }
                if(e.getSource() == check[3][1]){
                    stats.setMatrix(3, 1);
                    check[3][1].setEnabled(false);
                }
                if(e.getSource() == check[5][1]){
                    stats.setMatrix(5, 1);
                    check[5][1].setEnabled(false);
                }
                if(e.getSource() == check[2][2]){
                    stats.setMatrix(2, 2);
                    check[2][2].setEnabled(false);
                }
                if(e.getSource() == check[3][2]){
                    stats.setMatrix(3, 2);
                    check[3][2].setEnabled(false);
                }
                if(e.getSource() == check[4][2]){
                    stats.setMatrix(4, 2);
                    check[4][2].setEnabled(false);
                }
                if(e.getSource() == check[0][3]){
                    stats.setMatrix(0, 3);
                    check[0][3].setEnabled(false);
                }
                if(e.getSource() == check[1][3]){
                    stats.setMatrix(1, 3);
                    check[1][3].setEnabled(false);
                }
                if(e.getSource() == check[2][3]){
                    stats.setMatrix(2, 3);
                    check[2][3].setEnabled(false);
                }
                if(e.getSource() == check[4][3]){
                    stats.setMatrix(4, 3);
                    check[4][3].setEnabled(false);
                }
                if(e.getSource() == check[5][3]){
                    stats.setMatrix(5, 3);
                    check[5][3].setEnabled(false);
                }
                if(e.getSource() == check[6][3]){
                    stats.setMatrix(6, 3);
                    check[6][3].setEnabled(false);
                }
                if(e.getSource() == check[2][4]){
                    stats.setMatrix(2, 4);
                    check[2][4].setEnabled(false);
                }
                if(e.getSource() == check[3][4]){
                    stats.setMatrix(3, 4);
                    check[3][4].setEnabled(false);
                }
                if(e.getSource() == check[4][4]){
                    stats.setMatrix(4, 4);
                    check[4][4].setEnabled(false);
                }
                if(e.getSource() == check[1][5]){
                    stats.setMatrix(1, 5);
                    check[1][5].setEnabled(false);
                }
                if(e.getSource() == check[3][5]){
                    stats.setMatrix(3, 5);
                    check[3][5].setEnabled(false);
                }
                if(e.getSource() == check[5][5]){
                    stats.setMatrix(5, 5);
                    check[5][5].setEnabled(false);
                }
                if(e.getSource() == check[0][6]){
                    stats.setMatrix(0, 6);
                    check[0][6].setEnabled(false);
                }
                if(e.getSource() == check[3][6]){
                    stats.setMatrix(3, 6);
                    check[3][6].setEnabled(false);
                }
                if(e.getSource() == check[6][6]){
                    stats.setMatrix(6, 6);
                    check[6][6].setEnabled(false);
                }

                resetTrilha();

                if(isTrilha()){
                    removePedra();
                    break;
                }

                /* If com o objetivo de controlar a vez dos jogadores */
                if(stats.getPlayer1()) stats.setPlayer1(false);
                else stats.setPlayer1(true);

                /* Número de peças */
                if(stats.getPieces() >= numeroPecas){
                    stats.setPlayer1(true);
                    fase = 2;
                    blockRadioButton();
                    for(int i = 0; i<7; i++){
                        for(int j = 0; j<7; j++){
                            if(stats.getPlayer1()){
                                if(stats.getMatrix(i, j) == 1) check[i][j].setEnabled(true);
                            } else if(stats.getMatrix(i, j) == -1) check[i][j].setEnabled(true);
                        }
                    }
                }
                break;

            /**********************************/
            /* Fase 2 do jogo: escolher a peça a ser movida */
            /**********************************/
            case 2:

                System.out.println("estamos na fase 2");
                blockRadioButton();
                if(e.getSource() == check[0][0]){
                    stats.resetMatrix(0, 0);
                    if(stats.getMatrix(0, 3) == 0) check[0][3].setEnabled(true);
                    if(stats.getMatrix(3, 0) == 0) check[3][0].setEnabled(true);
                    check[0][0].setEnabled(true);
                }
                if(e.getSource() == check[3][0]){
                    stats.resetMatrix(3, 0);
                    if(stats.getMatrix(0, 0) == 0) check[0][0].setEnabled(true);
                    if(stats.getMatrix(6, 0) == 0) check[6][0].setEnabled(true);
                    if(stats.getMatrix(3, 1) == 0) check[3][1].setEnabled(true);
                    check[3][0].setEnabled(true);
                }
                if(e.getSource() == check[6][0]){
                    stats.resetMatrix(6, 0);
                    if(stats.getMatrix(3, 0) == 0) check[3][0].setEnabled(true);
                    if(stats.getMatrix(6, 3) == 0) check[6][3].setEnabled(true);
                    check[6][0].setEnabled(true);
                }
                if(e.getSource() == check[1][1]){
                    stats.resetMatrix(1, 1);
                    if(stats.getMatrix(3, 1) == 0) check[3][1].setEnabled(true);
                    if(stats.getMatrix(1, 3) == 0) check[1][3].setEnabled(true);
                    check[1][1].setEnabled(true);
                }
                if(e.getSource() == check[3][1]){
                    stats.resetMatrix(3, 1);
                    if(stats.getMatrix(1, 1) == 0) check[1][1].setEnabled(true);
                    if(stats.getMatrix(5, 1) == 0) check[5][1].setEnabled(true);
                    if(stats.getMatrix(3, 0) == 0) check[3][0].setEnabled(true);
                    if(stats.getMatrix(3, 2) == 0) check[3][2].setEnabled(true);
                    check[3][1].setEnabled(true);
                }
                if(e.getSource() == check[5][1]){
                    stats.resetMatrix(5, 1);
                    if(stats.getMatrix(5, 3) == 0) check[5][3].setEnabled(true);
                    if(stats.getMatrix(3, 1) == 0) check[3][1].setEnabled(true);
                    check[5][1].setEnabled(true);
                }
                if(e.getSource() == check[2][2]){
                    stats.resetMatrix(2, 2);
                    if(stats.getMatrix(3, 2) == 0) check[3][2].setEnabled(true);
                    if(stats.getMatrix(2, 3) == 0) check[2][3].setEnabled(true);
                    check[2][2].setEnabled(true);
                }
                if(e.getSource() == check[3][2]){
                    stats.resetMatrix(3, 2);
                    if(stats.getMatrix(3, 1) == 0) check[3][1].setEnabled(true);
                    if(stats.getMatrix(2, 2) == 0) check[2][2].setEnabled(true);
                    if(stats.getMatrix(4, 2) == 0) check[4][2].setEnabled(true);
                    check[3][2].setEnabled(true);
                }
                if(e.getSource() == check[4][2]){
                    stats.resetMatrix(4, 2);
                    if(stats.getMatrix(3, 2) == 0) check[3][2].setEnabled(true);
                    if(stats.getMatrix(4, 3) == 0) check[4][3].setEnabled(true);
                    check[4][2].setEnabled(true);
                }
                if(e.getSource() == check[0][3]){
                    stats.resetMatrix(0, 3);
                    if(stats.getMatrix(0, 0) == 0) check[0][0].setEnabled(true);
                    if(stats.getMatrix(0, 6) == 0) check[0][6].setEnabled(true);
                    if(stats.getMatrix(1, 3) == 0) check[1][3].setEnabled(true);
                    check[0][3].setEnabled(true);
                }
                if(e.getSource() == check[1][3]){
                    stats.resetMatrix(1, 3);
                    if(stats.getMatrix(0, 3) == 0) check[0][3].setEnabled(true);
                    if(stats.getMatrix(2, 3) == 0) check[2][3].setEnabled(true);
                    if(stats.getMatrix(1, 1) == 0) check[1][1].setEnabled(true);
                    if(stats.getMatrix(1, 5) == 0) check[1][5].setEnabled(true);
                    check[1][3].setEnabled(true);
                }
                if(e.getSource() == check[2][3]){
                    stats.resetMatrix(2, 3);
                    if(stats.getMatrix(2, 4) == 0) check[2][4].setEnabled(true);
                    if(stats.getMatrix(2, 2) == 0) check[2][2].setEnabled(true);
                    if(stats.getMatrix(1, 3) == 0) check[1][3].setEnabled(true);
                    check[2][3].setEnabled(true);
                }
                if(e.getSource() == check[4][3]){
                    stats.resetMatrix(4, 3);
                    if(stats.getMatrix(4, 2) == 0) check[4][2].setEnabled(true);
                    if(stats.getMatrix(5, 3) == 0) check[5][3].setEnabled(true);
                    if(stats.getMatrix(4, 4) == 0) check[4][4].setEnabled(true);
                    check[4][3].setEnabled(true);

                }
                if(e.getSource() == check[5][3]){
                    stats.resetMatrix(5, 3);
                    if(stats.getMatrix(4, 3) == 0) check[4][3].setEnabled(true);
                    if(stats.getMatrix(5, 1) == 0) check[5][1].setEnabled(true);
                    if(stats.getMatrix(5, 5) == 0) check[5][5].setEnabled(true);
                    if(stats.getMatrix(6, 3) == 0) check[6][3].setEnabled(true);
                    check[5][3].setEnabled(true);
                }
                if(e.getSource() == check[6][3]){
                    stats.resetMatrix(6, 3);
                    if(stats.getMatrix(6, 0) == 0) check[6][0].setEnabled(true);
                    if(stats.getMatrix(6, 6) == 0) check[6][6].setEnabled(true);
                    if(stats.getMatrix(5, 3) == 0) check[5][3].setEnabled(true);
                    check[6][3].setEnabled(true);
                }
                if(e.getSource() == check[2][4]){
                    stats.resetMatrix(2, 4);
                    if(stats.getMatrix(3, 4) == 0) check[3][4].setEnabled(true);
                    if(stats.getMatrix(2, 3) == 0) check[2][3].setEnabled(true);
                    check[2][4].setEnabled(true);
                }
                if(e.getSource() == check[3][4]){
                    stats.resetMatrix(3, 4);
                    if(stats.getMatrix(2, 4) == 0) check[2][4].setEnabled(true);
                    if(stats.getMatrix(4, 4) == 0) check[4][4].setEnabled(true);
                    if(stats.getMatrix(3, 5) == 0) check[3][5].setEnabled(true);
                    check[3][4].setEnabled(true);
                }
                if(e.getSource() == check[4][4]){
                    stats.resetMatrix(4, 4);
                    if(stats.getMatrix(3, 4) == 0) check[3][4].setEnabled(true);
                    if(stats.getMatrix(4, 3) == 0) check[4][3].setEnabled(true);
                    check[4][4].setEnabled(true);
                }
                if(e.getSource() == check[1][5]){
                    stats.resetMatrix(1, 5);
                    if(stats.getMatrix(1, 3) == 0) check[1][3].setEnabled(true);
                    if(stats.getMatrix(3, 5) == 0) check[3][5].setEnabled(true);
                    check[1][5].setEnabled(true);
                }
                if(e.getSource() == check[3][5]){
                    stats.resetMatrix(3, 5);
                    if(stats.getMatrix(1, 5) == 0) check[1][5].setEnabled(true);
                    if(stats.getMatrix(5, 5) == 0) check[5][5].setEnabled(true);
                    if(stats.getMatrix(3, 4) == 0) check[3][4].setEnabled(true);
                    if(stats.getMatrix(3, 6) == 0) check[3][6].setEnabled(true);
                    check[3][5].setEnabled(true);
                }
                if(e.getSource() == check[5][5]){
                    stats.resetMatrix(5, 5);
                    if(stats.getMatrix(5, 3) == 0) check[5][3].setEnabled(true);
                    if(stats.getMatrix(3, 5) == 0) check[3][5].setEnabled(true);
                    check[5][5].setEnabled(true);
                }
                if(e.getSource() == check[0][6]){
                    stats.resetMatrix(0, 6);
                    if(stats.getMatrix(0, 3) == 0) check[0][3].setEnabled(true);
                    if(stats.getMatrix(3, 6) == 0) check[3][6].setEnabled(true);
                    check[0][6].setEnabled(true);
                }
                if(e.getSource() == check[3][6]){
                    stats.resetMatrix(3, 6);
                    if(stats.getMatrix(0, 6) == 0) check[0][6].setEnabled(true);
                    if(stats.getMatrix(3, 5) == 0) check[3][5].setEnabled(true);
                    if(stats.getMatrix(6, 6) == 0) check[6][6].setEnabled(true);
                    check[3][6].setEnabled(true);
                }
                if(e.getSource() == check[6][6]){
                    stats.resetMatrix(6, 6);
                    if(stats.getMatrix(3, 6) == 0) check[3][6].setEnabled(true);
                    if(stats.getMatrix(6, 3) == 0) check[6][3].setEnabled(true);
                    check[6][6].setEnabled(true);
                }

                fase = 3;
                break;

            /**********************************/
            /* Fase 3 do jogo: mover as peças */
            /**********************************/
            case 3:

                System.out.println("estamos na fase 3");
                if(e.getSource() == check[0][0]){
                    stats.setMatrix(0, 0);
                    check[0][0].setEnabled(false);
                }
                if(e.getSource() == check[3][0]){
                    stats.setMatrix(3, 0);
                    check[3][0].setEnabled(false);
                }
                if(e.getSource() == check[6][0]){
                    stats.setMatrix(6, 0);
                    check[6][0].setEnabled(false);
                }
                if(e.getSource() == check[1][1]){
                    stats.setMatrix(1, 1);
                    check[1][1].setEnabled(false);
                }
                if(e.getSource() == check[3][1]){
                    stats.setMatrix(3, 1);
                    check[3][1].setEnabled(false);
                }
                if(e.getSource() == check[5][1]){
                    stats.setMatrix(5, 1);
                    check[5][1].setEnabled(false);
                }
                if(e.getSource() == check[2][2]){
                    stats.setMatrix(2, 2);
                    check[2][2].setEnabled(false);
                }
                if(e.getSource() == check[3][2]){
                    stats.setMatrix(3, 2);
                    check[3][2].setEnabled(false);
                }
                if(e.getSource() == check[4][2]){
                    stats.setMatrix(4, 2);
                    check[4][2].setEnabled(false);
                }
                if(e.getSource() == check[0][3]){
                    stats.setMatrix(0, 3);
                    check[0][3].setEnabled(false);
                }
                if(e.getSource() == check[1][3]){
                    stats.setMatrix(1, 3);
                    check[1][3].setEnabled(false);
                }
                if(e.getSource() == check[2][3]){
                    stats.setMatrix(2, 3);
                    check[2][3].setEnabled(false);
                }
                if(e.getSource() == check[4][3]){
                    stats.setMatrix(4, 3);
                    check[4][3].setEnabled(false);
                }
                if(e.getSource() == check[5][3]){
                    stats.setMatrix(5, 3);
                    check[5][3].setEnabled(false);
                }
                if(e.getSource() == check[6][3]){
                    stats.setMatrix(6, 3);
                    check[6][3].setEnabled(false);
                }
                if(e.getSource() == check[2][4]){
                    stats.setMatrix(2, 4);
                    check[2][4].setEnabled(false);
                }
                if(e.getSource() == check[3][4]){
                    stats.setMatrix(3, 4);
                    check[3][4].setEnabled(false);
                }
                if(e.getSource() == check[4][4]){
                    stats.setMatrix(4, 4);
                    check[4][4].setEnabled(false);
                }
                if(e.getSource() == check[1][5]){
                    stats.setMatrix(1, 5);
                    check[1][5].setEnabled(false);
                }
                if(e.getSource() == check[3][5]){
                    stats.setMatrix(3, 5);
                    check[3][5].setEnabled(false);
                }
                if(e.getSource() == check[5][5]){
                    stats.setMatrix(5, 5);
                    check[5][5].setEnabled(false);
                }
                if(e.getSource() == check[0][6]){
                    stats.setMatrix(0, 6);
                    check[0][6].setEnabled(false);
                }
                if(e.getSource() == check[3][6]){
                    stats.setMatrix(3, 6);
                    check[3][6].setEnabled(false);
                }
                if(e.getSource() == check[6][6]){
                    stats.setMatrix(6, 6);
                    check[6][6].setEnabled(false);
                }

                resetTrilha();

                if(isTrilha()){
                    removePedra();
                    break;
                }

                if(stats.getPlayer1()) stats.setPlayer1(false);
                else stats.setPlayer1(true);

                fase = 2;
                blockRadioButton();

                for(int i = 0; i<7; i++){
                    for(int j = 0; j<7; j++){
                        if(stats.getPlayer1()){
                            if(stats.getMatrix(i, j) == 1) check[i][j].setEnabled(true);
                        } else if(stats.getMatrix(i, j) == -1) check[i][j].setEnabled(true);
                    }
                }

                break;

            case 4:

                System.out.println("Estamos na fase 4");
                if(e.getSource() == check[0][0]){
                    stats.resetMatrix(0, 0);
                }
                if(e.getSource() == check[3][0]){
                    stats.resetMatrix(3, 0);
                }
                if(e.getSource() == check[6][0]){
                    stats.resetMatrix(6, 0);
                }
                if(e.getSource() == check[1][1]){
                    stats.resetMatrix(1, 1);
                }
                if(e.getSource() == check[3][1]){
                    stats.resetMatrix(3, 1);
                }
                if(e.getSource() == check[5][1]){
                    stats.resetMatrix(5, 1);
                }
                if(e.getSource() == check[2][2]){
                    stats.resetMatrix(2, 2);
                }
                if(e.getSource() == check[3][2]){
                    stats.resetMatrix(3, 2);
                }
                if(e.getSource() == check[4][2]){
                    stats.resetMatrix(4, 2);
                }
                if(e.getSource() == check[0][3]){
                    stats.resetMatrix(0, 3);
                }
                if(e.getSource() == check[1][3]){
                    stats.resetMatrix(1, 3);
                }
                if(e.getSource() == check[2][3]){
                    stats.resetMatrix(2, 3);
                }
                if(e.getSource() == check[4][3]){
                    stats.resetMatrix(4, 3);
                }
                if(e.getSource() == check[5][3]){
                    stats.resetMatrix(5, 3);
                }
                if(e.getSource() == check[6][3]){
                    stats.resetMatrix(6, 3);
                }
                if(e.getSource() == check[2][4]){
                    stats.resetMatrix(2, 4);
                }
                if(e.getSource() == check[3][4]){
                    stats.resetMatrix(3, 4);
                }
                if(e.getSource() == check[4][4]){
                    stats.resetMatrix(4, 4);
                }
                if(e.getSource() == check[1][5]){
                    stats.resetMatrix(1, 5);
                }
                if(e.getSource() == check[3][5]){
                    stats.resetMatrix(3, 5);
                }
                if(e.getSource() == check[5][5]){
                    stats.resetMatrix(5, 5);
                }
                if(e.getSource() == check[0][6]){
                    stats.resetMatrix(0, 6);
                }
                if(e.getSource() == check[3][6]){
                    stats.resetMatrix(3, 6);
                }
                if(e.getSource() == check[6][6]){
                    stats.resetMatrix(6, 6);
                }

                /* Número de peças */
                if(stats.getPieces() >= numeroPecas){
                    if(fase == 1) stats.setPlayer1(true);
                    else {
                        if(stats.getPlayer1()) stats.setPlayer1(false);
                        else stats.setPlayer1(true);
                    }
                    fase = 2;
                    blockRadioButton();
                    for(int i = 0; i<7; i++){
                        for(int j = 0; j<7; j++){
                            if(stats.getPlayer1()){
                                if(stats.getMatrix(i, j) == 1) check[i][j].setEnabled(true);
                            } else if(stats.getMatrix(i, j) == -1) check[i][j].setEnabled(true);
                        }
                    }
                } else {
                    fase = 1;
                    if(stats.getPlayer1()) stats.setPlayer1(false);
                    else stats.setPlayer1(true);
                    blockRadioButton();
                    setRadioAfterRemove();
                }

            default:
        }

        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(stats.getMatrix(i, j) == -1) check[i][j].setBackground(Color.LIGHT_GRAY);
                else if(stats.getMatrix(i, j) == 1) check[i][j].setBackground(Color.DARK_GRAY);
                else if(stats.getMatrix(i, j) == 0) {
                    try {
                        check[i][j].setBackground(null);
                    } catch (NullPointerException ex) {
                        //tratamento do erro
                    }
                }

            }
        }
        /* Retorna a Matriz de posições */
        stats.getMatrix();


    }

}
