package letTheGameBegin;

/**
* <h1>Living Creatures Abstract Class</h1>
* The abstract class for all living creatures.
* <p>
* <b>Note:</b> It allows program to not create a LivingCreature
* object itself but inherited subclasses.
*
* @author  Utku Saridede
* @version 1.0
* @since   2017-03-26
*/
public abstract class LivingCreature {
	
	private int hp;
	private int attPow;
	
	/*
	 * In the case of override of setting methods
	 * as shown in the subclasses.
	protected int hp;
	protected int attPow;
	*/
	
	/**
	 * Allows program to reach private hp instance variable
	 * @return the hp
	 */
	public int getHp() {
		
		return hp;
	}
	
	/**
	 * Allows program to set private hp instance variable
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		
		this.hp = hp;
	}

	/**
	 * Allows program to reach private attPow instance variable
	 * @return the attPow
	 */
	public int getAttPow() {
		
		return attPow;
	}

	/**
	 * Allows program to set private attPow instance variable
	 * @param attPow the attPow to set
	 */
	public void setAttPow(int attPow) {
		
		this.attPow = attPow;
	}
	
}