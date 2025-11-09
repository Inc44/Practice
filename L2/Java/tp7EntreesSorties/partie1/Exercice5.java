package tp7EntreesSorties.partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercice5 {
	public static void createFile(String fileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			writer.println("/* ceci");
			writer.println("est");
			writer.println("un commentaire */");
			writer.println("et on essaye");
			writer.println("de supprimer");
			writer.println("/* tous les commentaires*/");
			writer.println("du fichier");
			writer.println("Alors?");
			writer.println("/* marche");
			writer.println("ou marche pas*/");
			writer.println("?");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void createFileWithoutComments(String srcFileName, String dstFileName) {
		try (Scanner sc = new Scanner(new FileReader(srcFileName));
			PrintWriter writer = new PrintWriter(new FileWriter(dstFileName))) {
			boolean inComment = false;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.trim().contains("/*")) {
					inComment = true;
				}
				if (!inComment) {
					writer.println(line);
				}
				if (inComment && line.trim().contains("*/")) {
					inComment = false;
				}
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
		String srcFileName = "data/AvecCom.txt";
		String dstFileName = "data/SansCom.txt";
		createFile(srcFileName);
		createFileWithoutComments(srcFileName, dstFileName);
		readFile(dstFileName);
	}
}