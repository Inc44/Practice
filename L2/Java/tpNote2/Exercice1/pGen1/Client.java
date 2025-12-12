package tpNote2.Exercice1.pGen1;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private List<Commande> lesCommandes;
	public Client() {
		this.lesCommandes = new ArrayList<>();
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
	public List<Commande> getCommande() {
		return this.lesCommandes;
	}
}