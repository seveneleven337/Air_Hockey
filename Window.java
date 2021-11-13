package game2;

import java.awt.Color;

import javax.swing.JFrame;


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
			this.setLocationRelativeTo(null);
		}
}
