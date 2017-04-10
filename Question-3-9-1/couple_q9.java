import java.io.*;
import java.util.*;
/** Makes couple accordingly question 9
*/
public class couple_q9 extends couple {	
	ArrayList <couple > couples ;
	ArrayList <couple> gifted;
	public  couple_q9 () {
		boy br = new boy();
		ArrayList <boy> boys = br.getter( "boy.txt"  , br);
		girl g = new girl();
		ArrayList <girl> girls = g.getter( "girl.txt" , g);

		couples = new ArrayList < >();
		couple c ;
		basket = new Gift_Basket("gift.txt");
		/**
		 * To get best k values 
		 */
		int k ;
		// type is obj of bestkVlaue class 	
		bestkValues  < boy >  type = new bestkValues < boy > () ;
		Random r = new Random();
		Collections.sort(boys  , new Comparator < boy >() {
				@Override
				public int  compare(boy o1, boy o2) {
				return (int)(o2.IQ- (o1.IQ));  //secondry criteria
				}
				});
		k =  2 +  r.nextInt( girls.size()  - 3);
		/**
		 * List of best k boys 
		 */
		boys  = type.get( boys , k  );   //
		/**
		 * Sorting Girls list by secondry criteria ie maintenance to be chosen by boys 
		 */
		Collections.sort(girls  , new Comparator < girl >() {
				@Override
				public int  compare(girl o1, girl o2) {
				return (int)(o2.maintenance_budget - (o1.maintenance_budget));  //secondry criteria
				}
				});
		/** list of best k girls accor to maintenance 
		 */
		bestkValues < girl > typegirl = new bestkValues < girl > () ;  // changing genric to girl type class with reference var typegirl
		girls =  typegirl.get( girls  , k  );  
		int i , j;
		boy temp = new boy();
		girl Girl = new girl();
		//To upcast from child class obj  miser , geeks etc 

		boy choose = null;
		boolean  flag = false;
		for (girl gi : girls ) {
			for (boy b : boys ) {
				if (b.budget < gi.maintenance_budget || b.requirement >= gi.attractiveness  || b.isSingle == false ) 
					continue;
				try {
					if ((gi.criteria).equalsIgnoreCase("Intelligent")== true ) {
						choose = temp.most_intelligent (boys);
						//System.out.println(choose.getClass().toString());
						flag = true;
					}
					else if ((gi.criteria).equalsIgnoreCase("Attractive")== true ) {
						choose = b.most_attractive (boys);
						flag = true;
					}
					else if ((gi.criteria).equalsIgnoreCase("Rich")== true ){
						choose  = b.most_rich(boys);
						flag = true;
					}
					if (flag == true && (choose != null)) {
						c = new couple(choose  , gi );
						couples.add(c);
						choose.isSingle = false;
						gi.isSingle = false;
						flag = false;
						break; //girls.remove(girls.indexOf(gi)); 
					}
				}catch( Exception e ) {
					e.printStackTrace();
				}
			}
		}
		/** basket is inherited from couple class 
		 *  generate basket of gifts 
		 */
		basket = new Gift_Basket("gift.txt");
		/** sort basket by Secondry Criteria mentioned in q9 accoring to value;
		 * gift_basket is arraylist  list of Gifts( class objects) 
		 */
		Collections.sort(basket.gift_basket , new Comparator < Gift >() {
				@Override
				public int  compare(Gift o1, Gift  o2) {
				return (int)(o2.value  - (o1.value));  //secondry criteria
				}
				});
		bestkValues < Gift  > giftBasket = new bestkValues < Gift > () ;
		ArrayList < Gift > Basket = new ArrayList < Gift > () ;
		/** 
		 *  Get best k valued gift according  to their value 
		 */
		Basket =  giftBasket.get( basket.gift_basket   , k  );

		gifted = get_gifted ( ) ;
	}	
	/** Perform a gifting on couples 
	 * @param gifted ( list of couples where updated happiness , compatibility is stored )
	 * @return (Returns updated list of couples 
	*/
	private ArrayList< couple> get_gifted ( ) {
		ArrayList<couple> gifted = new ArrayList <couple> () ;
		try {
			writer  = new PrintWriter (new FileOutputStream ( new File("log.txt"), true ));/////////////// "UTF-8"

			boy b = new boy() ;
		
			int i = 0 ; //as an iterator
			/** All subclasses of boy has a method happiness and boy class reference variable b is used to call happines() method
			 *   During runtime the associated method of the object of sublasses is invoked which is either of miser , geek etc
			 */
			for (couple c :  couples) {
				/** object of subclass upcasted to b ie superclass boy;
				 */
				b  = c.Boy;
				gifted.add ( b.gift(basket , c , writer ) ) ;//b.gift()  method of object associated with is invoed
				gifted.get(i).happiness = (gifted.get(i).Boy.happines() + gifted.get(i).Girl.happines()) % 30 ;

				c.compatibility = Math.abs((int) (c.basket.basket_cost - c.Boy.budget)) 
					+ Math.abs(c.Boy.attractiveness - c.Girl.attractiveness) + Math.abs (c.Boy.IQ - c.Girl.IQ) ;			
				//System.out.println("::" + gifted.get(i).Boy.name + gifted.get(i).Girl.name + gifted.get(i).happiness);
				i++;

			}	
		}catch(Exception e ) {
			e.printStackTrace();
		}
		writer.close(); 
		return gifted;

	}
	
}

