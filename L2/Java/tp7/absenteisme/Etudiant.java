package tp7.absenteisme;

public class Etudiant {
	private long id;
	private String nom;
	private String prenom;
	private Groupe groupe;

	public Etudiant(long id, String nom, String prenom, Groupe groupe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}

	public Etudiant(String nom, String prenom, Groupe groupe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@Override
	public String toString() {
		String resultat = "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom
			+ ", groupe=" + groupe + "]";
		return resultat;
	}
}
