package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;
import java.util.Random;

public class Exercice33MatriceTransposeeEtMatriceOpposee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Entrez N : ");
		int N = sc.nextInt();
		System.out.print("Entrez M : ");
		int M = sc.nextInt();
		int min = -100, max = 100;
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = rand.nextInt(max - min) + min;
			}
		}
		// int[][] A = {{0,2,13},{-2,0,-8},{-13,8,0}};
		System.out.println("Matrice A :");
		for (int[] row : A) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		int[][] tA = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tA[j][i] = A[i][j];
			}
		}
		System.out.println("Transposee tA :");
		for (int[] row : tA) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		int[][] Aopp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Aopp[i][j] = -A[i][j];
			}
		}
		System.out.println("Opposee -A :");
		for (int[] row : Aopp) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		boolean isAntiSymmetric = (N == M);
		if (isAntiSymmetric) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tA[i][j] != Aopp[i][j]) {
						isAntiSymmetric = false;
						break;
					}
				}
			}
		}
		System.out.println("Antisymetrique : " + isAntiSymmetric);
		sc.close();
	}
}
