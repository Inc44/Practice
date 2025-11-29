package tpExprLambda.exercice5;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Etudiant etudiants[] = {new Etudiant("Codd", "Edgar", 18, 17, 18),
			new Etudiant("Backus", "John", 18, 17.5, 19),
			new Etudiant("Nygaard", "Kristen", 16, 20, 19),
			new Etudiant("Naur", "Peter", 18, 20, 17), new Etudiant("Turing", "Alan", 20, 20, 20)};

		// Question 1
		Stream.of(etudiants)
			.sorted((x, y) -> {
				if (x.moyenne() < y.moyenne())
					return 1;
				else
					return -1;
			})
			.map(x -> {
				// Question 2
				System.out.println(" -> " + x + " <-");
				return x;
			})
			.limit(3)
			.forEach(System.out::println);

		// Question 3
		/*
		OptionalDouble moyenne =
			Stream.of(etudiants).flatMap(x -> x.notesAsStream()).mapToDouble(x -> x).average();

		if (moyenne.isPresent()) {
			System.out.println("La moyenne générale est " + moyenne.getAsDouble());
		}
		*/
		System.out.print("La moyenne générale est : "
			+ Stream.of(etudiants)
				.flatMap(x -> x.notesAsStream())
				.mapToDouble(x -> x)
				.average()
				.orElse(0));
	}
}
