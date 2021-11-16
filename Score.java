package game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score implements Global {

		Integer player1 = 0;
		Integer player2 = 0;
		Rectangle goalpost1;
		Rectangle goalpost2;
		Score(){
			goalpost1 = new Rectangle(0,SHORT_BORDER,BORDER,GOALPOST);
			goalpost2 = new Rectangle(SCREEN_WIDTH-BORDER,SHORT_BORDER,BORDER,GOALPOST);
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.setFont(new Font("consolas",Font.PLAIN,60));
			g.drawRect(goalpost1.x, goalpost1.y, goalpost1.width, goalpost1.height);
			g.drawRect(goalpost2.x, goalpost2.y, goalpost2.width, goalpost2.height);
			g.drawString(String.valueOf(player1), SCREEN_WIDTH/2 -85, 150);
			g.drawString(String.valueOf(player2), SCREEN_WIDTH/2 +55, 150);
		}
}
