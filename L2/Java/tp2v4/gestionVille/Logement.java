package tp2v4.gestionVille;

public abstract class Logement extends Bien {
	private int superficieAuSol;
	private int nbPersonnesLogees;

	public Logement() {
		super();
	}

	public Logement(
		int valEuros, int coutEntretienMensuel, int superficieAuSol, int nbPersonnesLogees) {
		super(valEuros, coutEntretienMensuel);
		this.superficieAuSol = superficieAuSol;
		this.nbPersonnesLogees = nbPersonnesLogees;
	}

	public int getSuperficieAuSol() {
		return this.superficieAuSol;
	}

	public void setSuperficieAuSol(int superficieAuSol) {
		this.superficieAuSol = superficieAuSol;
	}

	public int getNbPersonnesLogees() {
		return this.nbPersonnesLogees;
	}

	public void setNbPersonnesLogees(int nbPersonnesLogees) {
		this.nbPersonnesLogees = nbPersonnesLogees;
	}

	@Override
	public String getInfo() {
		return "Superficie au sol : " + this.superficieAuSol + "\nNombre de personnes : "
			+ this.nbPersonnesLogees + "\nValeur en euros : " + getValEuros()
			+ "\nCout d'entretien mensuel : " + getCoutEntretienMensuel();
	}
}