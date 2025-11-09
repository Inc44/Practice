package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercice6_4 {
	public static int countNegative(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.err.println("File not found");
			return 0;
		}
		long fileLength = file.length();
		if (fileLength == 0) {
			return 0;
		}
		int negativeCount = 0;
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
			for (int i = 0; i < fileLength / 8; i++) {
				if (dis.readDouble() < 0) {
					negativeCount++;
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return negativeCount;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.bin";
		System.out.println(countNegative(reels1FileName));
	}
}