package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MainFrame extends JFrame  {

	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 350, 350);
		
		centreWindow(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		setVisible(true);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}