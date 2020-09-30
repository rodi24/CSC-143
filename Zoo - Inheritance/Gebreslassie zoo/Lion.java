/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Lion.java
 * 
 *This class is a subclass for the abstract class Animal.
 *
 */
public class Lion extends Animal{

	public Lion() {
		super();
	}

	@Override
	void talk() {
		System.out.println("Roar!");
		
	}
	/**
	 * will call the timePass() method of the superclass which increase hunger by 1.
	 */
	public void timePasses(){
		super.timePasses();
		if(super.getHunger() >= 3){
			System.out.println("The Lion paces hungrily.");
			
		}
		
	}
	
	public String toString(){
		return "Lion";
	}
	
	

}
