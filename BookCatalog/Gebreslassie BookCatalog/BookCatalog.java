/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 6/12/2018
 * 
 * CSC 143
 * 
 * BookCatalog.java
 * 
 * This class create a BookCatalog object.
 *
 */
public class BookCatalog {
	private BookListNode front;
	int size;
	
	// post: constructs an empty BookCatalog
	public BookCatalog(){
		front = null;
		size = 0;
	}
	
	// post: returns the number of elements in the BookCatalog
	public int size(){
		return size;
	}
	
	// post: creates a comma-separated, bracketed version of the list of Books
	public String toString(){
		if(front == null){
			return "[]";
		}
		else{
			String result = "[" + front.book;
			BookListNode current = front.next;
			while(current != null){
				result = result + ", " + current.book;
				current = current.next;
			}
			
			result = result + "]";
			
			return result;
			
		}
	}
	
	// pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
	public BookListNode nodeAt(int index){
		BookListNode current = front;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		
		return current;
		
		
	}
	
	// pre : 0 <= index < size()
    // post: returns the Book at the given index in the list
	public Book get(int index){
		return nodeAt(index).book;
	}
	
	public void add(Book book){
		if(front == null){
			front = new BookListNode(book);
			
			size = size + 1;
		}
		else{
			BookListNode current = front;
			
			while(current.next != null){
				current = current.next;
			}
			
			current.next = new BookListNode(book);
			
			size = size + 1;
		}
	}
	
	// post : returns the position of the first occurrence of the given
    //        Book (-1 if not found)
	private int indexOf(Book book){
		int index = 0;
		BookListNode current = front;
		
		while(current != null){
			if(current.book == book){
				return index;
				
			}
			index++;
			current = current.next;
		}
		
		return -1;
	}
	//Post: returns True if the Book newBook is in the Catalog.
	public boolean contains(Book newBook){
		BookListNode current = front;
		
		while(current != null){
			if(current.book.equalss(newBook) == true){
				return true;
			}
			current = current.next;
			
		}
		
		return false;
	}
	
	//Post: returns true if a given Book has the same ISBN to other book in the catalog
	public boolean containsISBN(Book newBook){
		BookListNode current = front;
		
		while(current != null){
			if(current.book.getCode().equals(newBook.getCode())){
				return true;
			}
			current = current.next;
			
		}
		
		return false;
		
	}
	
	// pre : 0 <= index < size()
    // post: removes Book from the catalog.
	public void remove(Book book){
		if(front.book == book){
			front = front.next;
			size--;
		}
		else{
			int index = indexOf(book);
			BookListNode current = front;
			for(int i = 0; i < index - 1; i++){
				current = current.next;
			}
			
			current.next = current.next.next;
			size--;
		}
	}
	//Post: search for a book in the catalog by firstName
	//      and return the Book
	public Book findBookFirstName(String firstName){
		BookListNode current = front;
		
		while(current != null){
			
			if(current.book.getFirstName().equalsIgnoreCase(firstName)){
				return current.book;
			}
			
			current = current.next;
		}
		
		return null;
	}
	
	//Post: search for a book in the catalog by title
	//      and return the book
	public Book findBookTitle(String title){
		BookListNode current = front;
		
		while(current != null){
			
			if(current.book.getTitle().equalsIgnoreCase(title)){
				return current.book;
			}
			
			current = current.next;
		}
		
		return null;
	}
	
	//Post: search for a book in the catalog by lastName
	//      and return the book
	public Book findBookLastName(String lastName){
		BookListNode current = front;
		
		while(current != null){
			
			if(current.book.getLastName().equalsIgnoreCase(lastName)){
				return current.book;
			}
			
			current = current.next;
		}
		
		return null;
	
	}
	
	//Post: search for book in the catalog by ISBN code
	//      and return the book
	public Book findBookCode(String code){
		BookListNode current = front;
		
		while(current != null){
			
			if(current.book.getCode().equals(code)){
				return current.book;
			}
			
			current = current.next;
		}
		
		return null;
		
	}
	
	//Post: search for book by first name, last name
	//      title and ISBN code and return the book
	public Book findBook(String StringValue){
		if(findBookFirstName(StringValue) != null){
			return findBookFirstName(StringValue);
			
		}
		else if(findBookLastName(StringValue) != null){
			return findBookLastName(StringValue);
			
		}
		else if (findBookCode(StringValue) != null){
			return findBookCode(StringValue);
		}
		
		else if (findBookTitle(StringValue) != null){
			return findBookTitle(StringValue);
			
		}
		
		return null;
			
	}
	

}
