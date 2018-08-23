/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;

/**
 *
 * @author oliver
 */
public class Stats implements Cloneable{
    private boolean player1;
    int[][] matrix = new int[7][7];
    private int pieces = 0;
    private boolean fase1, fase2, fase3;

    public Stats(){
        player1 = true;
        fase1 = true;
        fase2 = false;
        fase3 = false;
        for(int i=0;i<7;i++){
            for(int j=0; j<7; j++){
                matrix[i][j] = 0;
            }
        }
    }
    public void setMatrix(int i, int j){
        pieces++;
        if(player1){
            matrix[i][j] = 1;
        } else {
            matrix[i][j] = -1;
        }
    }
    
    public void resetMatrix(int i, int j){
        matrix[i][j] = 0;
    }

    public void setPlayer1(boolean s){
        player1 = s;
    }

    public boolean getPlayer1(){
        return player1;
    }

    public void getMatrix(){
        for(int i=0;i<7;i++){
            for(int j=0; j<7; j++){
                System.out.print(matrix[i][j] + "     ");
            }
            System.out.println(" ");
        }
        System.out.println("=========================================");
    }

    public int getMatrix(int i, int j){
        return matrix[i][j];
    }

    public int getPieces(){
        return pieces;
    }
    public boolean isTrilha(){
      int i;
      for(i = 0; i <= 6; ){
        if((matrix[i][0] > 0 && matrix[i][3] > 0 && matrix[i][6] > 0)
            || (matrix[i][0] < 0 && matrix[i][3] < 0 && matrix[i][6] < 0)){
          return true;
        }
        if((matrix[0][i] > 0 && matrix[3][i] > 0 && matrix[6][i] > 0)
            || (matrix[0][i] < 0 && matrix[3][i] < 0 && matrix[6][i] < 0)){
          return true;
        }
        i = i + 6;
      }
      for(i = 1; i <= 5; ){
        if((matrix[i][1] > 0 && matrix[i][3] > 0 && matrix[i][5] > 0)
            || (matrix[i][1] < 0 && matrix[i][3] < 0 && matrix[i][5] < 0)){
          return true;
        }
        if((matrix[1][i] > 0 && matrix[3][i] > 0 && matrix[5][i] > 0)
            || (matrix[1][i] < 0 && matrix[3][i] < 0 && matrix[5][i] < 0)){
          return true;
        }
        i = i + 4;
      }
      return false;
    }
    
    public boolean getFase1(){
        return fase1;
    }
    
    public void setFase1(boolean s){
        fase1 = s;
    }
    
    public boolean getFase2(){
        return fase2;
    }
    
    public void setFase2(boolean s){
        fase2 = s;
    }
    
    public boolean getFase3(){
        return fase3;
    }

}
