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

public class Exercice9 {
	public static void createFile(String fileName, int count, double min, double max) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			Random rand = new Random();
			for (int i = 0; i < count; i++) {
				double number = rand.nextDouble(max - min) + min;
				writer.println(number);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextDouble()) {
				System.out.println(sc.nextDouble());
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
		}
	}
	public static void zeroNegatives(String fileName) {
		List<Double> numbers = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextDouble()) {
				double number = sc.nextDouble();
				numbers.add(number < 0 ? 0 : number);
			}
		} catch (FileNotFoundException exception) {
			System.err.println("File not found: " + exception.getMessage());
			return;
		}
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (double number : numbers) {
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
		createFile(fileName, 10, -50.0, 50.0);
		readFile(fileName);
		zeroNegatives(fileName);
		System.out.println("After fucking around and finding out:");
		readFile(fileName);
	}
}