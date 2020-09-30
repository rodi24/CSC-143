/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Animal.java
 * 
 * This class is an abstract class of Animals.
 *
 */
public abstract class Animal {
	
	private int hunger;
	
	public Animal(){
		hunger = 0;
	}

	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Abstract method talk()
	 */
	abstract void talk();
	
	/**
	 * The method timePasses will increase hunger by 1.
	 */
	public void timePasses(){
		hunger = hunger + 1;
	}
	
	/**
	 * The method feed() will set hunger to zero.
	 */
	public void feed(){
		hunger = 0;
	}
	
	public String toString(){
		return "Animal";
	}
	
	
	
	

	

}
