import java.util.*;
import java.io.*;
/** A generic Data structure to return random value of type    T   From a list of that type T 
 *  Random Generator of Question 10
*/
public class random < T > {

        private T t;

        public T get( ){
                return this.t;
        }

        public T get( ArrayList< T > list ){
		return list.get((new Random()).nextInt(list.size())); 
        }
	public static void main(String args[] ) {

		random  < boy >  type = new random <boy> () ;
		ArrayList <boy> boys = (new boy () ).getter ("boy.txt" , new boy() );
		System.out.println(type.get(boys).name );
	}	
}
   
