import processing.core.PApplet;

public class House extends DrawingSurface {

	// FIELDS

	// CONSTRUCTORS

	// METHODS
	public void draw(PApplet surface) {

		// getHouseX() is the house x position and getHouseY() is the house y position
		// draw rectangle of the house
		surface.fill(255, 253, 169);
		surface.stroke(0, 0, 0);
		surface.rect(getHouseX(), getHouseY(), getHouseWidth(), getHouseHeight());

		surface.fill(154, 9, 9);
		// calculated second vertex coordinates with isosceles right angled triangle
		// draw triangle roof of the house
		int triX2 = getHouseX() + getHouseWidth() / 2;
		int triY2 = getHouseY() - getHouseWidth() / 2;
		surface.triangle(getHouseX(), getHouseY(), triX2, triY2, getHouseX() + getHouseWidth(), getHouseY());

		surface.fill(180, 42, 208);
		// draw the door for the house
		int doorWidth = getHouseWidth() / 3;
		int doorHeight = getHouseHeight() / 2;
		int doorX = getHouseX() + doorWidth;
		int doorY = getHouseY() + doorHeight;
		surface.rect(doorX, doorY, doorWidth, doorHeight);

		surface.fill(134, 194, 246);
		// draw two windows
		int winWidth = getHouseWidth() / 8;
		int win1X = getHouseX() + getHouseWidth() / 8;
		int win2X = win1X + (5 * getHouseWidth()) / 8;
		int winY = getHouseY() + getHouseHeight() / 4;
		surface.square(win1X, winY, winWidth);
		surface.square(win2X, winY, winWidth);
	}
}
