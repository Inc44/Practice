package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Exercice9 {
	public static void createFile(String fileName, int count, double min, double max) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				double number = rand.nextDouble(max - min) + min;
				raf.writeDouble(number);
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
			while (raf.getFilePointer() < raf.length()) {
				System.out.println(raf.readDouble());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void zeroNegatives(String fileName) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			while (raf.getFilePointer() < raf.length()) {
				double number = raf.readDouble();
				if (number < 0) {
					raf.seek(raf.getFilePointer() - 8);
					raf.writeDouble(0.0);
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
		String fileName = "data/.dat";
		createFile(fileName, 10, -50.0, 50.0);
		readFile(fileName);
		zeroNegatives(fileName);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
	}
}