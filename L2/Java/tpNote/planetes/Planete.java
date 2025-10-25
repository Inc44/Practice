package tpNote.planetes;

import java.util.ArrayList;
import java.util.List;

public class Planete {
	private String nom;
	private float masse;
	private List<Satellite> satellite = new ArrayList<>();

	public Planete(String nom, float masse) {
		this.nom = nom;
		this.masse = masse;
	}

	public float getMasse() {
		return this.masse;
	}

	public String getNom() {
		return this.nom;
	}

	@Override
	public String toString() {
		return this.nom + " pesant " + String.format("%.3f", this.masse) + " Masse terrestre";
	}

	public void ajouterSatellite(Satellite sat) {
		int length = this.satellite.size();
		if (length != 5)
			this.satellite.add(sat);
	}

	public float masseTotale() {
		float sum = 0;
		for (Satellite sat : this.satellite) {
			sum += sat.getMasse();
		}
		return sum;
	}

	public void afficherSysteme() {
		System.out.println(this.toString() + ", ayant pour satellite(s):");
		for (Satellite sat : this.satellite) {
			System.out.println("-" + sat.toString());
		}
	}
}
