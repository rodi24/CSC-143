/**
 * 
 * @author Rodas T. Gebreslassie
 * 
 * 4/19/18
 * 
 * CSC 143
 * 
 * Zoo.Java
 * 
 * The class zoo store animal objects.
 *
 */

public class Zoo {
	
	private Animal cage1;
	private Animal cage2;
	private Animal cage3;
	
	public Zoo(){
		cage1 = null;
		cage2= null;
		cage3 = null;
	}
	
	public void Print(){
		System.out.println("The zoo contains the following: ");
		if(cage1 != null){
			System.out.println("  " + cage1);
		}
		
		if(cage2 != null){
			System.out.println("  " + cage2);
		}
		
		if(cage3 != null){
			System.out.println("  " + cage3);
		}
		
	}
	
	public void putInCage1(Animal cage1){
		this.cage1 = cage1;
		
	}
	
	public void putInCage2(Animal cage2){
		this.cage2 = cage2;
	}
	
	public void putInCage3(Animal cage3){
		this.cage3 = cage3;
	}
	
	public void allTalk(){
		if(cage1 != null){
			cage1.talk();
			
		}
		
		if(cage2 != null){
			cage2.talk();
			
		}
		
		if(cage3 != null){
			cage3.talk();
			
		}
		
	}
	
	public void feedAll(){
		if(cage1 != null){
			cage1.feed();
			
		}
		
		if(cage2 != null){
			cage2.feed();
			
			
		}
		
		if(cage3 != null){
			cage3.feed();
			
			
		}
		
	}

}
