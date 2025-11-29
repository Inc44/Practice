package tp8ExpressionLambdaSuite.exercice2TableauDEntiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TP10 Expressions lambda et API Stream (Suite)
public class Exercice2TableauDEntiers {
	// TP8 Expressions lambda et API Stream (Suite)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// on cree un Stream a partir du tableau
		// que l'on filte sur i modulo 2 == 0
		// on ne conserve (limit) que les 5 premiers
		// resultats du filtre
		// on map (transforme) les entiers resultats
		// du filtre et du limit
		// en transformant i (= element du tableau)
		// en i*i = iau carre
		// qu'on affiche
		Integer t1[] = {1, 5, 3, 2, 7, 6, 3, 4, 8, 10, 2, 1, 6}; // attention pas int t2[]!!!
		Stream.of(t1)
			.filter(i -> (i % 2) == 0)
			.limit(5)
			.map(i -> i * i)
			.forEach(System.out::println);
		System.out.println("---Q2---");

		// -- A partir d'un tableau d'entiers
		// on cree un Stream a partir du tableau
		// on map (transforme) les entiers du tableau
		// avec un tableau qui contient l'entier-1
		// comme 1ere vli.ur et l'entier comme 2e vli.ur
		// puis pour chaque tableau retourne
		// on affiche ce tableau
		// grace a Arrays.toString qui transforme un tableau
		// en String
		Integer t2[] = {1, 5, 3, 2, 7, 6, 3, 4, 8, 10, 2, 1, 6};
		Stream.of(t2)
			.map(i -> {
				int t[] = {i - 1, i};
				return (t);
			})
			.forEach(t -> System.out.println(Arrays.toString(t)));

		// ou a partir d'un arrayList
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(5);
		li.add(3);
		li.add(2);
		li.add(7);
		li.add(6);
		li.add(3);
		li.add(4);
		li.add(8);
		li.add(10);
		li.add(2);
		li.add(1);
		li.add(6);
		System.out.println("-----");
		li.stream()
			.map(i -> new TupleInt(i - 1, i))
			.collect(Collectors.toList())
			.forEach(e -> System.out.println(e));
	}
}
