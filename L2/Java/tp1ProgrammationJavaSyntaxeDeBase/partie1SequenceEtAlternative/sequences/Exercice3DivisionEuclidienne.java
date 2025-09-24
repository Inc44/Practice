package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.sequences;

import java.util.Scanner;

public class Exercice3DivisionEuclidienne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez n : ");
		int n = sc.nextInt();
		System.out.print("Entrez d : ");
		int divisor = sc.nextInt();
		int quotient = n / divisor;
		int remainder = n % divisor;
		System.out.println("Quotient : " + quotient);
		System.out.println("Reste : " + remainder);
		sc.close();
	}
}
