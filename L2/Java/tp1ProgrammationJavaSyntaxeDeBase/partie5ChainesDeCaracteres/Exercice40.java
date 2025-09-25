package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice40 {
	public static String supprimeCar(String s, char c) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				str += s.charAt(i);
			}
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Entrez une chaine : ");
		String s = sc.nextLine();
		System.out.print("Entrez un caractere : ");
		char c = sc.next().charAt(0);
		String str = supprimeCar(s, c);
		System.out.println(str);
		sc.close();
	}
}
