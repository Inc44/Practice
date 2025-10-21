package tpClassesAbstraitesEtInterfacesSuite;

public class Voiture extends MoyenDeTransport {
	public Voiture() {
		super();
		limitation(vitesse * 10, 150);
	}

	@Override
	public void deplacementEnX() {
		x += vitesse;
	}
}