package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercice6_2 {
	public static void lecture(String fileName) {
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
			for (int i = 0; i < fileLength / 8; i++) {
				System.out.println(dis.readDouble());
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
		String reels1FileName = "data/Reels1.bin";
		lecture(reels1FileName);
	}
}