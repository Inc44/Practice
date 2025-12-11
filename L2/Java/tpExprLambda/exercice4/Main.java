package tpExprLambda.exercice4;

public class Main {
	public static void main(String[] args) {
		Etudiant etudiant = new Etudiant("Turing", "Alan");
		etudiant.add(17);
		etudiant.add(20);
		System.out.println(etudiant.moyenne());
		etudiant.add(19.5);
		System.out.println(etudiant.moyenne());
	}
}