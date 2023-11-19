package rithvikm.testers;

import processing.core.PApplet;
import rithvikm.shapes.*;

/**
 * This class calls the other shape classes constructors and draws them onto the
 * panel.
 * 
 * @author Rithvik Muthyalapati
 * @version 9/30/19
 */
public class DrawingSurface extends PApplet {

	private Rectangle rectangle;
	private Circle circle;
	private Line line;

	/**
	 * This method is executed only once in the program.
	 * 
	 * @pre This method has no precondition.
	 * @post This method has no postcondition.
	 */
	public void setup() {
		rectangle = new Rectangle(250, 250, 150, 100);
		circle = new Circle(250, 250, 100);
		line = new Line(250, 300, 400, 300);
	}

	/**
	 * This method draws the rectangle, circle, and line on the window.
	 * 
	 * @pre This method has no precondition.
	 * @post The background is always set as white.
	 */
	public void draw() {
		background(255);
		circle.draw(this);
		rectangle.draw(this);
		line.draw(this);
	}
}
