package tp8ExpressionLambdaSuite.exercice1ClassePoint;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TP10 Expressions lambda et API Stream (Suite)
public class Exercice1ClassePoint {
	public static void main(String[] args) {
		// Question 1
		//-----------
		Point t[] = {
			new Point(1, 2), new Point(1, 2), new Point(-1, 4), new Point(3, 2), new Point(-1, 2)};

		// on cree un Stream a partir du tableau
		// que l'on filtre
		// puis on utilise collect
		// pour collecter les valeurs du Stream filtrees avec getX()>0
		// dans un Set
		Set<Point> ens = Stream.of(t).filter(point -> point.getX() > 0).collect(Collectors.toSet());
		System.out.println(ens);
		// ou:
		Stream.of(t)
			.filter(point -> point.getX() > 0)
			.collect(Collectors.toSet())
			.forEach(System.out::println);

		// Question 2
		//-----------
		System.out.println("---");
		Integer p[] = {1, 5, 3, 2, 7}; // et non int!!!!
		Arrays.stream(p).map(elem -> elem * 2).forEach(System.out::println);
		Arrays.stream(p).map(elem -> new Point(elem, elem * 2)).forEach(System.out::println);

		// on cree un Stream a partir du tableau
		// que l'on map (permet permet de transformer la nature du stream
		// afin de passer d'un type a un autre)
		// puis on utilise collect
		// pour collecter les valeurs du Stream
		// dans une List... insuffisant
		Integer t2[] = {1, 5, 3, 2, 7}; // attention pas int t2[]!!!
		List<Point> l = Stream.of(t2).map(i -> new Point(i, i * 2)).collect(Collectors.toList());
		System.out.println(l);
		// ou:
		Stream.of(t2)
			.map(i -> new Point(i, i * 2))
			.collect(Collectors.toList())
			.forEach(System.out::println);

		// Mieux avec liste intermediaire + groupingBy pour creer le HashMap
		System.out.println("...");
		Integer t3[] = {1, 5, 3, 2, 7, 1, 2};
		List<Point> l2 = Stream.of(t3).map(i -> new Point(i, i * 2)).collect(Collectors.toList());
		System.out.println(l2);
		Map<Integer, List<Point>> hm = l2.stream().collect(Collectors.groupingBy(Point::getX));
		System.out.println(hm);
		// Solution 1
		// Mieux, plus court, sans liste intermediaire...
		// on cree un Stream a partir du tableau
		// que l'on transforme/map (entier -> Point)
		// puis on utilise collect
		// pour collecter les valeurs du Stream
		// dans une collection de type Map dont la cle est le groupement getX()
		// et la valeur est le point (l'element)
		Map<Integer, List<Point>> hm2 =
			Stream.of(t3).map(i -> new Point(i, i * 2)).collect(Collectors.groupingBy(Point::getX));
		System.out.println(hm2);
		// Ou: faux  car pas ArrayList.... et pas 2 fois la meme cle
		Integer t4[] = {1, 5, 3, 2, 7};
		Map<Integer, Point> hm3 = Stream.of(t4)
									  .map(e -> new Point(e, e * 2))
									  .collect(Collectors.toMap(e -> e.getX(), e -> e));
		System.out.println(hm3);
		// Ou (mais pas ne fonctionne pas si 2 fois la meme cle, les meme nombres):
		Integer t5[] = {1, 5, 3, 2, 7};
		Map<Integer, ArrayList<Point>> hm4 =
			Stream.of(t5)
				.map(e -> new Point(e, e * 2))
				.collect(
					Collectors.toMap(e -> e.getX(), e -> new ArrayList<Point>(Arrays.asList(e))));
		System.out.println(hm4);
		// Solution 2
		// 2 fois  la meme cle cf t3... tout fonctionne...
		Map<Integer, ArrayList<Point>> hm5 = Stream.of(t3)
												 .map(e -> new Point(e, e * 2))
												 .collect(Collectors.toMap(e
													 -> e.getX(),
													 e
													 -> {
														 ArrayList<Point> pl =
															 new ArrayList<Point>();
														 pl.add(e);
														 return pl;
													 },
													 (ll, lr) -> {
														 ll.addAll(lr);
														 return ll;
													 }));
		System.out.println(hm5);
	}
}
