package tp8ExpressionLambdaSuite.exercice1ClassePoint;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TP8 Expressions lambda et API Stream (Suite)
public class Exercice1ClassePoint {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		// on cree un Stream a partir du tableau
		// que l'on map (permet permet de transformer la nature du stream
		// afin de passer d'un type a un autre)
		// puis on utilise collect
		// pour collecter les valeurs du Stream
		// dans une List
		Integer t2[] = {1, 5, 3, 2, 7}; // attention pas int t2[]!!!
		List<Point> l = Stream.of(t2).map(i -> new Point(i, i * 2)).collect(Collectors.toList());
		System.out.println(l);

		// ou:
		Stream.of(t2)
			.map(i -> new Point(i, i * 2))
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}
