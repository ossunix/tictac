package program;

import gui.MainFrame;

public class TicTac {
	
    public static void main(String[] args) {
    	
		try {
			
			new MainFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
