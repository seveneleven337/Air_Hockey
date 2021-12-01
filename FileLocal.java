package game2;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/**
 * this class contain local final creation and write
 * @author Gonzalo
 *
 */
public class FileLocal implements Global {

		FileLocal(){
		//====== create a file =======
		
		String path = "test";
		CharSequence c = "Fps: "+(CharSequence)FPS.toString();
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
			output.println("last time played:");
			output.println(LocalDateTime.now());
			output.append(c);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
