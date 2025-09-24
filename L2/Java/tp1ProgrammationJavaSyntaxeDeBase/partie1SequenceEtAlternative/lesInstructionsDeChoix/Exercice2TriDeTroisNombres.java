package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice2TriDeTroisNombres {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le premier nombre : ");
		int first = sc.nextInt();
		System.out.print("Entrez le deuxieme nombre : ");
		int second = sc.nextInt();
		System.out.print("Entrez le troisieme nombre : ");
		int third = sc.nextInt();
		if (first > second) {
			int temp = first;
			first = second;
			second = temp;
		}
		if (second > third) {
			int temp = second;
			second = third;
			third = temp;
		}
		if (first > second) {
			int temp = first;
			first = second;
			second = temp;
		}
		System.out.println("Tries: " + first + ", " + second + ", " + third);
		sc.close();
	}
}
