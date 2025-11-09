package tp7EntreesSorties.partie2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static tp7EntreesSorties.partie2.Exercice7a.readFile;

public class Exercice7b {
	public static void mergeFiles(String r1FileName, String r2FileName, String r3FileName) {
		File file1 = new File(r1FileName);
		File file2 = new File(r2FileName);
		if (!file1.exists() && !file2.exists()) {
			System.err.println("File not found");
			System.err.println("File not found");
			return;
		}
		if (!file1.exists() || !file2.exists()) {
			System.err.println("File not found");
			File file = file1.exists() ? file1 : file2;
			try (DataInputStream dis = new DataInputStream(new FileInputStream(file));
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(r3FileName))) {
				long fileLength = file.length();
				for (int i = 0; i < fileLength / 8; i++) dos.writeDouble(dis.readDouble());
			} catch (FileNotFoundException exception) {
				System.err.println("File not found: " + exception.getMessage());
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			return;
		}
		long fileLength1 = file1.length();
		long fileLength2 = file2.length();
		try (DataInputStream dis1 = new DataInputStream(new FileInputStream(file1));
			DataInputStream dis2 = new DataInputStream(new FileInputStream(file2));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(r3FileName))) {
			long remaining1 = fileLength1 / 8;
			long remaining2 = fileLength2 / 8;
			boolean has1 = remaining1 > 0;
			boolean has2 = remaining2 > 0;
			double number1 = 0;
			double number2 = 0;
			if (has1) {
				number1 = dis1.readDouble();
				remaining1--;
			}
			if (has2) {
				number2 = dis2.readDouble();
				remaining2--;
			}
			while (has1 && has2) {
				if (number1 <= number2) {
					dos.writeDouble(number1);
					if (remaining1 > 0) {
						number1 = dis1.readDouble();
						remaining1--;
					} else {
						has1 = false;
					}
				} else {
					dos.writeDouble(number2);
					if (remaining2 > 0) {
						number2 = dis2.readDouble();
						remaining2--;
					} else {
						has2 = false;
					}
				}
			}
			while (has1) {
				dos.writeDouble(number1);
				if (remaining1 > 0) {
					number1 = dis1.readDouble();
					remaining1--;
				} else {
					has1 = false;
				}
			}
			while (has2) {
				dos.writeDouble(number2);
				if (remaining2 > 0) {
					number2 = dis2.readDouble();
					remaining2--;
				} else {
					has2 = false;
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
		String r1FileName = "data/R1.bin";
		String r2FileName = "data/R2.bin";
		String r3FileName = "data/R3.bin";
		mergeFiles(r1FileName, r2FileName, r3FileName);
		readFile(r3FileName);
	}
}