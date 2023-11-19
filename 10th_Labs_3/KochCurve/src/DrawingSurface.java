
import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private KochCurve curve;
	private BoxFractal box;
	private int level, length;
	private double kochX, kochY, boxX, boxY;

	public DrawingSurface() {
		level = 5;
		length = 200;
		kochX = 350;
		kochY = 150;
		boxX = 0;
		boxY = 0;
		curve = new KochCurve(level, (float) length, kochX, kochY);
		box = new BoxFractal(level, (float) length, boxX, boxY);
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background

		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, use UP/DOWN keys to change level.", 0, 15);

		stroke(0);
		curve.draw(this);
		box.draw(this);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num * 10;
		curve = new KochCurve(level, (float) length, kochX, kochY);
		box = new BoxFractal(level, (float) length, boxX, boxY);
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			curve = new KochCurve(level, (float) length, kochX, kochY);
			box = new BoxFractal(level, (float) length, boxX, boxY);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			curve = new KochCurve(level, (float) length, kochX, kochY);
			box = new BoxFractal(level, (float) length, boxX, boxY);
		}
	}
}
