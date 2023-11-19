import processing.core.PApplet;

public class Bird extends DrawingSurface {

	// FIELDS
	private double x1, y1, x2, y2;
	private double pX, pY;
	private boolean tX1X2 = false, tY1Y2 = false, tOX1X2 = false, tOY1Y2 = false;

	// CONSTRUCTORS
	public Bird() {
		x1 = getBirdX() - 25;
		x2 = getBirdX() + 25;
		y1 = getBirdY() + 25;
		y2 = getBirdY() + 25;
	}

	// METHODS
	public void draw(PApplet drawer) {
		drawer.stroke(0);
		drawer.fill(getBirdColor().getRed(), getBirdColor().getGreen(), getBirdColor().getBlue());
		drawer.frameRate(20);
		drawer.circle(getBirdX(), getBirdY(), 50);
		drawer.fill(255);
		drawer.circle(getBirdX() - 10, getBirdY() - 5, 5);
		drawer.circle(getBirdX() + 10, getBirdY() - 5, 5);
		drawer.fill(252, 186, 3);
		drawer.triangle(getBirdX() - 5, getBirdY() + 3, getBirdX() + 5, getBirdY() + 3, getBirdX(), getBirdY() + 20);
		drawer.stroke(0);
		drawer.line(getBirdX() - 25, getBirdY(), getBirdX() - 50, getBirdY() - 10);
		drawer.line(getBirdX() - 50, getBirdY() - 10, getBirdX() - 20, getBirdY() + 15);
		drawer.line(getBirdX() + 25, getBirdY(), getBirdX() + 50, getBirdY() - 10);
		drawer.line(getBirdX() + 50, getBirdY() - 10, getBirdX() + 20, getBirdY() + 15);
		drawer.noStroke();
		drawer.line((float) x1, (float) y1, (float) x2, (float) y2); // Invisible line drawn to detect intersection
																		// between the laser and the bird
	}

	public boolean intersects(Person person) {
		if (((x1 - x2) * (person.getNewArrowY() - person.getArrowY2())
				- (y1 - y2) * (person.getNewArrowX() - person.getArrowX2())) != 0) {
			pX = (((x1 * y2) - (y1 * x2)) * (person.getNewArrowX() - person.getArrowX2()) - (x1 - x2)
					* ((person.getNewArrowX() * person.getArrowY2() - person.getNewArrowY() * person.getArrowX2())))
					/ ((x1 - x2) * (person.getNewArrowY() - person.getArrowY2())
							- (y1 - y2) * (person.getNewArrowX() - person.getArrowX2()));
			pY = (((x1 * y2) - (y1 * x2)) * (person.getNewArrowY() - person.getArrowY2()) - (y1 - y2)
					* ((person.getNewArrowX() * person.getArrowY2() - person.getNewArrowY() * person.getArrowX2())))
					/ ((x1 - x2) * (person.getNewArrowY() - person.getArrowY2())
							- (y1 - y2) * (person.getNewArrowX() - person.getArrowX2()));

			// checking if pX is between x1 and x2
			if ((pX >= x1 && pX <= x2) || (pX <= x1 && pX >= x2)) {
				tX1X2 = true;
			} else {
				tX1X2 = false;
			}

			// checking if pY is between y1 and y2
			if ((pY >= y1 && pY <= y2) || (pY <= y1 && pY >= y2)) {
				tY1Y2 = true;
			} else {
				tY1Y2 = false;
			}

			// checking if pX is between person.x1 and person.x2
			if ((pX >= person.getNewArrowX() && pX <= person.getArrowX2())
					|| (pX <= person.getNewArrowX() && pX >= person.getArrowX2())) {
				tOX1X2 = true;
			} else {
				tOX1X2 = false;
			}

			// checking if pY is between person.y1 and person.y2
			if ((pY >= person.getNewArrowY() && pY <= person.getArrowY2())
					|| (pY <= person.getNewArrowY() && pY >= person.getArrowY2())) {
				tOY1Y2 = true;
			} else {
				tOY1Y2 = false;
			}

			// checking to make sure pX,pY are within the canvas and both are +ve and then
			// making sure they are between the line segments (x1,y1) (x2,y2)
			// and the person line segment (person.x1,person,y1) (person.x2,person,y2)
			if ((pX >= 0) && (pY >= 0) && (tX1X2) && (tY1Y2) && (tOX1X2) && (tOY1Y2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
