import java.io.*;
import java.util.*;
import java.nio.file.*;
/**
* SubClass of findGirlfriend class 
* Finding girlfriend using Binary Search on  boys (single and non-single ) Array 
*/
public class sorted  extends findGirlfriend{
	String boyname;
	String girlname;

	ArrayList<sorted> couples = new ArrayList <sorted> () ;
	public sorted( String bn , String gn ) {
		boyname = bn;
		girlname = gn;
	}
	public sorted ( ) {
			
		String split = ",";
                Path path = FileSystems.getDefault().getPath("./" , "couple.txt");//1st arg directory name relative to current directory 2nd filename
                
		couples = new ArrayList <sorted> () ;

                try (BufferedReader reader = Files.newBufferedReader(path )) {
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                                String s[ ]  = line.split(split);

                                couples.add(new sorted( s[0].trim() , s[1].trim())) ;

                        }
                } catch (IOException x) {
                        System.err.format("IOException: %s%n", x);
                }
		
	}
	 /**
        *   override abstract method 
	* @param boys (list of boys whose girlfriens to be found
        */ 
	public void find_girlfriend(ArrayList <boy> boys ) {
		String Boys[] = new String[couples.size()]; // list of commited boys 
		int i = 0;
		for(sorted s : couples) {
			Boys[i++] = s.boyname;
		}
		Collections.sort(couples , new Comparator < sorted >() {
                                @Override
                                public int  compare(sorted o1, sorted o2) {
                                return (int) ( o2.boyname.compareTo(o1.boyname) ) ;  //ob1.compareTo(o2)
                                }
                 });
		i = 0 ;//as iterator;
		boolean flag = false ;
		for( boy b : boys ) {
				//If commited boy 
			if( ( i = binary_search (Boys , b.name , couples.size() ) ) != -1  )  {
                        	System.out.println( b.name  + "'s " + " girlfriend  is " + couples.get(i).girlname   +"\n" );
                                	flag = true; 
					i++;
               		}
                        if (flag == false )
                                System.out.println( b.name + "   " + " is Singe \n  ");
                        else flag = false;

		}
	}
	/** Returns index where boyname boy is found or -1 if not found
	* @param boys (list of commited boys)
	* @return (returns index  in  boys ) 
	*/
	public int binary_search ( String boys [] , String boyname , int n  ) {
		int l = 0 , h = n - 1;
		int mid = (l + h ) / 2 ;
							//Arrays.sort(boys);		
		while( l <= h) {
			if ( boys[mid].equals(boyname) )
				return mid; // index
		 	if ( boys[mid].compareTo (boyname) < 0) // mid < search
				l = mid + 1;
			else 
				h = mid - 1;
			mid = ( l + h) / 2;
		}
		return -1;
	}


}
