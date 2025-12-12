package tpNote2.Exercice3;

public class Joueur {
	private String nom;
	private String prenom;
	private String role;
	private int numero;
	private int age;
	public Joueur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return this.role;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	@Override
	public String toString() {
		return this.nom + " " + this.prenom + " " + this.role + " " + this.numero + " " + this.age;
	}
}