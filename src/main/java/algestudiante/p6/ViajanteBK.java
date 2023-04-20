package algestudiante.p6;

import java.util.ArrayList;
import java.util.Arrays;

public class ViajanteBK {

	private int [][] graph;
	private int numNodi; 
	private ArrayList<Integer> mejorDistancia;
	private ArrayList<Integer> mejorSolucion;
	private int distance;
	
    boolean[] visited;
    int[] path;
	
	
	public ViajanteBK ( int [][] grafosCaminos ) {
		this.graph = grafosCaminos;
		
		this.distance = 0 ;
		this.numNodi = grafosCaminos.length;
		/*
	    visited = new boolean[numNodi];
	    distanze = new int[numNodi];
	    Arrays.fill(distanze, Integer.MAX_VALUE);
	    */
	    visited = new boolean[grafosCaminos.length];
	    
	    path = new int[visited.length];
	    
	    Arrays.fill(path, -1);
	    
	}
	
	public void calcularCiclo(int origen) {
		
		
		//visitaGrafoRicorsivo(grafo, origen, visitati, distanze);
		
		//distanza = visitaGrafo(grafo, origen);
		//visitaGrafo(int[][] grafo, int nodoIniziale)
		
		//visitaGrafo(int[][] grafo, int nodoIniziale, boolean[] visitato, int distanza)
		
		//findPath(graph, origen, visited, path, distance, origen);
		
	}
	
	public int getDistanza ( ) {
		int totalDistance = 0;
		
		for (int i = 0; i < path.length; i++) {
			System.out.println(i + " " + path[i]);
			
			
			
			/*
			if( i + 1 > path.length )
				totalDistance += graph[path[i]][path[i+1]];
			else
				totalDistance += graph[path[i]][path[i]];
*/
		}
		
		return totalDistance;
	}
	
	public int [] getDistanze ( ) {
		return path;
	}

	
	public static void findPath(int[][] graph, int node, boolean[] visited, int[] path, int distance, int start, int totalDistance) {
	    visited[node] = true; // marcare il nodo come visitato
	    path[distance] = node; // aggiungere il nodo al percorso
	    distance++; // incrementare la distanza percorsa
	    
	    // Se abbiamo visitato tutti i nodi e siamo tornati al nodo di partenza
	    if (distance == visited.length && node == start) {
	        // Stampa il percorso trovato con la distanza totale
	        for (int i = 0; i < path.length; i++) {
	            System.out.print(path[i] + " ");
	        }
	        System.out.println(" - Distanza totale: " + totalDistance);
	    }
	    
	    // Altrimenti, continuare la ricerca nei nodi adiacenti non ancora visitati
	    for (int i = 0; i < graph[node].length; i++) {
	        if (graph[node][i] != 0 && !visited[i]) { // se c'è un arco e il nodo non è ancora stato visitato
	        	findPath(graph, i, visited, path, distance, start, totalDistance + graph[node][i]); // ricerca ricorsiva
	        }
	    }
	    
	    // Ripristinare lo stato del nodo
	    visited[node] = false;
	    path[distance - 1] = -1;
	    distance--;
	}

	
	


}
