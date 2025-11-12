package tp5CollectionsGenericite.partie2Genericite.exercice2TripletHybride;

public class TestTripletHybride {
	public static void main(String[] args) {
		TripletHybride<Integer, Integer, String> tripletEntier =
			new TripletHybride<>(1, 5, "Vingt Cinq");

		System.out.println("Triplet d'entiers : " + tripletEntier);

		TripletHybride<String, String, String> tripletString =
			new TripletHybride<>("Un", "Deux", "Trois");

		System.out.println("Triplet de chaine de caractères : " + tripletString);
	}
}
