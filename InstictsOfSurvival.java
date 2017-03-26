package letTheGameBegin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class InstictsOfSurvival {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> fileLines = new ArrayList<String>();

		IOThingies.readFile(args.length, args, fileLines);
		
		//System.out.println(fileLines);
		
		Hero karacaOglan = new Hero();
		
		int wayToGo = Integer.parseInt(IOThingies.getTheWord((fileLines.get(0)), 3));
		karacaOglan.setWayToGo(wayToGo);
		
		int hp = Integer.parseInt(IOThingies.getTheWord((fileLines.get(1)), 3));
		karacaOglan.setHp(hp);
		
		int attPow = Integer.parseInt(IOThingies.getTheWord((fileLines.get(2)), 4));
		karacaOglan.setAttPow(attPow);
		
		ArrayList<Enemy> uniqueEnemies = new ArrayList<Enemy>();
		int numberOfEnemies = 0;
		for (String line : fileLines){
			
			if (line.indexOf("Enemy") != -1){
				numberOfEnemies++;
				String name = IOThingies.getTheWord(line, 1);
				uniqueEnemies.add(new Enemy(name));
			}
		}
		
		int counter = 0;
		for (int i = numberOfEnemies + 3; i < numberOfEnemies * 3 + 2; i+=2){
			
			int enemyHp = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i)), 3));
			uniqueEnemies.get(counter).setHp(enemyHp);
			int enemyAttPow = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i+1)), 4));
			uniqueEnemies.get(counter).setAttPow(enemyAttPow);
			counter++;
		}
		
		TreeMap <Integer, Enemy> enemiesOnTheMap = new TreeMap<Integer, Enemy>();
		
		for (int i = numberOfEnemies * 3 + 3; i < fileLines.size(); i++){
			String whichEnemy = IOThingies.getTheWord((fileLines.get(i)), 4);
			int possionOfEnemy = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i)), 7));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemiesOnTheMap.put(possionOfEnemy, enemy);
					System.out.println(enemiesOnTheMap.keySet());
				}
			}
		}
		
		for(Map.Entry<Integer, Enemy> entry : enemiesOnTheMap.entrySet()) {
			  Integer key = entry.getKey();
			  Enemy value = entry.getValue();

			  System.out.println(key + " => " + value);
		}
		
		ArrayList<String> wholeStory = killEmAll(karacaOglan, enemiesOnTheMap);
		
		System.out.println(wholeStory);
		
	}
	public static ArrayList<String> killEmAll(Hero kog, TreeMap <Integer, Enemy> roadMap) {
		
		ArrayList<String> output = new ArrayList<String>();
		output.add("Hero started journey with " + kog.getHp() + "HP!");
		
		for(Map.Entry<Integer, Enemy> road :roadMap.entrySet()){
			
			Integer position = road.getKey();
			Enemy enemy = (Enemy)road.getValue();
			
			int heroHp = kog.getHp();
			int heroAtt = kog.getAttPow();
			int enemyHp = enemy.getHp();
			int enemyAtt = enemy.getAttPow();
			
			while (heroHp > 0 && enemyHp > 0) {
				heroHp -= enemyAtt;
				enemyHp -= heroAtt;
			}
			
			kog.setHp(heroHp);
			
			if (heroHp <= 0) {
				output.add(enemy.name + "defeated Hero with " + enemyHp + " HP remaining.");
				output.add("Hero is Dead!! Last seen at position "+ position.intValue());
				break;
			} else {
				output.add("Hero defeated " + enemy.name + " with " + heroHp + " HP remaining.");
			}
		}
		output.add("Hero Survived.");
		return output;
	}
}