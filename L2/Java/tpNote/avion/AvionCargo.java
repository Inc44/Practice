package tpNote.avion;

public class AvionCargo extends Avion {
	private int nbAvionsCargo;

	AvionCargo(int cargoMax, int porteeMax) {
		super(porteeMax, porteeMax);
		this.cargoMax = cargoMax;
		this.porteeMax = porteeMax;
	}

	public int getNombreAvionCargo() {
		return this.nbAvionsCargo;
	}

	@Override
	public String getType() {
		return "Avion de cargo";
	}
}
