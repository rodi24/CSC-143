/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * CSC 143
 * 
 * 4/19/18
 * 
 * Book.java
 * 
 * This class is a subclass of Publication with added field author.
 *
 */
public class Book extends Publication {
	
	private String author;
	/**
	 * 
	 * @param author
	 * @param publisher
	 * @param numberOfPages
	 * @param price
	 * @param title
	 */

	public Book(String author, String publisher, int numberOfPages, int price, String title) {
		super(publisher, numberOfPages, price, title);
		
		this.author = author;
		
	}
	
	public String toString(){
		return "Book : Author = " + author +", " + super.toString();
	}
	
	

}
