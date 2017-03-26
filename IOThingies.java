/**
 * 
 */
package letTheGameBegin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
					if (line.length() > 0) lines.add(line);
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
	
	final public static void writeFile(ArrayList<String> arrList, String out) throws IOException {
		
		FileWriter writer = new FileWriter(out);
		
		try {
			for(String line: arrList) {
				writer.write(line + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.close();
	}
	
	final public static String getTheWord(String str, int n) {
		
		String[] tmp = str.split(" ");
		if(n-1 < tmp.length) return tmp[n - 1];
		return null;
	}
}
