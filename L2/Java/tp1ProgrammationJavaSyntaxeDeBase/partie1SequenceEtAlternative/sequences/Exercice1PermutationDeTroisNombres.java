package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.sequences;

import java.util.Scanner;

public class Exercice1PermutationDeTroisNombres {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le premier nombre : ");
		int first = sc.nextInt();
		System.out.print("Entrez le deuxieme nombre : ");
		int second = sc.nextInt();
		System.out.print("Entrez le troisieme nombre : ");
		int third = sc.nextInt();
		int temp = first;
		first = second;
		second = third;
		third = temp;
		System.out.println("Apres permutation : " + first + ", " + second + ", " + third);
		sc.close();
	}
}
