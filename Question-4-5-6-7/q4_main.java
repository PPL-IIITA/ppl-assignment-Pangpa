public class q4_main {
	 /**
         * Main Function
         * @param args (java.lang.String)
         * @throws IOException (java.io.IOException)
         */
	public static void main(String args[] ) {

		breakup b = new breakup();  //perform breakup 
		patch_girls p = new patch_girls ();	//patch_up girls

		System.out.println("\nNew Coples\n ");

		for(couple n: p.new_couples) {
			System.out.printf("%-12s %-12s \n",  n.Boy.name , n.Girl.name  );	

		}
	}
}
