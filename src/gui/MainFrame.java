package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MainFrame extends JFrame  {

	private final int BORDER = 25;
	
	private GridPanel grid;
	
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		//((JComponent)getContentPane()).setBorder(BorderFactory.createMatteBorder(BORDER, BORDER, BORDER, BORDER, this.getBackground()));
		
		add(new GridPanel());
		setResizable(false);
		pack();
		centreWindow(this);
		
		grid = new GridPanel();
		
		
			JMenu mnGame = new JMenu("Game");
			menuBar.add(mnGame);	
			
			JMenuItem mntmPlayLevel = new JMenuItem("Play level 1");
			mntmPlayLevel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					grid.newGame(1);
				}
			});
			mnGame.add(mntmPlayLevel);
		
		setVisible(true);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}