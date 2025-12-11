package tpExprLambda.exercice4;

import java.util.ArrayList;
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
	public void add(double note) {
		notes.add(note);
	}
	double moyenne() {
		Stream<Double> snotes = notes.stream();
		DoubleStream dsnotes = snotes.mapToDouble(x -> x);
		return dsnotes.average().orElse(0);
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}