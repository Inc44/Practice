package tp4Exceptions.exo2;

public class Client {
	private int numeroCourant;
	private String nom;
	private String prenom;
	private Banque banque;
	public Client(int no, String nom, String prenom, Banque banque) {
		this.numeroCourant = no;
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
	}
	public void retraitCB(int montant) throws Exception {
		banque.debit(this.numeroCourant, montant);
	}
}