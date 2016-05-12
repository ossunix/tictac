package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.MinMaxAgent;
import engine.Position;

@SuppressWarnings("serial")
public class GridPanel extends JPanel {
	
	Position position = new Position();
	MinMaxAgent agent = new MinMaxAgent(1);
	
	private Field[][] fields = new Field[3][3];
	
	public GridPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(320, 320));
		JLabel grid = new JLabel(ImageHelper.getGrid());
		grid.setBounds(0, 0, 300, 300);
		add(grid);
		
		while (position.result() == 0) {
			
			agent.playMove(position);
			fillGrid(position.getTable());
		}
	}

	private void fillGrid(char[][] table) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if(fields[i][j] != null)
					remove(fields[i][j]);
				
				Field field = new Field(table[i][j], i, j);
				field.setBounds(i*100, j*100, 100, 100);
				add(field);
				fields[i][j] = field;
			}
		}
	}

	public void newGame(int level) {
		// TODO Auto-generated method stub
		
	}
}
