package tpNote.avion;

public abstract class Avion {
	protected int cargoMax;
	protected int porteeMax;
	private int nbAvions;
	protected int cargo = 0;
	protected int portee = 0;

	public Avion(int cargoMax, int porteeMax) {
		this.cargoMax = cargoMax;
		this.porteeMax = porteeMax;
	}

	public int getCargoMax() {
		return this.cargoMax;
	}

	public int getPorteeMax() {
		return this.cargoMax;
	}

	public int getCargo() {
		return this.cargo;
	}

	public void rechargeKerosene() {
		this.portee = this.porteeMax;
	}

	public int getNombreAvion() {
		return this.nbAvions;
	}

	public abstract String getType();

	@Override
	public String toString() {
		String type = getType();
		return type + " : " + this.cargo + ", " + this.cargoMax + ", " + this.portee + ", "
			+ this.porteeMax;
	}

	public boolean voler(int distance) {
		return this.portee <= distance;
	}

	public boolean chargerCargo(int qtt) {
		if (qtt <= this.cargoMax) {
			this.cargo += qtt;
			return true;
		}
		return false;
	};

	public boolean dechargerCargo(int qtt) {
		if (qtt <= this.cargo) {
			this.cargo -= qtt;
			return true;
		}
		return false;
	};

	public void viderCargo() {
		this.cargo = 0;
	};
}
