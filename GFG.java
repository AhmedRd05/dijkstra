// Programma Java per implementare l'Algoritmo di Dijkstra
// Utilizzando una Coda di Priorità

// Importazione delle classi di utilità
import java.util.*;

// Classe principale DPQ
public class GFG {

	// Variabili membro di questa classe
	private int dist[];
	private Set<Integer> visitati;
	private PriorityQueue<Nodo> codaPriorita;
	// Numero di vertici
	private int V;
	List<List<Nodo>> adiacenze;

	// Costruttore di questa classe
	public GFG(int V) {

		// La parola chiave "this" si riferisce all'oggetto corrente stesso
		this.V = V;
		dist = new int[V];
		visitati = new HashSet<Integer>();
		codaPriorita = new PriorityQueue<Nodo>(V, new Nodo());
	}

	// Metodo 1
	// Algoritmo di Dijkstra
	public void dijkstra(List<List<Nodo>> adiacenze, int src) {
		this.adiacenze = adiacenze;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		// Aggiungi il nodo di origine alla coda di priorità
		codaPriorita.add(new Nodo(src, 0));

		// La distanza dal nodo di origine è 0
		dist[src] = 0;

		while (visitati.size() != V) {

			// Controllo della condizione di terminazione quando
			// la coda di priorità è vuota, restituisci
			if (codaPriorita.isEmpty())
				return;

			// Rimuovi il nodo con la distanza minima
			// dalla coda di priorità
			int u = codaPriorita.remove().nodo;

			// Aggiungi il nodo il cui valore della distanza è stato
			// definito
			if (visitati.contains(u))

				// La parola chiave "continue" salta l'esecuzione del
				// controllo seguente
				continue;

			// Non è necessario chiamare e_Vicini(u)
			// se u è già presente nell'insieme dei nodi visitati.
			visitati.add(u);

			e_Vicini(u);
		}
	}
