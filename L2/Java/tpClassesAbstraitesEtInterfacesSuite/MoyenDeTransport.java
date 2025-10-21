package tpClassesAbstraitesEtInterfacesSuite;

public abstract class MoyenDeTransport implements Deplacement {
	protected int x;
	protected int y;
	protected int vitesse;

	public MoyenDeTransport() {
		this.x = 0;
		this.y = 0;
		this.vitesse = 1;
	}

	public void limitation(int nouvelleVitesse, int limite) {
		this.vitesse = Math.min(nouvelleVitesse, limite);
	}

	public void afficher() {
		System.out.println("Position: (" + x + ", " + y + ")");
	}

	public void seDeplacer() {
		deplacementEnX();
		deplacementEnY();
	}
}