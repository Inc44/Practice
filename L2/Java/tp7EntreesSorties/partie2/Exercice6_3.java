package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercice6_3 {
	public static void stats(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.err.println("File not found");
			return;
		}
		long fileLength = file.length();
		if (fileLength == 0) {
			return;
		}
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
			double first = dis.readDouble();
			double max = first;
			double min = first;
			double sum = first;
			for (int i = 1; i < fileLength / 8; i++) {
				double number = dis.readDouble();
				if (number < min)
					min = number;
				if (number > max)
					max = number;
				sum += number;
			}
			System.out.println("Max: " + max);
			System.out.println("Min: " + min);
			System.out.println("Average: " + sum / (fileLength / 8));
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
		String reels1FileName = "data/Reels1.bin";
		stats(reels1FileName);
	}
}