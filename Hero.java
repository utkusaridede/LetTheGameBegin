package letTheGameBegin;

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
	public void setHp(int hp){
		if (hp > 0) {
			this.hp = hp;
		} else {
			this.hp = 1000
		}
	}
	
	 * Protecting attPow to have negative value.
	 * Default: 10 for Hero
	public void setHp(int attPow){
		if (attPow > 0) {
			this.attPow = attPow;
		} else {
			this.attPow = 10;
		}
	}
	*/
}
