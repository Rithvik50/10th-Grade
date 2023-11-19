import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Coded by:
	Modified on:

*/

public class Labyrinth {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public Labyrinth() {
		data = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		data = readData(filename);
	}

	// Finds a path through the labyrinth and returns the number of moves required
	// to exit
	public int findPath() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				if (data[j][i] == 'C') {
					return findPath(i, j, false);
				}
			}
		}
		return -1;
	}

	// Private recursive version of findPath()
	private int findPath(int i, int j, boolean hasCloak) {
		if ((i < 0 || i >= data.length) || (j < 0 || j >= data[0].length)) {
			return -1;
		} else if (data[j][i] == '#') {
			return -1;
		} else if (data[j][i] == '!' && hasCloak) {
			return -1;
		} else if (data[j][i] == '!' && !hasCloak) {

		} else if (data[j][i] == 'A' && !hasCloak) {
			return -1;
		} else if (data[j][i] == 'X') {
			return 0;
		} else {
			char symbol = data[j][i];
			if (symbol == '@') {

			}
		}
		return -1;
	}

	// Formats this grid as a String to be printed (one call to this method returns
	// the whole multi-line grid)
	public String toString() {
		String out = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				out += data[j][i];
			}
			out += "\n";
		}
		return out;
	}

	public char[][] readData(String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			char[][] gameData = new char[cols][rows];
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

}