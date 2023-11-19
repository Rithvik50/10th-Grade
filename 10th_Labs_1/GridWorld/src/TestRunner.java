/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a Bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class TestRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7,2), new Bug());
        world.add(new Location(7,5), new Bug(Color.CYAN));
        Bug b = new Bug();
        b.setColor(Color.GREEN);
        world.add(new Location(7,8), b);
        world.add(new Location(4,2), new Rock());
        world.add(new Location(4,5), new Rock());
        world.add(new Location(4,8), new Rock());
        world.add(new Location(5,3), new Rock());
        world.add(new Location(5,6), new Rock());
        world.add(new Location(5,9), new Rock());
        world.show();
    }
}
