import java.util.*;
import java.io.*;

public class q7_main  {
	public static void main(String args[] ) {
		Scanner s = new Scanner (System.in);
		ArrayList <boy> boys = (new boy() ).getter ("boy.txt" , new boy() );
		int choice;		
		findGirlfriend h;
		System.out.println("\n Enter choice 1 Hashtable 2 . ArrayList 3.Binary Search  else random" );
		choice = s.nextInt();
		
		if(choice == 1) 
			h = new hashTable();
		else if( choice  == 2) 
			h = new list( );
		else if( choice  == 3) 
			h = new sorted () ;
		else {
			findGirlfriend list[] = { new hashTable() , new list() , new sorted () };
				
			h = list[ (new Random () ).nextInt(3)];
		}
		h.find_girlfriend( boys);		
	}
}
