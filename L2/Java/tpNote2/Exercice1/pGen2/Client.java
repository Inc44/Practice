package tpNote2.Exercice1.pGen2;

import java.util.TreeSet;

public class Client {
	private TreeSet<Commande> lesCommandes;
	public Client() {
		this.lesCommandes = new TreeSet<>();
	}
	public void ajouterCommande(Commande c) {
		this.lesCommandes.add(c);
	}
	@Override
	public String toString() {
		String commandeString = "Les commandes : \n";
		for (Commande c : lesCommandes) {
			commandeString = commandeString + c + "\n";
		}
		return commandeString;
	}
	public TreeSet<Commande> getCommande() {
		return this.lesCommandes;
	}
}