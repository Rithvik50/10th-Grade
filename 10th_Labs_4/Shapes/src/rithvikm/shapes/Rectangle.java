package rithvikm.shapes;

import processing.core.PApplet;

/**
 * This class represents a double precision Rectangle. It can perform common
 * calculations as well as drawing a representation of the Rectangle to a
 * Processing PApplet.
 * 
 * @author Rithvik Muthyalapati
 * @version 9/30/19
 */
public class Rectangle extends Shape {

	// private double x2, y2, x3, y3, x4, y4;
	private double width, height;

	/**
	 * This no-args constructor sets all values of the Rectangle to zero.
	 */
	public Rectangle() {
		super(0, 0);
	}

	/**
	 * This constructor sets the Rectangle coordinates and dimensions from the users
	 * values.
	 * 
	 * @param x      The top-left corner x-coordinate of the Rectangle.
	 * @param y      The top-left corner y-coordinate of the Rectangle.
	 * @param width  The width of the Rectangle.
	 * @param height The height of the Rectangle.
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
//		x2 = getX() + width;
//		y2 = getY();
//		x3 = getX() + width;
//		y3 = getY() + height;
//		x4 = getX();
//		y4 = getY() + height;
	}

	/**
	 * This method contains the width of the Rectangle.
	 * 
	 * @return Returns the width of the Rectangle.
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * This method contains the height of the Rectangle.
	 * 
	 * @return Returns the height of the Rectangle.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * This method creates a Rectangle boundary around the Rectangle.
	 * 
	 * @return Returns the Rectangle boundary of the Rectangle.
	 */
	@Override
	public Rectangle getBoundingRectangle() {
		return new Rectangle(getX(), getY(), width, height);
	}

	/**
	 * This method draws the Rectangle on the window.
	 * 
	 * @pre marker must be kept null.
	 * @param marker Used as an implement to draw the final Rectangle.
	 * @post marker is kept as null throughout this method.
	 */
	@Override
	public void draw(PApplet marker) {
		marker.fill(getColor().getRGB());
//		marker.quad((float) getX(), (float) getY(), (float) x2, (float) y2, (float) x3, (float) y3, (float) x4,
//				(float) y4);
		marker.rect((float) getX(), (float) getY(), (float) width, (float) height);
	}

	/**
	 * This method calculates the area of the Rectangle.
	 * 
	 * @return Returns the area of the Rectangle.
	 */
	@Override
	public double getArea() {
		return Math.abs(width * height);
	}

	/**
	 * This method calculates the perimeter of the Rectangle.
	 * 
	 * @return Returns the perimeter of the Rectangle.
	 */
	@Override
	public double getPerimeter() {
		return Math.abs((width * 2)) + Math.abs((height * 2));
	}

	/**
	 * This method calculates the center x-coordinate of the Circle.
	 * 
	 * @return Returns the center x-coordinate of the Circle.
	 */
	@Override
	public double getCenterX() {
		return (getX() + width) / 2;
	}

	/**
	 * This method calculates the center y-coordinate of the Circle.
	 * 
	 * @return Returns the center y-coordinate of the Circle.
	 */
	@Override
	public double getCenterY() {
		return (getY() + height) / 2;
	}

	/**
	 * This method detects if the inputed values are located in the Rectangle.
	 * 
	 * @pre x and y can be any value on the window.
	 * @param x Inputed x-coordinate awaiting to be checked.
	 * @param y Inputed y-coordinate awaiting to be checked.
	 * @return Returns true or false whether the point is located inside of the
	 *         Rectangle or not and the borders are included.
	 */
	@Override
	public boolean isPointInside(double x, double y) {
		if ((x >= Math.min(getX(), getX() + width) && x <= Math.max(getX(), getX() + width))
				&& ((y >= Math.min(getY(), getY() + height)) && (y <= Math.max(getY(), getY() + height)))) {
			return true;
		}
		return false;
	}

//	/**
//	 * This method rotates the Rectangle by degrees.
//	 * 
//	 * @pre This method has no precondition.
//	 * @param degrees The amount of degrees rotation takes in the user input value
//	 *                in Shapes.java.
//	 * @post The new Rectangle is redrawn with a quadrilateral with points (getX(),
//	 *       getY()), (x2, y2), (x3, y3), and (x4, x4).
//	 */
//	public void rotateRectBy(int degrees) {
//		double theta = Math.toRadians(degrees);
//		x2 = getX() + width * Math.cos(theta);
//		y2 = getY() + width * Math.sin(theta);
//		double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
//		double alpha = Math.atan(height / width);
//		x3 = getX() + diagonal * Math.cos(theta + alpha);
//		y3 = getY() + diagonal * Math.sin(theta + alpha);
//		x4 = getX() + height * Math.cos(PApplet.PI / 2 + theta);
//		y4 = getY() + height * Math.sin(PApplet.PI / 2 + theta);
//	}

	/**
	 * This method detects if the Rectangle is a square.
	 * 
	 * @return Returns true or false if the sides of the Rectangle are equal.
	 */
	public boolean isSquare() {
		if (Math.abs(width) == Math.abs(height)) {
			return true;
		}
		return false;
	}

	/**
	 * This method calculates the lenght of the diagonal of the Rectangle.
	 * 
	 * @return Returns the distance between two opposite vertices.
	 */
	public double getDiagonal() {
		return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
	}
}
