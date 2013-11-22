package rubberband;

import processing.core.PApplet;


public class RubberBand extends PApplet {
	
	// constant variable
	private static final long serialVersionUID = 1L;
	private static int WIDTH = Global.WINDOW_WIDTH;
	private static int HEIGHT = Global.WINDOW_HEIGHT;
	
	// setup()
	public void setup() {
		
		// setup display
		size(WIDTH, HEIGHT);
		background(255);
		
		// setup member
		dataHandler = new DataHandler(this);
		unitList = new OneUnit[Global.NUM_OF_UNIT];
		for (int i=0; i<Global.NUM_OF_UNIT; i++)
			unitList[i] = new OneUnit();
	}
	
	// draw()
	public void draw() {
		
		// update data
		dataHandler.updateData(unitList);
		
		// draw display
		background(255);
		String msg = "Joy1: x = " + unitList[0].getDegreeX() + ", y = " + unitList[0].getDegreeY();
		textSize(16);
		fill(0);
		text(msg, 10, 100);
	}
	
	// class member
	private DataHandler dataHandler;
	private OneUnit[] unitList; 
}
