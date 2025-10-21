package tpClassesAbstraitesEtInterfacesSuite;

public class Fusee extends MoyenDeTransport {
	public Fusee() {
		super();
		limitation(vitesse * 100, 1200);
	}

	@Override
	public void deplacementEnX() {
		x += vitesse;
	}

	@Override
	public void deplacementEnY() {
		y += vitesse;
	}
}