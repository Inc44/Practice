package tp1v3.src.geometrie;

public class Polyligne {
	private Point[] tabPoints;

	public Polyligne(Point[] tabPoints) {
		this.tabPoints = tabPoints;
	}

	public Point[] getTabPoints() {
		return this.tabPoints;
	}

	public void setTabPoints(Point[] tabPoints) {
		this.tabPoints = tabPoints;
	}

	public void affichage() {
		System.out.print("Polyligne: ");
		for (Point p : tabPoints) {
			System.out.print(p.toString() + " ");
		}
	}

	public int nbPoints() {
		return this.tabPoints.length;
	}

	public void translate(Vecteur v) {
		double dx = v.getPoint().getX();
		double dy = v.getPoint().getY();
		for (Point p : tabPoints) {
			p.translater(dx, dy);
		}
	}

	public boolean estPolygone() {
		if (tabPoints == null || tabPoints.length < 3) {
			return false;
		}
		return tabPoints[0].confondu(tabPoints[tabPoints.length - 1]);
	}

	public double longueur() {
		if (tabPoints == null || tabPoints.length < 2) {
			return 0.0;
		}
		double length = 0.0;
		for (int i = 0; i < tabPoints.length - 1; i++) {
			length += tabPoints[i].distance(tabPoints[i + 1]);
		}
		return length;
	}
}