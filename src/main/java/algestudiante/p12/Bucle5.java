package algestudiante.p12;

public class Bucle5 {

	public static long bucle4(int n) //O(n^3logn)
	{
		long cont = 0;
		for (int i = 0; i <= n*n*n; i++)
			for (int j = 1; j <= n; j*=2)
				cont++;
		return cont;
	}
	
	public static void main(String arg[]) {
		long t1, t2;
		int limite = 1000;
		System.out.println("n\ttiempo\tcontador");

		for (int n = 8; n <= 100000; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {
				c += bucle4(n);
			}
			
			t2 = System.currentTimeMillis();

			System.out.println(n+"\t"+(t2-t1)+"\t"+c);
		} // for
			
	} // main
} // class