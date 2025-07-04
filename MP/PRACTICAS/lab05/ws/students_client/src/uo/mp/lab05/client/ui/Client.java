/**
 * 
 */
package uo.mp.lab05.client.ui;

import uo.mp.lab05.drawing.software.Canvas;
import uo.mp.lab05.picture.Picture;
import uo.mp.lab05.shapes.Circle;
import uo.mp.lab05.shapes.Colour;
import uo.mp.lab05.shapes.Rectangle;
import uo.mp.lab05.shapes.Triangle;

/**
 * @author Hugo
 *
 */
public class Client {
	public void run() {
		Canvas drawing = new Canvas();

		drawing.add( new Rectangle(1, 2, 3, 6, Colour.BLACK) );
		drawing.add( new Rectangle(3, 4, 7, 8, Colour.YELLOW) );
		drawing.add( new Circle(5, 5, 2, Colour.RED) );
		drawing.add( new Triangle(5, 5,Colour.GREEN,3,3,3,3) );
		drawing.add( new Picture(10, 10, 100, 75, "picture1.jpg") );

		drawing.draw(System.out);
	}
}
