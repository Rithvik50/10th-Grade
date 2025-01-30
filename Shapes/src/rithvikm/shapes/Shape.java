package rithvikm.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * This class represents a double precision Shape. It can perform common
 * calculations and providing methods to its polygonic subclasses as well as
 * drawing a representation of the polygonic subclasses to a Processing PApplet.
 * 
 * @author Rithvik Muthyalapati
 * @version 10/7/19
 */
public abstract class Shape {

	// FIELDS
	private double x, y;
	private Color color;

	// CONSTRUCTORS
	/**
	 * This constructor sets the Shape coordinates and dimensions from the users
	 * values.
	 * 
	 * @param x The x-coordinate of the Shape.
	 * @param y The y-coordinate of the Shape.
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		color = new Color(255, 255, 255, 0);
	}

	// METHODS
	/**
	 * This method contains the width of the Shape.
	 * 
	 * @return Returns the width of the Shape.
	 */
	public abstract double getWidth();

	/**
	 * This method contains the height of the Shape.
	 * 
	 * @return Returns the height of the Shape.
	 */
	public abstract double getHeight();

	/**
	 * This method creates a Rectangle boundary around the Shape.
	 * 
	 * @return Returns the Rectangle boundary of the Shape.
	 */
	public abstract Rectangle getBoundingRectangle();

	/**
	 * This method draws the Shape on the window.
	 * 
	 * @pre marker must be kept null.
	 * @param marker Used as an implement to draw the final Shape.
	 * @post marker is kept as null throughout this method.
	 */
	public abstract void draw(PApplet marker);

	/**
	 * This method moves the Shape.
	 * 
	 * @param x The x-coordinate of the Shape.
	 * @param y The y-coordinate of the Shape.
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method stores the x-coordinate of the Shape.
	 * 
	 * @return Returns the x-coordinate of the Shape.
	 */
	public double getX() {
		return x;
	}

	/**
	 * This method stores the y-coordinate of the Shape.
	 * 
	 * @return Returns the y-coordinate of the Shape.
	 */
	public double getY() {
		return y;
	}

	/**
	 * This method sets the new Color of the Shape.
	 * 
	 * @param c Assigned Color object with the newly inputed Color of the Shape.
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * This method stores the Color of the Shape.
	 * 
	 * @return Returns the Color of the Shape.
	 */
	public Color getColor() {
		return color;
	}

	// Shape2D
	/**
	 * This method calculates the area of the Shape.
	 * 
	 * @return Returns the area of the Shape.
	 */
	public abstract double getArea();

	/**
	 * This method calculates the perimeter of the Shape.
	 * 
	 * @return Returns the perimeter of the Shape.
	 */
	public abstract double getPerimeter();

	/**
	 * This method calculates the center x-coordinate of the Shape.
	 * 
	 * @return Returns the center x-coordinate of the Shape.
	 */
	public abstract double getCenterX();

	/**
	 * This method calculates the center y-coordinate of the Shape.
	 * 
	 * 
	 * @return Returns the center y-coordinate of the Shape.
	 */
	public abstract double getCenterY();

	/**
	 * This method detects if the inputed values are located in the Shape.
	 * 
	 * @pre x and y can be any value on the window.
	 * @param x Inputed x-coordinate awaiting to be checked.
	 * @param y Inputed y-coordinate awaiting to be checked.
	 * @return Returns true or false whether the point is located inside of the
	 *         Shape or not and the borders are included.
	 */
	public abstract boolean isPointInside(double x, double y);
}
