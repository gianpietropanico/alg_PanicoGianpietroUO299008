package algestudiante.p12;

public class Bucle4 {

	public static long bucle2(int n) //O(nquadro)
	{
		long cont = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				cont++;
		return cont;
	}
	
	public static void main(String arg[]) {
		long t1, t2;
		int limite = Integer.parseInt(arg[0]);

		for (int n = 512; n <= 100000; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {
				c += bucle2(n);
			}
			
			t2 = System.currentTimeMillis();

			System.out.println(c + "**n=" + n + "**TIEMPO=" + (t2 - t1)
					+ "**nVeces=" + limite);
		} // for
			
	} // main
} // class