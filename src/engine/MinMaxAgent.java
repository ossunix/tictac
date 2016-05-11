/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;

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
        ArrayList<Move> mlist = pos.moves();
        ArrayList<Integer> vlist = new ArrayList();
        mlist.forEach((Move m) -> {
            pos.play(m);
            int value = minmax(pos);
            pos.undo(m);
            vlist.add(0, new Integer(value));
        });
        
    }
    
    public int minmax(Position pos) {
        return 0;
    }
}
