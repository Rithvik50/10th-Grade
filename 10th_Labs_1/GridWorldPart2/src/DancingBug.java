import info.gridworld.actor.Bug;

public class DancingBug extends Bug {

	private int[] dance;
	private int steps;

	public DancingBug(int[] dance) {
		this.dance = dance;
		steps = 0;
	}

	public void act() {
		for (int i = 0; i < dance[steps]; i++) {
			turn();
		}
	}
}
