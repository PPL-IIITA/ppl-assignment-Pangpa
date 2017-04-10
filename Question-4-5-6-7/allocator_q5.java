import java.util.*;
import java.io.*;
import java.nio.file.*;
public class allocator_q5 {
	ArrayList <couple> couples;// new couples 
	public allocator_q5 () {
		boy br = new boy();
		ArrayList <boy> boys = br.getter( "boy.txt"  , br);
		girl g = new girl();
		ArrayList <girl> girls = g.getter( "girl.txt" , g);
		couples = new ArrayList < >();
		couple c ;
		
		Collections.sort(boys  , new Comparator < boy >() {
				@Override
				public int  compare(boy o1, boy o2) {
				return (int)(o2.attractiveness - (o1.attractiveness));  //ob1.compareTo(o2)
				}
				});
		Collections.sort(girls  , new Comparator < girl >() {
				@Override
				public int  compare(girl o1, girl o2) {
				return (int)(o2.maintenance_budget - (o1.maintenance_budget));  //ob1.compareTo(o2)
				}
				});
		int i = 0 , j = 0;
		boy temp = new boy();
		girl Girl = new girl();
		boolean limit = true , flag = false;
		while (limit == true ) {
			try {	
				if( girls.get(j).isSingle == true) {
					if ((girls.get(j)).criteria.equalsIgnoreCase("Intelligent")== true ) {
						temp = boys.get(i).most_intelligent (boys);
						flag = true;
					}
					else if ((girls.get(j)).criteria.equalsIgnoreCase("Attractive")== true ) {
						temp = boys.get(i).most_attractive (boys);
						flag = true;
					}
					else if ((girls.get(j)).criteria.equalsIgnoreCase("Rich")== true ){
						temp = boys.get(i).most_rich(boys);  //temp.
						flag = true;
					}
					if (flag == true && (temp != null)) {
						c = new couple(temp  , girls.get(j) );
						couples.add(c);
						temp.isSingle = false;
						temp = null;
						girls.get(j).isSingle = false;
					}
				}
			}catch( Exception e ) {
				e.printStackTrace();
			}
			try { if(boys.get(i).isSingle == true){
				Girl = girls.get(j).most_attractive(girls);
				if(Girl != null) {
					Girl.isSingle= false;
					c = new couple (boys.get(i) , Girl);
					couples.add(c);
					boys.get(i).isSingle = false;

				}
			}
			}catch (Exception e ) {
				e.printStackTrace();
			}
			i++;
			if(flag == true ){  //girl is patched
				j++;
				flag = false ;	
			}
			if  ( (i >= boys.size())  || (j >= girls.size() ))
				limit = false;

		}
		Path path = FileSystems.getDefault().getPath("./" , "couple.txt" ); //1st arg directory name relative to current directory2nd filename
		try { 
			BufferedWriter buff = Files.newBufferedWriter(path );
			PrintWriter writer  = new PrintWriter ( buff );//object of bufferedwriter to printerwriter
			for (couple n : couples) {     			 
				writer.println(n.Boy.name + " , " +  n.Girl.name+" , " + n.boy_type +" , " +n.girl_type );        /// Writing couple details in couple.txt 
				System.out.println(" Couples Asigned :" + "\t" + n.Boy.name + "\t" + n.Girl.name);
			}
			writer.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		couples  = gift_couples (couples );  // Gift newly formed couples //couple list replaced by gifted couples
		int k = (new Random()).nextInt(couples.size() - 2 ) + 2;
		Collections.sort(couples   , new Comparator < couple >() {
                                @Override
                                public int  compare(couple o1, couple o2) {
                                return (int)(o2.happiness - (o1.happiness));  //ob1.compareTo(o2)
                                }
                 });
		System.out.println( "\n" + k + "  Most Happiest Couples \n");
		try {
System.out.printf("%-12s %-12s %-12s %-12s %-12s \n\n" , "Boy Name", "Girl Name"  , "Gift-Basket" , "Boy-Type" , "Happiness" );
 
			for (couple n: couples){
				if (k-- <= 0 ) 	
					break;
System.out.printf("%-12s %-12s %-12d %-12s %-12d \n" , n.Boy.name , n.Girl.name , n.basket.basket_cost , n.boy_type , n.happiness );
			}
		} catch(Exception e) { 	
			e.printStackTrace();
		}

	}
	/**Gift Allocator For Newly formed couples
	*/
	public ArrayList <couple> gift_couples(ArrayList <couple> couples  ) {
		ArrayList <couple> gifted = new ArrayList < couple >();
		Gift_Basket basket = new Gift_Basket("gift.txt");//ArrayList<gift>gift_basket attribute in basket object from gift.txt file 
		giffter g = new giffter(5) ;
		for (couple c : couples) {
			if ((c.boy_type).equalsIgnoreCase("Miser")== true ) {
				gifted.add ( g.gift_miser (basket , c ));		//Replace ?
			}
			else if ((c.boy_type).equalsIgnoreCase("Generous")== true ) {
				gifted.add ( g.gift_generous (basket , c ));   
			}	
			else 
				gifted.add ( g.gift_geeks(basket , c ));
		}
		return gifted; //gifted couple list 	
	}
}           













