package algestudiante.p31;

/*
 * método recursivo POR SUSTRACCION con una complejidad O(3^n/2).
 * para obtenerla debemos: a=3, b=2, k=0
 * a>1 ==> O(3^n/2)
 */

public class Sustraccion4
{

	static long cont;

	public static boolean rec4 (int n)
	{
		if (n<=0) 
			cont++;
		else
		{
			cont++;   // O(1)    
			rec4 (n-2);
			rec4 (n-2);
			rec4 (n-2);
		}
		return true;   
	}

	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		//int nVeces= Integer.parseInt (arg [0]);
		int nVeces = 10000000;
		boolean b=true; 
		System.out.println ("n   \tTiempo");
		for (int n=1;n<=100;n++)
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