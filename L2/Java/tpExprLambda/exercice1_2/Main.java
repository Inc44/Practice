package tpExprLambda.exercice1_2;

import tpExprLambda.exercice1_1.Coord;
import tpExprLambda.exercice1_1.MaListe;

public class Main {
	private static int i = 0;
	public static void main(String[] args) {
		MaListe l = new MaListe();
		l.add(new Coord(3, 2));
		l.add(new Coord(1, 4));
		l.add(new Coord(2, 5));
		l.afficher(w -> {
			i = i + 1;
			return i + ". Coordonnees " + w.getX() + ", " + w.getY();
		});
	}
}