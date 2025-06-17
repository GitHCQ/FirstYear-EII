package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;


/**
 * A rectangle specifies an area in a coordinate space that is enclosed by the
 * the rectangle upper-left point (x, y) in the coordinate space, its width, and
 * its height.
 */
public class Rectangle extends Shape implements Drawable{
	/**
	 * The width of the rectangle, in pixels.
	 */
	private int width;

	/**
	 * The height of the rectangle, in pixels.
	 */
	private int height;

	/**
	 * Creates a new rectangle
	 * @param x x coordinate of the lower left corner
	 * @param y y coordinate of the lower left corner
	 * @param width of the shape, in pixels
	 * @param height height of the rectangle, in pixels
	 * @param colour 
	 * @throws IAE if some argument is illegal
	 * 			coordinates, width, height is 0 or under 0
	 * 			colour is null
	 */
	public Rectangle(int x, int y, int width, int height, Colour colour) {
		super(x,y,colour);
		this.width = width;
		this.height = height;
	}
	
	
	/**
	 * @return the width
	 */
	private int getWidth() {
		return width;
	}


	/**
	 * @return the height
	 */
	private int getHeight() {
		return height;
	}


	@Override
	public void draw(PrintStream out) {
			String output = String.format("Drawing a %s Rectangle: (%d, %d) - width: %d - height: %d", 
			this.getColour(),getX(),this.getY(),this.getWidth(), this.getHeight());
			out.println(output);
		}
	}

