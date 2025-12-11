package tp8ExpressionLambdaSuite.exercice2TableauDEntiers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.util.Pair;

public class Exercice2TableauDEntiers {
	public static void main(String[] args) {
		Integer t[] = {1, 5, 3, 2, 7, 6, 3, 4, 8, 10, 2, 1, 6};
		List<Integer> l1 = Stream.of(t)
							   .filter(i -> (i % 2) == 0)
							   .limit(5)
							   .map(i -> i * i)
							   .collect(Collectors.toList());
		System.out.println(l1);
		List<Pair<Integer, Integer>> l2 =
			Stream.of(t).map(i -> new Pair<>(i - 1, i)).collect(Collectors.toList());
		System.out.println(l2);
	}
}