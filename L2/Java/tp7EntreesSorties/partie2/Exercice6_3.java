package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice6_3 {
	public static void stats(String fileName) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			if (!sc.hasNextDouble()) {
				return;
			}
			double first = sc.nextDouble();
			double max = first;
			double min = first;
			double sum = first;
			int count = 1;
			while (sc.hasNextDouble()) {
				double number = sc.nextDouble();
				if (number < min)
					min = number;
				if (number > max)
					max = number;
				sum += number;
				count++;
			}
			System.out.println("Max: " + max);
			System.out.println("Min: " + min);
			System.out.println("Average: " + sum / count);
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.txt";
		stats(reels1FileName);
	}
}