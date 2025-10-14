package tp1v3.src.geometrie;

public class Vecteur {
	private String nom;
	private Point point;

	public Vecteur(String nom, Point point) {
		this.nom = nom;
		this.point = point.copie();
	}

	public void affiche() {
		System.out.println("Vecteur " + this.nom + " : " + this.point.toString());
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point.copie();
	}

	public Vecteur additionne(Vecteur v) {
		String nom = this.nom + v.nom;
		double x = this.point.getX() + v.point.getX();
		double y = this.point.getY() + v.point.getY();
		return new Vecteur(nom, new Point(x, y));
	}

	public void multiplie(int scalaire) {
		this.point.setX(this.point.getX() * scalaire);
		this.point.setY(this.point.getY() * scalaire);
	}

	public double norme() {
		return this.point.distance(new Point(0, 0));
	}

	public boolean compare(Vecteur v) {
		return this.point.confondu(v.point);
	}

	public boolean collineaire(Vecteur v) {
		double x1 = this.point.getX();
		double y1 = this.point.getY();
		double x2 = v.point.getX();
		double y2 = v.point.getY();
		return x1 / x2 == y1 / y2;
	}

	public void rotation(double angle) {
		double rad = Math.toRadians(angle);
		double x = this.point.getX();
		double y = this.point.getY();
		double rx = Math.cos(rad) * x - Math.sin(rad) * y;
		double ry = Math.sin(rad) * x + Math.cos(rad) * y;
		this.point.setX(rx);
		this.point.setY(ry);
	}

	@Override
	public String toString() {
		return "Vecteur " + this.nom + " : " + this.point.toString();
	}
}