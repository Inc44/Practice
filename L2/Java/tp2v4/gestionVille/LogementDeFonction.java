package tp2v4.gestionVille;

public class LogementDeFonction extends Logement {
	public LogementDeFonction() {
		super();
	}

	public LogementDeFonction(
		int valEuros, int coutEntretienMensuel, int superficieAuSol, int nbPersonnesLogees) {
		super(valEuros, coutEntretienMensuel, superficieAuSol, nbPersonnesLogees);
	}

	@Override
	public String getInfo() {
		return "Logement de fonction : " + super.getInfo();
	}
}