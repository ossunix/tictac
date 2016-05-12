/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Toma
 */
public class Move implements Comparable {
    
    private int row, col;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public Move(int row, int col) {
        this.row = row;
        this.col = col;        
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    @Override
    public int compareTo(Object o) {
        return ((Move)o).value - this.value;
    }
}
