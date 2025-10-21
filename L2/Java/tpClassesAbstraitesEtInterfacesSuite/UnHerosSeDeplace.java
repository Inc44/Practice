package tpClassesAbstraitesEtInterfacesSuite;

public class UnHerosSeDeplace {
	public static void main(String[] args) {
		Voiture voiture = new Voiture();
		Ascenseur ascenseur = new Ascenseur();
		Fusee fusee = new Fusee();

		voiture.seDeplacer();
		voiture.afficher();

		ascenseur.seDeplacer();
		ascenseur.afficher();

		fusee.seDeplacer();
		fusee.afficher();
	}
}