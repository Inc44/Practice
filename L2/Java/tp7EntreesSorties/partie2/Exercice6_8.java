package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercice6_8 {
	public static void concatenateFiles(
		String srcFileName, String srcFileName2, String dstFileName) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(dstFileName))) {
			File file1 = new File(srcFileName);
			if (!file1.exists()) {
				System.err.println("File not found");
			} else {
				long fileLength = file1.length();
				try (DataInputStream dis1 = new DataInputStream(new FileInputStream(file1))) {
					for (int i = 0; i < fileLength / 8; i++) dos.writeDouble(dis1.readDouble());
				}
			}
			File file2 = new File(srcFileName2);
			if (!file2.exists()) {
				System.err.println("File not found");
			} else {
				long fileLength2 = file2.length();
				try (DataInputStream dis2 = new DataInputStream(new FileInputStream(file2))) {
					for (int i = 0; i < fileLength2 / 8; i++) dos.writeDouble(dis2.readDouble());
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
		String reels1NegFileName = "data/Reels1neg.bin";
		String reels1PosFileName = "data/Reels1pos.bin";
		String reels3FileName = "data/Reels3.bin";
		concatenateFiles(reels1NegFileName, reels1PosFileName, reels3FileName);
	}
}