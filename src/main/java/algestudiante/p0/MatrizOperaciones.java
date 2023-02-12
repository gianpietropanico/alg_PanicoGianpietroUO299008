package algestudiante.p0;

import java.util.NoSuchElementException;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrizOperaciones {

	private int matrix[][];
	private int matrixLenght;

	public MatrizOperaciones(int n, int min, int max) {

		if (n > 0 && min <= max) {
			matrixLenght = n;
			matrix = new int[n][n];
			Random rand = new Random();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = rand.nextInt(max - min) + min;
				}
			}
		} else {
			System.out.println("please enter a positive n-value and the min value < than max");

			matrixLenght = 0;
			matrix = new int[matrixLenght][matrixLenght];
		}

	}

	public int getTam() {
		return matrix.length;
	}

	public void escribir() {
		if (matrixLenght == 0) {
			System.out.println("The matrix is empty");
			return;
		} else {
//			System.out.println("Matrix printing: ");
			for (int i = 0; i < matrixLenght; i++) {
				for (int j = 0; j < matrixLenght; j++) {
					System.out.printf("%d ", matrix[i][j]);
				}
				System.out.println("\n");
			}
		}

	}

	public MatrizOperaciones(String fileName) {

		// reading file
		try (Scanner input = new Scanner(new File(fileName))) {

			if (input.hasNext()) {
				matrixLenght = input.nextInt();
			}

			if (matrixLenght < 0) {

				System.out.println("Please enter a positive n-value and the min value < than max");
				System.out.println("Setted a default matrix with n = 0");
				matrixLenght = 0;
				matrix = new int[matrixLenght][matrixLenght];

			} else {

				int i = 0, j = 0;
				matrix = new int[matrixLenght][matrixLenght];

				while (input.hasNext()) {

					matrix[i][j] = input.nextInt();
					j++;

					if (j == matrixLenght) {
						i++;
						j = 0;
					}

				}

			}

		} catch (IOException | NoSuchElementException | IllegalStateException e) {

			System.out.println("File not found: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public int sumarDiagonal1() {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i == j)
					sum += matrix[i][j];
			}
		}
		return sum;
	}

	public int sumarDiagonal2() {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		return sum;
	}

	public void recorrerCamino(int i, int j) {

		 //check if the matrix has values between 1 and 4
//		for (int x = 0; x < matrix.length; x++) {
//			for (int y = 0; y < matrix.length; y++) {
//				if (matrix[x][y] < 1 || matrix[x][y] > 4) {
//					System.out.println("the matrix must have numbers between 1 and 4");
//					return;
//				}
//			}
//		}

		while (matrix[i][j] != -1) {
			switch (matrix[i][j]) {

			case 1:
				matrix[i][j] = -1;
				i = i - 1;
				break;

			case 2:
				matrix[i][j] = -1;
				j = j + 1;
				break;

			case 3:
				matrix[i][j] = -1;
				i = i + 1;
				break;

			case 4:
				matrix[i][j] = -1;
				j = j - 1;
				break;
				
				default: System.out.println("error");
				return;

			}
			if (i < 0 || j > matrix.length || j < 0 || i > matrix.length) {
				return;
			}
		}
		

	}
}
