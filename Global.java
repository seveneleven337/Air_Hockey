package game2;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public interface Global {
	//======screen=====
	public static final Integer SCREEN_WIDTH = 1200;
	public static final Integer SCREEN_HEIGHT = 800;
	public static final Dimension SCREEN = new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);
		
	//=====striker=======
	public static final int STRIKER_HEIGHT = 130;
	public static final int STRIKER_WIDTH = 40;
	
	//======disc=======
	public static final int DISC_DIAMETER = 10;
	
	//====== speed =====
	public static final int STRIKER_SPEED = 10;
	public static final int DISC_SPEED = 6;
	public static final int DELTA_SPEED = 1; 
	
	//====== image =========
	public static final Image BACKGROUND = new ImageIcon("PNG\\background-wO.png").getImage();
	public static final Image STRIKER1 = new ImageIcon("PNG\\St1.png").getImage().getScaledInstance(STRIKER_WIDTH+20, STRIKER_HEIGHT, Image.SCALE_FAST);
	public static final Image STRIKER2 = new ImageIcon("PNG\\St.png").getImage().getScaledInstance(STRIKER_WIDTH+20, STRIKER_HEIGHT, Image.SCALE_FAST);
	
	public static final Image HOR_BLUE = new ImageIcon("PNG\\hor-blue.png").getImage();
	public static final Image HOR_GREEN = new ImageIcon("PNG\\hor-green.png").getImage();
	public static final Image HOR_RED = new ImageIcon("PNG\\hor-red.png").getImage();
	public static final Image HOR_YELLOW = new ImageIcon("PNG\\hor-yellow.png").getImage();
	public static final Image VER_BLUE = new ImageIcon("PNG\\sup-blue.png").getImage();
	public static final Image VER_GREEN = new ImageIcon("PNG\\sup-green.png").getImage();
	public static final Image VER_RED = new ImageIcon("PNG\\sup-red.png").getImage();
	public static final Image VER_YELLOW = new ImageIcon("PNG\\sup-yellow.png").getImage();
	
	//====== border dimension =======
	public static final int BORDER= 70;
	public static final int LONG_BORDER = 580;
	public static final int SHORT_BORDER = 254;
	public static final int GOALPOST = 292;
	
	//====== dimension to improve collision =====
	public static final int INVISIBLE_WIDTH = 23;
	public static final int INVISIBLE_HEIGHT =1;
	
}
