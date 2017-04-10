import java.io.*;
import java.util.*;
public class desperate extends girl {
        String type;
        int happiness;
        public desperate( ) {
                // happiness inherited from couple 
                type = new String("Desperate");

        }
	/**
         * Description of Constructor 
         * @param nam (Girl's  Name)
         * @param attv (Girl's Attractiveness)
         * @param bud (Girl's Maintenance_Budget)
         * @param iq (Girl's IQ Intelligence level )
         * @param cri (Girl Criteria )
         */
        public desperate(String nam, int attv , int iq , float bud , String cri) {
                name = nam;
                attractiveness = attv;
                IQ = iq;
                maintenance_budget = bud;
                criteria = cri;
                isSingle = true ;
                type = new String ("Desperate");
        }
	 /** Sets the happiness of Desperate girl 
         */
	public void set_happiness(  couple c , int double_lux , int value_sum  ) {
                happiness = (int) Math.exp(Math.abs(c.basket.basket_cost - c.Girl.maintenance_budget))%100000;                                  
        }
	/** Returns happiness of Desperate girl 
        */
        public int happines ( ) {

                return happiness;
        }
}

