package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static tp7EntreesSorties.partie2.Exercice7a.readFile;

public class Exercice7b {
	public static void mergeFiles(String r1FileName, String r2FileName, String r3FileName) {
		try (Scanner sc1 = new Scanner(new File(r1FileName));
			Scanner sc2 = new Scanner(new File(r2FileName));
			PrintWriter writer = new PrintWriter(new FileWriter(r3FileName))) {
			boolean has1 = sc1.hasNextDouble();
			boolean has2 = sc2.hasNextDouble();
			double number1 = has1 ? sc1.nextDouble() : 0;
			double number2 = has2 ? sc2.nextDouble() : 0;
			while (has1 && has2) {
				if (number1 < number2) {
					writer.println(number1);
					has1 = sc1.hasNextDouble();
					if (has1) {
						number1 = sc1.nextDouble();
					}
				} else {
					writer.println(number2);
					has2 = sc2.hasNextDouble();
					if (has2) {
						number2 = sc2.nextDouble();
					}
				}
			}
			if (has1) {
				writer.println(number1);
				while (sc1.hasNextDouble()) {
					writer.println(sc1.nextDouble());
				}
			}
			if (has2) {
				writer.println(number2);
				while (sc2.hasNextDouble()) {
					writer.println(sc2.nextDouble());
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String r1FileName = "data/R1.txt";
		String r2FileName = "data/R2.txt";
		String r3FileName = "data/R3.txt";
		mergeFiles(r1FileName, r2FileName, r3FileName);
		readFile(r3FileName);
	}
}