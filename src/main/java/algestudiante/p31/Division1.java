package algestudiante.p31;

//a=1, b=3, k=1
//complessita: O(n)


public class Division1
{

	static long cont;

	public static boolean rec1 (int n)
	{ 
		if (n<=0) 
			cont++; 
		else
		{ 
			for (int i=1;i<n;i++) cont++ ;  //O(n)    
			rec1 (n/3);
		}
		return true;   
	}

	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
//		int nVeces= Integer.parseInt (arg [0]);
		int nVeces= 10000000; 
		boolean b=true;

		for (int n=10;n<=10_000_000;n*=2) 
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec1 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (" n="+n+ " T="+(t2-t1));
//			System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);
		}  // for
	} // main
} //class