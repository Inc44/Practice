package tpClassesAbstraitesEtInterfacesSuite;

public class Ascenseur extends MoyenDeTransport {
	public Ascenseur() {
		super();
		limitation(vitesse * 5, 50);
	}

	@Override
	public void deplacementEnY() {
		y += vitesse;
	}
}