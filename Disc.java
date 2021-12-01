package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/**
 * this class contain state and behavior of disc
 * @author Gonzalo
 *
 */
public class Disc extends Rectangle implements Global{
		
		private Random random;
		private Integer Speedx;
		private Integer Speedy;
		//constructor
		Disc(){
			super(SCREEN_WIDTH/2-DISC_DIAMETER/2,SCREEN_HEIGHT/2-DISC_DIAMETER/2,DISC_DIAMETER-40,DISC_DIAMETER-40);
			random = new Random();
			int randomXDirection = random.nextInt(2);
			if(randomXDirection ==0) {
				randomXDirection--;
			}
			setXDirection(randomXDirection*DISC_SPEED);
			
			int randomYDirection = random.nextInt(2);
			if(randomYDirection ==0) {
				randomYDirection--;
			}
			setYDirection(randomYDirection*DISC_SPEED);
		}
		/**
		 * set the X direction of the disc when is instantiate 
		 * @param randomXDirection
		 */
		public void setXDirection(int randomXDirection ) {
			Speedx = randomXDirection;
		}
		/**
		 * set the Y direction of the disc when is instantiate 
		 * @param randomYDirection
		 */
		public void setYDirection(int randomYDirection) {
			Speedy = randomYDirection;
		}
		/**
		 * method to modify the position of the disc
		 */
		public void move() {
			x +=  Speedx;
			y +=  Speedy;
		}
		/**
		 * method to draw 
		 * @param g
		 */
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.drawImage(DISC, x-20, y-20, null);
			//g.fillOval(x, y, height, width);
			
		}
		/**
		 * return speedx
		 * @return
		 */
		public Integer getSpeedx() {
			return Speedx;
		}
		/**
		 * set speedx
		 * @param speedx
		 */
		public void setSpeedx(Integer speedx) {
			Speedx = speedx;
		}
		/**
		 * get speedy
		 * @return
		 */
		public Integer getSpeedy() {
			return Speedy;
		}
		/**
		 * set speedy
		 * @param speedy
		 */
		public void setSpeedy(Integer speedy) {
			Speedy = speedy;
		}
		
}
