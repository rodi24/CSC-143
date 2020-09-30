/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Zebra.java
 * 
 * The class Zebra is a subclass for the class Animal.
 *
 */
public class Zebra extends Animal {

	
	public Zebra() {
		super();
	}

	void talk() {
		System.out.println("The Zebra quietly chews.");
	}
	
	
	public String toString(){
		return "Zebra";
	}
	

}
