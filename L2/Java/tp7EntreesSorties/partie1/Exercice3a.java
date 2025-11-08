package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercice3a {
	public static void createFile(String fileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName));
			Scanner sc = new Scanner(System.in)) {
			while (true) {
				String line = sc.nextLine();
				if (line.equals("0")) {
					break;
				}
				writer.println(line);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String fileName = "data/texte.txt";
		createFile(fileName);
	}
}