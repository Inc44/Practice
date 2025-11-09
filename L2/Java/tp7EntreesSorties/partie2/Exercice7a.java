package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Exercice7a {
	public static void createFile(String fileName, int count) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
			Random rand = new Random();
			double number = rand.nextDouble(20.0);
			dos.writeDouble(number);
			for (int i = 1; i < count; i++) {
				number += rand.nextDouble(20.0);
				dos.writeDouble(number);
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
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
		String r1FileName = "data/R1.bin";
		String r2FileName = "data/R2.bin";
		createFile(r1FileName, 12);
		createFile(r2FileName, 12);
		readFile(r1FileName);
		readFile(r2FileName);
	}
}