package game2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AirHockeyGame {

	public static void main(String[] args) {
		
		Window window = new Window();
		
		
		//====== create a file =======
		
		String path = "test";
		CharSequence c = "Fps: "+(CharSequence)window.panel.avgFps.toString();
		File f1 = new File(path);
		
		String files[] = f1.list();
		
		for(String file : files) {
			System.out.println(file);
		}
		boolean b = f1.mkdir();
		if(b) {
			System.out.println("File Created");
		}else {
			System.out.println("File already exist");
		}
		
		File data = new File(f1,"AirHockey.txt");
		try {
			data.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintWriter output;
		try {
			output = new PrintWriter(data);
			output.println(LocalDateTime.now());
			output.append(c);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
