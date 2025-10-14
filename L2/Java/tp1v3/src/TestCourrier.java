package tp1v3.src;

public class TestCourrier {
	public static void main(String[] args) {
		System.out.println("== Test Feuille et Enveloppe ");
		Feuille f1 = new Feuille("Recto de la feuille 1.", "Verso de la feuille 1.");
		Feuille f2 = new Feuille("Recto de la feuille 2.", "Verso de la feuille 2.");
		System.out.println("Feuille 1 hors enveloppe: " + f1);
		f1.retourner();
		System.out.println("Feuille 1 retournee: " + f1);
		System.out.println();
		Enveloppe env = new Enveloppe(2);
		System.out.println("Ajout de f1 et f2 a l'enveloppe.");
		env.ajoutFeuille(f1);
		env.ajoutFeuille(f2);
		System.out.println("Tentative de lecture de l'enveloppe fermee:");
		env.lire();
		System.out.println("Feuille 1 dans enveloppe fermee: " + f1);
		System.out.println();
		System.out.println("Ouverture de l'enveloppe.");
		env.ouvrir();
		System.out.println("Tentative de lecture de l'enveloppe ouverte:");
		env.lire();
		System.out.println();
		System.out.println("Feuille 2 dans enveloppe ouverte: " + f2);
		System.out.println();
		System.out.println("Fermeture de l'enveloppe.");
		env.fermer();
		System.out.println("Tentative de lecture de l'enveloppe fermee a nouveau:");
		env.lire();
	}
}