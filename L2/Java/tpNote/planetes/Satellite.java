package tpNote.planetes;

public class Satellite {
	private String nom;
	private float masse;

	public Satellite(String nom, float masse) {
		this.nom = nom;
		this.masse = masse;
	}

	@Override
	public String toString() {
		return this.nom + " pesant " + String.format("%.3f", this.masse) + " Masse terrestre";
	}

	public String getNom() {
		return this.nom;
	}

	public float getMasse() {
		return this.masse;
	}
}
