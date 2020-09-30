/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * KidsMagazine.Java
 * 
 * This class is a subclass of Magazine with added field age range.
 *
 */
public class KidsMagazine extends Magazine {
	
	private int ageRange;
	/**
	 * 
	 * @param title
	 * @param publisher
	 * @param numberOfPages
	 * @param price
	 * @param unit
	 * @param ageRange
	 */
	
	public KidsMagazine(String title, String publisher, int numberOfPages, int price, String unit, int ageRange) {
		super(title, publisher, numberOfPages, price, unit);
		this.ageRange = ageRange;
		
	}
	
	
	public KidsMagazine(String title, String publisher, int numberOfPages, int price, String unit) {
		super(title, publisher, numberOfPages, price, unit);
		ageRange = 10;
		
	}
	
	public String toString(){
		return "Kids " + super.toString() + ", Age range = " + ageRange +"+";
	}
	
	

	
	
	

	
	

}
