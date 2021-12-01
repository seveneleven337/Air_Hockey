package game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
/**
 * this class contain the class who hold all the objects in the jPanel, override runnable and generate the threads for the game
 *  * @author Gonzalo
 *
 */


public class Playground extends JPanel implements Global, Runnable{
		
	    //Basic variables 
		private Thread mainThread;
		private Graphics graphics;
		
		//image
		private Image image;
		
		//main objects  
		private Striker striker1;
		private Striker striker2;
		private Disc disc;
		private Score score;
		//Score score2;
		
		//main background
		private ArrayList <Background> back = new ArrayList <Background>();

		//other
		private Random random;
		private Integer avgFps = 60;
		private File file;
		
		
		//constructor
		Playground(){
			//======
			background();
			striker();
			disc();
			//score();
			score= new Score();
			//file
			new FileLocal();
			file = new File();
			file.input();
			
			
			//======
			this.setFocusable(true);                 //listen to key signals
			this.addKeyListener(new Keyboard());
			this.setPreferredSize(SCREEN);
			
			//=======
			mainThread = new Thread(this);
			mainThread.start();
		}
		
		/**
		 * method who instantiate different parts of the back(background) object
		 */
		public void background() {
			//top
			back.add(new Background((SCREEN_WIDTH/2+DISC_DIAMETER/2)-LONG_BORDER,0,LONG_BORDER,BORDER,1));
			back.add(new Background(SCREEN_WIDTH/2-DISC_DIAMETER/2,0,LONG_BORDER,BORDER,2));
			//bot
			back.add(new Background((SCREEN_WIDTH/2+DISC_DIAMETER/2)-LONG_BORDER,SCREEN_HEIGHT-BORDER,LONG_BORDER,BORDER,3));
			back.add(new Background(SCREEN_WIDTH/2-DISC_DIAMETER/2,SCREEN_HEIGHT-BORDER,LONG_BORDER,BORDER,4));
			//left
			back.add(new Background(0,0,BORDER,SHORT_BORDER+40,5));
			back.add(new Background(0,SCREEN_HEIGHT-SHORT_BORDER-40,BORDER,SHORT_BORDER+40,6));
			//right
			back.add(new Background(SCREEN_WIDTH-BORDER,0,BORDER,SHORT_BORDER+40,7));
			back.add(new Background(SCREEN_WIDTH-BORDER,SCREEN_HEIGHT-SHORT_BORDER-40,BORDER,SHORT_BORDER+40,8));
		
		}
		/**
		 * method who instantiate 2 striker 
		 */
		public void striker() {
			striker1 = new Striker(3*BORDER,1);
			striker2 = new Striker(SCREEN_WIDTH-3*BORDER-STRIKER_WIDTH,2);
		}
		/**
		 * method who instantiate 2 disc 
		 */
		public void disc() {
			disc = new Disc();
		}
		/**
		 * method to draw
		 * @param g
		 */
		public void paint(Graphics g) {
			image = createImage(getWidth(),getHeight());
			graphics = image.getGraphics();
			draw(graphics);
			g.drawImage(image,0,0,this);
		}
		/**
		 * method who hold different object who will be draw
		 * @param g
		 */
		public void draw(Graphics g) {
			drawBorder(g);
			striker1.draw(g);
			striker2.draw(g);
			disc.draw(g);
			score.draw(g);
		}
		/**
		 * method who hold background who will be draw
		 * @param g
		 */
		public void drawBorder(Graphics g) {
			g.drawImage(BACKGROUND, 0, 0, null);
			for(Background e: back) {
				e.draw(g);
			}
		}
		/**
		 * method who contain movements of the objects
		 */
		public void move() {
			striker1.move();
			striker2.move();
			disc.move();	
		}
		/**
		 * method who handle the objects collision
		 */
		public void checkCollision() {
			
			//========disk top and bottom===========
			if(back.get(0).contains(disc)||back.get(1).contains(disc)) {
				disc.setYDirection(-disc.getSpeedy());
			}
			if(back.get(2).contains(disc)||back.get(3).contains(disc)) {
				disc.setYDirection(-disc.getSpeedy());
			}
			
			//========disk right and left background border==========
			if(back.get(4).contains(disc)||back.get(5).contains(disc)) {
				disc.setXDirection(-disc.getSpeedx());
			}
			if(back.get(6).contains(disc)||back.get(7).contains(disc)) {
				disc.setXDirection(-disc.getSpeedx());
			}
			
			
			//========striker area movement===========
			//striker1 top
			if(striker1.intersects(back.get(0))) {
				striker1.y = BORDER;
			}
			//striker1 bottom
			if(striker1.intersects(back.get(2))) {
				striker1.y = SCREEN_HEIGHT-BORDER-STRIKER_HEIGHT;
			}
			//striker2 top
			if(striker2.intersects(back.get(1))) {
				striker2.y = BORDER;
			}
			//striker2 bottom
			if(striker2.intersects(back.get(3))) {
				striker2.y = SCREEN_HEIGHT-BORDER-STRIKER_HEIGHT;
			}
			
			//==========striker and disk=========== 
			
			if(striker1.contains(disc) || striker2.contains(disc)) {
				if(disc.getSpeedx()<0) {
				disc.setXDirection(Math.abs(disc.getSpeedx())+1);
					if(disc.getSpeedy()>0)
						disc.setYDirection(Math.abs(disc.getSpeedy())+1);
					else {
						disc.setYDirection(-1*(Math.abs(disc.getSpeedy())+1));
					}
				} else {
				disc.setXDirection(-1*(Math.abs(disc.getSpeedx())+1));
					if(disc.getSpeedy()>0)
						disc.setYDirection(Math.abs(disc.getSpeedy())+1);
					else {
						disc.setYDirection(-1*(Math.abs(disc.getSpeedy())+1));
				}
				}
			}
			
			
			
			//==========score=============
			//player1 score
			if(score.getGoalpost1().contains(disc)) {
				score.setPlayer1();;
				striker();
				disc();
				System.out.println("player 1 score" + score.getPlayer1());
				file.output(score);;
			}
			//player2 score
			if(score.getGoalpost2().contains(disc)) {
				score.setPlayer2();
				striker();
				disc();
				System.out.println("player 2 score" + score.getPlayer2());
				file.output(score);
			}
		}
		
		/**
		 * loop of the game
		 */
		public void run() {
			
			//frames configuration											
			double delta = 0;										
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
					avgFps = frames;
					frames = 0;
					time = 0;
				}
			}
		}

		/**
		 * inner class who listen the keyboard signals
		 * @author Gonzalo
		 */

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









