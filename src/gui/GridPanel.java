package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.MinMaxAgent;
import engine.Move;
import engine.Position;

@SuppressWarnings("serial")
public class GridPanel extends JPanel {
	
	private Position position = new Position();
	private MinMaxAgent agent = new MinMaxAgent(3);
	private Field[][] fields = new Field[3][3];
	
	private static boolean computerPlayInProgress = false;
	
	public GridPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(300, 300));
		JLabel grid = new JLabel(ImageHelper.getGrid());
		grid.setBounds(0, 0, 300, 300);
		add(grid);
		
		fillGrid(position.getTable());
	}

	private void fillGrid(char[][] table) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Field field = new Field(table[i][j], i, j);
				add(field);
				fields[i][j] = field;
			}
		}
	}
	
	private void refreshGrid(char[][] table) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fields[i][j].setSymbol(table[i][j]);
			}
		}
		
		repaint();
	}

	public void newComputerGame(int level) {
		
		if(computerPlayInProgress) 
			return;
		
		computerPlayInProgress = true;
		
		this.agent = new MinMaxAgent(3);
		this.position = new Position();
		refreshGrid(position.getTable());
		repaint();
		
		Thread computerGame = new Thread() {
			
			public void run() {
				while (position.result() == 0) {
					
					agent.playMove(position);
					refreshGrid(position.getTable());
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
					}
					repaint();
				}
				
				computerPlayInProgress = false;
			}
		};

		computerGame.start();
	}
	
	public void newGame(int level) {
		
		this.agent = new MinMaxAgent(level);
		this.position = new Position();
		
		refreshGrid(position.getTable());
	}

	public void userClick(Field field) {
		
		if(computerPlayInProgress) 
			return;
		
		// user's move
		if (position.result() == 0) {
			position.play(new Move(field.getRow(), field.getColumn()));
			refreshGrid(position.getTable());
		}
		
		// agent's move
		if (position.result() == 0) {
		
			agent.playMove(position);
			refreshGrid(position.getTable());
		}
	}
}
