package letTheGameBegin;

import java.util.TreeMap;
import java.io.IOException;
import java.util.ArrayList;

/**
* <h1>InstictsOfSurvival Public Class</h1>
* The main class for survival analysis
*
* @author  Utku Saridede
* @version 1.0
* @since   2017-03-26
*/
public class InstictsOfSurvival {

	/**
	 * Main method of program
	 * @param args command line arguments of program
	 * @throws IOException in order to handle writing operation
	 */
	public static void main(String[] args) throws IOException {
		
		// In order to keep input file in arrayList
		ArrayList<String> fileLines = new ArrayList<String>();
		// Reading input into arrayList
		IOUtils.readFile(args.length, args, fileLines);
		
		// Our main hero, Karacaoglan
		Hero karacaOglan = new Hero();
		
		// The way Karacaoglan should pass, the health point and attack power.
		int wayToGo = Integer.parseInt(getNthWord((fileLines.get(0)), 3));
		karacaOglan.setWayToGo(wayToGo);
		
		int hp = Integer.parseInt(getNthWord((fileLines.get(1)), 3));
		karacaOglan.setHp(hp);
		
		int attackPower = Integer.parseInt(getNthWord((fileLines.get(2)), 4));
		karacaOglan.setAttackPower(attackPower);
		
		// Enemy types with name attribute and number of unique enemies
		ArrayList<Enemy> uniqueEnemies = new ArrayList<Enemy>();
		int numberOfEnemies = 0;
		for (String line : fileLines){
			
			if (line.indexOf("Enemy") != -1){
				numberOfEnemies++;
				String name = getNthWord(line, 1);
				uniqueEnemies.add(new Enemy(name));
			}
		}
		
		// The enemy attributes; health point and attack power
		for (int i = numberOfEnemies + 3; i < numberOfEnemies * 3 + 2; i+=2){
			String whichEnemy = getNthWord((fileLines.get(i)), 1);
			int enemyHp = Integer.parseInt(getNthWord((fileLines.get(i)), 3));
			int enemyAttackPower = Integer.parseInt(getNthWord((fileLines.get(i+1)), 4));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemy.setHp(enemyHp);
					enemy.setAttackPower(enemyAttackPower);
				}
			}
		}
		
		// TreeMap is used for positions and related enemy object to refer
		TreeMap <Integer, Enemy> enemiesOnTheMap = new TreeMap<Integer, Enemy>();
		
		for (int i = numberOfEnemies * 3 + 3; i < fileLines.size(); i++){
			String whichEnemy = getNthWord((fileLines.get(i)), 4);
			int positionOfEnemy = Integer.parseInt(getNthWord((fileLines.get(i)), 7));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemiesOnTheMap.put(positionOfEnemy, enemy);
				}
			}
		}
		
		// Final result for path of Hero
		ArrayList<String> wholeStory = Hero.killEmAll(karacaOglan, enemiesOnTheMap);
		
		// Writing story to file
		IOUtils.writeFile(wholeStory, args[1]);
		
		// Whole story might be seen in the command prompt.
		System.out.println(wholeStory);
		
	}
	
	/**
	 * Allows program to get nth word in a string.
	 * @param str whole sentence
	 * @param n the order of word which program is looking for
	 * @return the string of nth word or null for out of bound
	 */
	public static String getNthWord(String str, int n) {
		
		String[] tmp = str.split(" ");
		if(n-1 < tmp.length) return tmp[n - 1];
		return null;
	}
}