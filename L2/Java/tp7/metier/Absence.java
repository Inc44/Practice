package tp7.metier;

public class Absence {
	private String dateAbs;
	private String hrAbs;
	private Etudiant etudiant;

	public Absence(String dateAbs, String hrAbs, Etudiant etudiant) {
		this.dateAbs = dateAbs;
		this.hrAbs = hrAbs;
		this.etudiant = etudiant;
	}

	public String getDateAbs() {
		return dateAbs;
	}

	public void setDateAbs(String dateAbs) {
		this.dateAbs = dateAbs;
	}

	public String getHrAbs() {
		return hrAbs;
	}

	public void setHrAbs(String hrAbs) {
		this.hrAbs = hrAbs;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Absence [dateAbs=" + dateAbs + ", hrAbs=" + hrAbs + ", etudiant=" + etudiant + "]";
	}
}
