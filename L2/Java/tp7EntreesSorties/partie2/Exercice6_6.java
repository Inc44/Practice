package tp7EntreesSorties.partie2;

import java.io.File;
import java.util.Scanner;
import static tp7EntreesSorties.partie2.Exercice6_1.ecriture;
import static tp7EntreesSorties.partie2.Exercice6_2.lecture;

public class Exercice6_6 {
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels2FileName = "data/Reels2.txt";
		ecriture(reels2FileName, 30, -10.0, 60.0);
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		lecture("data/" + fileName);
		sc.close();
	}
}