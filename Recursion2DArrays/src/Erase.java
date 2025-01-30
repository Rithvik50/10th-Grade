
//Rithvik Muthyalapati
//Period 1
//3-23-20
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	This program erases objects (connected stars) from a 2D grid. 

	Coded by: 
	Modified on: 

*/

public class Erase {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public Erase() {
		data = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Erase(String filename) {
		data = readData(filename);
	}

	// see heading on line 1
	// Erases an object beginning at x,y
	public void eraseObject(int x, int y) {
		if (x < 0 || y < 0 || x >= data.length || y >= data[0].length) {
			return;
		} else if (data[x][y] != '*') {
			return;
		} else {
			data[x][y] = ' ';
			eraseObject(x, y - 1);
			eraseObject(x, y + 1);
			eraseObject(x - 1, y);
			eraseObject(x + 1, y);
		}
	}

	// Formats this grid as a String to be printed (one call to this method returns
	// the whole multi-line grid)
	public String toString() {
		String out = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (data[j][i] == '*') {
					out += "*";
				} else {
					out += " ";
				}
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