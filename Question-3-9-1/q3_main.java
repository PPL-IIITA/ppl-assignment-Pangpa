import java.util.*;
import java.io.*;
public class q3_main {
	public static void main(String args[] ) {
		couple c = new couple();
		ArrayList <couple> gifted = c.get_couples( ) ;	
		for(couple n : gifted) {
	
System.out.printf("%-15s  %-15s  %-15s  %-15s  %-15d %-15d\n",n.Boy.name,n.Girl.name,n.Boy.getClass(),n.Girl.getClass(),n.happiness,n.compatibility );
		}
	}
}
