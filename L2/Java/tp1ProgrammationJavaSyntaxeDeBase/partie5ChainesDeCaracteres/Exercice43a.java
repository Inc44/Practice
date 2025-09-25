package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Random;

public class Exercice43a {
	public static String genere() {
		Random rand = new Random();
		String symbols = ":-()";
		String str = "";
		for (int i = 0; i < 10; i++) {
			str += symbols.charAt(rand.nextInt(symbols.length()));
		}
		return str;
	}
	public static void main(String[] args) {
		String str = genere();
		System.out.println("Chaine aleatoire : " + str);
	}
}
