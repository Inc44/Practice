package tpNote.avion;

public class AvionLigne extends Avion implements IDeplacementPassagers {
	private int nbPassagers;
	private int nbAvionLigne;
	private int nbPassagersMax;

	public int getNombrePassagers() {
		return this.nbPassagers;
	}

	public int getNombreAvionLigne() {
		return this.nbAvionLigne;
	}

	@Override
	public String getType() {
		return "Avion de ligne";
	}

	@Override
	public String toString() {
		String type = getType();
		return type + " : " + this.cargo + ", " + this.cargoMax + ", " + this.portee + ", "
			+ this.porteeMax;
	}

	public AvionLigne(int cargoMax, int porteeMax, int passagerMax) {
		super(cargoMax, porteeMax);
		this.cargoMax = cargoMax;
		this.porteeMax = porteeMax;
		this.nbPassagersMax = passagerMax;
	}

	@Override
	public boolean embarquerPassagers(int nb) {
		if (nb <= this.nbPassagersMax && nb * 130 <= this.cargoMax) {
			this.nbPassagers += nb;
			this.cargo += nb * 130;
			return true;
		}
		return false;
	}

	@Override
	public boolean debarquerPassagers(int qtt) {
		if (qtt <= this.nbPassagers && qtt * 130 <= this.cargo) {
			this.nbPassagers -= qtt;
			this.cargo -= qtt * 130;
			return true;
		}
		return false;
	}

	@Override
	public void viderAvion() {
		this.cargo = 0;
		this.portee = 0;
	}
}
