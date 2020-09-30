/*
 * Rodas T. Gebreslassie
 * 
 * SortedIntList.java
 * 
 * CSC 143
 * 
 * 5/20/2018
 * 
 * this class is a class of SortedIntList with 3 private fields.
 */
import java.util.*;
public class SortedIntList {
	private int[] elementData;
	private int size;
	private boolean unique;
	public static final int Default_Capacity = 10;
	
	//post: constructs an empty list of default capacity.
	public SortedIntList(){
		this(false, Default_Capacity);
		
	}
	
	 // post: constructs an empty list with the given unique value default capacity.
	public SortedIntList(boolean unique){
		this(unique, Default_Capacity);
		
	}
	
	// pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
	public SortedIntList(int capacity){
		this(false, capacity);
		
	}
	
	// pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity and unique value
	public SortedIntList(boolean unique, int capacity){
		if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
		
		this.unique = unique;
		elementData = new int[capacity];
		size = 0;
		
	}
	
	// pre : size() < capacity (throws IllegalStateException if not)
    // post: add a given value in a list in its appropriate position
	public void add(int value){
		checkCapacity(size + 1);
		int count = count(value);
		
		int position;
		
		if(unique == true && count == 1){
			
		}
		
		else{
			if(size == 0){
				elementData[0] = value;
				size++;
			}
			
			else if( value >= elementData[size - 1]){
				elementData[size] = value;
				size++;
			}
			
			else if(value < elementData[size - 1]){
				position = compare(value);
				
				for(int i = size; i > position; i--){
					elementData[i] = elementData[i - 1];
				}
				
				elementData[position] = value;
				size++;
				
				
			} 
			
		}
		
	}
	
	 // post: creates a comma-separated, bracketed version of the list
	public String toString(){
		if(size == 0){
			return "[]";
			
		}
		else{
			String result = "[" + elementData[0];
			for(int i = 1; i < size; i++){
				result = result + "," + elementData[i];
			}
			
			result = result + "]";
			return result;
		}
		
		
	}
	
	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
	public void remove(int index){
		checkIndex(index);
		for(int i = index; i < size - 1; i++){
			elementData[i] = elementData[i+1];
		}
		
		size--;
	}
	
	// pre: 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
	public int get(int index){
		checkIndex(index);
		return elementData[index];
	}
	
	// post: returns the current number of elements in the list
	public int size(){
		return size;
	}
	
	// post: returns true if list is empty, false otherwise
	public boolean isEmpty(){
		return size==0;
	}
	
	//post: return the index of a specific value as returned from a binary search.
	private int indexOf2(int value){
		int index = Arrays.binarySearch(elementData, 0, size, value);
		return index;
		
	}
	
	// post : returns the position of the first occurrence of the given
    //        value.
	public int indexOf(int value){
		int indexFirst = Arrays.binarySearch(elementData, 0, size, value);
		int index = indexFirst;
		int counter = indexFirst;
		
		while(counter > 0){
			if(elementData[index] == elementData[index - 1]){
				index = index - 1;
			}
			
			counter = counter - 1;
			
		}

		
		return index;
	}
	
	//post: returns the number of time a given value occur in a list.
	public int count(int value){
		int index = indexOf2(value);
		int index2 = index;
		int sum = 0;
		
		if(index > -1){
			sum = sum + 1;
			
			while(index <= size - 2 &&  elementData[index] == elementData[index + 1] ){
				
				sum = sum + 1;
				index = index + 1;
				
				if(index == size - 2){
					if(elementData[index] == elementData[size - 1]){
						sum = sum + 1;
						break;
					} 

				}
				
				
			}
			
			while(index2 >= 1 && elementData[index2] == elementData[index2 - 1]  ){
				sum = sum + 1;
				index2 = index2 - 1;
				
				}
				
				
				
			}
		
		return sum;
			
		}
		
		
		
	
	//post: returns the unique value of the list (true or false)
	public boolean getUnique(){
		
		for(int i = 0; i < size; i++){
			int count = count(elementData[i]);
			
			if(count > 1 && unique == false){
				return false;
			}
		}
		
		return true;
		
	}
	
	//post: If setUnique is set to true, duplicates in a list will get removed.           
	public void setUnique(boolean unique){
		this.unique = unique;
		
		if(unique == true){
			for(int i = size - 1  ; i >= 1; i--){
				if(elementData[i] == elementData[i - 1]){
					remove(i); 
				}
			}
		}
	}
	
	//post: returns the maximum value in a list
	public int max(){
		if(size == 0){
			throw new NoSuchElementException("No Such element");
		}
		return elementData[size - 1];
	}
	
	//post: return the minimum value in a list.
	public int min(){
		return elementData[0];
	}
	
	//compare elements in a list and returns position
	private int compare(int value){
		int position = 0;
		for(int i = 1; i < size; i++){
			int previous = elementData[i - 1];
			int next = elementData[i];
			
			if( value >= previous && value < next){
				position = i;
			}
			
		}
		
		return position;
		
		
	}
	
	private void checkCapacity(int capacity) {
        if (capacity > elementData.length) {
            throw new IllegalStateException("would exceed list capacity");
        }
    }
	
	 private void checkIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("index: " + index);
	        }
	 }

}
