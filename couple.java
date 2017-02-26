import java.util.*;
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
