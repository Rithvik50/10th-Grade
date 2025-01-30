package rithvikm.shapedemo;

import fabioeirea.shapes.*;
import processing.core.PApplet;

public class PhysicsShape {
	private Shapes s;
	private double vx, vy;

	public PhysicsShape(Shapes s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}

	public void act() {
		double x = s.getX();
		double y = s.getY();
		s.move((float) (x + vx), (float) (y + vy));

		if (x + s.getWidth() >= 500) {
			vx = -vx;
		} else if (x <= 0) {
			vx = -vx;
		} else if (y + s.getHeight() >= 500) {
			vy = -vy;
		} else {
			vy = -vy;
		}
	}

	public void draw(PApplet drawer) {
		s.draw(drawer);
	}

	public void setLocation(double x, double y) {
		s.move((float) x, (float) y);
	}

	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
}
