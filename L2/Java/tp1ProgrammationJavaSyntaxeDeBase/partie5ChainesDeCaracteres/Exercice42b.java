package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice42b {
	public static String inverse(String str) {
		String inversedStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			inversedStr += str.charAt(i);
		}
		return inversedStr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		String inversedStr = inverse(str);
		System.out.println("Chaine inversee : " + inversedStr);
		sc.close();
	}
}
