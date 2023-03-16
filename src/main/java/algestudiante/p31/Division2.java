package algestudiante.p31;


//a=2, b=2, k=1
//complessita: O(nlogn)


public class Division2
{

	static long cont;

	public static boolean rec2 (int n)
	{
		if (n<=0) cont++;
		else
		{ 
			for (int i=1;i<n;i++) cont++ ;    
			rec2 (n/2);
			rec2 (n/2);
		}   
		return true;
	}
	
	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		//int nVeces= Integer.parseInt (arg [0]);
		int nVeces= 1000000;
		boolean b=true;
		System.out.println ("n   \tTiempo");
		for (int n=1;n<=10_000_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec2 (n);
			} 

			t2 = System.currentTimeMillis ();
			
			System.out.println (n+"\t"+(t2-t1));
			//System.out.println(b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);
		}  // for
	} // main
} //class