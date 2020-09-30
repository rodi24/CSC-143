/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * AnimalClient.java
 * 
 * This class is a client class for Animal. 
 *
 */

public class AnimalClient {

	public static void main(String[] args) {
		
		Zebra z = new Zebra();
		Lion l = new Lion();
		Lion l2 = new Lion();
		Zebra z2 = new Zebra();
		
		System.out.println("Hunger level of the zebra was initially " + z.getHunger() + ".");
		System.out.println("Hunger level of the Lion was initially " + l.getHunger());
		System.out.println();
		
		System.out.println("As time passes (calling timePasses() 3 times) ");
		System.out.print("     :");
		for(int i = 1; i <=3; i++){
			z.timePasses();
			l.timePasses();
		}
		
		System.out.println("      with a hunger level of = " + l.getHunger());
		System.out.println();
		System.out.println("     :Hunger level of the Zebra = " + z.getHunger());
		
		l.feed();
		z.feed();
		System.out.println();
		System.out.println("Once we feed them");
		System.out.println("     : Hunger level of the lion = " + l.getHunger());
		System.out.println("     : Hunger level of the Zebra = " + z.getHunger());
		System.out.println();
		
		Zoo zo = new Zoo();
		zo.putInCage1(l);
		zo.putInCage2(z);
		zo.Print();
		
		System.out.println();
		System.out.println("allTalk() method of the ZOO returns: "); 
		zo.allTalk();
		
		System.out.println();
		zo.feedAll();
		System.out.println("After calling feedAll() method of the ZOO");
		System.out.println("     :Hunger level of the Lion = " + l.getHunger() );
		System.out.println("     :Hunger level of the Zebra = " + z.getHunger());
		
		
		
		
		
		
		
		

	}

}