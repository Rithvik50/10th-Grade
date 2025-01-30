import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import java.awt.Color;

import processing.core.PApplet;

/*

Represents a Game Of Life grid.

Coded by: 12/3/19
Modified on: 12/3/19

*/

@SuppressWarnings("unused")
public class Life {

	int row;
	int col;
	boolean[][] cells;

// Constructs an empty grid
	public Life() {
		row = 0;
		col = 0;
	}

// Constructs the grid defined in the file specified
	public Life(int row, int col, String filename) {
		this.row = row;
		this.col = col;
		cells = new boolean[row][col];
		readData(filename, cells);
	}

// Runs a single turn of the Game Of Life
	public void step() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
// Stay Same
				if (getNeighbors(i, j) == 2 || getNeighbors(i, j) == 3) {
// Birth
					if (!cells[i][j] && getNeighbors(i, j) == 3) {
						cells[i][j] = true;
					}
				} else {
// Lonely Death
					if (getNeighbors(i, j) <= 1) {
						cells[i][j] = false;
					}
// Overcrowdin
					if (getNeighbors(i, j) <= 4) {
						cells[i][j] = false;
					}
				}
			}
		}
	}

// Runs n turns of the Game Of Life
	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
		}
	}

	public int getNeighbors(int x, int y) {
		int count = 0;
		int r = x;
		int c = y;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || row <= i || j < 0 || col <= j)
					continue;
				if (r == i && c == j)
					continue;
				if (cells[i][j] == true)
					count++;
			}
		}
		return count;
	}

// Formats this Life grid as a String to be printed (one call to this method
// returns the whole multi-line grid)
	public String toString() {
		String[][] stringCells = new String[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (cells[i][j] == true) {
					stringCells[i][j] = "*";
				} else {
					stringCells[i][j] = " ";
				}
			}
		}
		for (String[] a : stringCells)
			System.out.println(Arrays.toString(a));
		return Arrays.deepToString(stringCells);
	}

// public String toString()
//    {
//        String theFinalBeautifulStringMadeByMe = "";
//
//        for(int r = 0; r < row; r++)
//        {
//            for (int c = 0; c < col; c++)
//            {
//                if(cells[r][c] == true)
//                    theFinalBeautifulStringMadeByMe += "*";
//                else
//                    theFinalBeautifulStringMadeByMe += " ";
//            }
//            theFinalBeautifulStringMadeByMe += "\n";
//        }
//        return theFinalBeautifulStringMadeByMe;
//    }
// Reads in array data from a simple text file containing asterisks (*)
	public void readData(String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length && line.charAt(i) == '*')
							gameData[count][i] = true;

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 *
	 * @param marker The PApplet used for drawing.
	 * @param x      The x pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param y      The y pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param width  The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		int xx = 0;
		int yy = 0;
		width = width / cells.length;
		height = height / cells[0].length;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j]) {
					marker.fill(100, 100, 100);
				} else {
					marker.fill(255, 255, 255);
				}
				marker.rect(x + (i * width), y + (j * height), width, height);
			}
		}
	}

	/**
	 * Optionally, complete this method to determine which element of the grid
	 * matches with a particular pixel coordinate.
	 *
	 * @param p      A Point object representing a graphical pixel coordinate.
	 * @param x      The x pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param y      The y pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param width  The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life
	 *         grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		return null;
	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 *
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		cells[i][j] = !cells[i][j];
	}

}
