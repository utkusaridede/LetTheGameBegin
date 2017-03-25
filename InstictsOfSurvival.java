package letTheGameBegin;

import java.io.IOException;
import java.util.ArrayList;

public class InstictsOfSurvival {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> fileLines = new ArrayList<String>();

		IOThingies.readFile(args.length, args, fileLines);
		
		System.out.println(fileLines);
	}
}