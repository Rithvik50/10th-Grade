package rithvikm.illusions;
import java.awt.Color;

import processing.core.PApplet;
import rithvikm.shapes.*;

public class SecondIllusion extends PApplet {

	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Line line;

	public SecondIllusion() {
		rectangle1 = new Rectangle(225, 125, 15, 200);
		rectangle2 = new Rectangle(300, 125, 15, 200);
		line = new Line(-100, 225, 500, -55);
	}

	public void draw() {
		background(255);
		for (int i = 0; i < 11; i++) {
			line = new Line(-100, 225, 500, -55 + i * 60);
			line.draw(this);
		}
		rectangle1.setColor(Color.BLUE);
		rectangle1.draw(this);
		rectangle2.setColor(Color.BLUE);
		rectangle2.draw(this);
	}
}
