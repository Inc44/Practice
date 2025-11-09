package tp7EntreesSorties.partie1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exercice1b {
	public static void readFile(String fileName) {
		try (Scanner sc = new Scanner(new FileReader(fileName))) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
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