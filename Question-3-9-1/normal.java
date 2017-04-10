import java.io.*;
import java.util.*;
public class normal extends girl {
        String type;
        int happiness;
        public normal ( ) {
                // happiness inherited from couple 
                type = new String("Normal");

        }
	/**
         * Description of Constructor 
         * @param nam (Girl's  Name)
         * @param attv (Girl's Attractiveness)
         * @param bud (Girl's Maintenance_Budget)
         * @param iq (Girl's IQ Intelligence level )
         * @param cri (Girl Criteria )
         */
        public normal (String nam, int attv , int iq , float bud , String cri) {
                name = nam;
                attractiveness = attv;
                IQ = iq;
                maintenance_budget = bud;
                criteria = cri;
                isSingle = true ;
                type = new String ("Normal");
        }
	/** Sets the happiness of Normal girl 
	 */
	public void set_happiness(  couple c , int double_lux , int value_sum  ) {
		happiness = (5 * c.basket.basket_cost + value_sum )% 1000;  
	}
	/** Returns happiness of normal girl 
	*/
        public int happines ( ) {
		
                return happiness;
        }
}

