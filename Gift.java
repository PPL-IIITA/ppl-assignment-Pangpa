import java.util.*;
class Gift {
	String name ;
	int value;
	int  price;	
	String type;
	public Gift () {
		String typ[] = { "Essential" , "Luxury" , "Utility"};
		this.type = typ[ (new Random()).nextInt(typ.length)];		
	}
	public Gift (String nam , int val , int pric , String typ ) {
		name = nam;
		value = val;
		price = pric;
		type = typ;
        }
}
