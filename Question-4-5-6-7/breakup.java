import java.util.*;
import java.io.*;
/**
 *  Performs Breakup of couples 
*/
public class breakup extends giffter {
	
	ArrayList <boy> cb;
	//giffter g;// couples after gifted not to change 
	int count;
	/** Constructor performing breakup and Crating a list of old commited boys 
	 *
	 */
	public breakup ( )  {   
		//g = new giffter() ;
		Collections.sort(gifted  , new Comparator < couple >() {
                                @Override
                                public int  compare(couple o1, couple o2) {
                                return (int)(o1.happiness - (o2.happiness));  //ob1.compareTo(o2)
                                }
                 });
		int k;
                k = (new Random()).nextInt(4) + 2 ;
		count = k;	
		System.out.println( "\n" + k + "\tLeast Happiest Couples \n");
                 for (couple n : gifted){
                        if (k-- <= 0 )
                                break;
                        System.out.printf("%-15s %-15s %-15s %-15d \n" , n.Boy.name ,n.Girl.name, n.boy_type , n.happiness );
                }
		// pass  gifted couple list
		cb = Boys_patch(gifted );  //boys with detail of whether single r not

	}
	/** Returs list of boys after updating their status as wether they are single or not 
	*   Actual breakup of boy is done in patch_up class where boy is then become available to be assigned with some other girl then before he 
	*    was with earlier 
	* @param gifted ( List of couples Before breakup ) 
	* @return ( Returns list of commited boys eariler used in patch_up class to assign if eligible to some another girl then before ) 
	*/
	public ArrayList<boy> Boys_patch(ArrayList <couple> gifted  ) {        //boys with detail if they single or not to patch with girls
		boy br = new boy() ;
		int i = 0; 
		ArrayList <boy> boys = br.getter("boy.txt" , br );
		for (boy b : boys ) {
			for ( couple c : gifted) {
				if (c.Boy.name.equals(b.name )  == true) 
					boys.get(i).isSingle = false ;
			}
			i++;
		}
		return boys;
	}

}
