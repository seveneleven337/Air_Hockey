package game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;


public class Score implements Global, Serializable {

	
		private static final long serialVersionUID = 1L;
		private Integer player1 = 0;
		private Integer player2 = 0;
		private Rectangle goalpost1;
		private Rectangle goalpost2;
		Score(){
			goalpost1 = new Rectangle(0,SHORT_BORDER,BORDER,GOALPOST);
			goalpost2 = new Rectangle(SCREEN_WIDTH-BORDER,SHORT_BORDER,BORDER,GOALPOST);
		}
		
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.setFont(new Font("consolas",Font.PLAIN,60));
			
			g.drawString(String.valueOf(player1), SCREEN_WIDTH/2 -85, 150);
			g.drawString(String.valueOf(player2), SCREEN_WIDTH/2 +55, 150);
			//g.drawRect(goalpost1.x, goalpost1.y, goalpost1.width, goalpost1.height);
			//g.drawRect(goalpost2.x, goalpost2.y, goalpost2.width, goalpost2.height);
		}

		public Rectangle getGoalpost1() {
			return goalpost1;
		}

		public void setGoalpost1(Rectangle goalpost1) {
			this.goalpost1 = goalpost1;
		}

		public Rectangle getGoalpost2() {
			return goalpost2;
		}

		public void setGoalpost2(Rectangle goalpost2) {
			this.goalpost2 = goalpost2;
		}

		public Integer getPlayer1() {
			return player1;
		}

		public void setPlayer1() {
			player1++;
		}

		public Integer getPlayer2() {
			return player2;
		}

		public void setPlayer2() {
			player2++;
		}
}
