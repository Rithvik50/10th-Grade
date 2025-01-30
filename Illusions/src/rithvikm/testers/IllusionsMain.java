package rithvikm.testers;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import rithvikm.illusion.Illusions;

/**
 * This class creates a new panel and displays the shapes.
 * 
 * @author Rithvik Muthyalapati
 * @version 10/3/19
 */
public class IllusionsMain {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		Illusions drawing = new Illusions();
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) canvas.getFrame();

		window.setSize(500, 500);
		window.setMinimumSize(new Dimension(100, 100));

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

}
