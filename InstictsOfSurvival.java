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
		
		ArrayList<String> wholeStory = killEmAll(karacaOglan, enemiesOnTheMap);
		
		IOThingies.writeFile(wholeStory, args[1]);
		
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
			
			System.out.println(enemy.name + ": " + enemy.getHp() + ", " + enemy.getAttPow());
			
			while (heroHp > 0 && enemyHp > 0) {
				heroHp -= enemyAtt;
				//System.out.println(heroHp);
				enemyHp -= heroAtt;
			}
			
			kog.setHp(heroHp);
			
			if (heroHp <= 0) {
				output.add(enemy.name + " defeated Hero with " + enemyHp + " HP remaining.");
				output.add("Hero is Dead!! Last seen at position "+ position.intValue());
				break;
			} else {
				output.add("Hero defeated " + enemy.name + " with " + heroHp + " HP remaining.");
			}
		}
		if(kog.getHp() > 0) output.add("Hero Survived.");
		return output;
	}
}