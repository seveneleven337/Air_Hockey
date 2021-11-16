package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Background extends Rectangle implements Global{
		
		int id;
		Background(int x, int y, int width, int height, int id){
			super(x,y,width,height);
			this.id = id;
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.red);
			if(id==1) {
				g.drawImage(HOR_BLUE, x, y-10, null);
				g.drawRect(x, y,width, height);
			}
			if(id==2) {
				g.drawRect(x, y,width, height);
				g.drawImage(HOR_GREEN, x, y-10, null);
			}
			if(id==3) {
				g.drawImage(HOR_RED, x, y-50, null);
				g.drawRect(x, y,width, height);
			}
			if(id==4) {
				g.drawImage(HOR_YELLOW, x, y-50, null);
				g.drawRect(x, y,width, height);
			}
			if(id==5) {
				g.drawImage(VER_BLUE, x, y+40, null);
				g.drawRect(x, y,width, height);
			}
			if(id==7) {
				g.drawRect(x, y,width, height);
				g.drawImage(VER_GREEN, x-40, y+40, null);
			}
			if(id==6) {
				g.drawRect(x, y,width, height);
				g.drawImage(VER_RED, x, y-40, null);
			}
			if(id==8) {
				g.drawRect(x, y,width, height);
				g.drawImage(VER_YELLOW, x-40, y-40, null);
			}
		}
		
}








//deberia crear los rectangulos en playground 
//deberia crearlos aca?