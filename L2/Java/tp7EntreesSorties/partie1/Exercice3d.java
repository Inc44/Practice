package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice3d {
	public static int countWords(String fileName) {
		int wordCount = 0;
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				boolean inWord = false;
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == ' ' || c == '\'') {
						if (inWord) {
							wordCount++;
							inWord = false;
						}
					} else {
						if (!inWord) {
							inWord = true;
						}
					}
				}
				if (inWord) {
					wordCount++;
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
		return wordCount;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String fileName = "data/texte.txt";
		int wordCount = countWords(fileName);
		System.out.println(wordCount);
	}
}