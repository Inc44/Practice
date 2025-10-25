package tpNote.planetes;

public class TestPlanetes {
	public static void main(String[] args) {
		Planete mars = new Planete("Mars", (float) 0.107);
		Planete terre = new Planete("Terre", (float) 1.000);
		Planete jupiter = new Planete("Jupiter", (float) 317.8);

		Satellite lune = new Satellite("Lune", (float) 0.123);
		Satellite ganymede = new Satellite("Ganymede", (float) 0.025);
		Satellite calisto = new Satellite("Calisto", (float) 0.018);
		Satellite io = new Satellite("Io", (float) 0.015);
		Satellite europe = new Satellite("Europe", (float) 0.008);

		terre.ajouterSatellite(lune);
		jupiter.ajouterSatellite(ganymede);
		jupiter.ajouterSatellite(calisto);
		jupiter.ajouterSatellite(io);
		jupiter.ajouterSatellite(europe);

		mars.afficherSysteme();
		terre.afficherSysteme();
		jupiter.afficherSysteme();
	}
}
