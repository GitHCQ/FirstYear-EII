package uo.mp.lab06.greenhouse.actuators.doors;

/**
 * <p>Title: Door</p>
 * <p>Description: Class that simulates a door.</p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author mp
 * @version 2.0
 */
public class Door implements VentilationDevice{

	protected boolean opened = false;
	protected int id;
	
	public Door(int id) {
		this.id = id;
	}

	public boolean isOpened() {
		return this.opened;
	}
	
	public String open(){
		if ( ! opened) {			
			opened = true;
			return "  Please, open the door " + id;
		}
		return "";
	}

	public String close(){
		if ( opened) {
			opened = false;
			return "  Please, close the door" + id;
		}
		return "";
	}	
}
