package tpExprLambda.exercice1_1;

public class Main {
	public static void main(String[] args) {
		MaListe l = new MaListe();
		l.add(new Coord(3, 2));
		l.add(new Coord(1, 4));
		l.add(new Coord(2, 5));
		l.afficher(w -> "Coordonnees " + w.getX() + ", " + w.getY());
	}
}