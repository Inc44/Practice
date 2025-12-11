package tp8ExpressionLambdaSuite.exercice3ChaineDeCaracteres;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class Exercice3ChaineDeCaracteres {
	public static void main(String[] args) {
		Integer t[] = {2, 35, 7};
		String res = Stream.of(t)
						 .map(i -> {
							 String s;
							 if (i % 2 == 0)
								 s = 'p' + String.valueOf(i);
							 else
								 s = 'i' + String.valueOf(i);
							 return (s);
						 })
						 .collect(Collectors.joining(","));
		System.out.println(res);
		String tc[] = {"bonjour", "je", "n'aime", "pas", "les", "Stream/lambda"};
		String ch = Stream.of(tc).filter(s -> s.length() > 4).collect(Collectors.joining("|"));
		System.out.println(ch);
		String tc2[] = {"bonjour", "bibou", "comme", "claire", "est", "partie", "tu", "chantes"};
		Map<String, List<String>> mapS =
			Stream.of(tc2).collect(Collectors.groupingBy(s -> s.substring(0, 1)));
		System.out.println(mapS);
	}
}
