// Programma Java Algoritmo di Dijkstra
// Utilizzando una Coda di Priorità

import java.util.*;

public class GFG {

	// Variabili di questa classe
	private int dist[];
	private Set<Integer> visitati;
	private PriorityQueue<Nodo> codaPriorita;
	// Numero di vertici
	private int V;
	List<List<Nodo>> adiacenze;

	// Costruttore di questa classe
	public GFG(int V) {
		
		this.V = V;
		dist = new int[V];
		visitati = new HashSet<Integer>();
		codaPriorita = new PriorityQueue<Nodo>(V, new Nodo());
	}

	// Algoritmo di Dijkstra
	public void dijkstra(List<List<Nodo>> adiacenze, int src) {
		this.adiacenze = adiacenze;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		// Aggiungi il nodo di origine alla coda di priorità
		codaPriorita.add(new Nodo(src, 0));

		// La distanza dal nodo
		dist[src] = 0;

		while (visitati.size() != V) {

			// Controllo della condizione
			if (codaPriorita.isEmpty())
				return;

			// Rimuovi il nodo
			int u = codaPriorita.remove().nodo;

			if (visitati.contains(u))

				// La parola chiave "continue" salta l'esecuzione del controllo
				
				continue;

			visitati.add(u);

			e_Vicini(u);
		}
	}
