package tp1v3.src;

public class TestFraction {
	private int testCount = 0;
	private int testFailed = 0;

	public static void main(String[] args) {
		(new TestFraction()).run();
	}

	public void run() {
		testPGCD();

		testBasic();
		testMultiplieParCoeff();
		testInverse();
		testEgale();
		testReduire();
		testAjoute();
		testSoustrait();
		testMultiplie();
		testDivise();

		System.out.println("*** TESTS RUN: " + testCount + " - FAILURE: " + testFailed
			+ " SUCCESS: " + (testCount - testFailed) + " ***");
	}

	public void testPGCD() {
		System.out.println("== Test PGCD ");

		check("pgcd(1,1) ", Fraction.pgcd(1, 1) == 1, Integer.toString(Fraction.pgcd(1, 1)));
		check("pgcd(2,2) ", Fraction.pgcd(2, 2) == 2, Integer.toString(Fraction.pgcd(2, 2)));
		check("pgcd(12,15) ", Fraction.pgcd(12, 15) == 3, Integer.toString(Fraction.pgcd(12, 15)));
		check("pgcd(1,15) ", Fraction.pgcd(1, 15) == 1, Integer.toString(Fraction.pgcd(1, 15)));
		check("pgcd(-1,2) ", Fraction.pgcd(-1, 2) == -1, Integer.toString(Fraction.pgcd(-1, 2)));
		check("pgcd(1,-2) ", Fraction.pgcd(1, -2) == 1, Integer.toString(Fraction.pgcd(1, -2)));

		System.out.println();
	}

	public void testBasic() {
		// need to test new Fraction(5,0) !!!
		System.out.println("== Test Basiques ");

		Fraction f = new Fraction(3, 2);

		check("numerateur(3/2) ", f.getNumerateur() == 3,
			"attendue: 3 \nobtenu: " + f.getNumerateur());
		check("denominateur(3/2) ", f.getDenominateur() == 2,
			"attendue: 2 \nobtenu: " + f.getDenominateur());

		f.setNumerateur(5); // only numerateur is changed
		check("numerateur((3/2).setNumerateur(5))  ", f.getNumerateur() == 5,
			"attendue: 5 \nobtenu: " + f.getNumerateur());
		check("denominateur((3/2).setNumerateur(5)) ", f.getDenominateur() == 2,
			"attendue: 2 \nobtenu: " + f.getDenominateur());

		f.setDenominateur(7); // only denominateur is changed
		check("numerateur((5/2).setDenominateur(7)) ", f.getNumerateur() == 5,
			"attendue: 5 \nobtenu: " + f.getNumerateur());
		check("denominateur((5/2).setDenominateur(7)) ", f.getDenominateur() == 7,
			"attendue: 7 \nobtenu: " + f.getDenominateur());

		f.setDenominateur(0); // does change since X/0 is not valid
		check("numerateur((5/7).setDenominateur(0)) ", f.getNumerateur() == 5,
			"attendue: 5 \nobtenu: " + f.getNumerateur());
		check("denominateur((5/7).setDenominateur(0)) ", f.getDenominateur() == 7,
			"attendue: 7 \nobtenu: " + f.getDenominateur());

		Fraction f2 = new Fraction(-5, 2);
		check("numerateur(-5/2) ", f2.getNumerateur() == -5,
			"attendue: -5 \nobtenu: " + f2.getNumerateur());
		check("denominateur(-5/2) ", f2.getDenominateur() == 2,
			"attendue: 2 \nobtenu: " + f2.getDenominateur());

		Fraction f3 = new Fraction(5, -2);
		check("numerateur(5/-2) ", f3.getNumerateur() == 5,
			"attendue: 5 \nobtenu: " + f3.getNumerateur());
		check("denominateur(5/-2) ", f3.getDenominateur() == -2,
			"attendue: -2 \nobtenu: " + f3.getDenominateur());

		System.out.println();
	}

	public void testMultiplieParCoeff() {
		System.out.println("== Test MultiplieParCoeff ");

		Fraction f = new Fraction(3, 7);
		f.multiplierParCoeff(4);
		check("numerateur(4*(3/7)) ", f.getNumerateur() == 12,
			"attendue: 12 \nobtenu: " + f.getNumerateur());
		check("denominateur(4*(3/7)) ", f.getDenominateur() == 7,
			"attendue: 7 \nobtenu: " + f.getDenominateur());

		Fraction f2 = new Fraction(3, 7);
		f2.multiplierParCoeff(-5);
		check("numerateur(-5*(3/7)) ", f2.getNumerateur() == -15,
			"attendue: -15 \nobtenu: " + f2.getNumerateur());
		check("denominateur(-5*(3/7)) ", f2.getDenominateur() == 7,
			"attendue: 7 \nobtenu: " + f2.getDenominateur());

		System.out.println();
	}

	public void testInverse() {
		System.out.println("== Test Inverse");

		Fraction f = new Fraction(3, 2);
		f.inverse();
		check("numerateur(inverse(3/2)) ", f.getNumerateur() == 2,
			"attendue: 2 \nobtenu: " + f.getNumerateur());
		check("denominateur(inverse(3/2)) ", f.getDenominateur() == 3,
			"attendue: 3 \nobtenu: " + f.getDenominateur());

		f = new Fraction(0, 2);
		f.inverse(); // does change since X/0 is not valid
		check("numerateur(inverse(0/2)) ", f.getNumerateur() == 0,
			"attendue: 0 \nobtenu: " + f.getNumerateur());
		check("denominateur(inverse(0/2)) ", f.getDenominateur() == 2,
			"attendue: 2 \nobtenu: " + f.getDenominateur());

		f = new Fraction(-5, 2);
		f.inverse();
		check("numerateur(inverse(-5/2)) ", f.getNumerateur() == 2,
			"attendue: 2 \nobtenu: " + f.getNumerateur());
		check("denominateur(inverse(-5/2)) ", f.getDenominateur() == -5,
			"attendue: -5 \nobtenu: " + f.getDenominateur());

		f = new Fraction(5, -2);
		f.inverse();
		check("numerateur(inverse(5/-2)) ", f.getNumerateur() == -2,
			"attendue: -2 \nobtenu: " + f.getNumerateur());
		check("denominateur(inverse(5/-2)) ", f.getDenominateur() == 5,
			"attendue: 5 \nobtenu: " + f.getDenominateur());

		System.out.println();
	}

	public void testEgale() {
		System.out.println("== Test Egale");

		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(2, 4);
		Fraction f3 = new Fraction(1, 3);
		Fraction f4 = new Fraction(1, -2);
		Fraction f5 = new Fraction(-1, 2);
		Fraction f6 = new Fraction(-1, -2);
		Fraction f7 = new Fraction(1, 2);

		check("1/2 egale 1/2", f.egaleA(f), "attendue: vrai");
		check("1/2 egale 1/2", f.egaleA(f7), "attendue: vrai");
		check("1/2 egale 2/4", f.egaleA(f2), "attendue: vrai");
		check("2/4 egale 1/2", f2.egaleA(f), "attendue: vrai");
		check("1/2 egale 1/3", !f.egaleA(f3), "attendue: faux");
		check("1/-2 egale -1/2", f4.egaleA(f5), "attendue: vrai");
		check("-1/2 egale 1/-2", f5.egaleA(f4), "attendue: vrai");
		check("1/2 egale -1/-2", f.egaleA(f6), "attendue: vrai");
		check("-1/-2 egale 1/2", f6.egaleA(f), "attendue: vrai");

		System.out.println();
	}

	public void testReduire() {
		System.out.println("== Test Reduire");

		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(2, 4);
		Fraction f3 = new Fraction(-1, -2);
		Fraction f4 = new Fraction(4, 1);
		Fraction f5 = new Fraction(-1, 2);
		Fraction f6 = new Fraction(1, -2);

		f.reduire();
		f2.reduire();
		f3.reduire();
		f4.reduire();
		f5.reduire();
		f6.reduire();

		check("reduire(1/2)", f.getNumerateur() == 1 && f.getDenominateur() == 2,
			"attendue: 1/2 \nobtenu: " + format(f));
		check("reduire(2/4)", f2.getNumerateur() == 1 && f2.getDenominateur() == 2,
			"attendue: 1/2 \nobtenu: " + format(f2));
		check("reduire(-1/-2)", f3.getNumerateur() == 1 && f3.getDenominateur() == 2,
			"attendue: 1/2 \nobtenu: " + format(f3));
		check("reduire(4/1)", f4.getNumerateur() == 4 && f4.getDenominateur() == 1,
			"attendue: 4/1 \nobtenu: " + format(f4));
		check("reduire(-1/2)", f5.getNumerateur() == -1 && f5.getDenominateur() == 2,
			"attendue: -1/2 \nobtenu: " + format(f5));
		check("reduire(1/-2)", f6.getNumerateur() == -1 && f6.getDenominateur() == 2,
			"attendue: -1/2 \nobtenu: " + format(f6));

		System.out.println();
	}

	public void testAjoute() {
		System.out.println("== Test Ajoute");

		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(3, 2);
		f.ajoute(f2);
		check("1/2 + 3/2 ", f.egaleA(new Fraction(4, 2)), "attendu: 4/2 \nobtenu: " + format(f));

		f = new Fraction(10, 2);
		f2 = new Fraction(5, 4);
		f.ajoute(f2);
		check("10/2 + 5/4 ", f.egaleA(new Fraction(25, 4)), "attendu: 25/4 \nobtenu: " + format(f));

		Fraction f3 = new Fraction(1, 2);
		Fraction f4 = new Fraction(-1, 2);
		f3.ajoute(f4);
		check("1/2 + -1/2 ", f3.egaleA(new Fraction(0, 1)), "attendu: 0/1 \nobtenu: " + format(f3));

		f3 = new Fraction(1, 2);
		f4 = new Fraction(-1, 2);
		f4.ajoute(f3);
		check("-1/2 + 1/2 ", f4.egaleA(new Fraction(0, 1)), "attendu: 0/1 \nobtenu: " + format(f4));

		f3 = new Fraction(1, 2);
		f4 = new Fraction(1, -2);
		f3.ajoute(f4);
		check("1/2 + 1/-2 ", f3.egaleA(new Fraction(0, 1)), "attendu: 0/1 \nobtenu: " + format(f3));

		System.out.println();
	}

	public void testSoustrait() {
		System.out.println("== Test Soustrait");

		// A COMPLETER
		System.out.println("non testé, à vous d'écrire les tests");

		System.out.println();
	}

	public void testMultiplie() {
		System.out.println("== Test Multiplie");

		// A COMPLETER
		System.out.println("non testé, à vous d'écrire les tests");

		System.out.println();
	}

	public void testDivise() {
		System.out.println("== Test Divise");

		// A COMPLETER
		System.out.println("non testé, à vous d'écrire les tests");

		System.out.println();
	}

	/*
	 * Affiche le résultat d'un test
	 */
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

	/*
	 * Construit la représentation sous forme d'une chaine de caractère de la fraction passée en
	 * paramètre
	 */
	private String format(Fraction f) {
		return f.getNumerateur() + "/" + f.getDenominateur();
	}
}