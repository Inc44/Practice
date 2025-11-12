package tp5CollectionsGenericite.partie1Collections.exercice3ManipulationDesMapsLaClasseGraphe;

public class TestGraphePondere {
	public static void main(String[] args) {
		GraphePondere gP = new GraphePondere();

		System.out.println(gP);

		System.out.println("Ajout du sommet A");

		gP.ajouterSommet("A");

		System.out.println(gP);

		System.out.println("Ajout du chemin A-B avec poids 2");

		gP.ajouterChemin("A", "B", 2);
		gP.ajouterChemin("A", "D", 4);
		gP.ajouterChemin("C", "A", 3);
		gP.ajouterChemin("B", "C", 1);
		System.out.println(gP);
	}
}
