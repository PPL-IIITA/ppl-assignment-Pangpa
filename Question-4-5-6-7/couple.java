import java.util.*;
/** Couple class of boy obj and girl obj 
*   Also has Field basket which is basket of Gift 
*/
public class couple {
	boy Boy; // reference to boy object 
	girl Girl; //reference to girl object 
	String 	boy_type; // Miser , Generous , Geeks 
	String 	girl_type; // Choosy , Normal , desperate 
	int happiness_boy;
	int happiness_girl;
	Gift_Basket basket;
	int happiness;
	int compatibility;
	public couple () {
	}
	/**Constructor of couple creates couple 
	*  The constructor asigns Random values to type of girl ie Choosy , Normal  , Desperate and Boy Type ie Miser ,Generous , Geeks 
	* @param b (boy Object reference of newly formed couple  )
	* @param g (girl Object reference of new couple) 
	*/
	public couple (boy b , girl g) {
		Boy = b;
		Girl = g;
		String btype [ ] = { "Miser" , "Generous" , "Geeks" };
		String gtype [ ] = { "Choosy" , "Normal" , "Desperate"};
		Random r = new Random ();
		this.boy_type = btype[r.nextInt(btype.length)];
		this.girl_type = gtype[r.nextInt(gtype.length)];
		basket = new Gift_Basket();				
	}

}
