package tpExprLambda.exercice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Etudiant {
	private String nom;
	private String prenom;
	private ArrayList<Double> notes;

	Etudiant(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		notes = new ArrayList<Double>();
	}

	Etudiant(String nom, String prenom, ArrayList<Double> notes) {
		this.nom = nom;
		this.prenom = prenom;
		this.notes = notes;
	}

	void ajouteNote(double note) {
		notes.add(note);
	}

	double moyenne() {
		return notes.stream().mapToDouble(x -> x).average().orElse(0);
	}
}
