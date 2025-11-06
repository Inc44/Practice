package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1b {
	public static void readFile(String fileName) {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void main(String[] args) {
		String fileName = "data/essai.txt";
		readFile(fileName);
	}
}