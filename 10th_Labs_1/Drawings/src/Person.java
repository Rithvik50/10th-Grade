import processing.core.PApplet;

public class Person extends DrawingSurface {

	// FIELDS
	private int arrowX1, arrowY1, arrowX2, arrowY2;

	// CONSTRUCTORS
	public Person() {
		arrowX1 = getArrowX();
		arrowY1 = getArrowY();
		arrowX2 = getPersonX() + 50;
		arrowY2 = getPersonY() + 140;
	}

	// METHODS
	public void draw(PApplet surface) {
		surface.scale(0.5F);
		surface.fill(225, 126, 247);
		// draw stick person body, hands, legs
		surface.line(getPersonX(), getPersonY() + 50, getPersonX(), getPersonY() + 200);
		surface.line(getPersonX() - 50, getPersonY() + 140, getPersonX(), getPersonY() + 100); // left arm
		surface.line(getPersonX() + 50, getPersonY() + 140, getPersonX(), getPersonY() + 100); // right arm
		surface.line(getPersonX() - 50, getPersonY() + 240, getPersonX(), getPersonY() + 200); // left leg
		surface.line(getPersonX() + 50, getPersonY() + 240, getPersonX(), getPersonY() + 200); // right leg
		surface.fill(255, 0, 0);
		surface.arc(getPersonX() - 5, getPersonY() + 80, 200, 200, 0, HALF_PI, CHORD);

		// Switch case to change the shape of the person's head based on vertex counter
		switch (getHeadVerticesCount()) {
		case -1:
			surface.stroke(225, 126, 247);
			surface.line(getPersonX(), getPersonY() + 100, getPersonX(), getPersonY() - 50);
			break;
		case 0:
			surface.circle(getPersonX() + 4, getPersonY(), 100);
			break;
		case 1:
			surface.triangle(getPersonX() - 50, getPersonY() + 50, getPersonX(), getPersonY() - 50, getPersonX() + 50,
					getPersonY() + 50);
			break;
		case 2:
			surface.square(getPersonX() - 50, getPersonY() - 50, 100);
			break;
		default:
			break;
		}

		surface.stroke(255, 0, 0);
		surface.line(arrowX1, arrowY1, arrowX2, arrowY2); // Lazer beam
	}

	public int getNewArrowX() {
		return arrowX1;
	}

	public int getNewArrowY() {
		return arrowY1;
	}

	public int getArrowX2() {
		return arrowX2;
	}

	public int getArrowY2() {
		return arrowY2;
	}
}
