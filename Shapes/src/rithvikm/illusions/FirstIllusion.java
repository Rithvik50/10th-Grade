package rithvikm.illusions;

import rithvikm.shapes.*;
import processing.core.*;

/**
 * This class creates an optical illusion consisting of Circles and Rectangles.
 * 
 * @author Rithvik Muthyalapati
 * @version 10/3/19
 */
public class FirstIllusion extends PApplet {

	private Rectangle rectangle;
	private Circle circle;

	/**
	 * This no-args constructor sets values for the Rectangle.
	 */
	public FirstIllusion() {
		rectangle = new Rectangle(140, 115, 220, 270);
	}

	/**
	 * This method draws in the 16 Circles all increasing by 20 in radius and a
	 * Rectangle on top of it.
	 * 
	 * @pre i has to be greater than or equal to 0.
	 * @post This method has no postcondition.
	 */
	public void draw() {
		rectangle.draw(this);
		for (int i = 0; i < 160; i += 10) {
			circle = new Circle(250, 250, 12 + i);
			circle.draw(this);
		}
	}
}
