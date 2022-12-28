package games.guitarHero;

import javax.swing.JFrame;

import games.guitarHero.Panel;

public class GameFrame extends JFrame {
	
	GameFrame() {
		this.add(new Panel());
		this.setTitle("Guitar Hero");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
