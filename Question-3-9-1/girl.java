import java.io.*;
import java.nio.file.*;
import java.util.*;
public class girl {
	String name;
	int attractiveness;
	int IQ;
	float maintenance_budget;
	String criteria;
	boolean isSingle;
	public girl () { 
	}
	
	public girl (String nam , int attrc , int iq , float maint , String cri ) {
		name = nam;
		attractiveness = attrc;
		IQ = iq;
		maintenance_budget = maint;	
		criteria = cri;
		isSingle = true;
	}
	public void set_happiness (couple c , int a , int b ) {
	}
	public int happines () {
		return 0;	
	}
public  ArrayList <girl> getter( String file , girl b  ) {
		ArrayList <girl > list = new ArrayList<>();
		String split = ",";
		Path path = FileSystems.getDefault().getPath("./" , file ); // 1st arg directory name relative to current directory 2nd filename
		try (BufferedReader reader = Files.newBufferedReader(path )) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String s[ ]  = line.split(split);
				try {
		girl Girls [] = {new choosy(s[0].trim(),Integer.parseInt(s[1].trim()),Integer.parseInt(s[2].trim()),Float.parseFloat(s[3].trim()) , s[4].trim()) ,new normal(s[0].trim(),Integer.parseInt(s[1].trim()),Integer.parseInt(s[2].trim()),Float.parseFloat(s[3].trim()) , s[4].trim()) , new desperate(s[0].trim(),Integer.parseInt(s[1].trim()),Integer.parseInt(s[2].trim()),Float.parseFloat(s[3].trim()) , s[4].trim()) };

		list.add(Girls[(new Random()).nextInt(3)] );//ADD GIRL OBJECT IN LIST

				} catch ( Exception  e ) {
					e.printStackTrace();
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return list;// GIRL LIST 
	}
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
