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
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinMaxAgent mma = new MinMaxAgent(MinMaxAgent.LEVEL[1]);
        
        int[] scores = { 0, 0, 0 };
        for(int i=0; i<1000;i++) {
            Position pos = new Position();
            while(pos.result() == 0) {
                mma.playMove(pos);
            }
            int res = pos.result();
            if(res == 100)
                scores[0] += 1;
            else if(res == -100)
                scores[2] += 1;
            else
                scores[1] += 1;        
            System.out.println("X:" + scores[0] + " D:" + scores[1] + " O:" + scores[2]);
        }
    }    
}
