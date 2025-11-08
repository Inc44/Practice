package tp7EntreesSorties.partie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exercice8 {
	public static void createFile(String fileName, int count, int min, int max) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				int number = rand.nextInt(max - min) + min;
				writer.println(number);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void addFive(String fileName) {
		List<Integer> numbers = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextInt()) {
				int number = sc.nextInt();
				numbers.add(number + 5);
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
			return;
		}
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (int number : numbers) {
				writer.println(number);
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
		String fileName = "data/.txt";
		createFile(fileName, 15, -50, 50);
		readFile(fileName);
		addFive(fileName);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
	}
}