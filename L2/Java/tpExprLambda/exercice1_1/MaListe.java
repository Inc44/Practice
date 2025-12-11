package tpExprLambda.exercice1_1;

import java.util.ArrayList;
import java.util.function.Function;

public class MaListe {
	private ArrayList<Coord> liste = new ArrayList<Coord>();
	public void add(Coord c) {
		liste.add(c);
	}
	public void afficher(Function<Coord, String> f) {
		for (Coord c : liste) {
			System.out.println(f.apply(c));
		}
	}
}