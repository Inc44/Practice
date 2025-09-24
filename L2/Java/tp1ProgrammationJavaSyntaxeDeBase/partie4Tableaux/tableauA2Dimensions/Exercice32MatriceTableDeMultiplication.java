package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;

public class Exercice32MatriceTableDeMultiplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez N : ");
		int N = sc.nextInt();
		System.out.print("Entrez M : ");
		int M = sc.nextInt();
		int[][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = i * j;
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
