import java.util.*;
import java.io.*;
import java.nio.file.*;
/**
* Defines boy creates initialises list of boys
*/
public class boy 
{
	String name;
	int attractiveness;
	int IQ;
	float budget;
	int requirement;//minimum attactiveness req from girl  
	boolean isSingle;
	public boy() {
	}
	/**
         * Description of Constructor 
         * @param nam (Boy Name)
         * @param attv (Boy Attractiveness)
         * @param bud (Boy's Budget)
         * @param iq (Boy IQ Intelligence level )
         * @param requ (Boy requirement )
         */
	public boy (String nam, int attv , int iq , float bud , int requ) {
		name = nam;
		attractiveness = attv;
		IQ = iq;
		budget = bud;
		requirement = requ;
		isSingle = true ;
	}
	 /** 
         * @param file (File Name from boys data to be read )
         * @param b (temporary boy object to use methods( constructor )  of boy class  to create objects of boys
         */
	public  ArrayList <boy> getter( String file , boy b  ) {
		ArrayList <boy > list = new ArrayList<>();
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , file ); // 1st arg directory name relative to current directory 2nd filename
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);
				try {				//CREATE BOY OBJECT b
					b = new boy (s[0].trim() , Integer.parseInt(s[1].trim()) , 
						Integer.parseInt(s[2].trim()) , Float.parseFloat(s[3].trim()), Integer.parseInt(s[4].trim()) );    
							         				                          
					list.add(b); //add boy object in list 

				} catch ( ArrayIndexOutOfBoundsException  e ) {
					//      e.printStackTrace();
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return list; //BOY list 
	}
	/**
         *  Determines the most Attractive  boy  who is still single  among list of boys who are still single 
         *  @param list (Arraylist of boys )
         *  @return  (Returns refernce of most attractive boy ) 
         */
	public boy  most_attractive  (ArrayList<boy>  list ){    // most attractive boy 
		int max = -1;
		boy maxb = new boy() ;///////
		for ( int i = list.size()- 1; i >= 0; i-- ) {
			if ( list.get(i).attractiveness > max && list.get(i).isSingle == true ) {
				max = list.get(i).attractiveness;
				maxb = list.get(i);
			}
		}
		if (max == -1 ) 
			return null;
		return maxb; // reference to most_attractive boy object 
	}
	 /**
         *  Determines the most Rich  boy avialable  who is still single  among list of boys who are still single 
         *  @param list (Arraylist of boys )
         *  @return  (Returns refernce of most rich  boy  avialable ) 
         */
	public boy  most_rich  (ArrayList<boy>  list ){    //most rich boy
		float max = -1 ;
		boy maxr = new boy();
		for ( int i = list.size()- 2; i >= 0; i-- ) {
			if ( list.get(i).budget > max && list.get(i).isSingle == true ) {
				max = list.get(i).budget;
				maxr = list.get(i);
			}
		}
		if (max == -1) 	
			return null;
		return maxr; //reference to most rich boy object 
	}
	  /**
         *  Determines the most Intelligent boy  who is still single  among list of boys who are still single 
         *  @param list (Arraylist of boys )
         *  @return  (Returns refernce of most intelligent boy ) 
         */

	public boy  most_intelligent  (ArrayList<boy>  list ){    //most intelligent boy 
		int max = 0;
		boy maxr = new boy();
		for ( int i = list.size()- 2; i >= 0; i-- ) {
			if ( list.get(i).IQ > max && list.get(i).isSingle == true ) {
				max = list.get(i).IQ;
				maxr = list.get(i);
			}
		}
		if (max == 0)
			return null;
		return maxr;// reference to most intelligent boy 
	}
}
