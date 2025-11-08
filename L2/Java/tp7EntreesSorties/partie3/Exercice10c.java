package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import static tp7EntreesSorties.partie3.Exercice10b.readFile;

public class Exercice10c {
	public static void addAdherent(String fileName, String name, int age, double fee) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			raf.seek(raf.length());
			raf.writeUTF(name);
			raf.writeInt(age);
			raf.writeDouble(fee);
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
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		int age = sc.nextInt();
		double fee = sc.nextDouble();
		addAdherent(fileName, name, age, fee);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
		sc.close();
	}
}