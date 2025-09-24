package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.sequences;

import java.util.Scanner;

public class Exercice2ParallelepipedeRectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez la longueur : ");
		double length = sc.nextDouble();
		System.out.print("Entrez la largeur : ");
		double width = sc.nextDouble();
		System.out.print("Entrez la hauteur : ");
		double height = sc.nextDouble();
		double surface = 2 * (length * width + length * height + width * height);
		double volume = length * width * height;
		System.out.println("Surface : " + surface);
		System.out.println("Volume : " + volume);
		sc.close();
	}
}
