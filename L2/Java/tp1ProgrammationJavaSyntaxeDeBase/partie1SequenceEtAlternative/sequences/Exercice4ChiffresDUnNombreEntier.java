package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.sequences;

import java.util.Scanner;

public class Exercice4ChiffresDUnNombreEntier {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier : ");
		int number = sc.nextInt();
		int unitsDigit = number % 10;
		int tensDigit = (number / 10) % 10;
		int hundredsDigit = (number / 100) % 10;
		System.out.println("Unites : " + unitsDigit);
		System.out.println("Dizaines : " + tensDigit);
		System.out.println("Centaines : " + hundredsDigit);
		sc.close();
	}
}
