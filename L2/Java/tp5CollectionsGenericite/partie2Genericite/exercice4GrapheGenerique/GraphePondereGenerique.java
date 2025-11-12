package tp5CollectionsGenericite.partie2Genericite.exercice4GrapheGenerique;

import java.util.HashMap;

public class GraphePondereGenerique<Sommet, Poids> {
	private HashMap<Sommet, HashMap<Sommet, Poids>> leGraphe;

	public GraphePondereGenerique() {
		this.leGraphe = new HashMap<Sommet, HashMap<Sommet, Poids>>();
	}

	public void ajouterSommet(Sommet sommet) {
		if (!leGraphe.containsKey(sommet)) {
			leGraphe.put(sommet, new HashMap<Sommet, Poids>());
		}
	}

	public void ajouterChemin(Sommet depart, Sommet arrivee, Poids poids) {
		this.ajouterSommet(depart);
		this.ajouterSommet(arrivee);

		HashMap<Sommet, Poids> sommetsArrivee = this.leGraphe.get(depart);

		if (sommetsArrivee.containsKey(arrivee))
			sommetsArrivee.replace(arrivee, poids);
		else
			sommetsArrivee.put(arrivee, poids);
	}

	public Poids distance(Sommet depart, Sommet arrivee) {
		if (leGraphe.containsKey(depart)) {
			HashMap<Sommet, Poids> sommetsArrivee = this.leGraphe.get(depart);
			if (sommetsArrivee.containsKey(arrivee))
				return sommetsArrivee.get(arrivee);
		}
		return null;
	}
}
