package algestudiante.p7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import algestudiante.p6.ViajanteBK;


public class ViajanteTiemposBK {

	private int[][] grafoCaminos;
	ViajanteBK viajante = new ViajanteBK(grafoCaminos);

	long t1, t2;
	

	public static void main(String[] args) {
		final int MAX_VALUE = 200_000;
		long limite = 100000;

		System.out.println("n   \tTiempo");
	

		for (int n = 5; n < MAX_VALUE; n+=5) {
			
			
			EstadoViajante ini= new EstadoViajante(n);
				
			
			long t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= limite; repeticiones++) {
				ini.calcularValorHeuristico();
				
			}
			
			long t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}

		System.out.printf("\n\n");
		System.out.println("n   \tTiempo");
	}

}
