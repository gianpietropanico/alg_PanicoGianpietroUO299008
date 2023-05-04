package algestudiante.p6;

public class ViajanteMod {

    private int[][] grafoCaminos;
    private boolean[] visitados;
    private int[] solucionActual;
    private int[] mejorSolucion;
    private int mejorDistancia;
    private int distanciaActual;
    private int origen;

    public ViajanteMod(int[][] grafoCaminos) {
        this.grafoCaminos = grafoCaminos;
        this.visitados = new boolean[grafoCaminos.length];
        this.solucionActual = new int[grafoCaminos.length];
        this.mejorSolucion = new int[grafoCaminos.length];
        this.mejorDistancia = Integer.MAX_VALUE;
        this.origen = 0;
    }
      
    public ViajanteMod (int n ) {
    	
    	this.grafoCaminos  =  new int [n][n];
    	
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < n; j++) {
    	        if (i == j) {
    	            grafoCaminos[i][j] = 0;
    	        } else {
    	            grafoCaminos[i][j] = ran(10,99);
    	        }
    	    }
    	}

        this.visitados = new boolean[grafoCaminos.length];
        this.solucionActual = new int[grafoCaminos.length];
        this.mejorSolucion = new int[grafoCaminos.length];
        this.mejorDistancia = Integer.MAX_VALUE;
        this.origen = 0;
    }

	private int ran(int min , int max ) {
		return ((int) (Math.random()*max)+min);
	}
	
	/*
	    public void calcularCiclo(int origen) {
        this.origen = origen;
        this.distanciaActual = 0;
        for (int i = 0; i < visitados.length; i++) {
            visitados[i] = false;
        }
        visitados[origen] = true;
        solucionActual[0] = origen;
        calcularCicloRecursivo(1);
        
        addOrigenNode ( );
    }
	 */
	
/* precede sta prima di sigue 
il vianjante passa prima per precede e poi per sigue
deve ritornare quella di minor coste

0-> 2 -> 1 -> x -> 0 coste = 
*/

    public void calcularCiclo(int origen, int precede , int sigue ) {
    	
        this.origen = origen;
        this.distanciaActual = 0;
        for (int i = 0; i < visitados.length; i++) {
            visitados[i] = false;
        }
        visitados[origen] = true;
        solucionActual[0] = origen;
        calcularCicloRecursivo(1, precede, sigue);
        
        addOrigenNode();
    }

    private void addOrigenNode() {
    	
    	int n = mejorSolucion.length+1;
    
    	
		int[] arraycopy = new int [n];
		for( int i = 0 ; i < n; i++ ) {
			if(i != n-1)
				arraycopy[i] = mejorSolucion[i];
			else
				arraycopy[i] = origen;
		}

    	this.mejorSolucion = new int[arraycopy.length];

    	System.arraycopy(arraycopy, 0, mejorSolucion, 0, arraycopy.length);    	
    	
	}
/*
	private void calcularCicloRecursivo(int nivel, int prec, int sig) {
        if (nivel == grafoCaminos.length) {
            int distancia = grafoCaminos[solucionActual[nivel - 1]][origen];
            if (distancia != 0 && solucionActual[1] == prec && solucionActual[solucionActual.length-1] == sig) {
                distanciaActual += distancia;
                if (distanciaActual < mejorDistancia) {
                    mejorDistancia = distanciaActual;
                    System.arraycopy(solucionActual, 0, mejorSolucion, 0, solucionActual.length);
                }
                distanciaActual -= distancia;
            }
        } else {
            for (int i = 0; i < visitados.length; i++) {
                if (!visitados[i] && grafoCaminos[solucionActual[nivel - 1]][i] != 0) {
                    if(nivel==1 && i!=prec) continue;
                    if(nivel==grafoCaminos.length-1 && i!=sig) continue; 
                    
                    visitados[i] = true;
                    solucionActual[nivel] = i;
                    distanciaActual += grafoCaminos[solucionActual[nivel - 1]][i];
                    calcularCicloRecursivo(nivel + 1, prec, sig);
                    distanciaActual -= grafoCaminos[solucionActual[nivel - 1]][i];
                    visitados[i] = false;
                }
            }
        }
    }
*/
	private void calcularCicloRecursivo(int nivel, int prec, int sig) {
        if (nivel == grafoCaminos.length) {
            int distancia = grafoCaminos[solucionActual[nivel - 1]][origen];
            if (distancia != 0 && solucionActual[1] == prec && solucionActual[solucionActual.length-1] == sig) {
                distanciaActual += distancia;
                if (distanciaActual < mejorDistancia) {
                    mejorDistancia = distanciaActual;
                    System.arraycopy(solucionActual, 0, mejorSolucion, 0, solucionActual.length);
                }
                distanciaActual -= distancia;
            }
        } else {
            for (int i = 0; i < visitados.length; i++) {
                if (!visitados[i] && grafoCaminos[solucionActual[nivel - 1]][i] != 0) {
                    if(nivel==1 && i!=prec) continue;
                    if(nivel==grafoCaminos.length-1 && i!=sig) continue; 
                    
                    
                    
                    visitados[i] = true;
                    solucionActual[nivel] = i;
                    distanciaActual += grafoCaminos[solucionActual[nivel - 1]][i];
                    calcularCicloRecursivo(nivel + 1, prec, sig);
                    distanciaActual -= grafoCaminos[solucionActual[nivel - 1]][i];
                    visitados[i] = false;
                }
            }
        }
    }
	
    public int getMejorDistancia() {
        return mejorDistancia;
    }

    public int[] getMejorSolucion() {
    	
        return mejorSolucion;
    }

	public void escribirSolucion(int[] solucion) {
		// TODO Auto-generated method stub
		
	}

}