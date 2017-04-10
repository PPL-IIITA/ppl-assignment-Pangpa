import java.io.*;
import java.util.*;
/**
*   GiftBasket basket  is the gifting details intially zero 
*   happiness is the happiness of couple total
*   ArrayList couple inherited from allocator 
*/
public class couple { 
	int happiness;		//here  happiness of couple in child claass it is happines of the like happiness of boy etc
	Gift_Basket basket;  // this field appear in child classes but is not accessible 
	girl Girl;
	boy Boy;
	int compatibility;  //only in this class
	PrintWriter writer;
	public couple() {
		
	}
	/** Intialises a new couple 
	 *@param b (Boy member ) 
	 * @param g (girl member)  
	*/
	public couple (boy b , girl g  ) {
		Boy = b;
		Girl = g;
		basket = new Gift_Basket();	
		
	}
	/** Method makes couples with help of allocator class and returns a the list of couples formed 
	 * @return (list of couples ) 	
	 * after calculating their happiness , compatibility 
	*/	
	public ArrayList<couple> get_couples () {		
		basket = new Gift_Basket("gift.txt");
		allocator a = new allocator() ;
			
		ArrayList<couple> gifted = new ArrayList <couple> () ;
	
		try {
			writer  = new PrintWriter (new FileOutputStream ( new File("log.txt"), true ));/////////////// "UTF-8"
		
		boy b = new boy() ;
			
		int i = 0 ; //as an iterator
	 	/** All subclasses of boy has a method happiness and boy class reference variable b is used to call happines() method
		*   During runtime the associated method of the object of sublasses is invoked which is either of miser , geek etc
		*/
		for (couple c : a.couples) {
			/** object of subclass upcasted to b ie superclass boy;
			*/
			b  = c.Boy;
			gifted.add ( b.gift(basket , c , writer ) ) ;//b.gift()  method of object associated with is invoed
			gifted.get(i).happiness = (gifted.get(i).Boy.happines() + gifted.get(i).Girl.happines()) % 30 ;
			
c.compatibility = Math.abs((int) (c.basket.basket_cost - c.Boy.budget)) 
			+ Math.abs(c.Boy.attractiveness - c.Girl.attractiveness) + Math.abs (c.Boy.IQ - c.Girl.IQ) ;			
//			System.out.println("::" + gifted.get(i).Boy.name + gifted.get(i).Girl.name + gifted.get(i).happiness);
			i++;
				
		}	
		}catch(Exception e ) {
			e.printStackTrace();
		}
		writer.close(); 
		return gifted;
	}
}
