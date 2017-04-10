import java.util.*;
import java.io.*;
import java.nio.file.*;
/** Creates a ArrayList of Gift type objects 
*  Has a basket cost filld
*  Reads Gift items from file gift.txt 
*/
class Gift_Basket 
{
	ArrayList <Gift> gift_basket ;//list  of Gift objects 
	int basket_cost;    
	/** Initialises basket cost to 0
	*/
	public Gift_Basket () {
		gift_basket = new ArrayList <Gift>();
		basket_cost = 0;
	}
	/**Description of constructor 
	 * Reads the gift items available in file gift.txt 
	 *  and creates a list of Gift 
	 * @param file (File Name here is gift.txt)
	 */
	public Gift_Basket(String file ) {
		gift_basket = new ArrayList <Gift>();
		basket_cost = 0;
		Gift g = new Gift();
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , file ); // 1st arg directory name relative to current directory 2nd filename
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);
				try {                               //Object of type gift 
					g  = new Gift (s[0].trim() , Integer.parseInt(s[1].trim()) ,  Integer.parseInt(s[2].trim()), s[3].trim());
					gift_basket.add(g);  // add gift object in gift_basket attibute of object

				} catch ( ArrayIndexOutOfBoundsException  e ) {
					//      e.printStackTrace();
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}		
}
