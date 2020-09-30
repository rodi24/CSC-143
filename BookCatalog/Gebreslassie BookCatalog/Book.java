/**
 * Rodas T. Gebreslassie
 * 
 * CSC 143
 * 
 * 6/12/2018
 * 
 * book.java
 * 
 * The class Book.java will create a book object.
 */

import java.math.BigInteger;

public class Book {
	private String firstName;
	private String lastName;
	private String title;
	private int year;
	private double price;
	private String code;
	/**
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param year
	 * @param price
	 * @param code
	 */
	public Book(String firstName, String lastName, String title, int year, double price, String code) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.year = year;
		this.price = price;
		this.code = code;
		
		if(checkISBN() == true){
			throw new IllegalArgumentException("Invalid ISBN code");
		}
		
		 if(price < 0){
			throw new IllegalArgumentException("price = " + price);
		}
		
		if(year >= 2019){
			throw new IllegalArgumentException("year = " + year);
		}  
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "firstName = " + firstName + ", lastName = " + lastName + ", title = " + title + ", year = " + year
				+ ", price = " + price + ", code = " + code ;
	}
	
	/**
	 * 
	 * @param newBook  - will check if two books are equal 
	 * @return a boolean
	 */
	public boolean equalss(Book newBook){
		return firstName.equals(newBook.getFirstName()) && lastName.equals(newBook.getLastName()) &&
				title.equals(newBook.getTitle()) && year == newBook.getYear() && price == newBook.getPrice() &&
				code.equals(newBook.getCode());
	}
	
	/**
	 * 
	 * @return false if the ISBN code is valid and true if the ISBN code is invalid.
	 */
	public boolean checkISBN(){
		int dashNumber = 0;
		boolean error = false;
		String input = code;
		
		
		while(error == false) {                               
			dashNumber = countDash(input);
			error = compareDashes(dashNumber);
			if(error == false) {
				error = tooCloseDashes(input);
			}
			if(error == false) {
				error = sequentialDashes(input);
				//error = tooCloseDashes(input);
				if(error == false) {
					error = evsb(input);      
				}
			}
			
			String modifiedInput = replaceDash(input);
			int numberOfDigits = modifiedInput.length();
			if(error == false) {
				error = countDigits(modifiedInput);
			}
			String input0 = checkX(modifiedInput);
			
			if(numberOfDigits == 10 && error == false) {
				
				error = baddigit(modifiedInput);
				
			}
			if(numberOfDigits == 10 && error == false) {
				error = checksum(modifiedInput, input0, numberOfDigits);
			}
				
			if(error == false) {
				return false;
			}
			
		}
		
		return true;
	}
	
	
	/**
	 * method the return the number of dash for checkISBN method.
	 */
	private int countDash(String input) {
		char dash = '-';
		int dashNum = 0;
		
		for(int i = 0; i < input.length(); i++) {                
			if(input.charAt(i) == dash) {                         
				dashNum = dashNum + 1;
				
			}
			
		}
		return dashNum;
	}
	/**
	 *  method for the checkISBN method.
	 * 
	 */
	private boolean compareDashes(int dashNum) {                 
		boolean error = false;                                 
		if(dashNum == 0 || dashNum == 3) {                 
			error = false;
		}else if(dashNum < 3) {
			error = true;
		}else if(dashNum > 3) {
			error = true;
		}
		
		return error;
	}
	
	/**
	 * 
	 * Method for the checkISBN method.
	 * 
	 */
	private boolean sequentialDashes(String input) {
		boolean error = false;
		char dash = '-';
		for(int i = 0; i < input.length() - 1; i++) {
			if(input.charAt(i) == dash && input.charAt(i + 1) == dash) {
				
				error = true;
			}
		}
		
		return error;
	}
	/*
	 * Method for the checkISBN method.
	 */
	private boolean tooCloseDashes(String input) {
		boolean error = false;
	
		for(int i = 0; i < input.length() - 2; i++) {                                    
			if(input.charAt(i) == input.charAt(i + 2) && input.charAt(i) == '-') {       
				error = true;
				
			}
		}
		
		return error;
		
	}
	
	/*
	 * Method for the checkISBN method.
	 */
	private boolean evsb(String input) {
		boolean error = false;
		char dash = '-';
		if(input.charAt(0) == dash) {
			error = true;
			
			
		}
		
		if(input.charAt(input.length() - 1) == dash) {
			error = true;
			
		}
		
		return error;
	}
	
	/*
	 * Method for the checkISBN method.
	 */
	private String replaceDash(String input) {
		input = input.replaceAll("-","" );
		return input;
		
	}
	
	/*
	 * Method for the checkISBN method.
	 */
	private boolean countDigits(String input) {
		boolean error = false;
		int numberOfDigits = input.length();
		if(numberOfDigits == 10) {
			error = false;
			
		}else if(numberOfDigits < 10) {
			error = true;
		}else {
			error = true;
		}
		
			
		return error;
		
	} 
	
	/*
	 * Method for the checkISBN method.
	 */
	private String checkX(String input) {
		int num = input.length();
		if(num == 10) {
			input = input.substring(0, 9) + '0';
		}
		else {
			for(int i = num; i < 10; i++) {
				input = input.substring(0, i) + '0';
			}
			
		}
		
		return input;
	}
	
	/*
	 * Method for the checkISBN method.
	 */
	private boolean baddigit(String input) {
		boolean error = false;
		for(int i = 0; i <= 8; i++) {
			if(Character.isDigit(input.charAt(i)) == false) {
				error = true;
				
			}
		}
		
		return error;
	}
	
	/*
	 * Method for the checkISBN method.
	 */
	private boolean checksum(String modifiedinput, String input0, int num ) {
		boolean error = false;
		BigInteger big = new BigInteger(input0);
		long isbn = big.longValue();
		
		
		long n1 = isbn / 1000000000;                              
		long remaining = isbn % 1000000000;                       
		
		long n2 = remaining/ 100000000;
		remaining = remaining % 100000000;
		
		
		long n3 = remaining / 10000000;
		remaining = remaining % 10000000;
	
		
		long n4 = remaining / 1000000;
		remaining = remaining % 1000000;
		
		
		long n5 = remaining / 100000;
		remaining = remaining % 100000;
		
		
		long n6 = remaining / 10000;
		remaining = remaining % 10000;
		
		
		long n7 = remaining / 1000;
		remaining = remaining % 1000;
		
		
		
		
		long n8 = remaining / 100;
		remaining = remaining % 100;
		
		
		long n9 = remaining / 10;
		remaining = remaining % 10;
	
		
		long multiple = (n1 * 1) + (n2 * 2) + (n3 * 3) + (n4 * 4) + (n5 * 5) + (n6 * 6) + (n7 * 7) + (n8 * 8) + (n9 * 9);
		 
		
		long mod = multiple % 11;
		String modString = Long.toString(mod);
		
		
		if(mod == 10 && modifiedinput.charAt(9) == 'X') {
			
			error = false;
		}
		else if ( modifiedinput.charAt(9) == modString.charAt(0)) {
			
			error = false;
			
		}else {
			error = true;
		}
		
		return error;
		
		
	}
	
	
	
	
	
	
	
	
	

}
