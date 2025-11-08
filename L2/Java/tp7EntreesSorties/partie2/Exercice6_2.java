package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice6_2 {
	public static void lecture(String fileName) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextDouble()) {
				System.out.println(sc.nextDouble());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.txt";
		lecture(reels1FileName);
	}
}