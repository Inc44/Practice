package tpNote2.Exercice3;

import java.util.ArrayList;
import java.util.function.Function;

public class Equipe {
	private String nom;
	private int score;
	private ArrayList<Joueur> liste;
	public Equipe(String nom, int score) {
		this.nom = nom;
		this.score = score;
		this.liste = new ArrayList<Joueur>();
	}
	public void ajouterJoueur(Joueur j) {
		this.liste.add(j);
	}
	public void rechercheConditionnee(Function<Joueur, String> f) {
		for (Joueur j : this.liste) {
			System.out.println(f.apply(j));
		}
	}
}