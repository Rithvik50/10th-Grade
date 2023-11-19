package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class ChameleonKid extends ChameleonCritter {
	private static final double DARKENING_FACTOR = 0.05;

	public void processActors(ArrayList<Actor> actors) {
		Color c = getColor();
		int n = actors.size();
		if (n == 0) {
			setColor(new Color((int) (c.getRed() * (1 - DARKENING_FACTOR)),
					(int) (c.getGreen() * (1 - DARKENING_FACTOR)), (int) (c.getBlue() * (1 - DARKENING_FACTOR))));
			return;
		}

		int r = (int) (Math.random() * n);
		Actor other = actors.get(r);
		setColor(new Color((int) (other.getColor().getRed() * (1 - DARKENING_FACTOR)),
				(int) (other.getColor().getGreen() * (1 - DARKENING_FACTOR)),
				(int) (other.getColor().getBlue() * (1 - DARKENING_FACTOR))));
		return;
	}
}
