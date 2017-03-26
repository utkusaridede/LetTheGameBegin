package letTheGameBegin;

/**
* <h1>Enemy Class</h1>
* Non-abstract class extends from LivingCreature
*
* @author  Utku Saridede
* @version 1.0
* @since   2017-03-26
*/
public class Enemy extends LivingCreature {
	
	String name;
	
	/**
	 * Constructor of Enemy Class to set 
	 * name instance variable
	 * @param enemyName name of the enemy
	 */
	public Enemy(String enemyName) {
		
		this.name = enemyName;
	}
	
	/*
	 * Protecting hp to have negative value.
	 * Default: 100 for Enemy
	public void setHp(int hp){
		if (hp > 0) {
			this.hp = hp;
		} else {
			this.hp = 100;
		}
	}
	
	 * Protecting attPow to have negative value.
	 * Default: 8 for Enemy
	public void setHp(int attPow){
		if (attPow > 0) {
			this.attPow = attPow;
		} else {
			this.attPow = 8;
		}
	}
	*/
}
