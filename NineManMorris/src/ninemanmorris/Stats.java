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
public class Stats {
    private boolean player1;
    int[][] matrix = new int[7][7];
    
    public Stats(){
        player1 = true;
        for(int i=0;i<7;i++){
            for(int j=0; j<7; j++){
                matrix[i][j] = 0;
            }
        }
    }
    public void setMatrix(int i, int j){
        if(player1){
            matrix[i][j] = 1;
            player1 = false;
        } else {
            matrix[i][j] = -1;
            player1 = true;
        }
    }
    
    public boolean getPlayer(){
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
    
}
