package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercice6_7 {
	public static void createSignedFiles(
		String srcFileName, String negFileName, String posFileName) {
		File file = new File(srcFileName);
		if (!file.exists()) {
			System.err.println("File not found");
			return;
		}
		long fileLength = file.length();
		if (fileLength == 0) {
			return;
		}
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file));
			DataOutputStream negDos = new DataOutputStream(new FileOutputStream(negFileName));
			DataOutputStream posDos = new DataOutputStream(new FileOutputStream(posFileName))) {
			for (int i = 0; i < fileLength / 8; i++) {
				double number = dis.readDouble();
				if (number < 0) {
					negDos.writeDouble(number);
				} else {
					posDos.writeDouble(number);
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
		String reels1FileName = "data/Reels1.bin";
		String reels1NegFileName = "data/Reels1neg.bin";
		String reels1PosFileName = "data/Reels1pos.bin";
		createSignedFiles(reels1FileName, reels1NegFileName, reels1PosFileName);
	}
}