/*
	JAVA es sensible a minúsculas y mayusculas (minúscula != mayúscula)
	Es norma que una clase comience por letra mayúscula.
	Los métodos y todo tipo de variables comienzan por minúscula.

	Las clases JAVA se guardan en ficheros con el mismo nombre
	al que se añade la extensión Nombre.java.

	Los paquetes deben estar en directorio del mismo nombre, esto es,
	el paquete alg77777777.p1 debe estar en el directorio
	alg77777777\p1. 
 */

package algestudiante.p11;

import java.util.Random; //es la clase que genera números aleatorios

/** Esta clase permite trabajar con vectores */
public class Vector4 {
	static int[] v;
	static int [] m;

	public static void main(String arg[]) {
		// int n= Integer.parseInt(arg[0]); //tamaño del problema leido de línea de
		// comandos
		// int n = 100000000;
		long t1, t2;
		int s;
		int limite= 10000000;

		System.out.println("n\tt");
//		for (int n = 10; n < 1000000; n *= 3) {
//			v = new int[n];
//
//			Vector1.rellena(v);
//			// Vector1.escribe (v);
//
//			t1 = System.currentTimeMillis();
//			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
//				s = Vector1.suma(v);
//			t2 = System.currentTimeMillis();
//
//			System.out.println(n + "\t" + +(t2 - t1));
//
//		}
		
		System.out.println();
		System.out.println("ora il massimo ");
		System.out.println();
		
		int [] m = new int [2];
		for (int n = 10; n < 1000000; n *= 3) {
			v = new int[n];

			Vector1.rellena(v);
			// Vector1.escribe (v);

			t1 = System.currentTimeMillis();
			for (int repeticiones = 0; repeticiones < limite; repeticiones++)
			 Vector1.maximo(v,m);
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + +(t2 - t1));

		}
		// System.out.println ("Suma de los elementos del vector = "+ s);

	} // fin de main

} // fin de clase
