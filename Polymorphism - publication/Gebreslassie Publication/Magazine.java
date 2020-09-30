/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Magazine.java
 * 
 * This class is a subclass of Publication with added field unit.
 *
 */
public class Magazine extends Publication {
	
	private String unit;
	/**
	 * 
	 * @param title
	 * @param publisher
	 * @param numberOfPages
	 * @param price
	 * @param unit
	 */

	public Magazine(String title, String publisher, int numberOfPages, int price, String unit) {
		super(publisher, numberOfPages, price, title);
		this.unit = unit;
	}
	
	public String toString(){
		return "Magazine : " + super.toString() + ", Unit = " + unit;
	}

}
