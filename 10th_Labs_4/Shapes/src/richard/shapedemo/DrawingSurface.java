package richard.shapedemo;



import processing.core.PApplet;
import rithvikm.shapes.*;
public class DrawingSurface extends PApplet {
	PhysicsShape shape;
	Line launcher;
	double tipX, tipY, z; 
	public DrawingSurface() {
		launcher = new Line(200, 230, 200, 280);
		shape = new PhysicsShape(new Rectangle(100, 100, 30, 30));
		

	}
	public void draw() {
		background(255);
		//DRAWINGS
		shape.draw(this);
		
		
		//MOVING/INTERACTING/CHANGING
		
		shape.act(400, 300);
		launcher.draw(this);
		
	}

	public void mouseMoved() {
		z =  Math.pow(Math.pow(mouseX - 200, 2) + Math.pow(280 - mouseY, 2), 0.5);
		if(z <= 50) {
			launcher.move(mouseX, mouseY);
		}
		else {
			tipX = 200 + (50 * (mouseX - 200))/z;  
			tipY = 280 - (50 * (280 - mouseY))/z;
			launcher.move(tipX, tipY); 
			
		}
	}
	public void mousePressed() {
		shape = new PhysicsShape(new Rectangle(tipX, tipY, 30, 30));
		if(tipX < 195) {
			shape.setVelocity(0.1 * (tipX - tipY), -6);
		}
		else if(tipX > 195 && tipX < 205) {
			shape.setVelocity(0, -8);
		}
		else {
			shape.setVelocity(0.1 * (tipY - tipX + 30), -6);
		}

	}
}