import java.util.*;
import java.io.*;
public class patch_girls extends breakup {
	ArrayList <couple> new_couples;
	public patch_girls () {// cb list contains newly broke up boys
		new_couples = new ArrayList < >();
		boolean flag = false;
		int i = 0;
		boy temp = new boy();
		couple new_couple ;
		int ctr = 0; // upto k girls to patch up
		for (couple c: gifted ) {
			for (boy b : cb)  {
				if (b.budget < c.Girl.maintenance_budget || b.requirement >= c.Girl.attractiveness|| b.isSingle == false)
					continue;
				try {
					if((c.Girl.criteria).equalsIgnoreCase("Intelligent") == true ){
						temp = b.most_intelligent ( cb); //ret refernce to most_Iq boy from list br.cb of boys 
						flag = true;
					}
					else if ((c.Girl.criteria).equalsIgnoreCase("Attractive") == true ) {
						temp = b.most_attractive ( cb);
						flag = true;
					}
					else if ((c.Girl.criteria).equals("Rich")== true){
						temp = b.most_rich (cb);
						flag = true;
					}
					if (flag == true && (temp != null )) {
						temp.isSingle = false;					
						new_couple  = new couple (temp , c.Girl );
						new_couples.add(new_couple );
					
						change_status(c.Boy.name , cb);//broke up boy "named c.Boy.mane now availble for patch anothr girl
						flag = false;
						break;  //
					}
					else {    // girl not got boy according to her choice now she lower the expectations 
						int k;
						while(true ) {
							k = (new Random() ).nextInt(cb.size());
							if(cb.get(k).isSingle == true) {
								new_couples.add(new couple(cb.get(k) , c.Girl));
								cb.get(k).isSingle= false;
								c.Girl.isSingle = false;
								break;
							}
						}
					}
				} catch ( Exception e ) {
					e.printStackTrace();	
				}
			}
			i++;
			if(++ctr == count)  //k girls to patch
				break;
			
		}
	}	
	void change_status ( String name , ArrayList<boy> boys) {  // change status of broke up boy to single 
		int i=0;
		for( boy b: boys) {
			if ((b.name).equals(name) == true)
				boys.get(i).isSingle = true;
			i++;
		}
	}

}

