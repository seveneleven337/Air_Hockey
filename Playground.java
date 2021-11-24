package game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;



public class Playground extends JPanel implements Global, Runnable{
		
	    //Basic variables
		Thread mainThread;
		Graphics graphics;
		
		//image
		Image image;
		
		//main objects  
		Striker striker1;
		Striker striker2;
		Disc disc;
		Score score;
		//Score score2;
		
		//main background
		ArrayList <Background> back = new ArrayList <Background>();

		//other
		Random random;
		Integer avgFps = 60;
		
		Playground(){
			//======
			background();
			striker();
			disc();
			//score();
			score= new Score();
			
			
			//======
			this.setFocusable(true);                 //listen to key signals
			this.addKeyListener(new Keyboard());
			this.setPreferredSize(SCREEN);
			
			//=======
			mainThread = new Thread(this);
			mainThread.start();
		}
		
		/*public void score() {	
		 * 
		 * 
		 * 
		 * 
		}*/
		
		public void background() {
			//top
			back.add(new Background((SCREEN_WIDTH/2+DISC_DIAMETER)-LONG_BORDER,0,LONG_BORDER,BORDER,1));
			back.add(new Background(SCREEN_WIDTH/2-DISC_DIAMETER,0,LONG_BORDER,BORDER,2));
			//bot
			back.add(new Background((SCREEN_WIDTH/2+DISC_DIAMETER)-LONG_BORDER,SCREEN_HEIGHT-BORDER,LONG_BORDER,BORDER,3));
			back.add(new Background(SCREEN_WIDTH/2-DISC_DIAMETER,SCREEN_HEIGHT-BORDER,LONG_BORDER,BORDER,4));
			//left
			back.add(new Background(0,0,BORDER,SHORT_BORDER,5));
			back.add(new Background(0,SCREEN_HEIGHT-SHORT_BORDER,BORDER,SHORT_BORDER,6));
			//right
			back.add(new Background(SCREEN_WIDTH-BORDER,0,BORDER,SHORT_BORDER,7));
			back.add(new Background(SCREEN_WIDTH-BORDER,SCREEN_HEIGHT-SHORT_BORDER,BORDER,SHORT_BORDER,8));
		
		}
		public void striker() {
			striker1 = new Striker(3*BORDER,1);
			striker2 = new Striker(SCREEN_WIDTH-3*BORDER-STRIKER_WIDTH,2);
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
			drawBorder(g);
			striker1.draw(g);
			striker2.draw(g);
			disc.draw(g);
			score.draw(g);
		}
		
		public void drawBorder(Graphics g) {
			g.drawImage(BACKGROUND, 0, 0, null);
			for(Background e: back) {
				e.draw(g);
			}
		}
		
		public void move() {
			striker1.move();
			striker2.move();
			disc.move();	
		}
		
		public void checkCollision() {
			
			//========disk top and bottom===========
			if(back.get(0).contains(disc)||back.get(1).contains(disc)) {
				disc.setYDirection(-disc.Speedy);
			}
			if(back.get(2).contains(disc)||back.get(3).contains(disc)) {
				disc.setYDirection(-disc.Speedy);
			}
			
			//========disk right and left background border==========
			if(back.get(4).contains(disc)||back.get(5).contains(disc)) {
				disc.setXDirection(-disc.Speedx);
			}
			if(back.get(6).contains(disc)||back.get(7).contains(disc)) {
				disc.setXDirection(-disc.Speedx);
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
				if(disc.Speedx<0) {
				disc.setXDirection(Math.abs(disc.Speedx)+1);
					if(disc.Speedy>0)
						disc.setYDirection(Math.abs(disc.Speedy)+1);
					else {
						disc.setYDirection(-1*(Math.abs(disc.Speedy)+1));
					}
				} else {
				disc.setXDirection(-1*(Math.abs(disc.Speedx)+1));
					if(disc.Speedy>0)
						disc.setYDirection(Math.abs(disc.Speedy)+1);
					else {
						disc.setYDirection(-1*(Math.abs(disc.Speedy)+1));
				}
				}
			}
			
			
			
			//==========score=============
			//player1 score
			if(score.goalpost1.contains(disc)) {
				score.player1 ++;
				striker();
				disc();
				System.out.println("player 1 score" + score.player1);
			}
			//player2 score
			if(score.goalpost2.intersects(disc)) {
				score.player2 ++;
				striker();
				disc();
				System.out.println("player 2 score" + score.player2);
			}
		}
		
		
		
		public void run() {
			
			//frames config
			final double fps = 60.0;								
			double targetTime = 1000000000/fps; 					
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







