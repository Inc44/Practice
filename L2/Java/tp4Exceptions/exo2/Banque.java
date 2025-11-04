package tp4Exceptions.exo2;

import java.util.ArrayList;
import java.util.List;

public class Banque {
	private List<Compte> accounts = new ArrayList<>();
	public void ajouter(Compte c) {
		accounts.add(c);
	}
	private Compte findAccount(int noCompte) throws Exception {
		for (Compte c : accounts) {
			if (c.getNumero() == noCompte) {
				return c;
			}
		}
		throw new Exception("Account not found");
	}
	public void supprimer(int noCompte) throws Exception {
		Compte c = findAccount(noCompte);
		accounts.remove(c);
	}
	public void debit(int noCompte, int montant) throws Exception {
		Compte c = findAccount(noCompte);
		c.debit(montant);
	}
	public void credit(int noCompte, int montant) throws Exception {
		Compte c = findAccount(noCompte);
		c.credit(montant);
	}
}