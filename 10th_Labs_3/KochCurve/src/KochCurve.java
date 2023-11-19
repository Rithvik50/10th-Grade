import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author Rithvik Muthyalapati
 * @version 2/13/20
 */
public class KochCurve {

	// TO DO
	private int level;
	private double length;
	private double x, y;

	public KochCurve(int level, float length, double x, double y) {
		// TO DO
		this.level = level;
		this.length = length;
		this.x = x;
		this.y = y;
	}

	public void draw(PApplet marker) {
		drawKochCurve(marker, level, x, y, length, 180);
	}

	private void drawKochCurve(PApplet marker, int level, double x, double y, double length, double angle) {
		// TO DO
		if (level < 1) {
			marker.line((float) x, (float) y, (float) (x + length), (float) y);
		} else {
			drawKochCurve(marker, level - 1, x, y, length / 3, angle);
			x += (float) Math.cos(angle * Math.PI / 180) * length;
			y += (float) Math.sin(angle * Math.PI / 180) * length;
			drawKochCurve(marker, level - 1, x, y, length / 3, angle += 60);
			x += (float) Math.cos(angle * Math.PI / 180) * length;
			y += (float) Math.sin(angle * Math.PI / 180) * length;
			drawKochCurve(marker, level - 1, x, y, length / 3, angle -= 120);
			x += (float) Math.cos(angle * Math.PI / 180) * length;
			y += (float) Math.sin(angle * Math.PI / 180) * length;
			drawKochCurve(marker, level - 1, x, y, length / 3, angle += 60);
		}
	}
}
