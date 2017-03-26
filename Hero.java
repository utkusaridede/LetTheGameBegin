package letTheGameBegin;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
* <h1>Hero Class</h1>
* Non-abstract class extends from LivingCreature
*
* @author  Utku Saridede
* @version 1.0
* @since   2017-03-26
*/
public class Hero extends LivingCreature {
	
	private int wayToGo;

	/**
	 * Allows program to reach private wayToGo instance variable
	 * @return the wayToGo
	 */
	public int getWayToGo() {
		
		return wayToGo;
	}

	/**
	 * Allows program to set private wayToGo instance variable
	 * @param wayToGo the wayToGo to set
	 */
	public void setWayToGo(int wayToGo) {
		
		this.wayToGo = wayToGo;
	}
	
	/*
	 * Protecting hp to have negative value.
	 * Default: 1000 for Hero
	 */
	@Override
	public void setHp(int hp){
		if (hp > 0) {
			this.hp = hp;
		} else {
			this.hp = 1000;
		}
	}
	
	/*
	 * Protecting attackPower to have negative value.
	 * Default: 10 for Hero
	 */
	@Override
	public void setAttackPower(int attackPower){
		if (attackPower > 0) {
			this.attackPower = attackPower;
		} else {
			this.attackPower = 10;
		}
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
		output.add("Hero started journey with " + kog.getHp() + " HP!");
		
		// All attributes of hero
		int heroHp = kog.getHp();
		int heroAtt = kog.getAttackPower();
		int heroHpTemp = 0;
		
		// Running towards enemies on the map
		for(Map.Entry<Integer, Enemy> road :roadMap.entrySet()){
			
			Integer position = road.getKey();
			Enemy enemy = (Enemy)road.getValue();
			
			// All attributes of enemies
			int enemyHp = enemy.getHp();
			int enemyAtt = enemy.getAttackPower();
			
			// When hero come across with enemy
			while (heroHp > 0 && enemyHp > 0) {
				heroHp -= enemyAtt;
				enemyHp -= heroAtt;
			}
			
			// Set the injured health point value of hero
			kog.setHp(heroHp);
			heroHpTemp = heroHp;
			
			// Checks whether hero is alive or not
			if (heroHp <= 0) {
				output.add(enemy.name + " defeated Hero with " + enemyHp + " HP remaining.");
				output.add("Hero is Dead!! Last seen at position "+ position.intValue() + "!!");
				break;
			} else {
				output.add("Hero defeated " + enemy.name + " with " + heroHp + " HP remaining.");
			}
		}
		// Checks whether hero is survived or not.
		if(heroHpTemp > 0) output.add("Hero Survived!");
		return output;
	}
}
