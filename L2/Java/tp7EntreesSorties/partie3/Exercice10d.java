package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import static tp7EntreesSorties.partie3.Exercice10b.readFile;

public class Exercice10d {
	public static void modifyAdherent(
		String fileName, String nameToModify, int newAge, double newFee) {
		boolean found = false;
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			while (raf.getFilePointer() < raf.length()) {
				long recordStartPos = raf.getFilePointer();
				String name = raf.readUTF();
				if (name.equals(nameToModify)) {
					raf.writeInt(newAge);
					raf.writeDouble(newFee);
					found = true;
					break;
				} else {
					raf.seek(recordStartPos);
					raf.readUTF();
					raf.readInt();
					raf.readDouble();
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		if (!found) {
			System.err.println("Adherent not found");
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String fileName = "data/ADHERENTS.dat";
		readFile(fileName);
		Scanner sc = new Scanner(System.in);
		String nameToModify = sc.nextLine();
		int newAge = sc.nextInt();
		double newFee = sc.nextDouble();
		modifyAdherent(fileName, nameToModify, newAge, newFee);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
		sc.close();
	}
}