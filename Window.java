package game2;

import java.awt.Color;

import javax.swing.JFrame;
/**
 * class who contain the game frame
 * @author Gonzalo
 *
 */

public class Window extends JFrame implements Global{
		
		Playground panel;
		Window(){
			panel = new Playground();
			this.add(panel);
			this.setTitle("pingpong");
			this.setResizable(false);
			this.setBackground(Color.black);
			this.pack();
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
}
