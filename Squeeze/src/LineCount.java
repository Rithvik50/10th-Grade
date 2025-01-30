import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

	private char[][] data;

	public LineCount() {
		data = new char[0][0];
	}

	public LineCount(String filename) {
		data = readData(filename);
	}

	public int getRows() {
		int rows = 0;
		for (int i = 0; i < data.length; i++) {
			rows++;
		}
		return rows;
	}

	
	public int getCols() {
		int cols = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				cols++;
			}
		}
		return cols;
	}

	public String toString() {
		String out = "";
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
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
			char[][] gameData = new char[getCols()][getRows()];
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
