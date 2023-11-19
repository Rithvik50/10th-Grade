
import java.util.*;
import java.io.*;

public class ZipTester {

	public static final String FILE_NAME = "Kafka.txt";

	public static boolean compareFiles(String file1, String file2) {
		BufferedReader bReader = null;
		BufferedReader bReader2 = null;
		int line = 1;
		try {
			bReader = new BufferedReader(new FileReader(file1));
			bReader2 = new BufferedReader(new FileReader(file2));
			@SuppressWarnings("resource")
			Scanner in = new Scanner(bReader);
			@SuppressWarnings("resource")
			Scanner in2 = new Scanner(bReader2);
			while (in.hasNextLine() && in2.hasNextLine()) {
				boolean lineEqual = true;
				String input = in.nextLine();
				String input2 = in2.nextLine();
				lineEqual = input.equals(input2);
				if (!lineEqual) {
					System.out
							.println("First difference between " + file1 + " and " + file2 + " found on line " + line);
					System.out.println(file1 + ":" + input);
					System.out.println(file2 + ":" + input2);
					return false;
				}
				line++;
			}
			if (in.hasNextLine() || in2.hasNextLine()) {
				System.out.println(file1 + " and " + file2 + " have different lengths");
				return false;
			}
		} catch (IOException ex) {
			System.out.println("File cannot be read.");
			return false;
		} finally {
			try {
				if (bReader != null)
					bReader.close();
				if (bReader2 != null)
					bReader2.close();
			} catch (IOException ex) {
				System.out.println("File failed to close.");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		FileZip zipper = new FileZip();

		if (!(new File(FILE_NAME).exists())) {
			System.out.println("File does not exist. Quitting.");
			System.exit(1);
		}
		int i = FILE_NAME.lastIndexOf(".");
		String extension = "";
		String testFile = FILE_NAME;
		if (i >= 0) {
			extension = testFile.substring(i);
			testFile = testFile.substring(0, i);
		}

		System.out.println("TESTING: Do your readFile and writeFile produce exact copies?");
		try {
			String data = zipper.readFile(testFile + extension);
			zipper.writeFile(data, testFile + "2" + extension);
		} catch (Exception e) {
			System.out.println("FileZip's read or write threw an exception!");
			e.printStackTrace();
		}
		boolean equal1 = compareFiles(testFile + extension, testFile + "2" + extension);
		System.out.println("Is the file the same after a read, then a write? " + equal1);
		System.out.println();

		System.out.println("TESTING: How long does it take to zip and unzip?");
		long startTime = System.currentTimeMillis();
		FileZip zipper1 = new FileZip();
		zipper1.zip(testFile + extension, testFile + ".zip");
		FileZip zipper2 = new FileZip();
		zipper2.unzip(testFile + ".zip", testFile + "3" + extension);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		long mins = time / 60000;
		long secs = time % 60000 / 1000;
		long millis = time % 1000;

		System.out.println("Runtime: " + mins + ":" + secs + ":" + millis);
		System.out.println();

		System.out.println("TESTING: Is your unzipped file exactly equal to the original?");
		boolean equal2 = compareFiles(testFile + extension, testFile + "3" + extension);
		System.out.println("Is the file the same after zip, then a unzip? " + equal2);
		System.out.println();

		System.out.println("TESTING: What compression ratio do you achieve?");
		File first = new File(testFile + extension);
		File second = new File(testFile + ".zip");
		double ratio = ((double) second.length() / first.length()) * 100;
		System.out.println("The compression ratio (percentage): " + ratio + "%");

	}

}
