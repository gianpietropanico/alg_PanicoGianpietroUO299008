package algestudiante.p6;

// deve tenere un costruttuore che prende una matrice di interi e un metodo 
// calcularCiclo 
//condizione di stato valido: non si devono ripetere i nodi 
//grado = 5 --> per il for 
//altura = 5 --> condizione di parada (if)
//la soluzione 

public class ViajanteBK {

	public ViajanteBK(int[][] grafoCaminos) {
		// TODO Auto-generated constructor stub
	}

	public void calcularCiclo(int origen) {
		if (nivel == n) { // hay ya una asignación completa
			if (coste < costeMejor) {
				for (int k = 0; k < n; k++)
					asigMejor[k] = asig[k];
				costeMejor = coste;
			}
		} else {
			for (int i = 0; i < n; i++)
				if (!marca[i]) {
					asig[nivel] = i;
					coste = coste + w[nivel][i];
					marca[i] = true;
					backtracking(nivel + 1);
					coste = coste - w[nivel][i];
					marca[i] = false;
				}
		}

	}

}
