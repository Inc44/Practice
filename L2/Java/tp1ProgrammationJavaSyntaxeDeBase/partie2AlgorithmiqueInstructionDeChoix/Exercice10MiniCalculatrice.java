package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice10MiniCalculatrice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez l'operation (+ ou - ou * ou / ou ! ou i) : ");
		char operation =
			sc.nextLine().charAt(0); // Index 0 out of bounds for length 0 if Enter is pressed
		if (operation == '!' || operation == 'i') {
			System.out.print("Entrez le nombre : ");
			double number = sc.nextDouble();
			if (operation == '!') {
				System.out.println(-number);
			} else {
				System.out.println(1 / number);
			}
		} else {
			System.out.print("Entrez le premier nombre : ");
			double first = sc.nextDouble();
			System.out.print("Entrez le deuxieme nombre : ");
			double second = sc.nextDouble();
			switch (operation) {
				case '+':
					System.out.println(first + second);
					break;
				case '-':
					System.out.println(first - second);
					break;
				case '*':
					System.out.println(first * second);
					break;
				case '/':
					System.out.println(first / second);
					break;
			}
		}
		sc.close();
	}
}
