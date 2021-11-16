package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Disc extends Rectangle implements Global{
		
		Random random;
		Integer Speedx;
		Integer Speedy;
		Image image;
		
		Disc(){
			super(SCREEN_WIDTH/2-DISC_DIAMETER/2,SCREEN_HEIGHT/2-DISC_DIAMETER/2,DISC_DIAMETER+5,DISC_DIAMETER+5);
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
			image = new ImageIcon("D:\\user\\escritorio\\java\\entity JD\\game2.0\\PNG\\disc.png").getImage().getScaledInstance(DISC_DIAMETER+5, DISC_DIAMETER+5, Image.SCALE_FAST);
			
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
			//g.setColor(Color.white);
			//g.fillOval(x, y, height, width);
			g.drawImage(image, x, y, null);
		}
}
