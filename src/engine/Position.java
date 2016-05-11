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
public class Position {
    
    private int moveCount;
    private char turn;
    private char[][] table;
    
    public Position() {
        moveCount = 0;
        turn = 'X';
        table = new char[3][3];
        for(int r=0; r<3; r++) {
            for(int c=0;c<3;c++)
                table[r][c] = '_';
        }        
    }
    
    public char[][] getTable() {
        return table;
    }
    
    public char getTurn() {
        return turn;
    }

    public void print() {
        for(int r=0; r<3; r++) {
            for(int c=0;c<3;c++)
                System.out.print(table[r][c]);
            System.out.println();
        }
        System.out.println("Turn: " + turn + " Move count: " + moveCount);
    }
    
    public void play(Move m) {
        table[m.getRow()][m.getCol()] = turn;
        turn = (turn == 'X') ? 'O' : 'X';
        moveCount++;
    }
    
    public void undo(Move m) {
        table[m.getRow()][m.getCol()] = '_';
        turn = (turn == 'X') ? 'O' : 'X';         
        moveCount--;
    }

    public int result() {
        for(int r=0; r<3; r++) {
            if(table[r][0] == 'X' && table[r][1] == 'X' && table[r][2] == 'X')
                return 100;
            if(table[r][0] == 'O' && table[r][1] == 'O' && table[r][2] == 'O')
                return -100;            
        }
        
        for(int c=0; c<3; c++) {
            if(table[0][c] == 'X' && table[1][c] == 'X' && table[2][c] == 'X')
                return 100;
            if(table[0][c] == 'O' && table[1][c] == 'O' && table[2][c] == 'O')
                return -100;            
        }

        if(table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X')
            return 100;
        if(table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O')
            return -100;            
        if(table[0][2] == 'X' && table[1][1] == 'X' && table[2][0] == 'X')
            return 100;
        if(table[0][2] == 'O' && table[1][1] == 'O' && table[2][0] == 'O')
            return -100;
        
        if(moveCount >= 9)
            return 1;
        
        return 0;
    }
    
    public boolean isLegal(int row, int col) {
        return table[row][col] == '_';
    }

    public boolean isLegal(Move m) {
        return isLegal(m.getRow(), m.getCol());
    }
    
    public ArrayList<Move> moves() {
        ArrayList<Move> mlist = new ArrayList();
        for(int r=0; r<3; r++) {
            for(int c=0; c<3; c++)
                if(table[r][c] == '_')
                    mlist.add(new Move(r, c));
        }                
        return mlist;
    }    
}
