import java.util.*;
import java.nio.file.*;
import java.io.*;
class q1_main {
	public static void main (String args[] ) {
		FileWriter writer;
		allocator a = new allocator(); //a has attribute ArrayList <couples> of all couples assignes according to condition 
		for (couple c : a.couples) { 
			System.out.println(" Couples Asigned :" + "\t" + c.Boy.name + "\t" + c.Girl.name);
			try {
				String s = " Couples Asigned :" + "\t" + c.Boy.name + "\t" + c.Girl.name +"\n";
				Files.write(Paths.get("log.txt"), s.getBytes(), StandardOpenOption.APPEND);
				
			}catch (IOException e) {
				//exception handling left as an exercise for the reader
			}
			



		}
		//	writer.close();
	}
}
