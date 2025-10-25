package tpNote.avion;

import java.util.ArrayList;
import java.util.List;

public class TestAvion {
	public static void main(String[] args) {
		AvionLigne a380800 = new AvionLigne(42000, 14800, 853);
		AvionLigne a320Neo = new AvionLigne(25000, 6150, 194);
		AvionLigne boeing737 = new AvionLigne(17000, 6230, 215);
		AvionCargo antonovAn225 = new AvionCargo(25000, 14500);
		AvionCargo a300600ST = new AvionCargo(47000, 2779);

		List<AvionLigne> avionsLignes = new ArrayList<>();
		avionsLignes.add(a380800);
		avionsLignes.add(a320Neo);
		avionsLignes.add(boeing737);

		List<AvionCargo> avionsCargos = new ArrayList<>();
		avionsCargos.add(antonovAn225);
		avionsCargos.add(a300600ST);

		for (AvionLigne avion : avionsLignes) {
			avion.rechargeKerosene();
			avion.chargerCargo(21000);
			avion.embarquerPassagers(112);
			if (avion.getPorteeMax() < 9500) {
				System.out.println("Irrealisable");
				continue;
			}
			avion.dechargerCargo(18000);
			avion.debarquerPassagers(65);
			avion.chargerCargo(13000);
			avion.embarquerPassagers(11);
			if (avion.getPorteeMax() < 9500 + 2800) {
				System.out.println("Irrealisable");
				continue;
			}
		}

		for (AvionCargo avion : avionsCargos) {
			avion.rechargeKerosene();
			avion.chargerCargo(21000);
			if (avion.getPorteeMax() < 9500) {
				System.out.println("Irrealisable");
				continue;
			}
			avion.dechargerCargo(18000);
			avion.chargerCargo(13000);
			if (avion.getPorteeMax() < 9500 + 2800) {
				System.out.println("Irrealisable");
				continue;
			}
		}
	}
}
