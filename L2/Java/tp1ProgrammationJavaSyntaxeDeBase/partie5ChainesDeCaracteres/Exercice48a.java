package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

public class Exercice48a {
	public static void affichePendu(int n) {
		System.out.println("+--+");
		System.out.println("|" + (n >= 1 ? "  |" : ""));
		System.out.println("|" + (n >= 2 ? "  o" : ""));
		System.out.println("|" + (n >= 3 ? "  |" : ""));
		System.out.println("|" + (n == 4 ? "  |" : "") + (n >= 5 ? " / \\" : ""));
		System.out.println("|" + (n >= 6 ? "  |" : ""));
		System.out.println("|" + (n == 7 ? "  |" : "") + (n >= 8 ? " / \\" : ""));
		System.out.println("|");
	}
	public static void main(String[] args) {
		affichePendu(3);
		affichePendu(7);
	}
}
