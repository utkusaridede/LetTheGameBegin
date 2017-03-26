package letTheGameBegin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* <h1>IOUtils Public Final Class</h1>
* Public Final class to serve only its methods.
* <p>
* <b>Note:</b> Class for seperating IO operations
* from class which have main method.
*
* @author  Utku Saridede
* @version 1.0
* @since   2017-03-26
*/
public final class IOUtils {
	
	/**
	 * Reading from file operation.
	 * 
	 * @param argsLen number of arguments passed through program
	 * @param args arguments array
	 * @param lines stores whole input
	 * @throws IllegalArgumentException if number of arguments does not match with program
	 */
	public static void readFile(int argsLen, String[] args, ArrayList<String> lines) throws IllegalArgumentException{
		
		try {
		
		/*
		 * We do want two arguments passed from command line.
		 */
		if (argsLen == 2){
			
			
			File input = new File(args[0]);
			FileReader fileReader = new FileReader(input);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = reader.readLine()) != null){
				if (line.length() > 0) lines.add(line);
			}
			reader.close();
		} else {
			System.out.println("You should enter 2 file names from command prompt !");
				throw new IllegalArgumentException();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writing to file operation
	 * @param arrList whole story of output
	 * @param out output file
	 * @throws IOException if filewriter throw exception
	 */
	public static void writeFile(ArrayList<String> arrList, String out) throws IOException {
		
		FileWriter writer = new FileWriter(out);
		
		/*
		 * Test for writing action
		 */
		try {
			for(String line: arrList) {
				writer.write(line + "\n");
			}
			
		writer.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
