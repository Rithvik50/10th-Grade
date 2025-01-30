package rithvikm.shapedemo;

import fabioeirea.shapes.*;
import processing.core.*;

public class DrawingSurface extends PApplet {

	private PhysicsShape shape, newShape;

	public DrawingSurface() {
		shape = new PhysicsShape(new Rectangle(100, 100, 50, 50));
		newShape = new PhysicsShape(new Circle(25, 100, 50));
	}

	public void draw() {
		background(255);
		shape.draw(this);
		newShape.draw(this);
		shape.act();
		newShape.act();
	}

	public void mouseDragged() {
		if (mousePressed && mouseButton == RIGHT) {
			shape.setLocation(mouseX, mouseY);
			shape.setVelocity(mouseX - pmouseX, mouseY - pmouseY);
		} else if (mousePressed && mouseButton == LEFT) {
			newShape.setLocation(mouseX, mouseY);
			newShape.setVelocity(mouseX - pmouseX, mouseY - pmouseY);
		}
	}
}
