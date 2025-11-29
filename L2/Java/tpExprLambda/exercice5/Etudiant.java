package tpExprLambda.exercice5;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Etudiant {
	private String nom;
	private String prenom;
	private double[] notes;

	Etudiant(String nom, String prenom, double... notes) {
		this.nom = nom;
		this.prenom = prenom;
		this.notes = notes;
	}

	double moyenne() {
		return DoubleStream.of(notes).average().orElse(0);
	}

	Stream<Double> notesAsStream() {
		return Arrays.stream(notes).boxed();
	}

	public String toString() {
		return nom + " " + prenom;
	}
}
