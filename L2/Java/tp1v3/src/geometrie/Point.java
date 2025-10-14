package tp1v3.src.geometrie;

public class Point {
	private double x;
	private double y;
	private static int nbPoints = 0;

	public static int getNbPoints() {
		return nbPoints;
	}

	public Point() {
		this.x = 0.0;
		this.y = 0.0;
		nbPoints++;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		nbPoints++;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
		nbPoints++;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	public void translater(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void symetrieHorizontale() {
		this.y = -this.y;
	}

	public void symetrieVerticale() {
		this.x = -this.x;
	}

	public Point copie() {
		return new Point(this);
	}

	public boolean confondu(Point p) {
		return this.x - p.x == 0 && this.y - p.y == 0;
	}

	public double distance(Point p) {
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
}