package rithvikm.shapes;

import processing.core.PApplet;

/**
 * This class represents a double precision Line. It can perform common
 * calculations as well as drawing a representation of the Line to a Processing
 * PApplet.
 * 
 * @author Rithvik Muthyalapati
 * @version 9/30/19
 */
public class Line extends Shape {

	private double x2, y2;

	/**
	 * This no-args constructor sets all values of the Line to zero.
	 */
	public Line() {
		super(0, 0);
		x2 = 0;
		y2 = 0;
	}

	/**
	 * This constructor sets the Line first and second coordinates from the users
	 * values.
	 * 
	 * @param x1 The first endpoint x-coordinate of the Line.
	 * @param y1 The first endpoint y-coordinate of the Line.
	 * @param x2 The second endpoint x-coordinate of the Line.
	 * @param y2 The second endpoint y-coordinate of the Line.
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * This method contains the width of the Line.
	 * 
	 * @return Returns the width of the Line.
	 */
	@Override
	public double getWidth() {
		return x2 - getX();
	}

	/**
	 * This method contains the height of the Line.
	 * 
	 * @return Returns the height of the Line.
	 */
	@Override
	public double getHeight() {
		return y2 - getY();
	}

	/**
	 * This method creates a Rectangle boundary around the Line.
	 * 
	 * @return Returns the Rectangle boundary of the Line.
	 */
	@Override
	public Rectangle getBoundingRectangle() {
		return new Rectangle(getX(), getY(), Math.max(getX(), x2) - Math.min(getX(), x2),
				Math.max(getY(), y2) - Math.min(getY(), y2));
	}

	/**
	 * This method draws the Line on the window.
	 * 
	 * @pre marker must be kept null.
	 * @param marker Used as an implement to draw the final Line.
	 * @post marker is kept as null throughout this method.
	 */
	@Override
	public void draw(PApplet marker) {
		marker.fill(getColor().getRGB());
		marker.line((float) getX(), (float) getY(), (float) x2, (float) y2);
	}

	/**
	 * This method calculates the area of the Line.
	 * 
	 * @return Returns the area of the Line which is 0.
	 */
	@Override
	public double getArea() {
		return 0;
	}

	/**
	 * This method calculates the perimeter of the Line.
	 * 
	 * @return Returns the area of the Line which is 0.
	 */
	@Override
	public double getPerimeter() {
		return 0;
	}

	/**
	 * This method calculates the center x-coordinate of the Circle.
	 * 
	 * @return Returns the center x-coordinate of the Circle.
	 */
	@Override
	public double getCenterX() {
		return (getX() + x2) / 2;
	}

	/**
	 * This method calculates the center y-coordinate of the Circle.
	 * 
	 * @return Returns the center y-coordinate of the Circle.
	 */
	@Override
	public double getCenterY() {
		return (getY() + y2) / 2;
	}

	/**
	 * This method detects if the inputed values are located in the Line.
	 * 
	 * @pre x and y can be any value on the window.
	 * @param x Inputed x-coordinate awaiting to be checked.
	 * @param y Inputed y-coordinate awaiting to be checked.
	 * @return Returns true or false whether the point is located on the Line or
	 *         not.
	 */
	@Override
	public boolean isPointInside(double x, double y) {
		if ((x >= Math.min(getX(), x2) && x <= Math.max(getX(), x2))
				&& (y >= Math.min(getY(), y2) && y <= Math.max(getY(), y2))) {
			return true;
		}
		return false;
	}
}
