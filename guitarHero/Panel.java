package games.guitarHero;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	
	
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	final int y2[] = new int[GAME_UNITS];
	static final ArrayList<int[]> listaNote1 = new ArrayList<int[]>();
	static final ArrayList<int[]> listaNote2 = new ArrayList<int[]>();
	static final ArrayList<int[]> listaNote3 = new ArrayList<int[]>();
	static final ArrayList<int[]> listaNote4 = new ArrayList<int[]>();
	int flag = 0;
	int noise = 0;
	int counter = 0;
	int counter2 = 0;
	int bodyParts = 6;
	
	char direction = 'R';
	char playedNote = ' ';
	boolean playing = false;
	private char notePlayed;
	Timer timer;
	Random random;
	private int counterHardPhase;
	private int counterIniziale;
	
	Panel(){
		random = new Random();
		listaNote1.add(x);
		listaNote1.add(y);
		listaNote1.add(y2);
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	private void startGame() {
		// TODO Auto-generated method stub
		
		this.playing = true;
		ReproduceMusic.reproduceSong("/Users/manuelleoni/Desktop/Back in Black.wav");
		timer = new Timer(DELAY,this);
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (playing){
			
			
			move();
			checkNotes();
			checkCollisions();
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void newNote(Graphics g, int[] array) {
		counter += 50;
		counterIniziale += 30;
		
		//after 8 seconds
		
		if (counterIniziale > 1800) {
			
			
			if (counter % 200 == 0) {
				
				if (counter % 600 == 0) {
					listaNote2.add(array);
				}
				else if (counter % 1200 == 0)
				listaNote1.add(array);
				}
			
			if (counter % 1250 == 0) {
				listaNote3.add(array);
				flag++;	
			}
			
			if (flag >= 8) {
				
				if (counter % 900 == 0)
				listaNote4.add(array);
			}
			
			
		//	counter2 += 33;
//			
			//if (counter2 > 1000) {
			//	System.out.println("siamo nel secondo girone");

//				
     		//	if (counter2 % 99 == 0) {
			//		listaNote4.add(array);
//					
//					System.out.println("nota infernale");
			//	}
		//	}
//				
//				counterHardPhase += 30;
//				if (counterHardPhase > 2000) {
//					 
//					 if (counter % 300 == 0) {
//
//						
//						System.out.println("nuova nota");
//						listaNote3.add(array);
//				       
//					}
//					
//					if (counter2 % 150 == 0) {
//						
//						listaNote4.add(array);
//					}
//				
//			
//				
//			}
//			
//			
//		}
		//hard-phinal round
	 
	 }
		
	       
				
		    // do some more work
	}
	public void colorBlue(Graphics g) {
		g.setColor(Color.blue);
		
		
	}
	
	public void draw(Graphics g) {
	if (playing) {
		g.setColor(Color.white);
		for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
			//g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
		//	g.drawLine(0, i*UNIT_SIZE,  SCREEN_WIDTH, i*UNIT_SIZE);
			
		}
		
		newNote(g, new int[GAME_UNITS]);
		
		
		
		//disegno ovali dove la nota va suonata 
		
				g.setColor(Color.pink);
				g.fillOval(350, 500, UNIT_SIZE, UNIT_SIZE);
				
				g.setColor(Color.white);
				g.fillOval(300, 500, UNIT_SIZE, UNIT_SIZE);
				
				g.setColor(Color.green);
				g.fillOval(250, 500, UNIT_SIZE, UNIT_SIZE);
				
				g.setColor(Color.red);
				g.fillOval(200, 500,UNIT_SIZE, UNIT_SIZE);
				
		//disegno ulteriori note, scandite secondo una temporalità
		
		for (int[] s : listaNote1) {
			for (int i = 0; i < bodyParts; i++) {
				if ( i == 0) {
					g.setColor(Color.pink);
					g.fillOval(350 , s[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(Color.orange);
					g.drawLine(350, s[i], 350, s[i] + UNIT_SIZE);
				}
			}
		}
		
		for (int[] s : listaNote2) {
			for (int i = 0; i < bodyParts; i++) {
				if ( i == 0) {
					g.setColor(Color.red);
					g.fillOval(200 , s[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(Color.orange);
					g.drawLine(200, s[i], 200, s[i] + UNIT_SIZE);
				}
			}
			
		}
		
		for (int[] s : listaNote3) {
			for (int i = 0; i < bodyParts; i++) {
				if ( i == 0) {
					g.setColor(Color.green);
					g.fillOval(250 , s[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(Color.orange);
					g.drawLine(250, s[i], 250, s[i] + UNIT_SIZE);
				}
			}
			
		}
		
		for (int[] s : listaNote4) {
			for (int i = 0; i < bodyParts; i++) {
				if ( i == 0) {
					g.setColor(Color.white);
					g.fillOval(300 , s[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(Color.orange);
					g.drawLine(300, s[i], 300, s[i] + UNIT_SIZE);
				}
			}
			
		}
			
	}
	
	else gameOver(g);
	}
	
	
	
	public void move() {
		
		for (int[] s : listaNote1) {
			for (int i = bodyParts; i > 0; i--) {
				s[i] = s[i-1];
				}
			s[0] = s[0] + UNIT_SIZE;
		}
		
		for (int[] s : listaNote2) {
			for (int i = bodyParts; i > 0; i--) {
				s[i] = s[i-1];
				}
		s[0] = s[0] + UNIT_SIZE;
		}
		for (int[] s : listaNote3) {
			for (int i = bodyParts; i > 0; i--) {
				s[i] = s[i-1];
				}
		s[0] = s[0] + UNIT_SIZE;
		}
		for (int[] s : listaNote4) {
			for (int i = bodyParts; i > 0; i--) {
				s[i] = s[i-1];
				}
		s[0] = s[0] + UNIT_SIZE;
		}
	}
	
	
	
	public void checkNotes() {
		
		
		
		for (int[] s : listaNote1) {
			if (450 <= s[0] && 470 >= s[0]) {
				
				playedNote = ' ';
				
			}
				
			
			if (s[0] == 500 && playedNote != 'a') {
				System.out.println("DISSONANZA");
				
				DisturbNoise.dissonance();
				noise++;
				
			}
		}
		for (int[] s : listaNote2) {
			if (450 <= s[0] && 470 >= s[0]) {
				
				playedNote = ' ';
				
			}
				
			
			if (s[0] == 500 && playedNote != 'a') {
				System.out.println("DISSONANZA");
				
				DisturbNoise.dissonance();
				noise++;
				
			}
		}
//		for (int[] s : listaNote3) {
//			if (450 <= s[0] && 470 >= s[0]) {
//				
//				playedNote = ' ';
//				
//			}
//				
//			
//			if (s[0] == 500 && playedNote != 'a') {
//				System.out.println("DISSONANZA");
//				
//				DisturbNoise.dissonance();
//				noise++;
//				
//			}
//		}
//		for (int[] s : listaNote4) {
//			if (450 <= s[0] && 470 >= s[0]) {
//				
//				playedNote = ' ';
//				
//			}
//				
//			
//			if (s[0] == 500 && playedNote != 'a') {
//				System.out.println("DISSONANZA");
//				
//				DisturbNoise.dissonance();
//				noise++;
//				
//			}
//		}
		
		
		
		
		
		
			
	}
	
	public void checkCollisions() {
		if (noise > 10) {
			playing = false;
			timer.stop();
		}
		
		// the world is spherical
		
		if (y[0] > SCREEN_HEIGHT) y[0] = 0;
		if (y2[0] > SCREEN_HEIGHT) y2[0] = 0;
		if (!playing) timer.stop();
		
	}
	
	
	
	public void gameOver(Graphics g) {
		ReproduceMusic.EndSong();
		g.setColor(Color.blue);
		g.setFont( new Font("Ink Free", Font.BOLD, 50));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("You'll get better ;)", (SCREEN_WIDTH - metrics.stringWidth("You'll get better ;)"))/2, SCREEN_HEIGHT/2);
	}
	
	
	public class MyKeyAdapter extends KeyAdapter {
		

		@Override
		public void keyPressed(KeyEvent e) {
			
			playedNote = e.getKeyChar();
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') direction = 'L';
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') direction = 'R';
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') direction = 'U';
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') direction = 'D';
				break;
				
			}
			
		}
	}

}

