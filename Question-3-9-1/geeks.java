import java.io.*;
import java.util.*;
/** 
 * Data associated with miser boy 
 * method to perform gifing by him 
 */
public class geeks extends boy {
        String type;
	int happiness;
	/**One of the Constructor of class 
	*/
        public geeks( ) {
                type = new String("Geeks");
        }
	/**
         * Description of Constructor 
         * @param nam (Geek Boy Name)
         * @param attr (Geek Boy Attractiveness)
         * @param bud (Geek Boy's Budget)
         * @param iq (Geek Boy IQ Intelligence level )
         * @param requ (Geek Boy requirement )
         */
        public geeks (String nam, int attv , int iq , float bud , int requ) {
                name = nam;
                attractiveness = attv;
                IQ = iq;
                budget = bud;
                requirement = requ;
                isSingle = true ;
                type = new String ("Geeks");
        }
	/** Returns happiness of Geek boy 
	 *@return ( happiness of geek boy) 
	*/
	public int happines() {
		return happiness;
	}
	/** Gifting performed by a geek boyfriend 
	 *  @param g (Gift basket which has a attribute gift_basket ie a lisyt of gifts and their details )
	 *  @param c ( Associated couple object to store happiness , compatinbility ) 
	 *  @param writer (PrintWriter object to store the logs in log.txt).
	 * @return (Returns couple object Reference after setting associated couple object's  field 
	*/
	public couple gift (Gift_Basket g , couple c , PrintWriter writer   ){
		Collections.sort(g.gift_basket  , new Comparator < Gift >() {
		@Override public int  compare(Gift o1, Gift o2) {if ((o1.type).equalsIgnoreCase("Luxury") )//sort w r t luxury 
		return -1;return  1;  //ob1.compareTo(o2)
		} });
		int value_sum = 0;
		int doubl_lux = 0;
		int max = (int)c.Boy.budget + 100;
		
		c.basket.basket_cost = 0;		 

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
		c.happiness  = c.Girl.IQ;//HAPPINESS GEEK_BOY
		c.Girl.set_happiness ( c , doubl_lux ,   value_sum );

		return c;
	}
}
 
