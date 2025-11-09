package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercice10b {
	public static void readFile(String fileName) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
			while (raf.getFilePointer() < raf.length()) {
				String name = raf.readUTF();
				int age = raf.readInt();
				double fee = raf.readDouble();
				System.out.println(name + ", " + age + " ans, cotisation : " + fee + " euros");
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
		String fileName = "data/ADHERENTS.dat";
		readFile(fileName);
	}
}