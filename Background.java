package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * this class contain the different part of the background images
 * @author Gonzalo
 *
 */
public class Background extends Rectangle implements Global{
		
		int id;
		//constructor
		Background(int x, int y, int width, int height, int id){
			super(x,y,width,height);
			this.id = id;
		}
		/**
		 * method to draw background
		 * @param g
		 */
		public void draw(Graphics g) {
			g.setColor(Color.red);
			
			switch (id) {
			case 1:
				g.drawImage(HOR_BLUE, x+15, y-30, null);
				//g.drawRect(x, y,width, height);
				break;
			case 2:
				g.drawImage(HOR_GREEN, x-20, y-30, null);
				//g.drawRect(x, y,width, height);
				break;
			case 3:
				g.drawImage(HOR_RED, x+15, y-30, null);
				//g.drawRect(x, y,width, height);
				break;
			case 4:
				g.drawImage(HOR_YELLOW, x-20, y-30, null);
				//g.drawRect(x, y,width, height);
				break;
			case 5:
				g.drawImage(VER_BLUE, x-20, y+10, null);
				//g.drawRect(x, y,width, height);
				break;
			case 7:
				g.drawImage(VER_GREEN, x-30, y+20, null);
				//g.drawRect(x, y,width, height);
				break;
			case 6:
				g.drawImage(VER_RED, x-20, y-10, null);
				//g.drawRect(x, y,width, height);
				break;
			case 8:
				g.drawImage(VER_YELLOW, x-30, y-10, null);
				//g.drawRect(x, y,width, height);
				break;
			}
		}
		
}

