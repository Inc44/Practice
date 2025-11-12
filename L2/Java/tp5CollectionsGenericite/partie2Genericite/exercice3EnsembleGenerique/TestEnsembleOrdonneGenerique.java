package tp5CollectionsGenericite.partie2Genericite.exercice3EnsembleGenerique;

public class TestEnsembleOrdonneGenerique {
	public static void main(String[] args) {
		EnsembleOrdonneGenerique<Integer> eOGInt = new EnsembleOrdonneGenerique<>();
		eOGInt.ajoute(1);
		eOGInt.ajoute(15);
		System.out.println(eOGInt);

		EnsembleOrdonneGenerique<String> eOGString = new EnsembleOrdonneGenerique<>();
		eOGString.ajoute("Un");
		eOGString.ajoute("Deux");
		System.out.println(eOGString);

		EnsembleOrdonneGenerique<BankAccount> eOGBank = new EnsembleOrdonneGenerique<>();
		eOGBank.ajoute(new BankAccount(300));
		eOGBank.ajoute(new BankAccount(200));

		System.out.println(eOGBank);
	}
}
