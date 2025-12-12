package tpNote2.Exercice1.pGen2;

public class Magasin {
	public static void main(String[] args) {
		Client client = new Client();
		int date = 20251212;
		Commande<Item> c = new Commande<Item>(date);
		Item a = new Item("Burger", 4);
		c.ajouterArticle(a, date);
		client.ajouterCommande(c);
		System.out.print(client);
		System.out.print(c);
	}
}
