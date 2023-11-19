
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private Line l1, l2;

	public DrawingSurface() {
		l1 = null;
		l2 = null;
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

		if (l1 != null) {
			stroke(255, 0, 0);
			l1.draw(this);
		}
		if (l2 != null) {
			stroke(0, 255, 0);
			l2.draw(this);
		}

		if (l1 != null && l2 != null) {
			boolean intersect = l1.intersects(l2);
			fill(0);
			textSize(30);
			textAlign(CENTER);
			text(intersect + "", width / 2, 50);
		}
	}

	public void mousePressed() {
		if (mouseButton == LEFT) {
			l1 = new Line(mouseX, mouseY, mouseX, mouseY);
		} else if (mouseButton == RIGHT)
			l2 = new Line(mouseX, mouseY, mouseX, mouseY);
	}

	public void mouseDragged() {
		if (mouseButton == LEFT) {
			l1.setPoint2(mouseX, mouseY);
		} else if (mouseButton == RIGHT)
			l2.setPoint2(mouseX, mouseY);
	}

}
