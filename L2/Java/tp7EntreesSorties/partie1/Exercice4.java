package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercice4 {
	public static void createFile(String fileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			writer.println("21065468 Darboux Jean note: 16");
			writer.println("21067484 De la Croix Alfred note: 12");
			writer.println("21065386 Despre Estelle note: 11");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void createFileWithoutNames(String srcFileName, String dstFileName) {
		try (Scanner sc = new Scanner(new FileReader(srcFileName));
			PrintWriter writer = new PrintWriter(new FileWriter(dstFileName))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner lineSc = new Scanner(line);
				String id = lineSc.next();
				String grade = "";
				while (lineSc.hasNext()) {
					grade = lineSc.next();
				}
				writer.println(id + " " + grade);
				lineSc.close();
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
		try (Scanner sc = new Scanner(new FileReader(fileName))) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void main(String[] args) {
		File dataDir = new File("data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		String srcFileName = "data/notes.txt";
		String dstFileName = "data/notes2.txt";
		createFile(srcFileName);
		createFileWithoutNames(srcFileName, dstFileName);
		readFile(dstFileName);
	}
}