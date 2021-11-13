package game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Playground extends JPanel implements Global, Runnable{
		
	    //Basic variables
		Thread mainThread;
		Graphics graphics;
		
		//image
		Image image;
		Image background;
		
		//objects 
		Striker striker1;
		Striker striker2;
		Disc disc;
		Score score;
		
		//other
		Random random;
		
		
		Playground(){
			//=======
			striker();
			disc();
			score = new Score();
			background = new ImageIcon("PNG\\background.png").getImage();
			
			//======
			this.setFocusable(true);                 //listen to key signals
			this.addKeyListener(new Keyboard());
			this.setPreferredSize(SCREEN);
			
			//=======
			mainThread = new Thread(this);
			mainThread.start();
		}
		
		public void striker() {
			striker1 = new Striker(STRIKER_WIDTH*4,1);
			striker2 = new Striker(SCREEN_WIDTH-5*STRIKER_WIDTH,2);
		}
		
		public void disc() {
			disc = new Disc();
		}
		
		public void paint(Graphics g) {
			image = createImage(getWidth(),getHeight());
			graphics = image.getGraphics();
			draw(graphics);
			g.drawImage(image,0,0,this);
		}
		
		public void draw(Graphics g) {
			g.drawImage(background, 0, 0, null);
			striker1.draw(g);
			striker2.draw(g);
			disc.draw(g);
			score.draw(g);
		}
		
		public void move() {
			striker1.move();
			striker2.move();
			disc.move();	
		}
		
		public void checkCollision() {
			
			//========disk top and bottom===========
			if(disc.y<=BORDER_BACKGROUND) {
				disc.setYDirection(-disc.Speedy);
			}
			if(disc.y>=SCREEN_HEIGHT-DISC_DIAMETER-BORDER_BACKGROUND) {
				disc.setYDirection(-disc.Speedy);
			}
			
			//========disk right and left background border==========
			//right - bottom
			if(disc.x <= BORDER_BACKGROUND && disc.y <= 225) {
				disc.setXDirection(-disc.Speedx);
			}
			//right-left
			if(disc.x <= BORDER_BACKGROUND && disc.y >= SCREEN_HEIGHT-DISC_DIAMETER-(BORDER_BACKGROUND+225)) {
				disc.setXDirection(-disc.Speedx);
			}
			//left - bottom
			if(disc.x >= SCREEN_WIDTH-DISC_DIAMETER-BORDER_BACKGROUND && disc.y <= 225) {
				disc.setXDirection(-disc.Speedx);
			}
			//left - top
			if(disc.x >= SCREEN_WIDTH-DISC_DIAMETER-BORDER_BACKGROUND && disc.y >= SCREEN_HEIGHT-DISC_DIAMETER-(BORDER_BACKGROUND+225)) {
				disc.setXDirection(-disc.Speedx);
			}
			
			//========striker area movement===========
			//striker1 bottom
			if(striker1.y<=BORDER_BACKGROUND) {
				striker1.y = BORDER_BACKGROUND;
			}
			//striker1 top
			if(striker1.y>=SCREEN_HEIGHT-STRIKER_HEIGHT-BORDER_BACKGROUND) {
				striker1.y = SCREEN_HEIGHT-STRIKER_HEIGHT-BORDER_BACKGROUND;
			}
			//striker2 bottom
			if(striker2.y<=BORDER_BACKGROUND) {
				striker2.y = BORDER_BACKGROUND;
			}
			//striker2 top
			if(striker2.y>=SCREEN_HEIGHT-STRIKER_HEIGHT-BORDER_BACKGROUND) {
				striker2.y = SCREEN_HEIGHT-STRIKER_HEIGHT-BORDER_BACKGROUND;
			}
			
			//==========striker and disk===========
			//striker1 and disk
			if(disc.intersects(striker1)) {
				disc.setXDirection(-disc.Speedx);
			}
			//striker1 and disk
			if(disc.intersects(striker2)) {
				disc.setXDirection(-disc.Speedx);
			}
			
			//==========score=============
			//player1 score
			if(disc.x >=SCREEN_WIDTH-DISC_DIAMETER) {
				score.player1 ++;
				striker();
				disc();
				System.out.println("player 1 score" + score.player1);
			}
			//player2 score
			if(disc.x <= 0) {
				score.player2 ++;
				striker();
				disc();
				System.out.println("player 2 score" + score.player2);
			}
		}
		
		
		
		public void run() {
			
			//frames config
			final double fps = 60.0;								// fps que quiero
			double targetTime = 1000000000/fps; 					// tiempo en nanoseg teorico
			double delta = 0;										// diferencia entre tiempo teorico y real (fps)
			int frames = 0;
			
			//get time
			double lastTime = System.nanoTime();
			double time = 0;
			
			while(true) {
				double now = System.nanoTime();
				delta += (now - lastTime)/targetTime;
				time += (now - lastTime);
				lastTime = now;
				
				if(delta>=1) {
					move();
					checkCollision();
					repaint();
					delta--;
					frames++;
				}
				
				// conditional for print true fps
				if(time>=1000000000) {                                      
					double avgFps = frames;
					//System.out.println("Average FPS: " + avgFps);
					frames = 0;
					time = 0;
				}
			}
		}
		
		//=========inner class who listen the keyboard signals==========
		public class Keyboard extends KeyAdapter{
			public void keyPressed(KeyEvent e) {
				striker1.keyPressed(e);
				striker2.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				striker1.keyReleased(e);
				striker2.keyReleased(e);
			}
		}
}
