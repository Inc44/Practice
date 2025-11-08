package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercice10a {
	public static void createFile(String fileName) {
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			raf.setLength(0);
			raf.writeUTF("Paul");
			raf.writeInt(18);
			raf.writeDouble(27.5);
			raf.writeUTF("Jacques");
			raf.writeInt(23);
			raf.writeDouble(12.5);
			raf.writeUTF("Anne");
			raf.writeInt(21);
			raf.writeDouble(24.5);
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
		createFile(fileName);
	}
}