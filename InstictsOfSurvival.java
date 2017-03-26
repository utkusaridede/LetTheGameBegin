package letTheGameBegin;

import java.io.IOException;
import java.util.ArrayList;

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
		
		ArrayList<Enemy> enemiesOnTheMap = new ArrayList<Enemy>();
		
		for (int i = numberOfEnemies * 3 + 3; i < fileLines.size(); i++){
			String whichEnemy = IOThingies.getTheWord((fileLines.get(i)), 4);
			int possionOfEnemy = Integer.parseInt(IOThingies.getTheWord((fileLines.get(i)), 7));
			for (Enemy enemy : uniqueEnemies){
				if (enemy.name.equals(whichEnemy)){
					enemy.setPosition(possionOfEnemy);
					enemiesOnTheMap.add(enemy);
				}
			}
		}
		
		System.out.println(enemiesOnTheMap.get(5).getPosition());
		System.out.println(numberOfEnemies);
		
	}
}