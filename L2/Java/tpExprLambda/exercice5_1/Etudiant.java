package tpExprLambda.exercice5_1;

import java.util.stream.DoubleStream;

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
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}