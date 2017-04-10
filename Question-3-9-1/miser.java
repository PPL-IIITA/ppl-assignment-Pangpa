import java.io.*;
import java.util.*;
public class miser extends boy {
        String type;
	int happiness; 
        public miser ( ) {
                // happiness inherited from couple 
		type = new String("Miser");		
        }
	/**
         * Description of Constructor 
         * @param nam (Boy Name)
         * @param attr (Boy Attractiveness)
         * @param bud (Boy's Budget)
         * @param iq (Boy IQ Intelligence level )
         * @param requ (Boy requirement )
         */
  	public miser  (String nam, int attv , int iq , float bud , int requ) {
                name = nam;
                attractiveness = attv;
                IQ = iq;
                budget = bud;
                requirement = requ;
                isSingle = true ;
		type = new String ("Miser");
        }
	/** 
	* @return (happiness of miser boy)
	*/
	public int happines ( ) {

		return happiness;		
	}
	/** Gifting performed by a miser  boyfriend 
         *  @param g (Gift basket which has a attribute gift_basket ie a lisyt of gifts and their details )
         *  @param c ( Associated couple object to store happiness , compatinbility ) 
         *  @param writer (PrintWriter object to store the logs in log.txt).
         * @return (Returns couple object Reference after setting associated couple object's  field 
        */
	public couple gift ( Gift_Basket g , couple c , PrintWriter writer ){	
		Collections.sort(g.gift_basket  , new Comparator < Gift >() {@Override  // SORT BASKET AS PRICE INCREASING ORDER 
				public int  compare(Gift o1, Gift o2) {
				return (int)(o1.price  - (o2.price));  //ob1.compareTo(o2)
				}});
		int value_sum = 0;
		int doubl_lux = 0;
		int max = (int) c.Boy.budget + 100;	//gift price sum 
		int increase = 0;
		c.basket.basket_cost = 0;	
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
	
		happiness  = Math.abs( (int)c.Boy.budget - c.basket.basket_cost) ;//HAPPINESS BOY
		c.Girl.set_happiness ( c , doubl_lux ,   value_sum );  	
		return c;
	}		

}
