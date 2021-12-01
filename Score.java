package game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
/**
 * this class contain the state and behavior of the score of the game, this class is serializable
 * @author Gonzalo
 *
 */

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
		/**
		 * method to draw the score
		 * @param g
		 */
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.setFont(new Font("consolas",Font.PLAIN,60));
			
			g.drawString(String.valueOf(player1), SCREEN_WIDTH/2 -85, 150);
			g.drawString(String.valueOf(player2), SCREEN_WIDTH/2 +55, 150);
			//g.drawRect(goalpost1.x, goalpost1.y, goalpost1.width, goalpost1.height);
			//g.drawRect(goalpost2.x, goalpost2.y, goalpost2.width, goalpost2.height);
		}
		/**
		 * return goalpost1
		 * @return
		 */
		public Rectangle getGoalpost1() {
			return goalpost1;
		}
		/**
		 * set goalpost1
		 * @param goalpost1
		 */
		public void setGoalpost1(Rectangle goalpost1) {
			this.goalpost1 = goalpost1;
		}
		/**
		 * return goalpost2
		 * @return
		 */
		public Rectangle getGoalpost2() {
			return goalpost2;
		}
		/**
		 * set goalpost1
		 * @param goalpost2
		 */
		public void setGoalpost2(Rectangle goalpost2) {
			this.goalpost2 = goalpost2;
		}
		/**
		 * return player1 score
		 * @return
		 */
		public Integer getPlayer1() {
			return player1;
		}
		/**
		 * set player 1 score
		 */
		public void setPlayer1() {
			player1++;
		}
		/**
		 * return player2 score
		 * @return
		 */
		public Integer getPlayer2() {
			return player2;
		}
		/**
		 * set player 2 score
		 */
		public void setPlayer2() {
			player2++;
		}
}
