package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Exercice6_1 {
	public static void ecriture(String fileName, int count, double min, double max) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				double number = rand.nextDouble(max - min) + min;
				writer.println(number);
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
		String reels1FileName = "data/Reels1.txt";
		ecriture(reels1FileName, 20, -20.0, 50.0);
	}
}