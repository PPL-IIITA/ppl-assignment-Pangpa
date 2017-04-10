import java.util.*;
import java.io.*;
import java.nio.file.*;
public class boy   // happiness is inherited from couple 
{
	String name;
	int attractiveness;
	int IQ;                  
	float budget;
	int requirement;//minimum attactiveness req from girl  
	boolean isSingle;
	
	public couple gift (Gift_Basket b , couple c ,PrintWriter w){ // never executed 
		return null;
	}
	public int happines(){
		return 0;
	}
	public boy(){
	} 
	public  ArrayList <boy> getter( String file , boy b  ) {
		ArrayList <boy > list = new ArrayList<>();
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , file ); // 1st arg directory name relative to current directory 2nd filename
								
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);
				try {				//CREATE BOY OBJECT b
					
boy Boys []  = { new miser (s[0].trim() , Integer.parseInt(s[1].trim()) ,Integer.parseInt(s[2].trim()) ,Float.parseFloat(s[3].trim()),Integer.parseInt(s[4].trim()) ) , (new generous (s[0].trim() , Integer.parseInt(s[1].trim()) ,                                                                                   Integer.parseInt(s[2].trim()) , Float.parseFloat(s[3].trim()), Integer.parseInt(s[4].trim()) )),(new geeks (s[0].trim() , Integer.parseInt(s[1].trim()) , Integer.parseInt(s[2].trim()) , Float.parseFloat(s[3].trim()), Integer.parseInt(s[4].trim()) ) ) };				         				                          
					
				list.add(Boys[ (new Random()).nextInt(3)]); //add boy object in list 
				 		

				} catch (Exception  e ) {
					e.printStackTrace();
				}
			}
		} catch (Exception x) {
			x.printStackTrace() ;
		}
		
		return list;// BOY LISt 
	}
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
		return maxr; //reference to most ricg boy object 
	}
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
