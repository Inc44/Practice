package tp7.metier;

import java.util.ArrayList;

public class Groupe {
	private String code;
	private String formation;
	private ArrayList<Etudiant> lesEtudiants;

	private void initgroupe(String code, String formation, ArrayList<Etudiant> liste) {
		this.code = code;
		this.formation = formation;
		this.lesEtudiants = liste;
	}

	public Groupe(String code, String formation, ArrayList<Etudiant> liste) {
		initgroupe(code, formation, liste);
	}

	public Groupe(String formation) {
		initgroupe(null, formation, new ArrayList<Etudiant>());
	}

	// ORM for bidirectional consistency
	public ArrayList<Etudiant> getListeEtudiants() {
		return this.lesEtudiants;
	}

	// ORM for bidirectional consistency
	public void addEtudiant(Etudiant etudiant) {
		if (!this.lesEtudiants.contains(etudiant)) {
			etudiant.setGroupe(this);
			this.lesEtudiants.add(etudiant);
		}
	}

	// ORM for bidirectional consistency
	public void delEtudiant(Etudiant etudiant) {
		if (this.lesEtudiants.contains(etudiant)) {
			etudiant.setGroupe(null);
			this.lesEtudiants.remove(etudiant);
		}
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Groupe [code=" + code + ", formation=" + formation
			+ ", étudiant(s) =" + this.lesEtudiants + "]";
	}

	// To prevent infinite recursion (Etudiant -> Groupe -> Etudiant -> ...)
	public String resume() {
		return "Groupe [code=" + code + ", formation=" + formation + "]";
	}
}
