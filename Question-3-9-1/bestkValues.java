import java.util.*;
import java.io.*;
/** This is data structure of question 9 
*  Returns a list of best k values 
*  Value passed should be sorted according to required criteria
*/
public class bestkValues < T > {

        private T t;

        public T get( ){
                return this.t;
        }

        public ArrayList< T >  get( ArrayList< T > list , int k ){
		ArrayList < T > bestk = new ArrayList < T > () ;
		for(int i = 0; i < k; i++ ) {
			/**
			* get top k valued from list of type T 
			*/
			bestk.add ( list.get(i) );
		}
		
		return bestk;
        }

	
}
   
