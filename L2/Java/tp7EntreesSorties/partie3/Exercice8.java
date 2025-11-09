package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Exercice8 {
	public static void createFile(String fileName, int count, int min, int max) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				int number = rand.nextInt(max - min) + min;
				raf.writeInt(number);
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
				System.out.println(raf.readInt());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void addFive(String fileName) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			while (raf.getFilePointer() < raf.length()) {
				int number = raf.readInt();
				raf.seek(raf.getFilePointer() - 4);
				raf.writeInt(number + 5);
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
		createFile(fileName, 15, -50, 50);
		readFile(fileName);
		addFive(fileName);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
	}
}