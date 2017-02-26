/*  
boy_type (Miser, Generous...) and girl_type is randomly assigned in couple.java when giftting in giffter.java by creating couple list by allocator.java  -> output  will differ 

*/
import java.util.*;
import java.io.*;
import java.nio.file.*;
public class q2_main {
	public static void main (String args[] ) {
		giffter g = new giffter() ;   //arraylist <couple > gifted
		Collections.sort(g.gifted  , new Comparator < couple >() {
                                @Override
                                public int  compare(couple o1, couple o2) {
                                return (int)(o2.compatibility  - (o1.compatibility));  //ob1.compareTo(o2)
                                }
                 });
		int k = (new Random()).nextInt(4) + 2 ;

		  System.out.println( k + "  Most compatible  Couples \n");

		 for (couple n: g.gifted){
			if (k-- <= 0 ) 	
				break;
			System.out.println(n.Boy.name +"\t\t"+ n.Girl.name+"\t\t" + 
				n.basket.basket_cost+"\t"+n.boy_type+" hapiness\t"+ n.happiness + "\t Comapatibility \t"+ n.compatibility);
		}
		Collections.sort(g.gifted  , new Comparator < couple >() {
                                @Override
                                public int  compare(couple o1, couple o2) {
                                return (int)(o2.happiness - (o1.happiness));  //ob1.compareTo(o2)
                                }
                 });
                k = (new Random()).nextInt(4) + 2 ;
		System.out.println( "\n" + k + "  Most Happiest Couples \n");
                 for (couple n: g.gifted){
                        if (k-- <= 0 )
                                break;
                        System.out.println(n.Boy.name +"\t\t"+ n.Girl.name+"\t\t" +
                                n.basket.basket_cost+"\t"+n.boy_type+" hapiness\t"+ n.happiness + "\t Comapatibility\t"+ n.compatibility);
                }
	}
}
	
