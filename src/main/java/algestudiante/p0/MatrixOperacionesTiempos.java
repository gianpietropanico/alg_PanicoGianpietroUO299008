package algestudiante.p0;


public class MatrixOperacionesTiempos {

	public static void main(String[] args) {

		long t1, t2;
		int limite = 10000000;

		System.out.println("n\tt");
		for (int n = 3; n < 100000; n *= 2) {
			// el tamaño de la matriz debe variar con el índice n, sino NO hay cambio real del tamaño del problema
			MatrizOperaciones matrizOperaciones = new MatrizOperaciones(n, 1, 5);
			t1 = System.currentTimeMillis();
			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
				matrizOperaciones.sumarDiagonal1();
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + +(t2 - t1));
		}
		System.out.println();
		System.out.println("n\tt");
		for (int n = 3; n < 100000; n *= 2) {
			MatrizOperaciones matrizOperaciones = new MatrizOperaciones(n, 1, 5);
			t1 = System.currentTimeMillis();
			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
				matrizOperaciones.sumarDiagonal2();
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + +(t2 - t1));
		}

	}
}
