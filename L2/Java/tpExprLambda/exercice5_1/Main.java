package tpExprLambda.exercice5_1;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Etudiant etudiants[] = {new Etudiant("Codd", "Edgar", 18, 17, 16.5, 19),
			new Etudiant("Backus", "John", 18, 17.5, 16.5, 19),
			new Etudiant("Nygaard", "Kristen", 16, 20, 16.5, 19),
			new Etudiant("Naur", "Peter", 18, 20, 16.5, 17),
			new Etudiant("Turing", "Alan", 20, 20, 16.5, 20)};
		Stream<Etudiant> setudiants = Stream.of(etudiants);
		setudiants.sorted(Comparator.comparing(e -> - e.moyenne())).forEach(System.out::println);
	}
}