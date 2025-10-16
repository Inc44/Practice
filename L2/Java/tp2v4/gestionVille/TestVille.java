package tp2v4.gestionVille;

public class TestVille {
	public static void main(String[] args) {
		Bien[] list = {new Vehicule(15000, 250, "AB-123-CD", 5),
			new Vehicule(25000, 400, "EF-456-GH", 2), new LogementSocial(120000, 300, 70, 4),
			new LogementSocial(90000, 200, 50, 2), new LogementDeFonction(250000, 600, 120, 5)};
		Ville city = new Ville(list);
		System.out.println("== Informations sur les biens ");
		for (int i = 0; i < list.length; i++) {
			System.out.println("Bien " + i + ":");
			System.out.println(city.getInfo(i));
			System.out.println();
		}
		System.out.println("== Statistiques de la ville ");
		System.out.println("Nombre d'exemplaires de biens: " + Bien.getNbExemplaires());
		System.out.println("Nombre de vehicules: " + city.getNbVehicules());
		System.out.println("Nombre de personnes logees: " + city.getNbPersonnesLogees());
		System.out.println();
		System.out.println("== Couts d'entretien mensuels ");
		System.out.println("Cout pour tous les biens: " + city.getEntretienCourantMensuel());
		System.out.println("Cout pour les vehicules: " + city.getCoutEntretienVehicules());
		System.out.println(
			"Cout pour les logements sociaux: " + city.getCoutEntretienLogementsSociaux());
		System.out.println(
			"Cout pour les logements de fonction: " + city.getCoutEntretienLogementsDeFonction());
	}
}