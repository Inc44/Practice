package tp1v3.src;

public class Feuille {
	private String recto;
	private String verso;
	private boolean isRectoVisible;
	private Enveloppe envelope;

	public Feuille(String recto, String verso) {
		this.recto = recto;
		this.verso = verso;
		this.isRectoVisible = true;
		this.envelope = null;
	}

	public void retourner() {
		this.isRectoVisible = !this.isRectoVisible;
	}

	public void setEnvelope(Enveloppe envelope) {
		this.envelope = envelope;
	}

	@Override
	public String toString() {
		if (this.envelope != null && !this.envelope.isOpen()) {
			return "Contenu illisible, car l'enveloppe est fermee.";
		}
		return isRectoVisible ? this.recto : this.verso;
	}
}