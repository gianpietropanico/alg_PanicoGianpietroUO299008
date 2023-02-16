package algestudiante.p12;

public class Bucle1 {

	public static long bucle1(int n) //O(nlogn)
	{
		long cont = 0;
		for (int i = 1; i <= n; i++) //O(n)
			for (int j = 1; j <= n; j *= 2) //O(logn)
				cont++; //O(1)
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2;
		int limite = Integer.parseInt(arg[0]);

		System.out.println("n\ttiempo\tcontador");
		for (int n = 8; n <= 100000; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {
				c += bucle1(n);
			}
				
			t2 = System.currentTimeMillis();
			
			System.out.println(n+"\t"+(t2-t1)+"\t"+c);

		} // for

	} // main
} // class


// : ¿cumplen los valores obtenidos con lo esperado?, si perche’ la complessita’ rispecchia quella del códice. 
//Se l’algoritmo ci mette piu di dieci minuti lo scrivo nella tabella 
