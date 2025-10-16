package tp2v4.gestionVille;

public abstract class Bien {
	private int valEuros;
	private int coutEntretienMensuel;
	private static int nbExemplaires = 0;

	public Bien() {
		nbExemplaires++;
	}

	public Bien(int valEuros, int coutEntretienMensuel) {
		this.valEuros = valEuros;
		this.coutEntretienMensuel = coutEntretienMensuel;
		nbExemplaires++;
	}

	public int getValEuros() {
		return this.valEuros;
	}

	public void setValEuros(int valEuros) {
		this.valEuros = valEuros;
	}

	public int getCoutEntretienMensuel() {
		return this.coutEntretienMensuel;
	}

	public void setCoutEntretienMensuel(int coutEntretienMensuel) {
		this.coutEntretienMensuel = coutEntretienMensuel;
	}

	public static int getNbExemplaires() {
		return nbExemplaires;
	}

	public abstract String getInfo();
}