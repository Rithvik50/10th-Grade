import java.awt.Color;
import java.util.Random;

import processing.core.PApplet;
import processing.event.MouseEvent;

/*
 * + you were able to adapt your intersects method to your new code.
 * + It was good that you used the fact that the bird would intersect the arrow on a horizontal line, for detection purposes.
 * - You're putting code such as houseRectMeasurments, flyAround, and 
 * - You shouldn't be putting get methods in this high level class
 * delta: Try moving the methods obviously meant for a house,person, or line class to make it stylistically correct
 * delta: have the specific classed for person and house actions in there area, such as in the class itself to then give the result to DrawingSurface
 */

public class DrawingSurface extends PApplet {

	// FIELDS
	private static int personX, personY, headVerticesCount;
	private static int houseX, houseY, houseWidth, houseHeight;
	private static int birdX, birdY;
	private static int arrowX;
	private static int arrowY;
	private static Color birdColor;
	private float windowWidth, windowHeight;
	private int birdsHunted = 0;

	private House house;
	private Person person;
	private Bird bird;

	// CONSTRUCTORS

	// METHODS
	public void setup() {
		// set the persons default x,y coordinates
		personX = 80;
		personY = 500;

		birdX = 50;
		birdY = 100;

		arrowX = personX + 120;
		arrowY = personY + 220;

		// set house rectangles starting left corner coordinates
		houseRectMeasurements(250, 250, true);
		headVerticesCount = 0;

		birdColor = new Color(255, 255, 255);
	}

	// Inherited reference method from Processing that draws onto the window
	public void draw() {
		windowWidth = width / 500F;
		windowHeight = height / 500F;

		// Redraws this on top of the duplicated Person and House when they are moving
		background(66, 230, 245);

		// Dynamically scales the shapes
		scale(windowWidth, windowHeight);

		house = new House();
		person = new Person();
		bird = new Bird();

		house.draw(this);
		fill(0, 0, 0);
		textSize(18);
		text("Interactions: Arrow Keys and Mouse Wheel\nLeft Mouse to shoot laser and Right Mouse\nto move house", 20,
				440);
		textSize(14);
		text("Birds Hunted: " + birdsHunted, 20, 20);
		person.draw(this);
		bird.draw(this);
		bird.intersects(person);
		flyAround();
		Random randomRGB = new Random();
		Random height = new Random();
		if (bird.intersects(person)) {
			birdX = 0;
			birdY = height.nextInt(250);
			birdColor = new Color(randomRGB.nextInt(255), randomRGB.nextInt(255), randomRGB.nextInt(255));
			arrowX = personX + 120;
			arrowY = personY + 220;
			birdsHunted++;
		}
	}

	// keyPressed() handles key inputs
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == RIGHT) {
				personX += 20; // person move to right
				arrowX += 20;
			} else if (keyCode == LEFT) {
				personX -= 20; // person move to left
				arrowX -= 20;
			} else if (keyCode == UP) {
				// zoom the house to make it big
				houseX -= 10;
				houseY -= 10;
				houseWidth += 20;
				houseHeight += 20;
			} else if (keyCode == DOWN) {
				// zoom the house to make it small
				houseX += 10;
				houseY += 10;
				houseWidth -= 20;
				houseHeight -= 20;
			}
		}
	}

	public void mousePressed(MouseEvent event) {
		if (mousePressed && mouseButton == LEFT) {
			arrowX = mouseX * 2;
			arrowY = mouseY * 2;
		} else if (mousePressed && mouseButton == RIGHT) {
			// move the house to new mouse clicked position
			houseRectMeasurements(mouseX * 2, mouseY * 2, false);
		}
	}

	public void mouseWheel(MouseEvent event) {
		// with mouse wheel up and down, change the person's head shape
		if (event.getCount() == 0) {

		} else if (event.getCount() > 0) {
			headVerticesCount++;
		} else if (event.getCount() < 0) {
			headVerticesCount--;
		}
	}

	public void houseRectMeasurements(int win_width, int win_height, boolean isResize) {
		// setting the house rectangle's coordinates originally and
		// when mouse clicked to move the house
		houseX = win_width / 2;
		houseY = win_height / 2;

		if (isResize) {
			// set the house with standard width and height for first time
			// as it needs to get adjust every time with zoom in/out or move
			houseWidth = houseX + 120;
			houseHeight = houseY + 100;
		}
	}

	public void flyAround() {
		if (birdX > width * 2 - 50) {
			birdX = 0;
		}
		birdX += 15;
	}

	// getter methods for private variables
	public static int getPersonX() {
		return personX;
	}

	public static int getPersonY() {
		return personY;
	}

	public static int getHouseX() {
		return houseX;
	}

	public static int getHouseY() {
		return houseY;
	}

	public static int getHouseWidth() {
		return houseWidth;
	}

	public static int getHouseHeight() {
		return houseHeight;
	}

	public static int getHeadVerticesCount() {
		return headVerticesCount;
	}

	public static int getBirdX() {
		return birdX;
	}

	public static int getBirdY() {
		return birdY;
	}

	public static int getArrowX() {
		return arrowX;
	}

	public static int getArrowY() {
		return arrowY;
	}

	public static Color getBirdColor() {
		return birdColor;
	}
}
