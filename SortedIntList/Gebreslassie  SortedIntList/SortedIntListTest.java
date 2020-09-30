/*
 * Rodas T. Gebreslassie
 * 
 * SortedIntListTest.java
 * 
 * CSC 143
 * 
 * 5/20/2018
 * 
 * This Program will crrat 3 SortedIntList objects S1, S2 and S3 to test
 * different methods of the SortedIntList class.
 */
public class SortedIntListTest {

	public static void main(String[] args) {
		
		SortedIntList s1 = new SortedIntList(15);
		
		s1.add(3);
		s1.add(5);
		s1.add(1);
		s1.add(10);
		s1.add(15);
		s1.add(8);
		s1.add(7);
		s1.add(7);
		s1.add(11);
		s1.add(9);
		s1.add(5);
		s1.add(12);
		
		System.out.println("SortedIntList 1 : ");
		System.out.println("  S1: " + s1);
		
		s1.remove(3);
		
		System.out.println("  S1 after removing element at index 3: " + s1 );
		
		System.out.println("  Element at index 5: " + s1.get(5));
		
		System.out.println("  The size of the SortedIntList is: " + s1.size());
		
		System.out.println("  s1.isEmpty() = " + s1.isEmpty());
		System.out.println();
		
		
		
		SortedIntList s2 = new SortedIntList(false,15);
		
		s2.add(7);
		s2.add(7);
		s2.add(7);
		s2.add(5);
		s2.add(5);
		s2.add(4);
		s2.add(10);
		s2.add(14);
		s2.add(11);
		s2.add(1);
		s2.add(3);
		s2.add(12);
		s2.add(4);
		s2.add(14);
		
		System.out.println("SortedIntList 2:");
		System.out.println("  s2: " + s2);
		System.out.println("  s2.size(): " + s2.size());
		
		s2.setUnique(true);
		
		System.out.println("  s2 after setting unique to true: " + s2);
		System.out.println("  s2.getUnique() = " + s2.getUnique());
		s2.add(3);
		System.out.println("  s2 after adding 3 with unique set to true: " + s2);
		
		System.out.println("  The largest element in the SortedIntlist s2 is: " + s2.max());
		System.out.println("  The smallest element in the SortedIntList s2 is:" + s2.min());
		System.out.println();
		
		
		SortedIntList s3 = new SortedIntList(15);
		
		s3.add(1);
		s3.add(8);
		s3.add(6);
		s3.add(5);
		s3.add(10);
		s3.add(8);
		s3.add(3);
		s3.add(11);
		s3.add(3);
		s3.add(5);
		s3.add(2);
		s3.add(2);
		s3.add(2);
		s3.add(2);
		s3.add(5);
		
		System.out.println("SortedIntList 3:");
		System.out.println("  s3: " + s3);
		System.out.println("  s3.indexOf(6) = " + s3.indexOf(6));
		System.out.println("  s3.count(2) = " + s3.count(2));
		System.out.println("  s3.indexOf(4) = " + s3.indexOf(4));
		
		
	

	}

}
