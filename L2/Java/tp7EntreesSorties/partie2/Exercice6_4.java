package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice6_4 {
	public static int countNegative(String fileName) {
		int negativeCount = 0;
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextDouble()) {
				if (sc.nextDouble() < 0) {
					negativeCount++;
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
		return negativeCount;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.txt";
		System.out.println(countNegative(reels1FileName));
	}
}