/**
 * Rodas T. Gebreslassie
 * 
 * CSC 143
 * 
 * BookCatalogClient2.java
 * 
 * 6/10/2018
 * 
 * This program is a client program that have a menu driven interface 
 * that allow users to search, add and remove book from the catalog.
 * Books from the text file booklist.txt are added to the catalog when
 * the program starts to run.
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class BookCatalogClient2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("booklist.txt"));
		
		BookCatalog library = new BookCatalog();
		System.out.println("      Welcome to the Book Catalog");
		
		while(input.hasNextLine() != false){
			String line = input.nextLine();
			String[] lineString = line.split("\t");
			try{
				Book temp = new Book(lineString[1], lineString[2],lineString[3], Integer.parseInt(lineString[4]), Double.parseDouble(lineString[5]), lineString[0]);
				library.add(temp);
			}catch(IllegalArgumentException e){
			}
			
		}
		
		boolean exit = false;
		while(exit != true){
			printMenu();
			String selection = getInput();
			exit = processSelection(selection,library);
			
		}
		

	}
	
	//printMenu() Print the first menu
	public static void printMenu(){
		System.out.println();
		System.out.println("Select one of the following:");
		System.out.printf("%45s", "S to search books form the book catalog \n");
		System.out.printf("%33s", "A to add book to the catalog\n");
		System.out.printf("%41s", "R to remove book from a book catalog\n");
		System.out.printf("%14s", "Q to quit\n");
		
		System.out.print("Selection: ");
	}
	
	//removeMenu() print the remove menu when the user wants to remove
	//a book.
	public static void removeMenu(){
		System.out.println("Remove book form the catalog using (select one of the following)");
		
		System.out.println("    I - using ISBN code");
		System.out.println("    T - using title");
		System.out.println("    x - to o back");
		
	}
	
	//addMenu() menu displayed when the user want to add a book.
	public static void addMenu(){
		System.out.println();
		System.out.println("Add Book : complete the following fields in the form (tab separated)");
		
		System.out.println("(FirstName \t LastName \t Title \t year \t price \t code) : ");
		System.out.println("     x - to go back");
		
	}
	
	//invalid() is the method that is called when the user 
	//select selection that is not listed in the menu.
	public static void invalid(){
		System.out.println();
		System.out.println("Invalid entry");
		System.out.println();
	}
	
	//This method will accept BookCatalog object library and 
	//String input selection from the user. Then it will process the selection
	//and call other methods based on the user selection.
	public static boolean processSelection(String selection, BookCatalog library) throws FileNotFoundException{
		
		switch(selection){
		
		case "s":
			searchBook(library);
			break;
			
		case "a":
			addBook(library);
			break;
			
		case "r":
			removeBook(library);
			break;
			
		case "q":
			saveBook(library);
			return true;
			
			
		default:
			invalid();
			
			
		
		}
		return false;
	}
	
	//This method accept a string input form the user.
	public static String getInput(){
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		return input;
	}
	
	//The method searchBook() accept a bookCatalog object library
	//and run a for loop which will call for the methods
	//searchMenu() to display the menu for the search items
	//and processSearchMenu() to process the user selection.
	
	public static void searchBook(BookCatalog library){
		boolean goBack = false;
		while(goBack != true){
			searchMenu();
			String input = getInput();
			goBack = processSearchMenu(input, library);
			
			
		}
		
	
	}
	//searchMenu() - display the menu 
	public static void searchMenu(){
		System.out.println();
		System.out.println("Search book using (select one of the following): ");
		System.out.println("   F - Author first name");
		System.out.println("   L - Author last name");
		System.out.println("   I - ISBN code");
		System.out.println("   T - Title");
		System.out.println("   X - To go to the previous page");
		System.out.println();
		System.out.print("Selection :");
	}
	
	//The method processSearchSelection() accept user input and BookCatalog
	//object library then call on another methods based on the user selection.
	//The user can search for books using firstName, lastName, Title and ISBN.
	
	public static boolean processSearchMenu(String input, BookCatalog library){
		String selection;
		if(input.equalsIgnoreCase("f")){
			selection = "first Name";
			searchBookByInput(library, selection);

		}
		
		else if(input.equalsIgnoreCase("l")){
			selection = "last name";
			searchBookByInput(library, selection);
		}
		
		else if(input.equalsIgnoreCase("i")){
			selection = "ISBN";
			searchBookByInput(library, selection);
		}
		
		else if(input.equalsIgnoreCase("t")){
			selection = "title";
			searchBookByInput(library, selection);
		}
		
		else if(input.equalsIgnoreCase("x")){
			return true;
		}
		else{
			System.out.println();
			System.out.println("Invalid entry");
			System.out.println();
		}
		return false;
	}
	//This method will search for a book using the user input.
	public static boolean searchBookByInput(BookCatalog library, String selection){
		System.out.println();
		System.out.print("Search Book:" + " " + selection + "(press x to go back):");
		String input = getInput();
		
		if(input.equalsIgnoreCase("x")){
			return true;
		}
		else if(library.findBook(input) != null){
			System.out.println("    Search Result :");
			processSearchInput(library, selection, input);
			System.out.println();
			searchBookByInput(library, selection );
		}
		
		else{
			System.out.println("No book found with the given information.");
			searchBookByInput(library, selection );
		}
		return false;
		
		
	}
	//The method processSearchInput() will check with what (first,last,code or title)
	//the user want to search for a book then call another method based on the selection.
	public static void processSearchInput(BookCatalog library,String selection, String input){
		if(selection.equalsIgnoreCase("first name")){
			System.out.println(library.findBookFirstName(input));
			
		}
		
		else if(selection.equalsIgnoreCase("last name")){
			System.out.println(library.findBookLastName(input));
			
		}
		
		else if(selection.equalsIgnoreCase("title")){
			System.out.println(library.findBookTitle(input));
		}
		else if(selection.equalsIgnoreCase("isbn")){
			System.out.println(library.findBookCode(input));
		}
		else{
			System.out.println("No book found with the given information.");
		}
		
		
	}
	
	
	//The method addBook() will add book to the BookCatalog by using an array to 
	//create a book object once the user enter information separated by tab.
	public static boolean addBook(BookCatalog library){
		addMenu();
		
		String input = getInput();
		
		if(input.equalsIgnoreCase("x")){
			return true;
		}
		else{
			String[] array = new String[6];
			array = input.split("\t");
			int year = Integer.parseInt(array[3]);
			int price = Integer.parseInt(array[4]);
			try{
				Book b = new Book(array[0], array[1], array[2], year, price, array[5]);
				
				if(library.containsISBN(b) != true){
					System.out.println();
					System.out.println("Your Book is added to the Book Catalog as:");
					System.out.println();
					System.out.println(b);
					library.add(b);
				}
				else{
					System.out.println(); 
					System.out.println("Book ISBN code already exist in the catalog.");
				}
				
			}catch(IllegalArgumentException e){
				System.out.println(e);
			}
			
			addBook(library);
			
		}
		return false;
		
	}
	
	//The method removeBook() accept a BookCatlog object library and call the method
	//removeSelection() once the user specify with what they want to remove a book (ISBN code
	// or title)
	public static void removeBook(BookCatalog library){
		
		boolean goBack = false;
		while(goBack != true){
			removeMenu();
			String input = getInput();
			goBack = removeSelection(input,library);
		}
		
		
	} 
	//The method removeSelection() accept user input and 
	//BookCatlog object library then call another method based on the user selection.
	public static boolean removeSelection(String input, BookCatalog library){
		if(input.equalsIgnoreCase("i")){
			removeByISBN(library);
		}
		
		else if(input.equalsIgnoreCase("t")){
			removeByTitle(library);
		}
		
		else if(input.equalsIgnoreCase("x")){
			return true;
		}
		else{
			invalid();
		}
		return false;
		
		
	}
	//This method remove a book from the BookCatalog once the user enter the ISBN code of
	//a book.
	public static boolean removeByISBN(BookCatalog library){
		System.out.println();
		System.out.print("Remove Book : ISBN code (x to go back): ");
		String input = getInput();
		if(input.equalsIgnoreCase("x")){
			System.out.println();
			return true;
		}
		else if(library.findBookCode(input) != null){
			library.remove(library.findBookCode(input));
			System.out.println("Book successfuly removed");
			removeByISBN(library);
			
		}
		else{
			System.out.println("No book found in the catalog with the given code.");
			
			removeByISBN(library);
		}
		return false;
	}
	
	//This method remove book from the BookCatalog once the user enter the title of the book.
	public static boolean removeByTitle(BookCatalog library){
		System.out.println();
		System.out.print("Remove Book : Title (Press x to go back): ");
		String input = getInput();
		if(input.equalsIgnoreCase("x")){
			System.out.println();
			return true;
		}
		else if(library.findBookTitle(input) != null){
			library.remove(library.findBookTitle(input));
			System.out.println("Book successfuly removed");
			removeByTitle(library);
		}
		else{
			System.out.println("No book found in the catalog with the given title.");
			
			removeByTitle(library);
		}
		return false;
	}
	
	
	//The method saveBook() is called when the user wants to quit the program
	//this method asks a user if they want to save a book catalog once they add or remove
	//books from the catalog. If the user wants to save a book, books will be saved
	//to the text file booklist.txt
	public static void saveBook(BookCatalog library) throws FileNotFoundException{
		System.out.println();
		System.out.println("Do you want to save the book catalog to a text file? (yes or no)");
		
		String input = getInput();
		input = input.toLowerCase();
		
		if(input.charAt(0) == 'y'){
			int i = 0;
			while(i < library.size()){
				Book b = library.get(i);
				String book = b.getCode() + "\t" + b.getFirstName() + "\t" + 
						b.getLastName() + "\t" + b.getTitle() + "\t" +
						b.getYear() + "\t" + b.getPrice() + "\n"; 
				
				File f = new File("booklist.txt");
				PrintStream p = new PrintStream(new FileOutputStream(f, true));
				p.print(book);
				
				i++;
						
			}
			
			System.out.println("books saved to the text file booklist.txt");
			System.out.println("Thank you for using this program.");
			
		}
		else{
			System.out.println("Thank you for using this program.");
		}
		
	}
	
	
	
	

}
