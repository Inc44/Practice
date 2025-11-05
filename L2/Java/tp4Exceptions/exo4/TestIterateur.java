package tp4Exceptions.exo4;

public class TestIterateur {
	public TestIterateur(String message, int[] t) {
		IterateurDesPairs i = new IterateurDesPairs(t);
		System.out.print(message);
		while (i.aUnSuivant()) {
			System.out.print(i.indiceDuSuivant() + "->" + i.suivant());
			System.out.print(",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new TestIterateur("test1 : ", new int[] {1, 2, 6, 7, 8, 9, 11, 12, 14, 13, 5});
		new TestIterateur("test2 : ", new int[] {2, 79});
		new TestIterateur("test3 : ", new int[] {});
	}
}