package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Exercice7a {
	public static void createFile(String fileName, int count) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			Random rand = new Random();
			double number = rand.nextDouble(20.0);
			writer.println(number);
			for (int i = 1; i < count; i++) {
				number += rand.nextDouble(20.0);
				writer.println(number);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
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
		String r1FileName = "data/R1.txt";
		String r2FileName = "data/R2.txt";
		createFile(r1FileName, 12);
		createFile(r2FileName, 12);
		readFile(r1FileName);
		readFile(r2FileName);
	}
}