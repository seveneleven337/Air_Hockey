package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Disc extends Rectangle implements Global{
		
		private Random random;
		private Integer Speedx;
		private Integer Speedy;
		
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
		
		public void setXDirection(int randomXDirection ) {
			Speedx = randomXDirection;
		}
		
		public void setYDirection(int randomXDirection) {
			Speedy = randomXDirection;
		}
		
		public void move() {
			x +=  Speedx;
			y +=  Speedy;
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.drawImage(DISC, x-20, y-20, null);
			//g.fillOval(x, y, height, width);
			
		}

		public Integer getSpeedx() {
			return Speedx;
		}

		public void setSpeedx(Integer speedx) {
			Speedx = speedx;
		}

		public Integer getSpeedy() {
			return Speedy;
		}

		public void setSpeedy(Integer speedy) {
			Speedy = speedy;
		}
		
}
