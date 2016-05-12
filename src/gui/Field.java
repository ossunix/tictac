package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Field extends JLabel {

	private char symbol;
	private int row;
	private int column;
	
	public Field(char symbol, int row, int column)  {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getSource().toString());
				
			}
		});
		
		this.row = row;
		this.column = column;
		this.symbol = symbol;
		
		if (symbol == '_') {
			setIcon(ImageHelper.getBlank());
		} else if (symbol == 'X') {
			setIcon(ImageHelper.getX());
		} else if (symbol == 'O') {
			setIcon(ImageHelper.getO());
			
		}
	}

	@Override
	public String toString() {
		return "[" + row + ", " + column + " " + symbol + "]";
	}
}
