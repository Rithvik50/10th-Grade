package info.gridworld.actor;

import java.awt.Color;

public class JumperRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new Jumper(new Color(0)));
		world.add(new Bug());
		world.add(new Rock());
		world.show();
	}
}
