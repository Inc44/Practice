package tpExprLambda.exercice3;

class Coord {
	private double x;
	private double y;
	Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Coord c = (Coord) obj;
		System.out.println("-> Appel de equals entre " + this.toString() + " et " + c.toString());
		System.out.println();
		return c.x == this.x && c.y == this.y;
	}

	static int i = 0;

	@Override
	public int hashCode() {
		System.out.println("-> Appel de hashCode sur " + this.toString());

		// hashCode donné en cours
		return (int) (this.x + this.y * 31);

		// hashCode constant
		// return 0;

		// hashCode toujours différent
		// return i++;
	}
}
