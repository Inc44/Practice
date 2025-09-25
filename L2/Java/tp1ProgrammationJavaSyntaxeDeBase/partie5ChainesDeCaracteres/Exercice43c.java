package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Random;

public class Exercice43c {
	public static String genere() {
		Random rand = new Random();
		String symbols = ":-()";
		String str = "";
		for (int i = 0; i < 10; i++) {
			str += symbols.charAt(rand.nextInt(symbols.length()));
		}
		return str;
	}
	public static boolean gagne(String str) {
		return str.contains(":-)");
	}
	public static void joue() {
		String str = genere();
		boolean isVictory = gagne(str);
		if (isVictory) {
			System.out.println("gagne");
		}
	}
	public static void main(String[] args) {
		joue();
	}
}
