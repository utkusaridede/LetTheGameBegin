/**
 * 
 */
package letTheGameBegin;

/**
 * @author utku
 *
 */
public abstract class LivingCreature {
	
	private int hp;
	private int attPow;
	
	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}
	
	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the attPow
	 */
	public int getAttPow() {
		return attPow;
	}

	/**
	 * @param attPow the attPow to set
	 */
	public void setAttPow(int attPow) {
		this.attPow = attPow;
	}
	
}