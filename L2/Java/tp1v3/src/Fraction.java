package tp1v3.src;

public class Fraction {
	private int numerateur;
	private int denominateur;

	public static int pgcd(int a, int b) {
		int c;
		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	public Fraction(int num, int den) {
		if (den == 0) {
			denominateur = 1;
			numerateur = 0;
		} else {
			numerateur = num;
			denominateur = den;
		}
	}

	public int getNumerateur() {
		return numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	public void setDenominateur(int den) {
		if (den == 0) {
			return;
		}
		if (den < 0) {
			numerateur = -numerateur;
			den = -den;
		}
		denominateur = den;
	}

	public void setNumerateur(int num) {
		numerateur = num;
	}

	public boolean egaleA(Fraction f) {
		return numerateur * f.getDenominateur() == f.getNumerateur() * denominateur;
	}

	public void ajoute(Fraction f) {
		numerateur = numerateur * f.getDenominateur() + f.getNumerateur() * denominateur;
		denominateur = denominateur * f.getDenominateur();
	}

	public void reduire() {
		int gcd = pgcd(numerateur, denominateur);
		if (gcd != 0) {
			numerateur /= gcd;
			denominateur /= gcd;
		}
		if (denominateur < 0) {
			numerateur = -numerateur;
			denominateur = -denominateur;
		}
	}

	public void inverse() {
		if (numerateur == 0) {
			return;
		}
		int temp = numerateur;
		numerateur = denominateur;
		denominateur = temp;
	}

	public void multiplierParCoeff(int i) {
		numerateur *= i;
	}

	public void soustrait(Fraction f) {
		numerateur = numerateur * f.getDenominateur() - f.getNumerateur() * denominateur;
		denominateur = denominateur * f.getDenominateur();
	}

	public void multiplie(Fraction f) {
		numerateur *= f.getNumerateur();
		denominateur *= f.getDenominateur();
	}

	public void divise(Fraction f) {
		if (f.getNumerateur() == 0) {
			return;
		}
		numerateur = numerateur * f.getDenominateur();
		denominateur = denominateur * f.getNumerateur();
	}
}