package algestudiante.p31;


/*
 * O(n^2)
 */


public class Sustraccion2
{

	static long cont;

	public static boolean rec2 (int n)
	{
		if (n<=0) 
			cont++;
		else 
		{ 
			for (int i=0;i<n;i++) cont++; // O(n)
			rec2 (n-1);
			for (int i=0;i<n;i++) cont++; // O(n)
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
		for (int n=1;n<=100_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec2 (n);
			} 

			t2 = System.currentTimeMillis ();
			System.out.println (n+"\t"+(t2-t1));
			//System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);
		}  // for
	} // main
} //class