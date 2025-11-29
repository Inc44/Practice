package tp8ExpressionLambdaSuite.exercice3ChaineDeCaracteres;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class Exercice3ChaineDeCaracteres {
	// TP8 Expressions lambda et API Stream (Suite)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// on cree un Stream a partir du tableau
		// on map (transforme) chaque entier (= element du tablea)
		// en une chaine i+entier ou p+entier
		// que l'on retourne
		// la chaine est ensuite collectee et concatenee avec joining
		// ce qui donne une chaine de caractere finale
		// affectee a "res"
		Integer t1[] = {1, 5, 3, 2, 7, 6, 3, 4, 8, 10, 2, 1, 6};
		String res = Stream.of(t1)
						 .map(entier -> {
							 String s;
							 if (entier % 2 == 0)
								 s = 'p' + String.valueOf(entier);
							 else
								 s = 'i' + String.valueOf(entier);
							 return (s);
						 })
						 .collect(Collectors.joining(","));
		System.out.println(res);

		// on cree un Stream a partir du tableau de chaines de caracteres
		// on filtre pour ne garder que les elements/chaine de caracteres
		// du tableau dont la longueur est superieur a 4
		// que l'on collecte et concatenee avec joining
		// ce qui donne une chaine de caractere finale
		// affectee a "ch"
		String tc[] = {"bonjour", "je", "n'aime", "pas", "les", "Stream/lambda"};
		String ch = Stream.of(tc).filter(s -> s.length() > 4).collect(Collectors.joining("|"));
		System.out.println(ch);

		// on cree un Stream de type Map (dictionnaire)
		// avec cle = String (1er caractere),
		// valeur = une liste de String
		// a partir du tableau de chaines de caracteres
		// on collecte chaque string "s" du tableau dans le map
		// en groupant par le 1er caractere (substring(0,1)
		// ce qui donne une chaine de caractere finale
		// affectee a "ch"
		String tc2[] = {"bonjour", "bibou", "comme", "claire", "est", "partie", "tu", "chantes"};
		Map<String, List<String>> mapS =
			Stream.of(tc2).collect(Collectors.groupingBy(s -> s.substring(0, 1)));
		System.out.println(mapS);
	}
}
