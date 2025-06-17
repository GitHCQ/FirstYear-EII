package uo.mp.lab05.drawing.software;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Canvas {
	private List< Rectangle > drawables = new ArrayList<>();

	/**
	 * Adds to the canvas a new object to be drawn 
	 * @param drawable something that can be drawn
	 * @throws IAE if argument is null
	 */
	public void add(Rectangle drawable) {
		drawables.add(drawable);
	}

	/**
	 * Prints the content in the canvas
	 * @implNote it will print in console the description of the items  
	 * @param out output
	 */
	public void draw(PrintStream out) {
		for (Rectangle rectangle:drawables) {
			String output = String.format("Drawing a %s Rectangle: (%d, %d) - width: %d - height: %d", 
					rectangle.getColour(), 
					rectangle.getX(), 
					rectangle.getY(), 
					rectangle.getWidth(), 
					rectangle.getHeight());
			out.println(output);
		}
	}
	
}
