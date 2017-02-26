import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;
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

}
