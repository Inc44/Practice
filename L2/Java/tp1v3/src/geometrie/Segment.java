package tp1v3.src.geometrie;

public class Segment {
	private Point p1;
	private Point p2;

	public Segment() {
		this.p1 = new Point();
		this.p2 = new Point();
	}

	public Segment(Segment s) {
		this.p1 = s.p1.copie();
		this.p2 = s.p2.copie();
	}

	public Segment(Point p1, Point p2) {
		this.p1 = p1.copie();
		this.p2 = p2.copie();
	}

	public Segment(double x1, double y1, double x2, double y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}

	public Point getP1() {
		return this.p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1.copie();
	}

	public Point getP2() {
		return this.p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2.copie();
	}

	public void translaterP1(double dx, double dy) {
		this.p1.translater(dx, dy);
	}

	public void translaterP2(double dx, double dy) {
		this.p2.translater(dx, dy);
	}

	public void translater(double dx1, double dy1, double dx2, double dy2) {
		this.p1.translater(dx1, dy1);
		this.p2.translater(dx2, dy2);
	}

	public void symetrieHorizontale() {
		this.p1.symetrieHorizontale();
		this.p2.symetrieHorizontale();
	}

	public void symetrieVerticale() {
		this.p1.symetrieVerticale();
		this.p2.symetrieVerticale();
	}

	public Segment copie() {
		return new Segment(this);
	}

	@Override
	public String toString() {
		return "Segment[" + p1.toString() + ", " + p2.toString() + "]";
	}
}