package tp4Exceptions.exo2;

public class Compte {
	private int numero;
	private int solde;
	public Compte(int no) {
		this.numero = no;
		this.solde = 0;
	}
	public int getNumero() {
		return this.numero;
	}
	public int getSolde() {
		return this.solde;
	}
	public void debit(int montant) throws Exception {
		if (this.solde < montant) {
			throw new PasAssezArgentException();
		}
		this.solde -= montant;
	}
	public void credit(int montant) {
		this.solde += montant;
	}
}