package letTheGameBegin;

/**
* <h1>LivingCreatures Abstract Class</h1>
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
	
	protected int hp;
	protected int attackPower;
	
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
	public void setHp(int hp) {}

	/**
	 * Allows program to reach private attackPower instance variable
	 * @return the attackPower
	 */
	public int getAttackPower() {
		
		return attackPower;
	}

	/**
	 * Allows program to set private attackPower instance variable
	 * @param attackPower the attackPower to set
	 */
	public void setAttackPower(int attackPower) {}
	
}