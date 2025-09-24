package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;
import java.util.Random;

public class Exercice35CompressionDUneMatriceDePixels {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int[][] matrix = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matrix[i][j] = rand.nextInt(255);
			}
		}
		/*
		int[][] matrix = {{134, 217, 62, 161, 131, 206, 192, 121},
			{39, 242, 136, 42, 234, 120, 146, 89}, {80, 230, 221, 105, 15, 119, 20, 1},
			{233, 4, 241, 72, 156, 83, 231, 185}, {233, 175, 146, 134, 247, 27, 162, 131},
			{241, 9, 250, 12, 49, 111, 239, 240}, {210, 66, 191, 137, 41, 240, 147, 62},
			{30, 16, 138, 94, 36, 185, 181, 238}};
		*/
		int[][] compMatrix = new int[4][4];
		int sum;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum = matrix[2 * i][2 * j] + matrix[2 * i][2 * j + 1] + matrix[2 * i + 1][2 * j]
					+ matrix[2 * i + 1][2 * j + 1];
				compMatrix[i][j] = sum / 4;
			}
		}
		System.out.println("La compression de la matrice 8x8 suivante :");
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		System.out.println("Donne la matrice 4x4 suivante :");
		for (int[] row : compMatrix) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
