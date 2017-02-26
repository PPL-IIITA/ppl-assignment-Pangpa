import java.util.*;
import java.io.*;
import java.nio.file.*;
class Gift_Basket 
{
	ArrayList <Gift> gift_basket ;//list  of Gift objects 
	int basket_cost;    
	public Gift_Basket () {
		gift_basket = new ArrayList <Gift>();
		basket_cost = 0;
	}
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
