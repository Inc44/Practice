package tp1v3.src.geometrie;

public class TestGeometrie {
	private int testCount = 0;
	private int testFailed = 0;

	public static void main(String[] args) {
		(new TestGeometrie()).run();
	}

	public void run() {
		TestPoint();
		TestSegment();
		TestVecteur();
		System.out.println("*** TESTS RUN: " + testCount + " - FAILURE: " + testFailed
			+ " SUCCESS: " + (testCount - testFailed) + " ***");
	}

	public void TestPoint() {
		System.out.println("== Test Point ");
		Point origine = new Point();
		check("Test origine.getX()", origine.getX() == 0, "[ok]");
		check("Test origine.getY()", origine.getY() == 0, "[ok]");
		Point p1 = new Point(3, 2);
		check("Test new(3.,2.).getX()", p1.getX() == 3, "[ok]");
		check("Test new(3.,2.).getY()", p1.getY() == 2, "[ok]");
		Point p2 = new Point(p1);
		check("Test copy(3.,2.).getX()", p2.getX() == 3, "[ok]");
		check("Test copy(3.,2.).getY()", p2.getY() == 2, "[ok]");
		p2.setX(4);
		check("Test setX(4.).getX()", p2.getX() == 4, "[ok]");
		p2.setY(7);
		check("Test setY(7.).getY()", p2.getY() == 7, "[ok]");
		Point p3 = new Point(2, 3);
		p3.translater(4, 7);
		check("Test (2.,3.).translater(4.,7.) X", p3.getX() == 6, "[ok]");
		check("Test (2.,3.).translater(4.,7.) Y", p3.getY() == 10, "[ok]");

		Point p4 = new Point(3, 2);
		check("Test confondu", p1.confondu(p4), "[ok]");
		Point p5 = new Point(6, 6);
		check("Test distance", p1.distance(p5) == 5, "[ok]");
		System.out.println();
	}

	public void TestSegment() {
		System.out.println("== Test Segment ");
		Segment s1 = new Segment(new Point(1, 2), new Point(3, 4));
		check("Test constructor", s1.getP1().getX() == 1 && s1.getP2().getY() == 4, "[ok]");
		s1.translater(1, 1, -1, -1);
		check("Test translater", s1.getP1().getX() == 2 && s1.getP2().getY() == 3, "[ok]");
		System.out.println();
	}

	public void TestVecteur() {
		System.out.println("== Test Vecteur ");
		Vecteur v1 = new Vecteur("v1", new Point(1, 2));
		check("Test assesseurs", v1.getPoint().confondu(new Point(1, 2)), "[ok]");
		v1.setPoint(new Point(3, 4));
		check("Test mutateurs", v1.getPoint().confondu(new Point(3, 4)), "[ok]");

		Vecteur v2 = new Vecteur("v2", new Point(1, 1));
		Vecteur v3 = v1.additionne(v2);
		check("Test additionne", v3.getPoint().getX() == 4 && v3.getPoint().getY() == 5, "[ok]");
		v1.multiplie(2);
		check("Test multiplie", v1.getPoint().getX() == 6 && v1.getPoint().getY() == 8, "[ok]");
		check("Test norme", v1.norme() == 10, "[ok]");
		Vecteur v4 = new Vecteur("v4", new Point(1, 0));
		v4.rotation(90);
		check("Test rotation", v4.getPoint().getX() < 1e-9 && v4.getPoint().getY() == 1, "[ok]");

		Vecteur v5 = new Vecteur("v5", new Point(2, 2));
		check("Test collineaire", v2.collineaire(v5), "[ok]");
		check("Test non-collineaire", !v1.collineaire(v5), "[ok]");
		System.out.println();
	}

	private void check(String message, boolean condition, String debug) {
		testCount++;
		if (!condition) {
			System.out.print("[echec]\t");
			testFailed++;
		} else {
			System.out.print("[ok]\t");
		}
		System.out.print(message + "\n");
		if (!condition) {
			System.out.println("---");
			System.out.println(debug);
			System.out.println("---");
		}
	}
}