package rithvikm.illusion;

import java.awt.Color;

import processing.core.PApplet;
import rithvikm.shapes.*;

/**
 * This class creates a new illusion implemented with colors to present a better
 * perspective of the illusion.
 * 
 * @author Rithvik Muthyalapati
 * @version 10/13/19
 *
 */
public class Illusions extends PApplet {

	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Line line;

	/**
	 * This no-args constructor sets values for the illusions.
	 */
	public Illusions() {
		rectangle1 = new Rectangle(225, 125, 15, 200);
		rectangle2 = new Rectangle(300, 125, 15, 200);
		line = new Line(-100, 225, 500, -55);
	}

	/**
	 * This method draws in the Shapes for the Illusion.
	 * 
	 * @pre i has to be greater than or equal to 0.
	 * @post This method has no postcondition.
	 */
	public void draw() {
		background(255);
		for (int i = 0; i < 11; i++) {
			line = new Line(-100, 225, 500, -55 + i * 60);
			line.draw(this);
		}
		rectangle1.setColor(Color.BLUE);
		rectangle1.draw(this);
		rectangle2.setColor(Color.BLUE);
		rectangle2.draw(this);
	}
}
