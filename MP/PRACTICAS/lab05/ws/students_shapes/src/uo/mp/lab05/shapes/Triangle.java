/**
 * 
 */
package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;

/**
 * @author usuario
 *
 */
public class Triangle extends Shape implements Drawable {
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	public Triangle(int x, int y, Colour colour,int x1,int x2,int y1,int y2) {
		super(x, y, colour);
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}

	/**
	 * @return the x1
	 */
	private int getX1() {
		return x1;
	}

	/**
	 * @return the x2
	 */
	private int getX2() {
		return x2;
	}

	/**
	 * @return the y1
	 */
	private int getY1() {
		return y1;
	}

	/**
	 * @return the y2
	 */
	private int getY2() {
		return y2;
	}

	@Override
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Triangle in : (%d, %d) - CoordinatesX:(%d,%d)- CoordinatesY:(%d,%d) ", 
				this.getColour(),getX(),this.getY(),this.getX1(),this.getX2(),this.getY1(),this.getY2());
				out.println(output);
			}
		
	}

