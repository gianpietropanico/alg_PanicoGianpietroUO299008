package algestudiante.p31;

/*
 *  método recursivo POR DIVISIÓN con una complejidad O(n^2) y el número de subproblemas = 4.
 * entonces: a=4, b=4, k=2
 * ==> 4<4^2 ==> O(n^2)    
 */


public class Division4 {
	
	static long cont;

	
 public static boolean rec4 (int n) {
		
		if (n<=0) 
			cont++;
		else { 
			for(int i = 1; i < n; i++) {
				for(int j = 1; j < n; j++) {
					cont++;
				}
			}
			
			rec4(n/4);
			rec4(n/4);
			rec4(n/4);
			rec4(n/4);
		}
		return true;   
	}
	
 @SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		//int nVeces= Integer.parseInt (arg [0]);
		int nVeces= 100000;
		boolean b=true;
		System.out.println ("n   \tTiempo");
		for (int n=1;n<=10_000_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec4 (n);
			} 

			t2 = System.currentTimeMillis ();
			System.out.println (n+"\t"+(t2-t1));
			//System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);

		}  // for

	} // main
} //class