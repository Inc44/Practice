package tp4Exceptions.exo4;

public class IterateurDesPairs implements IterateurTabInt {
	private int[] tab;
	private int pos;

	public IterateurDesPairs(int[] tab) {
		this.tab = tab;
		this.pos = 0;
		findNextEven();
	}
	public int suivant() {
		int valeur = tab[pos];
		pos++;
		findNextEven();
		return valeur;
	}
	public int indiceDuSuivant() {
		return pos;
	}
	public boolean aUnSuivant() {
		return pos < tab.length;
	}
	private void findNextEven() {
		while (aUnSuivant() && tab[pos] % 2 != 0) {
			pos++;
		}
	}
}