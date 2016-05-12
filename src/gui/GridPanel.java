package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
	
	public GridPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(300, 300));
	
		for (int i = 0; i < 3; i++) {
			JLabel label = new Field('O', i, i);
			label.setBounds(i*100, i*100, 100, 100);
			add(label);
		}
		
		
		JLabel label = new JLabel(ImageHelper.getGrid());
		label.setBounds(0, 0, 300, 300);
		add(label);
	}
}
