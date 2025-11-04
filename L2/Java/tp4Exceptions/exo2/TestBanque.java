package tp4Exceptions.exo2;

public class TestBanque {
	public static void main(String[] args) {
		Banque bank = new Banque();
		Compte account = new Compte(42);
		bank.ajouter(account);
		Client client = new Client(42, "Helene", "Brouard", bank);
		try {
			System.out.println("Credit of 420 euros to account " + account.getNumero());
			bank.credit(42, 420);
			System.out.println("New balance: " + account.getSolde());
			System.out.println("Attempt to withdraw 69 euros by the client");
			client.retraitCB(69);
			System.out.println("Withdrawal successful, new balance: " + account.getSolde());
			System.out.println("Attempt to withdraw 1337 euros by the client");
			client.retraitCB(1337);
			System.out.println("Withdrawal successful, new balance: " + account.getSolde());
		} catch (Exception exception) {
			System.err.println("Exception: " + exception.getMessage());
		}
		System.out.println("\nAccount status " + account.getNumero() + ": " + account.getSolde());
	}
}