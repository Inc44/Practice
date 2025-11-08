package tp7EntreesSorties.partie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercice6_8 {
	public static void concatenateFiles(
		String srcFileName, String srcFileName2, String dstFileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(dstFileName))) {
			try (Scanner sc = new Scanner(new File(srcFileName))) {
				while (sc.hasNextLine()) {
					writer.println(sc.nextLine());
				}
			} catch (FileNotFoundException exception) {
				System.err.println("File not found: " + exception.getMessage());
			}
			try (Scanner sc = new Scanner(new File(srcFileName2))) {
				while (sc.hasNextLine()) {
					writer.println(sc.nextLine());
				}
			} catch (FileNotFoundException exception) {
				System.err.println("File not found: " + exception.getMessage());
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
		String reels1NegFileName = "data/Reels1neg.txt";
		String reels1PosFileName = "data/Reels1pos.txt";
		String reels3FileName = "data/Reels3.txt";
		concatenateFiles(reels1NegFileName, reels1PosFileName, reels3FileName);
	}
}