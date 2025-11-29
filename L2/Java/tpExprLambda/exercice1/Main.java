package tpExprLambda.exercice1;

public class Main {
	static int i = 0;

	public static void main(String[] args) {
		MaListe l = new MaListe();

		l.add(new Coord(3, 2));
		l.add(new Coord(1, 4));
		l.add(new Coord(2, 5));

		// question 1.1
		l.afficher(s -> "Coordonnées : " + s.getX() + ", " + s.getY());

		// question 1.2
		i = 0;
		l.afficher(s -> {
			i = i + 1;
			return i + ". Coordonnées " + s.getX() + ", " + s.getY();
		});
	}
}
