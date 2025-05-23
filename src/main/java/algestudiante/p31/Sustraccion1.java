package algestudiante.p31;

/*
 * a=1, b=1, k=0 ==> O(n)
 * 
 */

public class Sustraccion1
{

	static long cont;

	public static boolean rec1 (int n)
	{
		if (n<=0) 
			cont++;
		else 
		{ 
			cont++;  // O(1)=O(n^0)
			rec1 (n-1);
		}
		return true;   
	}

	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
//		int nVeces= Integer.parseInt (arg [0]);
		int nVeces= 100000;
		boolean b=true;
		System.out.println ("n   \tTiempo");
		for (int n=10;n<=100_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec1 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (n+"\t"+(t2-t1));

			//System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);
		}  // for
	} // main
} //class