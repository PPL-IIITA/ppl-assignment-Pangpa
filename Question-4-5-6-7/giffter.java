import java.util.*;
import java.io.*;
import java.nio.file.*;
/** Performs Gifting of couples 
 *  Also calculates thier happiness and compatibility 
 */
public class giffter extends allocator  
{
	ArrayList <couple> gifted; //couples after gift  
	PrintWriter writer ;
	public giffter (int a ) {
		try {
			writer  = new PrintWriter (new FileOutputStream ( new File("log.txt"), true ));/////////////// "UTF-8"
		}catch (Exception e ) {	e.printStackTrace();}
	
	}
	/** Constructor Generats a list of available gifts w
	 *  Write the logs of Gist exchanges in log.txt 
	*/
	public giffter (  ) {
//		allocator a = new allocator();// couples attribut of couple arraylist
		Gift_Basket basket = new Gift_Basket("gift.txt");//ArrayList<gift>gift_basket attribute in basket object from gift.txt file  
		try {
			writer  = new PrintWriter (new FileOutputStream ( new File("log.txt"), true ));/////////////// "UTF-8"
		}catch (Exception e ) {	e.printStackTrace();}

		gifted = new ArrayList < couple >();
		for (couple c : couples) {
			if ((c.boy_type).equalsIgnoreCase("Miser")== true ) {
				gifted.add ( gift_miser (basket , c ));		//Replace ?
			}
			else if ((c.boy_type).equalsIgnoreCase("Generous")== true ) {
				gifted.add ( gift_generous (basket , c ));   
			}	
			else 
				gifted.add ( gift_geeks(basket , c ));
		}
		writer.close();
	}
	/** Performs giffting by a miser boyfriend 
	 * calculates the couple's happiness 
	 * miser boy's happiness and his girlfriend's happiness
	 * calculates compatibility between them 
	 * @param g (Gift_Basket object which has an attribute of gift_basket a list of Gifts )
         * @param c (Associated couple whose compatibility and happiness to be generated ) 
	 * @return (returns a couple object after calculatings its field details(happiness , compatibility ) 
	*/
	public couple gift_miser (Gift_Basket g , couple c ){  //gift by miser 
		Collections.sort(g.gift_basket  , new Comparator < Gift >() {@Override  // SORT BASKET AS PRICE INCREASING ORDER 
				public int  compare(Gift o1, Gift o2) {
				return (int)(o1.price  - (o2.price));  //ob1.compareTo(o2)
				}});
		int value_sum = 0;
		int doubl_lux = 0;
					//c.basket.basket_cost = 0 ; initialization 

		//g.basket_cost = (int)c.Boy.budget +(new Random()).nextInt((int) Math.abs((c.Girl.maintenance_budget - c.Boy.budget)) );
		int max = (int) c.Boy.budget + 100;	//gift price sum 
		int increase = 0;
		for ( Gift gi : g.gift_basket ) {
			if (gi.price + c.basket.basket_cost <= max  ) {
				c.basket.basket_cost = c.basket.basket_cost + gi.price;
				if ((gi.type).equalsIgnoreCase("Luxury"))
					doubl_lux = doubl_lux + gi.price ;
				value_sum = value_sum + gi.value;    //sum of values of gifts
			}
			else  {
				c.basket.basket_cost = c.basket.basket_cost + gi.price ; 
				writer.println (c.Boy.name + "\t"+ "Gifted "+ "\t"
						+ gi.name +"----"+ "---To---" + c.Girl.name + "----" 
						+"of price" + "----" +  gi.price+"\n" );
				if ((gi.type).equalsIgnoreCase("Luxury"))
					doubl_lux = doubl_lux + gi.price ;
				value_sum = value_sum + gi.value;
				break;	
			}
				  writer.println (c.Boy.name + "\t"+ "Gifted "+ "\t"
                                                + gi.name +"----"+ "---To---" + c.Girl.name + "----"
                                                +"of price" + "----" +  gi.price +"\n");

		}
		if ((c.girl_type).equalsIgnoreCase("Choosy") )   // HAPPINESS GIRL 
			c.happiness_girl =(int) (Math.log (c.basket.basket_cost + doubl_lux )/Math.log(2)) ;
		else if ((c.girl_type).equalsIgnoreCase("Normal"))
			c.happiness_girl = 20 * c.basket.basket_cost + value_sum; 
		else                         //  c.happiness_girl =(int) Math.exp(c.basket.basket_cost);
		c.happiness_girl = (int) Math.exp(Math.abs(c.basket.basket_cost - c.Girl.maintenance_budget))%100000;
		c.happiness_boy = (int)c.Boy.budget - c.basket.basket_cost;//HAPPINESS BOY
		c.happiness = Math.abs (1 + (c.happiness_boy + c.happiness_girl ) % 30 );		
		c.compatibility = Math.abs((int) (c.basket.basket_cost - c.Boy.budget)) + 
			Math.abs(c.Boy.attractiveness - c.Girl.attractiveness)+ Math.abs (c.Boy.IQ - c.Girl.IQ) ;
		return c;
	}
	/** Performs giffting by a Generous  boyfriend 
         * calculates the couple's happiness 
         * generous boy's happiness and his girlfriend's happiness
         * calculates compatibility between them 
	 * @param g (Gift_Basket object which has an attribute of gift_basket a list of Gifts )
	 * @param c (Associated couple whose compatibility and happiness to be generated ) 
	 * @return (returns a couple object after calculatings its field details(happiness , compatibility ) 
        */
	public couple gift_generous (Gift_Basket g , couple c ){  //gift by miser 
		Collections.sort(g.gift_basket  , new Comparator < Gift >() {  
				@Override
				public int  compare(Gift o1, Gift o2) {
				return (int)(o2.price  - (o1.price));  //ob1.compareTo(o2)//decreasing order 
				}
				});
		int max = (int)c.Boy.budget + 100;
		int value_sum = 0;
		int doubl_lux = 0;
		for (Gift gi : g.gift_basket ) {	
			if ( gi.price > max )
				continue ;
			if (c.basket.basket_cost + gi.price <= max ) {
				c.basket.basket_cost = c.basket.basket_cost + gi.price;
				if ((gi.type).equalsIgnoreCase("Luxury"))
					doubl_lux = doubl_lux + gi.price ;
				value_sum = value_sum + gi.value;	
			}
			else  	{
				c.basket.basket_cost = c.basket.basket_cost + gi.price;		
		  		writer.println (c.Boy.name + "\t"+ "Gifted "+ "\t"
                                                + gi.name +"----"+ "---To---" + c.Girl.name + "----"
                                                +"of price" + "----" +  gi.price + "\n");

				if ((gi.type).equalsIgnoreCase("Luxury"))
					doubl_lux = doubl_lux + gi.price ;
				value_sum = value_sum + gi.value;
				break;
			}
	  			writer.println (c.Boy.name + "\t"+ "Gifted "+ "\t"
                                                + gi.name +"----"+ "---To---" + c.Girl.name + "----"
                                                +"of price" + "----" +  gi.price +"\n");

		}	
		if ((c.girl_type).equalsIgnoreCase("Choosy") )   // HAPPINESS GIRL 
			c.happiness_boy = c.happiness_girl =(int) ( Math.log (c.basket.basket_cost + doubl_lux )/Math.log(2) ) ;		
		else if ((c.girl_type).equalsIgnoreCase("Normal")) 
			c.happiness_boy = c.happiness_girl = 20 * c.basket.basket_cost + value_sum;  
		else 
			//c.happiness_boy = c.happiness_girl = (int)Math.exp(c.basket.basket_cost);
			c.happiness_boy=  c.happiness_girl = (int) Math.exp(Math.abs(c.basket.basket_cost - c.Girl.maintenance_budget))%100000;

		c.happiness = Math.abs(1 + (c.happiness_boy + c.happiness_girl )%30 ) ;//HAPPINESS GENEROUS BOY 
		c.compatibility = Math.abs((int) (c.basket.basket_cost - c.Boy.budget)) 
			+ Math.abs(c.Boy.attractiveness - c.Girl.attractiveness)+ Math.abs (c.Boy.IQ - c.Girl.IQ) ;

		return c;
	}
	/** Performs giffting by a Geek  boyfriend 
         * calculates the couple's happiness 
         * Geek boy's happiness and his girlfriend's happiness
         * calculates compatibility between them 
         * @param g (Gift_Basket object which has an attribute of gift_basket a list of Gifts )
         * @param c (Associated couple whose compatibility and happiness to be generated ) 
	 * @return (returns a couple object after calculatings its field details(happiness , compatibility )  
        */
	public couple gift_geeks (Gift_Basket g , couple c  ){
		Collections.sort(g.gift_basket  , new Comparator < Gift >() {
				@Override
				public int  compare(Gift o1, Gift o2) {
				if ((o1.type).equalsIgnoreCase("Luxury") )//sort w r t luxury 
				return -1;
				return  1;  //ob1.compareTo(o2)
				}
				});
		int value_sum = 0;
		int doubl_lux = 0;
		int max = (int)c.Boy.budget + 100;
		for (Gift gi : g.gift_basket ) {
			if ( gi.price > max )
				continue ;
			if (c.basket.basket_cost + gi.price <= max )
				if ((gi.type).equalsIgnoreCase("Luxury")){
					doubl_lux = doubl_lux + gi.price ;
					value_sum = value_sum + gi.value;
					c.basket.basket_cost = c.basket.basket_cost + gi.price;
				}
				else    {
					c.basket.basket_cost = c.basket.basket_cost + gi.price;
					writer.println (c.Boy.name+"\t"+"Gifted "+"\t"
							+ gi.name+"\t  "+ " To " + c.Girl.name + "\t" 
							+"of price" + "\t" +  gi.price +"\n" );
					if ((gi.type).equalsIgnoreCase("Luxury"))
						doubl_lux = doubl_lux + gi.price ;
					value_sum = value_sum + gi.value;

					break;
				}
			  writer.println (c.Boy.name + "\t"+ "Gifted "+ "\t"
                                                + gi.name +"----"+ "---To---" + c.Girl.name + "----"
                                                +"of price" + "----" +  gi.price +"\n");

		}
		if ((c.girl_type).equalsIgnoreCase("Choosy") )   // HAPPINESS GIRL 
			c.happiness_girl = (int)Math.abs (( Math.log (c.basket.basket_cost + doubl_lux)/Math.log(2))) ;
		else if ((c.girl_type).equalsIgnoreCase("Normal"))
			c.happiness_girl = 20 * c.basket.basket_cost + value_sum;

		else
			//                       c.happiness_girl = (int) Math.exp(c.basket.basket_cost);
			c.happiness_girl = (int) Math.exp(Math.abs(c.basket.basket_cost - c.Girl.maintenance_budget))%100000;


		c.happiness_boy = c.Girl.IQ;//HAPPINESS GEEK_BOY
		c.happiness = Math.abs ( 1 + (c.happiness_boy + c.happiness_girl)%30) ;
		c.compatibility = Math.abs((int) (c.basket.basket_cost - c.Boy.budget)) 
			+ Math.abs(c.Boy.attractiveness - c.Girl.attractiveness) + Math.abs (c.Boy.IQ - c.Girl.IQ) ;

		return c;
	}
}



