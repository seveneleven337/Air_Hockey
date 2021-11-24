package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Striker extends Rectangle implements Global{
	
	private int id;
	private int speedY;
	Rectangle inv1;
	Rectangle inv2;
	
	Striker(int x,int id){
		super(x,(SCREEN_HEIGHT/2)-(STRIKER_HEIGHT/2),STRIKER_WIDTH,STRIKER_HEIGHT);
		this.id = id;
		inv1 = new Rectangle(x-2, (SCREEN_HEIGHT/2)-(STRIKER_HEIGHT/2)-INVISIBLE_HEIGHT-3,INVISIBLE_WIDTH, INVISIBLE_HEIGHT);
		inv2 = new Rectangle(x-2, (SCREEN_HEIGHT/2)+(STRIKER_HEIGHT/2)+INVISIBLE_HEIGHT+2,INVISIBLE_WIDTH, INVISIBLE_HEIGHT);
	}
		
		public void keyPressed(KeyEvent e) {
			switch(id) {
			//player 1 keycode
			case 1:
				if(e.getKeyCode()==KeyEvent.VK_W) {
					setYDirection(-STRIKER_SPEED);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
					setYDirection(STRIKER_SPEED);
					move();
				}
				break;
			//player 2 keycode
			case 2:
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					setYDirection(-STRIKER_SPEED);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					setYDirection(STRIKER_SPEED);
					move();
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
			inv1.y = inv1.y + speedY;
			inv2.y = inv2.y + speedY;
		}
		public void draw(Graphics g) {
			if(id==1) {
				g.drawImage(STRIKER1, x, y, null);
				/*g.setColor(Color.green);
				g.drawRect(x, y, width, height);
				g.setColor(Color.white);
				g.drawRect(inv1.x,inv1.y,inv1.width,inv1.height);
				g.drawRect(inv2.x,inv2.y,inv2.width,inv2.height);*/
			}else {
				g.drawImage(STRIKER2, x, y, null);
				/*g.setColor(Color.red);
				g.drawRect(x, y, width, height);
				g.setColor(Color.white);
				g.drawRect(inv1.x,inv1.y,inv1.width,inv1.height);
				g.drawRect(inv2.x,inv2.y,inv2.width,inv2.height);*/
			}
		}

		

}
