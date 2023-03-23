package algestudiante.p5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//C[i,j]:= Max(C[i,j],Min(C[i,k],C[k,j]))

//P[i][j]=k

public class IslandsPath {
	private final static int MAX_INF = Integer.MAX_VALUE; // to represent the value of infinity
	private final static int MIN_INF = Integer.MIN_VALUE; // to represent the value of -infinity
	private int numIslands; // number of islands (nodes) of the graph
	private int[][] W; // matrix with the widths of the bridges
	// support arrays to calculate the widths (analogous to Floyd)
	private int[][] C; // COST MATRIX: stores the maximum width
	private int[][] P; // PATH MATRIX: stores the best path
	private ArrayList<String> paths; // to store the different solutions
	private String camino = "";

	/**
	 * Create the arrays of the graph and initialize them It also created the arrays
	 * to do the calculations
	 * 
	 * @param file File with the data
	 */
	public IslandsPath(String file) {
		loadData(file); // load from the file the islands and bridges
		paths = new ArrayList<String>();

		// we create the support arrays
		C = new int[numIslands][numIslands];
		P = new int[numIslands][numIslands];

		for (int i = 0; i < numIslands; i++) {
			for (int j = 0; j < numIslands; j++) {
				C[i][j] = W[i][j];
				P[i][j] = MIN_INF;
			}
		}
	}

	/**
	 * Reads the initial data from a text file and creates an object to deal with
	 * the problem
	 */
	private void loadData(String file) {
		BufferedReader reader = null;
		String line;

		try {
			reader = new BufferedReader(new FileReader(file));

			// first line with the number of islands
			line = reader.readLine();
			numIslands = Integer.parseInt(line);

			// creates the array of widths for the number of islands
			W = new int[numIslands][numIslands];
			for (int i = 0; i < numIslands; i++)
				for (int j = 0; j < numIslands; j++)
					if (i != j)
						W[i][j] = MIN_INF; // there is no bridge
					else
						W[i][j] = MAX_INF; // there is no limit of width on the island itself

			// reads the rest of the lines with the bridges between the islands
			while (reader.ready()) {
				line = reader.readLine();
				String[] parts = line.split(" ");
				int i = Integer.parseInt(parts[0]);
				int j = Integer.parseInt(parts[2]);
				int width = Integer.parseInt(parts[3]);
				String edge = parts[1];
				if (edge.equals("--")) {
					W[i][j] = width;
					W[j][i] = width;
				} else if (edge.equals("->")) {
					W[i][j] = width;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Calculates the maximum width path between islands (nodes) (Analogous to
	 * Floyd, changing the conditions for the best way)
	 */
	public void calculateMaximumWidths() { //O(n^3)

		for (int k = 0; k < numIslands; k++) {

			for (int i = 0; i < numIslands; i++) {

				for (int j = 0; j < numIslands; j++) {

					if (C[i][j] < Math.min(C[i][k], C[k][j])) {
						C[i][j] = Math.max(C[i][j], Math.min(C[i][k], C[k][j]));
						P[i][j] = C[i][j];
					}

				}
			}
		}

	}

	/****** Methods for printing final and intermediate data *************/
	/**
	 * Prints the widths matrix
	 */
	public String toString() {
		return printMatrix(W);
	}

	/**
	 * Converts the given array to n nodes in a printable string
	 * 
	 * @param matrix
	 * @return
	 */
	public String printMatrix(int[][] matrix) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numIslands; i++) {
			for (int j = 0; j < numIslands; j++)
				if (matrix[i][j] == MAX_INF)
					sb.append("* ");
				else if (matrix[i][j] == MIN_INF)
					sb.append("- ");
				else
					sb.append(matrix[i][j] + " ");
			sb.append("\n");
		}
		return sb.toString();
	}

	public void printCostsMatrix() {
		System.out.println(printMatrix(C));
	}

	public void printPathsMatrix() {
		System.out.println(printMatrix(P));
	}

	/**
	 * Prints all paths found
	 */
	public void generatePaths() {
		// scorre P per ottenere il cammino tra i e y

		
		for (int i = 0; i < numIslands; i++)
			for (int j = 0; j < numIslands; j++) 
				if(i!=j)
			{
				camino=getCamino(i,j);
				paths.add(camino);
			}
	}

	private String getCamino(int i, int j) {
		return null;
	}
	
	static String  {
		
		if(M[i][j]>=1000000)
			System.out.println("No hay camino");
		else {
			camino.append(i+"---");
			trayectoria(i, j);
			camino.append(j);
		}
	}
		
	
	static void trayectoria(int i,int j) {
		int c=p[i][j];
		if(c>=0) {
			trayectoria(i,c,camino);
			camino.append(c+"---");
			trayectoria(c, j,camino);
		}
	}

	public ArrayList<String> getPaths() {
		return paths;
	}
}
