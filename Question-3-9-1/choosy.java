import java.io.*;
import java.util.*;
public class choosy extends girl {
        String type;
        int happiness;
        public choosy  ( ) {
                // happiness inherited from couple 
                type = new String("Choosy");

        }
	/**
         * Description of Constructor 
         * @param nam (Girl's  Name)
         * @param attv (Girl's Attractiveness)
         * @param bud (Girl's Maintenance_Budget)
         * @param iq (Girl's IQ Intelligence level )
         * @param cri (Girl Criteria )
         */
        public choosy (String nam, int attv , int iq , float bud , String cri) {
                name = nam;
                attractiveness = attv;
                IQ = iq;
                maintenance_budget = bud;
                criteria = cri;
                isSingle = true ;
                type = new String ("Choosy");
        }
	 /** Sets the happiness of Choosy girl 
         */
	public void set_happiness(  couple c , int doubl_lux , int value_sum  ) {
                happiness = (int) ( Math.log (c.basket.basket_cost + doubl_lux )/ Math.log(2) );
        }
	/** Returns happiness of choosy girl 
        */
        public int happines ( ) {

                return happiness;
        }
}

