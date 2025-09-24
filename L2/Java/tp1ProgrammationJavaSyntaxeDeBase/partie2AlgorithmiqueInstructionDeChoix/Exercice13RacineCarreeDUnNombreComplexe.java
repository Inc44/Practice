package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice13RacineCarreeDUnNombreComplexe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez la partie reelle de Z : ");
		double X = sc.nextDouble();
		System.out.print("Entrez la partie imaginaire de Z : ");
		double Y = sc.nextDouble();
		double modZ = Math.sqrt(X * X + Y * Y);
		double modz = Math.sqrt(modZ);
		double arg = Math.atan2(Y, X) / 2;
		double x1 = modz * Math.cos(arg);
		double y1 = modz * Math.sin(arg);
		double x2 = -x1;
		double y2 = -y1;
		System.out.println("Racines : " + x1 + " + " + y1 + "i, " + x2 + " + " + y2 + "i");
		sc.close();
	}
}
