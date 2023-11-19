import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author Rithvik Muthyalapati
 * @version 2/13/20
 */
public class BoxFractal {

	// TO DO
	private int level;
	private float length;
	private double x, y;

	public BoxFractal(int level, float length, double x, double y) {
		// TO DO
		this.level = level;
		this.length = length;
		this.x = x;
		this.y = y;
	}

	public void draw(PApplet marker) {
		drawBoxFractal(marker, level, x, y, length);
	}

	private void drawBoxFractal(PApplet marker, int level, double x, double y, double length) {
		// TO DO
		if (level > 0) {
			level--;
			length /= 3;
			drawBoxFractal(marker, level, x, y, length);
			drawBoxFractal(marker, level, x + 2 * length / 3, y, length);
			drawBoxFractal(marker, level, x + length / 3, y + length / 3, length);
			drawBoxFractal(marker, level, x, y + 2 * length / 3, length);
			drawBoxFractal(marker, level, x + 2 * length / 3, y + 2 * length / 3, length);
		} else {
			marker.square((float) x, (float) y, (float) length);
		}
	}
}
