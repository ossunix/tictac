package gui;

import javax.swing.ImageIcon;

public class ImageHelper {
	
	static ImageIcon o 	= new ImageIcon(MainFrame.class.getResource("/resources/o.png"));
	static ImageIcon x 	= new ImageIcon(MainFrame.class.getResource("/resources/x.png"));
	static ImageIcon grid 	= new ImageIcon(MainFrame.class.getResource("/resources/grid.png"));
	static ImageIcon blank 	= new ImageIcon(MainFrame.class.getResource("/resources/blank.png"));
		
	public static ImageIcon getO() {
		return new ImageIcon(MainFrame.class.getResource("/resources/o.png"));
	}
	
	public static ImageIcon getX() {
		return x;
	}
	
	public static ImageIcon getGrid() {
		return grid;
	}
	
	public static ImageIcon getBlank() {
		return blank;
	}
}
