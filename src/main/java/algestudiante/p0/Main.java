package algestudiante.p0;

public class Main {

	public static void main(String[] args) {
		
		MatrizOperaciones matrizOperaciones = new MatrizOperaciones(4 , 1 , 5 );

        System.out.println("The dimension of the square random matrix is: " +  matrizOperaciones.getTam());
        
        System.out.println("Printing of the random matrix:\n ");
        matrizOperaciones.escribir();
        
       MatrizOperaciones matrizOperaciones2 = new MatrizOperaciones("src/main/java/algestudiante/p0/matriz01.txt");
        
        System.out.println("The dimension of the square matrix from the file is: " +  matrizOperaciones.getTam());
       
        
        System.out.println("Printing the matrix taken from the file:\n ");
        matrizOperaciones2.escribir();
        
        System.out.println("sum of the diagonal across the whole matrix: " +matrizOperaciones.sumarDiagonal1());
        System.out.println("sum of the diagonal across only the elements of the diagonal: "+matrizOperaciones.sumarDiagonal2());
	
        System.out.println("\ncalculating the path: ");
        matrizOperaciones.recorrerCamino(1, 1);
        matrizOperaciones.escribir();
        
	}

}
