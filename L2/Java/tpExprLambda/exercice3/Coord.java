package tpExprLambda.exercice3;

class Coord {
	private double x;
	private double y;
	static int i = 0;
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
		return "(" + x + ", " + y + ")";
	}
	// If not defined, then produces duplicates
	// (1.0, 2.0) (1.0, 4.0) (3.0, 2.0) (1.0, 2.0)
	@Override
	public boolean equals(Object obj) {
		Coord c = (Coord) obj;
		System.out.println("-> Appel de equals entre " + this.toString() + " et " + c.toString());
		System.out.println(c.x == this.x && c.y == this.y);
		return c.x == this.x && c.y == this.y;
	}
	@Override
	public int hashCode() {
		System.out.println("-> Appel de hashCode sur " + this.toString());
		// hashCode cours
		// System.out.println(this.x + this.y * 31);
		// return (int) (this.x + this.y * 31);
		// Order: hashCode for each object, then equals if potential duplicates (hash collision)
		// hashCode (4), equals (1)
		// Difference: hashCode has priority over equals
		// hashCode constant
		// System.out.println(0);
		// return 0;
		// (1.0, 2.0) (1.0, 4.0) (3.0, 2.0)
		// hashCode (4), equals (4)
		// Difference: equals always called for each object due to hash collision
		// hashCode toujours different
		System.out.println(i + 1);
		return i++;
		// (1.0, 2.0) (1.0, 4.0) (3.0, 2.0) (1.0, 2.0)
		// hashCode (4), equals (0)
		// Difference: equals not called since no hash collision
	}
}