import java.io.*;
import java.util.*;
import java.nio.file.*;
/**
 * SubClass of findGirlfriend class 
 * Finding girlfriend using a Hashtable  of boys and girls which are commited and ArrayList of boys (single and non Single )
 * Creates a Hashtable of couples
 */
public class hashTable extends findGirlfriend  {

	Hashtable < String, String > table = new Hashtable < String , String >() ;
	/**
	 * Override 
	 */
	public hashTable ( ) {
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , "couple.txt");//1st arg directory name relative to current directory 2nd filename
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);

				table.put( s[0].trim() , s[1].trim());			                          

			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	/**Prints status of boys if commited prints thir girlfriends name 
	 * key is boy name 
	 * value of key if name of Girl (girlfriend) 
	 * Finds and Prints on Standard Output girlfriend names  of boys if exists
         *  @param boys ( list of boys who are commited to matched with the list of couples stored as a Hashtable (key = boyname , value = Girl name)
         */
	public void find_girlfriend (ArrayList <boy> boys  ) {
		Set <String> keys = table.keySet();
		boolean flag = false;
		for ( boy b : boys ) {
			for( String s : keys ) {
				//hashtable.get( key ) 
				if (b.name.equals(s) == true ) {
					System.out.println( b.name  + "'s " + " girlfriend  is " +  table.get(s) +"\n" );
					flag = true; break;
				}
			}
			if (flag == false )
				System.out.println( b.name + "   " + " is Singe \n  ");
			else flag = false;
		}
	}

	
}

