/**
 * Rodas T. Gebreslassie
 * 
 * 5/4/2018
 * 
 * CSC 143
 * 
 * BookClient.java
 * 
 * This Class is a client class for the class Book. 
 */
import java.io.*;
import java.util.*;

public class BookClient {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputA1 = Input("30486.txt");
		Scanner inputA2 = Input("9182-8.txt");
		Scanner inputA3 = Input("janey10.txt");
		Scanner inputA4 = Input("tprof10.txt");
		
		Scanner inputB1 = Input("161.txt");
		Scanner inputB2 = Input("20080525-141.txt");
		Scanner inputB3 = Input("20080528-158.txt");
		Scanner inputB4 = Input("pandp10.txt");
		Scanner inputB5 = Input("persu10.txt");
		
		//SetA1, setA2, SetA3 and setA4 represent books by Charlotte Bronte.
		Set<String> setA1 = returnSet(inputA1);
		Set<String> setA2 = returnSet(inputA2);
		Set<String> setA3 = returnSet(inputA3);
		Set<String> setA4 = returnSet(inputA4);
		
		//SetB1, setB2, SetB3 and setB4 represent books by Jane Austen. 
		Set<String> setB1 = returnSet(inputB1);
		Set<String> setB2 = returnSet(inputB2);
		Set<String> setB3 = returnSet(inputB3);
		Set<String> setB4 = returnSet(inputB4);
		Set<String> setB5 = returnSet(inputB5);
		
		// setA is a set of collection of words found in Charlotte Bronte novels.
		Set<String> setA = new HashSet<>();
		setA.addAll(setA1);
		setA.addAll(setA2);
		setA.addAll(setA3);
		setA.addAll(setA4);
		
		//SetB is a set of collectinon of words found in  Jane Austen novels.
		Set<String> setB = new HashSet<>();
		setB.addAll(setB1);
		setB.addAll(setB2);
		setB.addAll(setB3);
		setB.addAll(setB4);
		setB.addAll(setB5);
		
		Book books = new Book(setA, setB);
		Set<String> newSet = books.notContained(setA, setB);
		
		Scanner inputA11 = Input("30486.txt");
		Scanner inputA22 = Input("9182-8.txt");
		Scanner inputA33 = Input("janey10.txt");
		Scanner inputA44 = Input("tprof10.txt");
		
		
		ArrayList<String> arrayA = new ArrayList<String>();
		
		
		ArrayList<String> arrayA1 = returnArray(inputA11);
		ArrayList<String> arrayA2 = returnArray(inputA22);
		ArrayList<String> arrayA3 = returnArray(inputA33);
		ArrayList<String> arrayA4 = returnArray(inputA44);
		
		arrayA.addAll(arrayA1);
		arrayA.addAll(arrayA2);
		arrayA.addAll(arrayA3);
		arrayA.addAll(arrayA4);
		
		Map<String, Integer> wordMap = books.uniqueMap(arrayA);
		
		int max = books.mostUsedNumber();
		String word = books.mostUsedWord();
		
		System.out.println("Top 10 words found in Charlotte Bronte’s books ");
		System.out.println("but not in Jane Austen’s and their counts.");
		System.out.println();
		
		System.out.println("1. " +word + " - " + max);
		
		for(int i = 2; i <= 10; i++){
			wordMap.remove(word);
			max = books.mostUsedNumber(wordMap);
			word = books.mostUsedWord(wordMap);
			System.out.println(i + ". " + word + " - " + max);
			
			
			
		}
		
		
		
		
		

	}
	
	/**
	 * The method Input() will create a scanner variable  input that will read from
	 * a given book.
	 * 
	 * @param book
	 * @return
	 * @throws FileNotFoundException
	 */ 
	public static Scanner Input(String book) throws FileNotFoundException{
		Scanner input = new Scanner(new File(book));
		return input;
	
	}
	
	/**
	 * The method returnArray(Scanner input) will accept a scanner variable input
	 * as a parameter and add each word in the input to an array.
	 * @param input
	 * @return
	 */
	public static ArrayList<String> returnArray(Scanner input){
		ArrayList<String> array = new ArrayList<String>();
		
		while(input.hasNext()){
			String a = input.next();
			
			a = a.replace(",", "");
			a = a.replace(".", "");
			a = a.replace("?", "");
			a = a.replace("\"", "");
			a = a.replace("-", "");
			a = a.replace("!", "");
			a = a.replace("'", "");
			a = a.replace(":", "");
			a = a.replace(";", "");
			a = a.replace("\"", "");
			a = a.replace("...", "");
			a = a.replace("_", "");
			a = a.replace("=", "");
			a = a.replace("(", "");
			a = a.replace(")", "");
			a = a.toLowerCase();
			
			array.add(a);
			
			
		}
		
		return array;
	}
	
	/**
	 *This method accept a scanner variable input as parameter and return a set. 
	 * @param input - Scanner input.
	 * @return
	 */
	public static Set<String> returnSet(Scanner input){
		Set<String> wordSet = new HashSet<>();
		
		while(input.hasNext()){
			String a = input.next();
			a = a.replace(",", "");
			a = a.replace(".", "");
			a = a.replace("?", "");
			a = a.replace("\"", "");
			a = a.replace("-", "");
			a = a.replace("!", "");
			a = a.replace("'", "");
			a = a.replace(":", "");
			a = a.replace(";", "");
			a = a.replace("\"", "");
			a = a.replace("...", "");
			a = a.replace("_", "");
			a = a.replace("=", "");
			a = a.replace("(", "");
			a = a.replace(")", "");
			a = a.toLowerCase();
			
			wordSet.add(a);
			
			
			
			
		}
		
		return wordSet;
		
	}
	

}
