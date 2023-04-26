package algestudiante.p6;

public class ViajanteTiemposBK {

		private int[][] grafoCaminos;
		ViajanteBK viajante = new ViajanteBK(grafoCaminos);

		long t1, t2;
		

		public static void main(String[] args) {
			final int MAX_VALUE = 200_000;
			long limite = 5;

			System.out.println("n   \tTiempo");
		

			for (int n = 10; n < MAX_VALUE; n ++) {
				ViajanteBK problem = new ViajanteBK(n);
				long t1 = System.currentTimeMillis();
				for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {

					problem.calcularCiclo(0);
				}
				
				long t2 = System.currentTimeMillis();
				System.out.println(n + "\t" + (t2 - t1));
			}

			System.out.printf("\n\n");
			System.out.println("n   \tTiempo");
		}

	}

