import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as it
 * moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Bug extends Actor {
	/**
	 * Constructs a red bug.
	 */

	private Color bugColor;
	private boolean isColorChanged = false;

	public Bug() { // Sets default color to Red
		setColor(Color.RED);
	}

	/**
	 * Constructs a bug of a given color.
	 * 
	 * @param bugColor the color for this bug
	 */
	public Bug(Color bugColor) { // Sets custom color to the bug
		setColor(bugColor);
	}

	/**
	 * Moves if it can move, turns otherwise.
	 */

	int stepCount = 0;

	public void act() {

		if (!isColorChanged && !getColor().equals(bugColor)) {
			bugColor = getColor(); // Stores the current bugs color every time the bug can move
		}

		if (stepCount % 2 == 0) { // Slows the bug down
			if (canMove()) { // Checks if it can move or not
				move();
				setColor(bugColor);
				isColorChanged = false; // To set bugColor to the current color
			} else {
				setColor(new Color(153, 0, 153)); // Changes color to purple
				turn();
				isColorChanged = true; // To prevent overwriting the original bugColor
			}
		}
		stepCount++;
	}

	/**
	 * Turns the bug 90 degrees to the right without changing its location.
	 */
	public void turn() {
		setDirection(getDirection() + Location.RIGHT);
	}

	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next))
			moveTo(next);
		else
			removeSelfFromGrid();
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Flower);
		// ok to move into empty location or onto flower
		// not ok to move onto any other actor
	}

}
