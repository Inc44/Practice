package tpExprLambda.exercice0;

public class Calculatrice {
	public static void main(String[] args) {
		OperationEntiere add = (x, y) -> x + y;
		OperationEntiere minus = (x, y) -> x - y;

		Calculatrice calc = new Calculatrice();

		System.out.println("add (10,20) : " + calc.calculer(10, 20, add));
		System.out.println("minus (10,20) : " + calc.calculer(10, 20, minus));
	}

	public long calculer(int a, int b, OperationEntiere op) {
		return op.effectuer(a, b);
	}
}
