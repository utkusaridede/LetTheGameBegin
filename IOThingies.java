/**
 * 
 */
package letTheGameBegin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author utku
 *
 */
public class IOThingies {
	
	final public static void readFile(int argsLen, String[] args, ArrayList<String> lines) throws IllegalArgumentException{
		
		if (argsLen == 2){
			
			try {
				File input = new File(args[0]);
				FileReader fileReader = new FileReader(input);
				BufferedReader reader = new BufferedReader(fileReader);
				
				String line = null;
				
				while((line = reader.readLine()) != null){
					lines.add(line);
				}
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("You should enter 2 file names from command prompt !");
			throw new IllegalArgumentException();
		}
	}
}
