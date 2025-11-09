package tp7EntreesSorties.partie2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Exercice6_1 {
	public static void ecriture(String fileName, int count, double min, double max) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				double number = rand.nextDouble(max - min) + min;
				dos.writeDouble(number);
			}
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
		ecriture(reels1FileName, 20, -20.0, 50.0);
	}
}