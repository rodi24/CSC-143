/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Publication.java
 * 
 * This class is an abstract superclass with fields publisher, number of pages
 * , price and title.
 * 
 * 
 *
 */
public abstract class Publication {
	private String publisher;
	private int numberOfPages;
	private int price;
	private String title;
	/**
	 * @param publisher
	 * @param numberOfPages
	 * @param price
	 * @param title
	 */
	public Publication(String publisher, int numberOfPages, int price, String title) {
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.title = title;
	}
	/**
	 * @return The publisher of the publication.
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher - This method will set publisher.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}
	/**
	 * @param numberOfPages - set the numberOfPages.
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price - set the price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title - set the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Title = " + title + ", Publisher = " + publisher + ", Number Of Pages = " + numberOfPages + ", Price = $" + price
				;
	}
	
	
	
	

}
