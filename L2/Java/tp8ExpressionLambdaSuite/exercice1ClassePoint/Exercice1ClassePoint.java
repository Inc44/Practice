package tp8ExpressionLambdaSuite.exercice1ClassePoint;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercice1ClassePoint {
	public static void main(String[] args) {
		Point p[] = {
			new Point(1, 2), new Point(1, 2), new Point(-1, 4), new Point(3, 2), new Point(-1, 2)};
		Set<Point> ens = Stream.of(p).filter(point -> point.getX() > 0).collect(Collectors.toSet());
		System.out.println(ens);
		Integer t[] = {1, 5, 3, 2, 7, 1, 2};
		Stream<Point> st = Stream.of(t).map(i -> new Point(i, i * 2));
		Map<Integer, List<Point>> map = st.collect(Collectors.groupingBy(Point::getX));
		System.out.println(map);
	}
}