package tp2v4.gestionVille;

public class LogementSocial extends Logement {
	public LogementSocial() {
		super();
	}

	public LogementSocial(
		int valEuros, int coutEntretienMensuel, int superficieAuSol, int nbPersonnesLogees) {
		super(valEuros, coutEntretienMensuel, superficieAuSol, nbPersonnesLogees);
	}

	@Override
	public String getInfo() {
		return "Logement social : " + super.getInfo();
	}
}