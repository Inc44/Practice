package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice48bc {
	public static String initMot(String mot) {
		if (mot.length() <= 2) {
			return mot;
		}
		String str = "";
		str += mot.charAt(0);
		for (int i = 1; i < mot.length() - 1; i++) {
			str += "*";
		}
		str += mot.charAt(mot.length() - 1);
		return str;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un mot : ");
		String word = sc.nextLine();
		String str = initMot(word);
		System.out.println(str);
		sc.close();
	}
}
