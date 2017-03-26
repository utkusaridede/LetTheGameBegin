package letTheGameBegin;

import java.util.Map;
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
		IOThingies.readFile(args.length, args, fileLines);
		
		// Our main hero, Karacaoglan
		Hero karacaOglan = new Hero();
		
		// The way Karacaoglan should pass, the health point and attack power.
		int wayToGo = Integer.parseInt(IOThingies.getTheWord((fileLines.get(0)), 3));
		karacaOglan.setWayToGo(wayToGo);
		
		int hp = Integer.parseInt(IOThingies.getTheWord((fileLines.get(1)), 3));
		karacaOglan.setHp(hp);
		
		int attPow = Integer.parseInt(IOThingies.getTheWord((fileLines.get(2)), 4));
		karacaOglan.setAttPow(attPow);
		
		// Enemy types with name attribute and number of unique enemies
		ArrayList<Enemy> uniqueEnemies = new ArrayList<Enemy>();
		int numberOfEnemies = 0;
		for (String line : fileLines){
			
			if (line.indexOf("Enemy") != -1){
				numberOfEnemies++;
				String name = IOThingies.getTheWord(line, 1);
				uniqueEnemies.add(new Enemy(name));
			}
		}
		
		// The enemy attributes; health point and attack power
		for (int i = numberOfEnemies + 3; i < numberOfEnemies * 3 + 2; i+=2){
			String whichEnemy = IOThingies.getTheWord((fileLines.get(i)), 1);
			int enemyHp = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i)), 3));
			int enemyAttPow = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i+1)), 4));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemy.setHp(enemyHp);
					enemy.setAttPow(enemyAttPow);
				}
			}
		}
		
		// TreeMap is used for positions and related enemy object to refer
		TreeMap <Integer, Enemy> enemiesOnTheMap = new TreeMap<Integer, Enemy>();
		
		for (int i = numberOfEnemies * 3 + 3; i < fileLines.size(); i++){
			String whichEnemy = IOThingies.getTheWord((fileLines.get(i)), 4);
			int possionOfEnemy = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i)), 7));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemiesOnTheMap.put(possionOfEnemy, enemy);
				}
			}
		}
		
		// Final result for path of Hero
		ArrayList<String> wholeStory = killEmAll(karacaOglan, enemiesOnTheMap);
		
		// Writing story to file
		IOThingies.writeFile(wholeStory, args[1]);
		
		// Whole story might be seen in the command prompt.
		//System.out.println(wholeStory);
		
	}
	
	/**
	 * If the war is close enough, our hero will face with his destiny.
	 * @param kog hero object
	 * @param roadMap treeMap for road of hero
	 * @return arrayList which includes all actions of hero
	 */
	public static ArrayList<String> killEmAll(Hero kog, TreeMap <Integer, Enemy> roadMap) {
		
		// Final output string arrayList
		ArrayList<String> output = new ArrayList<String>();
		output.add("Hero started journey with " + kog.getHp() + "HP!");
		
		// All attributes of hero
		int heroHp = kog.getHp();
		int heroAtt = kog.getAttPow();
		
		// Running towards enemies on the map
		for(Map.Entry<Integer, Enemy> road :roadMap.entrySet()){
			
			Integer position = road.getKey();
			Enemy enemy = (Enemy)road.getValue();
			
			// All attributes of enemies
			int enemyHp = enemy.getHp();
			int enemyAtt = enemy.getAttPow();
			
			// When hero come across with enemy
			while (heroHp > 0 && enemyHp > 0) {
				heroHp -= enemyAtt;
				enemyHp -= heroAtt;
			}
			
			// Set the injured health point value of hero
			kog.setHp(heroHp);
			
			// Checks whether hero is alive or not
			if (heroHp <= 0) {
				output.add(enemy.name + " defeated Hero with " + enemyHp + " HP remaining.");
				output.add("Hero is Dead!! Last seen at position "+ position.intValue());
				break;
			} else {
				output.add("Hero defeated " + enemy.name + " with " + heroHp + " HP remaining.");
			}
		}
		// Checks whether hero is survived or not.
		if(kog.getHp() > 0) output.add("Hero Survived.");
		return output;
	}
}