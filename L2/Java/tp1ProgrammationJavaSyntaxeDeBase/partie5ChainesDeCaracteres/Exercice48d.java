package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice48d {
	public static String remplaceCar(String reponse, String etatActuel, char guess) {
		String str = "";
		for (int i = 0; i < reponse.length(); i++) {
			if (reponse.charAt(i) == guess) {
				str += guess;
			} else {
				str += etatActuel.charAt(i);
			}
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un mot : ");
		String word = sc.nextLine();
		System.out.print("Entrez l'etat actuel : ");
		String currentState = sc.nextLine();
		System.out.print("Entrez un caractere : ");
		char guess = sc.nextLine().charAt(0);
		String str = remplaceCar(word, currentState, guess);
		// String str = remplaceCar("Taratatta", "T*r*****a", 'a');
		System.out.println("L'etat actuel : " + str);
		sc.close();
	}
}
