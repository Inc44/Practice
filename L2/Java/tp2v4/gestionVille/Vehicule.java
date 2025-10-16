package tp2v4.gestionVille;

public class Vehicule extends Bien {
	private String numeroImmatriculation;
	private int nbPlaces;

	public Vehicule() {
		super();
	}

	public Vehicule(
		int valEuros, int coutEntretienMensuel, String numeroImmatriculation, int nbPlaces) {
		super(valEuros, coutEntretienMensuel);
		this.numeroImmatriculation = numeroImmatriculation;
		this.nbPlaces = nbPlaces;
	}

	public String getNumeroImmatriculation() {
		return this.numeroImmatriculation;
	}

	public void setNumeroImmatriculation(String numeroImmatriculation) {
		this.numeroImmatriculation = numeroImmatriculation;
	}

	public int getNbPlaces() {
		return this.nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	@Override
	public String getInfo() {
		return "Vehicule : "
			+ "Numero d'immatriculation : " + this.numeroImmatriculation
			+ "\nNombre de places : " + this.nbPlaces + "\nValeur en euros : " + getValEuros()
			+ "\nCout d'entretien mensuel : " + getCoutEntretienMensuel();
	}
}