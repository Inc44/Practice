package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercice6_7 {
	public static void createSignedFiles(
		String srcFileName, String negFileName, String posFileName) {
		try (Scanner sc = new Scanner(new File(srcFileName));
			PrintWriter negWriter = new PrintWriter(new FileWriter(negFileName));
			PrintWriter posWriter = new PrintWriter(new FileWriter(posFileName))) {
			while (sc.hasNextDouble()) {
				double number = sc.nextDouble();
				if (number < 0) {
					negWriter.println(number);
				} else {
					posWriter.println(number);
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
		String reels1FileName = "data/Reels1.txt";
		String reels1NegFileName = "data/Reels1neg.txt";
		String reels1PosFileName = "data/Reels1pos.txt";
		createSignedFiles(reels1FileName, reels1NegFileName, reels1PosFileName);
	}
}