/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;

import java.util.ArrayList;

import aima.core.search.adversarial.Game;
import aima.core.search.adversarial.AlphaBeta;
import aima.core.search.adversarial.GameState;
import aima.core.util.XYLocation;

/**
 *
 * @author oliver
 */
public class NineManMorris extends Game {
    public NineManMorris() {
        ArrayList<XYLocation> moves = new ArrayList<XYLocation>();
        for (int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                XYLocation loc = new XYLocation(i, j);
                moves.add(loc);
            }
        }
        initialState.put("moves", moves);
        initialState.put("player", "X");
        initialState.put("utility", new Integer(0));
        initialState.put("board", NineManMorrisBoard()); // Verificar
        initialState.put("level", new Integer(0));
        presentState = initialState;
    }
    
    public NineManMorrisBoard getBoard(GameState state){
        
    }

}
