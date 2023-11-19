import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Represents a 2D maze.

	Coded by: Rithvik Muthyalapati
	Modified on: 3/23/20
	
	Every maze works except for maze6.txt where the character goes outside the maze
*/

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs an empty grid
	public Maze() {
		grid = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		grid = readData(filename);
	}

	// Attempts to find a path through the maze and returns whether a path was found
	// or not
	public boolean solve() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[j][i] == 'C') {
					return solve(i, j);
				}
			}
		}
		return false;
	}

	// Private recursive version of solve()
	private boolean solve(int i, int j) {
		if ((i < 0 || i >= grid.length) || (j < 0 || j >= grid[0].length)) {
			return false;
		} else if (grid[j][i] == '#') {
			return false;
		} else if (grid[j][i] == '!') {
			return false;
		} else if (grid[j][i] == 'X') {
			return true;
		} else {
			grid[j][i] = '!';
			if (solve(i + 1, j)) {
				return true;
			} else if (solve(i - 1, j)) {
				return true;
			} else if (solve(i, j - 1)) {
				return true;
			} else if (solve(i, j + 1)) {
				return true;
			}
			grid[j][i] = '.';
			return false;
		}
	}

	// Formats this grid as a String to be printed (one call to this method returns
	// the whole multi-line grid)
	public String toString() {
		String out = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				out += grid[j][i];
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