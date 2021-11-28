package game2;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public interface Global {
	//======screen=====
	public final Integer SCREEN_WIDTH = 1200;
	public final Integer SCREEN_HEIGHT = 800;
	public final Dimension SCREEN = new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);
		
	//=====striker=======
	public final int STRIKER_HEIGHT = 150;
	public final int STRIKER_WIDTH = 30;
	
	//======disc=======
	public final int DISC_DIAMETER = 50;
	
	//====== speed =====
	public final int STRIKER_SPEED = 10;
	public final int DISC_SPEED = 6;
	public final int DELTA_SPEED = 1; 
	
	//====== border dimension =======
	public final int BORDER= 70;
	public final int LONG_BORDER = 640;
	public final int SHORT_BORDER = 254;
	public final int GOALPOST = 292;
	
	//====== image =========
	public final Image BACKGROUND = new ImageIcon("PNG\\background-wO.png").getImage();
	
	public final Image STRIKER1 = new ImageIcon("PNG\\St1.png").getImage().getScaledInstance(STRIKER_WIDTH+20, STRIKER_HEIGHT, Image.SCALE_FAST);
	public final Image STRIKER2 = new ImageIcon("PNG\\St.png").getImage().getScaledInstance(STRIKER_WIDTH+20, STRIKER_HEIGHT, Image.SCALE_FAST);
	
	public final Image DISC = new ImageIcon("PNG\\disc.png").getImage().getScaledInstance(DISC_DIAMETER, DISC_DIAMETER, Image.SCALE_FAST);
	
	public final Image HOR_BLUE = new ImageIcon("PNG\\hor-blue.png").getImage().getScaledInstance(LONG_BORDER, BORDER+60, Image.SCALE_FAST);
	public final Image HOR_GREEN = new ImageIcon("PNG\\hor-green.png").getImage().getScaledInstance(LONG_BORDER, BORDER+60, Image.SCALE_FAST);
	public final Image HOR_RED = new ImageIcon("PNG\\hor-red.png").getImage().getScaledInstance(LONG_BORDER, BORDER+60, Image.SCALE_FAST);
	public final Image HOR_YELLOW = new ImageIcon("PNG\\hor-yellow.png").getImage().getScaledInstance(LONG_BORDER, BORDER+60, Image.SCALE_FAST);
	
	public final Image VER_BLUE = new ImageIcon("PNG\\sup-blue.png").getImage().getScaledInstance(BORDER+50, SHORT_BORDER+40, Image.SCALE_FAST);
	public final Image VER_GREEN = new ImageIcon("PNG\\sup-green.png").getImage().getScaledInstance(BORDER+50, SHORT_BORDER+40, Image.SCALE_FAST);
	public final Image VER_RED = new ImageIcon("PNG\\sup-red.png").getImage().getScaledInstance(BORDER+50, SHORT_BORDER+40, Image.SCALE_FAST);
	public final Image VER_YELLOW = new ImageIcon("PNG\\sup-yellow.png").getImage().getScaledInstance(BORDER+40, SHORT_BORDER+40, Image.SCALE_FAST);
	

		
	public final Double FPS = 60.0;
	public double targetTime = 1000000000/FPS; 	
	
}
