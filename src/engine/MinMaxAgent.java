/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Toma
 */
public class MinMaxAgent {
    
    private Position pos;
    private int maxDepth;
    
    public MinMaxAgent(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    
    public void playMove(Position pos) {
        Move bestMove = minmax(pos);
        pos.play(bestMove);
    }
    
    public Move minmax(Position pos) {
        ArrayList<Move> mlist = pos.moves();
        mlist.forEach((Move m) -> {
            int rv = (int) (Math.random() * 100);
            m.setValue(rv);
        });
        
        Collections.sort(mlist);
        return mlist.get(0);
    }
}
