package algestudiante.p0;

public class Main {

	public static void main(String[] args) {
		
		MatrizOperaciones matrizOperaciones = new MatrizOperaciones(10 , 10 , 20 );

        System.out.println("The dimension of the square random matrix is: " +  matrizOperaciones.getTam());
        
        System.out.println("Printing of the random matrix:\n ");
        matrizOperaciones.escribir();
        
        MatrizOperaciones matrizOperaciones2 = new MatrizOperaciones("src/main/java/algestudiante/p0/matriz01.txt");
        
        System.out.println("The dimension of the square matrix from the file is: " +  matrizOperaciones.getTam());
       
        
        System.out.println("Printing the matrix taken from the file:\n ");
        matrizOperaciones2.escribir();
	
	}

}
