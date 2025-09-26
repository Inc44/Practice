package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice47 {
	public static void afficheMinMax(String str) {
		double min = 0;
		double max = 0;
		boolean initialized = false;
		String numberStr = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c >= '0' && c <= '9') || c == '.') {
				numberStr += c;
			}
			if (c == ';') {
				double number = numberStr.isEmpty() ? 0 : Double.parseDouble(numberStr);
				if (!initialized) {
					min = number;
					max = number;
					initialized = true;
				} else {
					if (number < min)
						min = number;
					else if (number > max)
						max = number;
				}
				numberStr = "";
			}
		}
		System.out.println("Min : " + min + "cm");
		System.out.println("Max : " + max + "cm");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String ch = sc.nextLine();
		// String ch = "1.93cm;2.2cm;1.65cm;1.76cm;2.07cm;1.8cm;";
		afficheMinMax(ch);
		sc.close();
	}
}
