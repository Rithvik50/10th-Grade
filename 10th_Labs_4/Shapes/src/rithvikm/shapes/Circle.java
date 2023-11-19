package rithvikm.shapes;

import processing.core.PApplet;

/**
 * This class represents a double precision Circle. It can perform common
 * calculations as well as drawing a representation of the Circle to a
 * Processing PApplet.
 * 
 * @author Rithvik Muthyalapati
 * @version 9/30/19
 */
public class Circle extends Shape {

	private double radius;

	/**
	 * This no-args constructor sets all values of the Circle to zero.
	 */
	public Circle() {
		super(0, 0);
	}

	/**
	 * This constructor sets the Circle coordinates and dimensions from the users
	 * values.
	 * 
	 * @param x      The center x-coordinate of the Circle.
	 * @param y      The center y-coordinate of the Circle.
	 * @param radius The radius of the Circle.
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * This method contains the width of the Circle.
	 * 
	 * @return Returns the width of the Circle.
	 */
	@Override
	public double getWidth() {
		return radius;
	}

	/**
	 * This method contains the height of the Circle.
	 * 
	 * @return Returns the height of the Circle.
	 */
	@Override
	public double getHeight() {
		return radius;
	}

	/**
	 * This method creates a Rectangle boundary around the Circle.
	 * 
	 * @return Returns the Rectangle boundary of the Circle.
	 */
	@Override
	public Rectangle getBoundingRectangle() {
		return new Rectangle(getX() - radius, getY() - radius, radius * 2, radius * 2);
	}

	/**
	 * This method draws the Circle on the window.
	 * 
	 * @pre marker must be kept null.
	 * @param marker Used as an implement to draw the final Circle.
	 * @post marker is kept as null throughout this method and the Circle is
	 *       transparent.
	 */
	@Override
	public void draw(PApplet marker) {
		marker.fill(getColor().getRGB());
		marker.circle((float) getX(), (float) getY(), (float) radius);
	}

	/**
	 * This method calculates the area of the Circle.
	 * 
	 * @return Returns the area of the Circle.
	 */
	@Override
	public double getArea() {
		return Math.pow(radius, 2) * PApplet.PI;
	}

	/**
	 * This method calculates the circumference/perimeter of the Circle.
	 * 
	 * @return Returns the circumference/perimeter of the Circle.
	 */
	@Override
	public double getPerimeter() {
		return Math.abs(radius * 2) * PApplet.PI;
	}

	/**
	 * This method calculates the center x-coordinate of the Circle.
	 * 
	 * @return Returns the center x-coordinate of the Circle.
	 */
	@Override
	public double getCenterX() {
		return getX();
	}

	/**
	 * This method calculates the center y-coordinate of the Circle.
	 * 
	 * @return Returns the center y-coordinate of the Circle.
	 */
	@Override
	public double getCenterY() {
		return getY();
	}

	/**
	 * This method detects if the inputed values are located in the Circle.
	 * 
	 * @pre x and y can be any value on the window.
	 * @param x Inputed x-coordinate awaiting to be checked.
	 * @param y Inputed y-coordinate awaiting to be checked.
	 * @return Returns true or false whether the point is located inside of the
	 *         Circle or not and the borders are included.
	 */
	@Override
	public boolean isPointInside(double x, double y) {
		if ((x >= getX() - radius && x <= getX() + radius) && (y >= getY() - radius && y <= getY() + radius)) {
			return true;
		}
		return false;
	}
}
