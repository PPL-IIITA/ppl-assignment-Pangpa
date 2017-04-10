import java.util.*;
import java.io.*;
import java.nio.file.*;
/**
* Defines girls creates initialises list of girls 
*/
public class girl {
	String name;
	int attractiveness;
	int IQ;
	float maintenance_budget;
	String criteria;
	boolean isSingle;
	public girl () { 
	}
	/**
	 * Description of Constructor 
	 * @param nam (Girl Name)
	 * @param attrc (Girl Attractiveness)
	 * @param maint (Girl Maintenance Budget)
	 * @param iq (Girl Intelligence level)
	 * @param cri (Girl Status)
	 */
	public girl (String nam , int attrc , int iq , float maint , String cri ) {
		name = nam;
		attractiveness = attrc;
		IQ = iq;
		maintenance_budget = maint;	
		criteria = cri;
		isSingle = true;
	}	
	/** 
	 * @param file (File Name from girl data to be read )
	 * @param b (temporary girl object to use methods( constructor )  of girl class  to create objects of girls
	 */
	public  ArrayList <girl> getter( String file , girl b  ) {
		ArrayList <girl > list = new ArrayList<>();
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , file ); // 1st arg directory name relative to current directory 2nd filename
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);
				try {
					b = new girl (s[0].trim(),Integer.parseInt(s[1].trim()),
							Integer.parseInt(s[2].trim()),
							Float.parseFloat(s[3].trim()) , s[4].trim());//CREATE GIRL OBJECT      
					list.add(b);//ADD GIRL OBJECT IN LIST 

				} catch ( ArrayIndexOutOfBoundsException  e ) {
					//      e.printStackTrace();
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return list;// GIRL LIST
	}
	/**
	 *  Determines the most Attractive  girl who is still single  among list of girls who are still single 
	 *  @param list (Arraylist of girls )
	 *  @return  (Returns refernce of most attractive girl ) 
	 */
	public girl  most_attractive  (ArrayList<girl>  list ){    // most attractive girl 
		int max = -1;
		girl maxb = new girl() ;///////
		for ( int i = list.size()- 1; i >= 0; i-- ) {
			if ( list.get(i).attractiveness > max && list.get(i).isSingle == true ) {
				max = list.get(i).attractiveness;
				maxb = list.get(i);
			}
		}
		if (max == -1 ) 
			return null;
		return maxb; // reference to most_attractive girl object 
	}

}
