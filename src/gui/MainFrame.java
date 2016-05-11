package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


@SuppressWarnings("serial")
public class MainFrame extends JFrame  {

	private final int BORDER = 25;
	
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createMatteBorder( BORDER, BORDER, BORDER, BORDER, this.getBackground ()) );
		
		getContentPane().add(new GridPanel());
		setResizable(false);
		pack();
		centreWindow(this);
		setVisible(true);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}