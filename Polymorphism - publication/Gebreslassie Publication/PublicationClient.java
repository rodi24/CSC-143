/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * PublicationClient.Java
 * 
 * This class is a client class for publication.java. 
 * 
 * 
 *
 */
public class PublicationClient {

	public static void main(String[] args) {
		Book b1 = new Book("James Stwaret", "Brooks Cole", 800, 100, "Calculus");
		Magazine m1 = new Magazine("Time", "Time inc", 30, 5, "weekly");
		KidsMagazine km1 = new KidsMagazine("kids Planet", "Planet inc", 30, 5, "weekly",15);
		Book b2 = new Book("John M. Zelle", "Franklin, Beedle & Associates", 800, 100, "Python");
		Magazine m2 = new Magazine("Newsweek", "Newsweek inc", 30, 5, "weekly");
		KidsMagazine km2 = new KidsMagazine("kids World", "kids inc", 30, 5, "weekly",10);
		Magazine m3 = new Magazine("Us weekly", "private inc", 30, 5, "weekly");
		Book b3 = new Book("Suzanne Collins", "Scholastic Corporation", 600, 50, "The Hunger Games");
		
		Publication[] publish = {b1, m1, km1, b2, m2, km2, m3, b3 };
		
		for(Publication p : publish){
			System.out.println(p);
			System.out.println();
		
		}
		
		

	}

}
