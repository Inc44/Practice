package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice2 {
	public static void readPublicLines(String fileName) {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.indexOf("public") != -1) {
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void main(String[] args) {
		String fileName = "Java/tp7EntreesSorties/partie1/Exercice1a.java";
		readPublicLines(fileName);
	}
}