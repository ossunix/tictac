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
        Position pos = new Position();
        pos.print();
        ArrayList<Move> mlist = pos.moves();
        mlist.forEach((Move m) -> {
            System.out.println("(" + m.getRow() + "," + m.getCol() + ")");
        });
    }    
}
