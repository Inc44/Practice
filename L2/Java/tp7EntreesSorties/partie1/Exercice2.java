package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exercice2 {
	public static void readPublicLines(String fileName) {
		try (Scanner sc = new Scanner(new FileReader(fileName))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains("public")) {
					System.out.println(line);
				}
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
		String fileName = "Java/tp7EntreesSorties/partie1/Exercice1a.java";
		readPublicLines(fileName);
	}
}