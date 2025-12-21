package tp7.metier;

public class Etudiant {
	private int id;
	private String nom;
	private String prenom;
	private Groupe groupe;

	// Don't repeat yourself
	private void initEtudiant(int id, String nom, String prenom, Groupe groupe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
		if (this.groupe != null)
			this.groupe.addEtudiant(this);
	}

	public Etudiant(String nom, String prenom, Groupe groupe) {
		// Don't repeat yourself
		initEtudiant(0, nom, prenom, groupe);
	}

	public Etudiant(int id, String nom, String prenom, Groupe groupe) {
		// Don't repeat yourself
		initEtudiant(id, nom, prenom, groupe);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		String resultat =
			"Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", groupe=";
		if (groupe != null)
			// To prevent infinite recursion (Etudiant -> Groupe -> Etudiant -> ...)
			resultat += groupe.resume();
		resultat += "]";
		return resultat;
	}
}
