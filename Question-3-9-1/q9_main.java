public class q9_main  {
		
	   public static void main ( String args[] ) {
                couple_q9 a = new couple_q9() ;
                for( couple n: a.couples ) {
System.out.printf("\n%-15s  %-15s  %-15s  %-15s  %-15d %-15d\n",n.Boy.name,n.Girl.name,n.Boy.getClass(),n.Girl.getClass(),n.happiness,n.compatibility );
		}
        }
}

