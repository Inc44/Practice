package tpExprLambda.exercice2;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		int t[][] = {{1, 2}, {1, 4}, {3, 2}, {1, 2}};
		Stream<Coord> scoord = Arrays.stream(t).map(elem -> new Coord(elem[0], elem[1]));
		scoord.forEach(System.out::println);
	}
}