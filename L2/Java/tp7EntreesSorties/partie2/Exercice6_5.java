package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice6_5 {
	public static boolean hasIntegerPart(String fileName, int number) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextDouble()) {
				if ((int) sc.nextDouble() == number) {
					return true;
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
		return false;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.txt";
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (hasIntegerPart(reels1FileName, number)) {
			System.out.println("You're goddamn right!");
		} else {
			System.out.println("You are still a failure!");
		}
		sc.close();
	}
}