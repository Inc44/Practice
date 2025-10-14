package tp1v3.src;

public class Enveloppe {
	private Feuille[] letters;
	private int lettersCount;
	private int lettersMaxSize;
	private boolean isOpen;

	public Enveloppe(int lettersMaxSize) {
		this.letters = new Feuille[lettersMaxSize];
		this.lettersCount = 0;
		this.lettersMaxSize = lettersMaxSize;
		this.isOpen = false;
	}

	public void ouvrir() {
		this.isOpen = true;
	}

	public void fermer() {
		this.isOpen = false;
	}

	public void ajoutFeuille(Feuille f) {
		if (lettersCount < lettersMaxSize) {
			letters[lettersCount] = f;
			f.setEnvelope(this);
			lettersCount++;
		}
	}

	public void lire() {
		if (this.isOpen) {
			for (int i = 0; i < lettersCount; i++) {
				System.out.println("Page " + (i * 2 + 1) + ":\n" + letters[i].toString());
				letters[i].retourner();
				System.out.println("Page " + (i * 2 + 2) + ":\n" + letters[i].toString());
				letters[i].retourner();
			}
		}
	}

	public boolean isOpen() {
		return this.isOpen;
	}
}