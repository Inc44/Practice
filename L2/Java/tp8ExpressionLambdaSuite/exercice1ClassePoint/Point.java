package tp8ExpressionLambdaSuite.exercice1ClassePoint;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	// a ajouter pour pouvoir afficher le Set
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	// a ajouter pour que 2 points qui ont les memes
	// x et y soient consideres comme egaux
	// et donc pas 2 fois dans le Set
	@Override
	public int hashCode() {
		return (int) (this.getX() + this.getY() * 99);
	}
	@Override
	public boolean equals(Object obj) {
		Point autrePoint = (Point) obj;
		return autrePoint.getX() == this.getX() && autrePoint.getY() == this.getY();
	}
}
