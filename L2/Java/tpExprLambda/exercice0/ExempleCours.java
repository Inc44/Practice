package tpExprLambda.exercice0;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ExempleCours {
	public static void main(String[] args) {
		Consumer<Integer> consumer = i -> System.out.println(" " + i);

		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200),
			new Integer(101), new Integer(-10), new Integer(0));

		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> " ' " + s + " '";
		Function<Integer, String> quoteIntToString = quote.compose(intToString);

		printList(integerList, consumer, quoteIntToString);
	}

	public static void printList(
		List<Integer> list, Consumer<Integer> consumer, Function<Integer, String> function) {
		for (Integer i : list) {
			consumer.accept(i);
			System.out.println(function.apply(i));
		}
	}
}
