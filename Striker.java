package game2;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;



//============================ cambiar todo denuevo aca y algunas del playground =============


public class Striker extends Rectangle implements Global{
	
	int id;
	int speedY;
	Image image;
	
	Striker(int x,int id){
		super(x,(SCREEN_HEIGHT/2)-(STRIKER_HEIGHT/2),STRIKER_WIDTH,STRIKER_HEIGHT);
		this.id = id;
		if(id == 1) {
			image = new ImageIcon("PNG\\St1.png").getImage().getScaledInstance(STRIKER_WIDTH+10, STRIKER_HEIGHT, Image.SCALE_FAST);
		}
		if(id == 2) {
			image = new ImageIcon("PNG\\St.png").getImage().getScaledInstance(STRIKER_WIDTH+10, STRIKER_HEIGHT, Image.SCALE_FAST);
		}
	}
		
		public void keyPressed(KeyEvent e) {
			switch(id) {
			//player 1 keycode
			case 1:
				if(e.getKeyCode()==KeyEvent.VK_W) {
					setYDirection(-STRIKER_SPEED);
					move();
					System.out.println("w");
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
					setYDirection(STRIKER_SPEED);
					move();
					System.out.println("s");
				}
				break;
			//player 2 keycode
			case 2:
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					setYDirection(-STRIKER_SPEED);
					move();
					System.out.println("up");
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					setYDirection(STRIKER_SPEED);
					move();
					System.out.println("down");
				} break;
		}
		}
		public void keyReleased(KeyEvent e) {
			switch(id) {
			case 1:
				if(e.getKeyCode()==KeyEvent.VK_W) {
					setYDirection(0);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
					setYDirection(0);
					move();
				}break;
			case 2:
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					setYDirection(0);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					setYDirection(0);
					move();
				}break;
			}	
		}
		
		public void setYDirection(int yDirection) {
			speedY = yDirection;
		}
		public void move() {
			y = y + speedY;
		}
		public void draw(Graphics g) {
			if(id==1) {
				g.setColor(Color.green);
			}
				
			else {
				g.setColor(Color.red);
			}
			g.drawImage(image, x, y, null);	
			//g.fillRect(x, y, width, height);
		}

		

}
