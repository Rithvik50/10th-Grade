package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class KingCrab extends CrabCritter {

	public KingCrab() {
		setColor(Color.CYAN);
	}

	public int distanceFrom(Location loc1, Location loc2) {
		int x1 = loc1.getRow();
		int y1 = loc1.getCol();
		int x2 = loc2.getRow();
		int y2 = loc2.getCol();
		double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) + .5;
		return (int) Math.floor(dist);
	}

	public boolean canMoveAway(Actor a) {
		ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());
		for (Location loc : locs) {
			if (distanceFrom(getLocation(), loc) > 1) {
				a.moveTo(loc);
				return true;
			}
		}
		return false;
	}

	/*
	 * * Each actor in the list actors is told to move one location further * away
	 * from this KingCrab. If that is not possible, the actor is * removed from the
	 * grid.
	 */ public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (!canMoveAway(a)) {
				a.removeSelfFromGrid();
			}
		}
	}
}
