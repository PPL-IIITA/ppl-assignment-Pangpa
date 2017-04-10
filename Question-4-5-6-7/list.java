import java.io.*;
import java.util.*;
import java.nio.file.*;
/**
 * SubClass of findGirlfriend class 
 * Finding girlfriend using a ArrayList of boys (single and non-single )
 */
public class list extends findGirlfriend {
	ArrayList <HashMap <String , String> > couples= new ArrayList <HashMap <String , String> >() ;
	/**
	 * Override 
	 */
	public list ( ) {
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , "couple.txt");//1st arg directory name relative to current directory 2nd filename
		HashMap <String , String> map  = new HashMap <String, String> ();
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);

				map.put( s[0].trim() , s[1].trim());
				couples.add (map);

			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

	}
	/** Finds and Prints on Standard Output girlfriend names  of boys if exists
	 *  @param boys ( list of boys who are commited to matched with the list of couples stored as a list of HashMap between Boy name (String) 
	 *  and Girl name ( String).
	 */
	public void find_girlfriend (ArrayList <boy> boys ) {
		HashMap <String, String> hash = couples.get(0);// HashMap.values() and HashMap.Keyset() methods 
		boolean flag = false;
		/**
		* GirlFriend list 
		*/
		Set <String> keys = hash.keySet();

		for (boy b: boys ) {
			for (String s : keys ) {
				if (b.name.equals(s) == true ) {
					System.out.println( b.name  + "'s " + " girlfriend  is " + hash.get(s)  +"\n" );
					flag = true; break;
				}

			}
			if (flag == false )
				System.out.println( b.name + "   " + " is Singe \n  ");
			else flag = false;
		}

	}
}

