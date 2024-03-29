package game2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * class to save status of the game when we are using serialization
 * @author Gonzalo
 */

public class File{
	private Score loaded;
	
	private FileOutputStream fileOut;
	private ObjectOutputStream objectOut;
	
	private FileInputStream fileIn;
	private ObjectInputStream objectIn;
	
	/**
	 * method who read and display previous score status
	 */
	public void input() {
		try {
			fileIn = new FileInputStream("file.txt");
			objectIn = new ObjectInputStream(fileIn);
			
			loaded = (Score)objectIn.readObject();
			
			System.out.println("previus score:\n" + "player1: " +  loaded.getPlayer1() + " player2: " + loaded.getPlayer2());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * method who create a new output file, and write inside the score of the game
	 * @param score
	 */
	public void output(Score score) {
		try {
			fileOut = new FileOutputStream("file.txt");
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(score);
			objectOut.flush();
			objectOut.close();
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
