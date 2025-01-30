package richard.shapedemo;

import processing.core.PApplet;
import rithvikm.shapes.*;
public class PhysicsShape {
	private Shape s;
	private double vx, vy;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}
	
	public void act(double width, double height) {
		double x = s.getX();
		double y = s.getY();
		if(s.isPointInside(width, height - 10)) {
			y = y - vy;
			s.move(x + vx, y + vy);
		}
		else {
			s.move(x + vx, y + vy);
			vy += 0.1;
		}
		
	}
	
	
	public void setLocation(double x, double y) {
		s.move(x, y);
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	public void draw(PApplet drawer) {
		s.draw(drawer);
	}
}
