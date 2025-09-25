package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice39 {
	public static String ajouteEtoiles(String s, int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += "*";
		}
		str += s;
		for (int i = 0; i < n; i++) {
			str += "*";
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String s = sc.nextLine();
		System.out.print("Entrez n : ");
		int n = sc.nextInt();
		String str = ajouteEtoiles(s, n);
		System.out.println(str);
		sc.close();
	}
}
