import java.util.*;
import java.io.*;
/**
* 	READS boy.txt AND girl.txt AND CREATES couples as an attribute of allocator class (ie  itself ) and writes couples to couples.txt
*/
public class allocator 
{
	ArrayList <couple> couples;      

	public allocator ( )  {
		boy br = new boy();
		ArrayList <boy> boys = br.getter( "boy.txt"  , br);
		girl g = new girl();
		ArrayList <girl> girls = g.getter( "girl.txt" , g);
		couples = new ArrayList < >();
		couple c;
		boolean flag = false;
		boy temp = new boy();
		boy choose = new boy() ;	
		for (girl gi : girls ) {
			for (boy b : boys ) {
				if (b.budget < gi.maintenance_budget || b.requirement >= gi.attractiveness  || b.isSingle == false ) 
					continue;
				try {
					if ((gi.criteria).equalsIgnoreCase("Intelligent")== true ) {
						choose = temp.most_intelligent (boys);
						//System.out.println(choose.getClass().toString());
						flag = true;
					}
					else if ((gi.criteria).equalsIgnoreCase("Attractive")== true ) {
						choose = b.most_attractive (boys);
						flag = true;
					}
					else if ((gi.criteria).equalsIgnoreCase("Rich")== true ){
						choose  = b.most_rich(boys);
						flag = true;
					}
					if (flag == true && (choose != null)) {
						c = new couple(choose  , gi );
						couples.add(c);
						choose.isSingle = false;
						gi.isSingle = false;
						flag = false;
						break; //girls.remove(girls.indexOf(gi)); 
					}
				}catch( Exception e ) {
					e.printStackTrace();
				}
			}
		}
		write_couple ("couple.txt" , couples);

	}
	/** Saving The Couple Details To A File Couple.txt  
	* For later use 
	* @param file (Filename to write couple details ie couple.txt) 
	* @param couples ( list of couples) 
	*/
	public static void write_couple  ( String file , ArrayList <couple> couples ) {
		try {	
			PrintWriter writer  = new PrintWriter (file ,  "UTF-8");

			for (couple c : couples ){ 

				writer.println (c.Boy.name + " , " + c.Girl.name  );//boy name, girl name , boy-type , girl-type
			}
			writer.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	} 
}


