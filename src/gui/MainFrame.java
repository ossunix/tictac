package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MainFrame extends JFrame  {

	private final int BORDER = 20;
	
	public static GridPanel grid = new GridPanel();
	
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(grid);
		setTitle("Tic-Tac-Toe");
		setBorder();
		setResizable(false);
		setMenus();
		
		pack();
		centreWindow(this);
		setVisible(true);
	}

	private void setBorder() {
		((JComponent)getContentPane()).setBorder(BorderFactory.createMatteBorder(BORDER, BORDER, BORDER, BORDER, this.getBackground()));
	}

	private void setMenus() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);	
		
		JMenuItem mntmPlayLevel = new JMenuItem("Comp. vs. comp");
		mntmPlayLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.newComputerGame(1);
			}
		});
		
		JMenuItem mntmPlayLevel_1 = new JMenuItem("Play Level 1");
		mntmPlayLevel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.newGame(1);
			}
		});
		
		JMenuItem mntmPlayLevel_2 = new JMenuItem("Play Level 2");
		mntmPlayLevel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.newGame(2);
			}
		});
		
		JMenuItem mntmPlayLevel_3 = new JMenuItem("Play Level 3");
		mntmPlayLevel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.newGame(3);
			}
		});
		
		mnGame.add(mntmPlayLevel_1);
		mnGame.add(mntmPlayLevel_2);
		mnGame.add(mntmPlayLevel_3);
		mnGame.add(mntmPlayLevel);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}