package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exercice3c {
	public static int countLines(String fileName) {
		int lineCount = 0;
		try (Scanner sc = new Scanner(new FileReader(fileName))) {
			while (sc.hasNextLine()) {
				sc.nextLine();
				lineCount++;
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
		return lineCount;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String fileName = "data/texte.txt";
		int lineCount = countLines(fileName);
		System.out.println(lineCount);
	}
}