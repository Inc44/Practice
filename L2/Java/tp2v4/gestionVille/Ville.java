package tp2v4.gestionVille;

public class Ville {
	private Bien[] list;

	public Ville(Bien[] lesBiens) {
		this.list = lesBiens;
	}

	public String getInfo(int indice) {
		if (indice >= 0 && indice < this.list.length) {
			return this.list[indice].getInfo();
		}
		return "Indice invalide";
	}

	public int getNbVehicules() {
		int count = 0;
		for (Bien item : this.list) {
			if (item instanceof Vehicule) {
				count++;
			}
		}
		return count;
	}

	public int getNbPersonnesLogees() {
		int count = 0;
		for (Bien item : this.list) {
			if (item instanceof Logement) {
				count += ((Logement) item).getNbPersonnesLogees();
			}
		}
		return count;
	}

	public int getEntretienCourantMensuel() {
		int count = 0;
		for (Bien item : this.list) {
			count += item.getCoutEntretienMensuel();
		}
		return count;
	}

	public int getCoutEntretienVehicules() {
		int count = 0;
		for (Bien item : this.list) {
			if (item instanceof Vehicule) {
				count += item.getCoutEntretienMensuel();
			}
		}
		return count;
	}

	public int getCoutEntretienLogementsSociaux() {
		int count = 0;
		for (Bien item : this.list) {
			if (item instanceof LogementSocial) {
				count += item.getCoutEntretienMensuel();
			}
		}
		return count;
	}

	public int getCoutEntretienLogementsDeFonction() {
		int count = 0;
		for (Bien item : this.list) {
			if (item instanceof LogementDeFonction) {
				count += item.getCoutEntretienMensuel();
			}
		}
		return count;
	}
}