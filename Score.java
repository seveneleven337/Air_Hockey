package game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score implements Global {

		Integer player1 = 0;
		Integer player2 = 0;
		Score(){
			
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.setFont(new Font("consolas",Font.PLAIN,60));
			
			//g.drawLine(SCREEN_WIDTH/2, 0, SCREEN_WIDTH/2,SCREEN_HEIGHT);
			g.drawString(String.valueOf(player1), SCREEN_WIDTH/2 -85, 150);
			g.drawString(String.valueOf(player2), SCREEN_WIDTH/2 +55, 150);
		}
}
