/**
 * Rodas T. Gebreslassie
 * 
 * 5/4/2018
 * 
 * CSC 143
 * 
 * Book.java
 * 
 * This class will create a book object which can holed 2 books in the form of sets.
 * Once this two sets of books are assigned to a book object then we can use them to 
 * examine which words are in setA(first book) but not in SetB(Second Book).
 */
import java.util.*;

public class Book {
	private Set<String> setA;
	private Set<String> setB;
	private ArrayList<String> arrayA;
	public Book(Set<String> setA, Set<String> setB){
		this.setA = setA;
		this.setB = setB;
		
	}
	/**
	 * 
	 * @param setA  - represent the set of words in book A.
	 * @param setB - represent the set of words in book B.
	 * @return
	 * 
	 * SetA is a set that we want to know how many unique element it holds when
	 * compared to setB.
	 * 
	 * The method notContained() will return a set which consists of words that are
	 * in SetA but not in SetB.
	 */
	public Set<String> notContained(Set<String> setA, Set<String> setB){
		
		Set<String> newSet = new HashSet<>();
		for(String word: setA){
			if(setB.contains(word) != true){
				newSet.add(word);
			}
		}
		
		return newSet;
		
	}
	/**
	 * 
	 * @param arrayA - is an array of BookA(The book we wanted to know how many unique
	 *                 words it contains when compared to the other Book)
	 * @return
	 * 
	 * The method uniqueMap() will call newSet() which is a set that contains unique 
	 * words in BookA and add this words to a map by referring to arrayA, to know the
	 * the number of times the word appear.
	 */
	public Map<String, Integer> uniqueMap(ArrayList<String> arrayA){
		this.arrayA = arrayA;
		Map<String, Integer> wordMap = new HashMap<>();
		Set<String> newSet = notContained(setA,setB);
		
		for(String word: arrayA){
			if(wordMap.containsKey(word) != true && newSet.contains(word) == true){
				wordMap.put(word, 1);
			}
			
			else if(wordMap.containsKey(word) == true && newSet.contains(word) == true){
				int num = wordMap.get(word);
				wordMap.put(word, num + 1);
			}
			
		}
		
		return wordMap;
		
		
	}
	
	/**
	 * The method mostUsedNumber() will accept a map from the previous method UniqueMap 
	 * which hold unique words that are in BookA. and it will evaluate the word that 
	 * appeared most in the Map.
	 * @return
	 */
	
	public int mostUsedNumber(){
		Map<String, Integer> wordMap = uniqueMap(arrayA);
		int max = 0;
		
		for(String word: wordMap.keySet()){
			int num = wordMap.get(word);
			if(num > max){
				max = num;
			}
		}
		
		return max;
		
	}
	/**
	 * The method mostUsedWord() will call the method uniqueMap() and mostUsedNumber
	 * to get the Map and maximum numbers the word appeared in a map to get the most
	 * used word.
	 * 
	 * @return
	 */
	public String mostUsedWord(){
		Map<String, Integer> wordMap = uniqueMap(arrayA);
		int max = mostUsedNumber();
		
		for(String word: wordMap.keySet()){
			int num = wordMap.get(word);
			
			if(num == max){
				return word;
				
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param wordMap - the map containing unique elements in BookA.
	 * @return
	 */
	public int mostUsedNumber(Map<String, Integer> wordMap){
		int max = 0;
		
		for(String word: wordMap.keySet()){
			int num = wordMap.get(word);
			if(num > max){
				max = num;
			}
		}
		
		return max;
		
	}
	/**
	 * 
	 * @param wordMap 
	 * @return
	 */
	public String mostUsedWord(Map<String, Integer> wordMap){
		int max = mostUsedNumber(wordMap);
		
		for(String word: wordMap.keySet()){
			int num = wordMap.get(word);
			
			if(num == max){
				return word;
				
			}
		}
		
		return null;
	}

}
