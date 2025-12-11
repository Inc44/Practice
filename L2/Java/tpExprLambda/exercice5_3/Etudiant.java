package tpExprLambda.exercice5_3;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Etudiant {
	private String nom;
	private String prenom;
	private double[] notes;
	public Etudiant(String nom, String prenom, double... notes) {
		this.nom = nom;
		this.prenom = prenom;
		this.notes = notes;
	}
	public double moyenne() {
		DoubleStream dsnotes = DoubleStream.of(notes);
		return dsnotes.average().orElse(0);
	}
	public Stream<Double> notesAsStream() {
		return Arrays.stream(notes).boxed();
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}