package rithvikm.shapes;

import processing.core.PApplet;

/**
 * This class represents a double precision RegularPolygon. It can perform
 * common calculations as well as drawing a representation of the RegularPolygon
 * to a Processing PApplet.
 * 
 * @author Rithvik Muthyalapati
 * @version 10/22/19
 */
public class RegularPolygon extends Shape {

	private int numSides;
	private double sideLength;

	/**
	 * This no-args constructor sets the default RegularPolygon to a triangle with
	 * side length 100.
	 */
	public RegularPolygon() {
		super(3, 100);
	}

	/**
	 * This constructor sets the coordinates at origin and takes in user inputted
	 * values for the sides.
	 * 
	 * @pre numSides has to be a natural number.
	 * @param numSides   The number of sides the RegularPolygon has.
	 * @param sideLength The length of the side of the RegularPolygon.
	 */
	public RegularPolygon(int numSides, double sideLength) {
		this(0, 0, numSides, sideLength);
	}

	/**
	 * This constructor sets the RegularPolygon coordinates and dimensions from the
	 * users values.
	 * 
	 * @param x          The center x-coordinate of the RegularPolygon.
	 * @param y          The center y-coordinate of the RegularPolygon.
	 * @param numSides   The number of sides for the RegularPolygon.
	 * @param sideLength The side length of the RegularPolygon.
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x, y);
		this.numSides = numSides;
		this.sideLength = sideLength;
	}

	/**
	 * This method contains the width of the RegularPolygon.
	 * 
	 * @return Returns the width of the RegularPolygon.
	 */
	@Override
	public double getWidth() {
		return calcR() * 2;
	}

	/**
	 * This method contains the height of the Rectangle.
	 * 
	 * @return Returns the height of the RegularPolygon.
	 */
	@Override
	public double getHeight() {
		return calcR() * 2;
	}

	/**
	 * This method creates a Rectangle boundary around the RegularPolygon.
	 * 
	 * @return Returns the Rectangle boundary of the RegularPolygon.
	 */
	@Override
	public Rectangle getBoundingRectangle() {
		return null;
	}

	/**
	 * This method draws the RegularPolygon on the window.
	 * 
	 * @pre marker must be kept null.
	 * @param marker Used as an implement to draw the final RegularPolygon.
	 * @post marker is kept as null throughout this method.
	 */
	@Override
	public void draw(PApplet marker) {
		marker.fill(getColor().getRGB());
		if (numSides % 2 != 0) {
			marker.line((float) getX(), (float) (getY() - calcR()), (float) getY(), 0.0F);
		}
	}

	/**
	 * This method calculates the area of the RegularPolygon.
	 * 
	 * @pre The number of sides should be a natural number.
	 * @return Returns the area of the RegularPolygon.
	 */
	@Override
	public double getArea() {
		return (calcr() * sideLength / 2) * numSides;
	}

	/**
	 * This method calculates the perimeter of the RegularPolygon.
	 * 
	 * @pre The number of sides should be a natural number.
	 * @return Returns the perimeter of the RegularPolygon.
	 */
	@Override
	public double getPerimeter() {
		return sideLength * numSides;
	}

	/**
	 * This method calculates the center x-coordinate of the RegularPolygon.
	 * 
	 * @return Returns the center x-coordinate of the RegularPolygon.
	 */
	@Override
	public double getCenterX() {
		return getX();
	}

	/**
	 * This method calculates the center y-coordinate of the RegularPolygon.
	 * 
	 * @return Returns the center y-coordinate of the RegularPolygon.
	 */
	@Override
	public double getCenterY() {
		return getY();
	}

	/**
	 * This method detects if the inputed values are located in the RegularPolygon.
	 * 
	 * @pre x and y can be any value on the window.
	 * @param x Inputed x-coordinate awaiting to be checked.
	 * @param y Inputed y-coordinate awaiting to be checked.
	 * @return Returns true or false whether the point is located inside of the
	 *         RegularPolygon or not and the borders are included.
	 */
	@Override
	public boolean isPointInside(double x, double y) {
		return false;
	}

	/**
	 * This method calculates the vertex angle of the RegularPolygon.
	 * 
	 * @return Returns the vertex angle measure of the RegularPolygon.
	 */
	public double calcVertexAngle() {
		return (180 * (numSides - 2)) / numSides;
	}

	public double calcR() {
		return sideLength / 2 * Math.sin(calcVertexAngle());
	}

	public double calcr() {
		return 0.5 * sideLength * PApplet.atan((float) (Math.toRadians(Math.PI) / numSides));
	}

	public void drawBoundingCircles(PApplet drawer) {
		drawer.circle((float) getX(), (float) getY(), (float) calcR());
		drawer.circle((float) getX(), (float) getY(), (float) calcr());
	}

	public int getNumSides() {
		return numSides;
	}

	public double getSideLength() {
		return sideLength;
	}
}
