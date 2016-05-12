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

		this.row = row;
		this.column = column;
		this.symbol = symbol;
		
		setBounds(row*100, column*100, 100, 100);
		setSymbol(symbol);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.grid.userClick((Field) e.getSource());
			}
		});
	}

	public void setSymbol(char symbol) {
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
		return "Field: [" + row + ", " + column + ", " + symbol + "]";
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
