package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercice6_5 {
	public static boolean hasIntegerPart(String fileName, int number) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.err.println("File not found");
			return false;
		}
		long fileLength = file.length();
		if (fileLength == 0) {
			return false;
		}
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
			for (int i = 0; i < fileLength / 8; i++) {
				if ((int) dis.readDouble() == number) {
					return true;
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String reels1FileName = "data/Reels1.bin";
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (hasIntegerPart(reels1FileName, number)) {
			System.out.println("You're goddamn right!");
		} else {
			System.out.println("You are still a failure!");
		}
		sc.close();
	}
}