import java.util.*;
import java.io.*;
public class q6 extends giffter {
	/**
	 * Constructor using gift basket 
	 * creating boys list of commited boys
	 * breakup and new couples patchup
	 */
	public q6 (  ) {
		int i;
		Random r = new Random();
		int t;
		/** k is Fixed calender dates size here taken 5
		*/
		int k = 5 , j;
		Gift_Basket basket = new Gift_Basket("gift.txt");
		int days [ ] = new int [k];
		for (i = 0; i< k; i++) 
			days[i] = r.nextInt(20) + 10;
		ArrayList <boy> boys = (new boy()).getter("boy.txt" , new boy() );
		i = 0; //
		for(couple n: gifted) {
			if ((boys.get(i).name).equals(n.Boy.name) == true)
				boys.get(i).isSingle = false ;
			i++;	
		}
		couple temp ;
		giffter g  = new giffter(5);
		j = 0;
		for ( i = 0;i < k; i++ ) {
			for(couple c : gifted ) {
				if ( c.happiness < days[i] ) {
					temp = get_couple (gifted ,gifted.get(j).Girl, boys ); // temp is new couple 
					if ( temp == null ) 
						continue;
					if ((c.boy_type).equalsIgnoreCase("Miser")== true ) {
						gifted.set (j , g.gift_miser (basket , temp ));         //R
						//boys.get(j).isSingle = false ;
						change_status(temp.Boy.name , boys);
					}
					else if ((c.boy_type).equalsIgnoreCase("Generous")== true ) {
						gifted.set  ( j , g.gift_generous (basket , temp ));
						// boys.get(j).isSingle = false ;
						change_status(temp.Boy.name , boys);
					}
					else {
						gifted.set  (j ,  g.gift_geeks(basket , temp ));							 						  //boys.get(j).isSingle = false ;
						change_status(temp.Boy.name , boys);

					}			
				}	
				j++;
			}
			j = 0;
			printk( gifted ) ;

		}	
	}
	/** Change status of boy names name to commited;
	 * @param name (Name of Boy) ;
	 * @param boys (list of boys with detail if they are single or not 
	*/
	 public void change_status ( String name , ArrayList<boy> boys) {  // change status of broke up boy to single 
                int i=0;
                for( boy b: boys) {
                        if ((b.name).equals(name) == true)
                                boys.get(i).isSingle = false;
                        i++;
                }
        }
        /** Print updated couples details after each date
	 * @param list ( couple list to be printed ).
	*/
	public void printk(ArrayList <couple > list ) {
		for (couple n: list ) {
System.out.printf("%-15s  %-15s  %-15s  %-15s  %-15d %-15d\n",n.Boy.name,n.Girl.name,n.boy_type,n.girl_type,n.happiness,n.compatibility );
		}
		System.out.println("");
	}	
	/** Returns couple 
	*/
	public couple get_couple(ArrayList<couple> gifted , girl g ,ArrayList <boy> boys) {
		boolean flag = false;
		boy temp = new boy();
		couple new_couple;
		int i = 0; //as iterator
		for (couple c : gifted ) {
			if ( (c.Girl.name).equals(g.name ) == false ) //only girl b is to be broked and setteled
				continue;
			for (boy b : boys)  {
				if (b.budget < c.Girl.maintenance_budget || b.requirement >= c.Girl.attractiveness|| b.isSingle == false)
					continue;
				try {
					if((c.Girl.criteria).equalsIgnoreCase("Intelligent") == true ){
						temp = b.most_intelligent ( boys); //ret refernce to most_Iq boy from list br.cb of boys 
						flag = true;
					}
					else if ((c.Girl.criteria).equalsIgnoreCase("Attractive") == true ) {
						temp = b.most_attractive (boys);
						flag = true;
					}
					else if ((c.Girl.criteria).equals("Rich")== true){
						temp = b.most_rich (boys);
						flag = true;
					}
					if (flag == true && (temp != null )) {
						temp.isSingle = false;				
						change_status(temp.name , boys);	
						new_couple  = new couple (temp , c.Girl );
	//change_status(c.Boy.name , cb);//broke up boy "named c.Boy.mane now availble for patch anothr girl
						boys.get(i).isSingle = true;
						flag = false;
						return new_couple ; //
					}
					else {    // girl not got boy according to her choice now she lower the expectations 
						int k;
						while(true ) {
							k = (new Random() ).nextInt( boys.size());
							if( boys.get(k).isSingle == true) {
								new_couple = new couple (boys.get(k) , c.Girl);
								change_status(boys.get(k).name , boys);
								c.Girl.isSingle = false;
								boys.get(i).isSingle = true;
								return new_couple;
							}
						}
					}
				} catch ( Exception e ) {
					e.printStackTrace();	
				}
				i++; ////
			}	
		}
	return null;
	}
	public static void main(String args[] ) {
		new q6();
	}
}
