/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 *6/12/2018
 *
 *CSC 143
 *
 *BookListNode.java
 *
 */
public class BookListNode {
	public Book book;
	public BookListNode next;
	
	public BookListNode(){
		this(null,null);
	}
	
	public BookListNode(Book book){
		this(book, null);
		
	}
	
	public BookListNode(Book book, BookListNode next){
		this.book = book;
		this.next = next;
	}
	

}
