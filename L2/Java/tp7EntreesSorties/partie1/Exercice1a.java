package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercice1a {
	public static void createFile(String fileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			writer.println("Mry2Dima");
			writer.println("Kotleta");
			writer.println("Inc44");
			writer.println("Xamitu Chidirif");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String fileName = "data/essai.txt";
		createFile(fileName);
	}
}