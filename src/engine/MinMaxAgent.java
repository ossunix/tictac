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
    
    public static final int[] LEVEL = { 0, 3, 20 };
    private Position pos;
    private int maxDepth;
    
    public MinMaxAgent(int level) {
        this.maxDepth = LEVEL[level-1];
    }
    
    public void playMove(Position pos) {
        ArrayList<Move> mlist = pos.moves();
        mlist.forEach((Move m) -> {
            pos.play(m);
            int v = minmax(pos, 0);
            pos.undo(m);
            m.setValue(v);
        });        
        Collections.sort(mlist);
        
        /*for(Move m: mlist) {
            System.out.print(m.getValue() + ", ");
        }
        System.out.println();*/
        
        Move bestMove;
        if (pos.getTurn() == 'X')
            bestMove = mlist.get(0);
        else
            bestMove = mlist.get(mlist.size() - 1);

        pos.play(bestMove);
    }
    
    public int minmax(Position pos, int d) {
        int res = pos.result();
        if(res != 0)
            return res + (int)(Math.random() * 10);
        if (d >= maxDepth)
            return (int)(Math.random() * 10);
        
        ArrayList<Move> mlist = pos.moves();
        int bestValue = (pos.getTurn() == 'X') ? -1000 : 1000;
        for(Move m: mlist) {
            pos.play(m);
            int v = minmax(pos, d+1);
            pos.undo(m);
            if (pos.getTurn() == 'X')
                bestValue = (v > bestValue) ? v : bestValue;
            else
                bestValue = (v < bestValue) ? v : bestValue;
        }
        return bestValue;
    }
}
