package rubberband;

import processing.core.PApplet;


public class RubberBand extends PApplet {
	
	// constant variable
	private static final long serialVersionUID = 1L;
	private static int WIDTH = Global.WINDOW_WIDTH;
	private static int HEIGHT = Global.WINDOW_HEIGHT;
	private static int NUM_OF_UNIT = Global.NUM_OF_UNIT;
	private static int UNIT_RADIUS = 40;
	
	// setup()
	public void setup() {
		
		// setup display
		size(WIDTH, HEIGHT,P3D);
		background(255);
		
		// setup member
		dataHandler = new DataHandler(this);
		unitList = new OneUnit[NUM_OF_UNIT];
		for (int i=0; i<NUM_OF_UNIT; i++)
			unitList[i] = new OneUnit();
		
		// For test disable unit[1] and unit[2]
		//unitList[1].disableUnit();
		//unitList[2].disableUnit();
	}
	
	// draw()
	public void draw() {
		
		// update data
		dataHandler.updateData(unitList);
		
		// draw display
		background(255);
		translate(WIDTH/2-NUM_OF_UNIT*UNIT_RADIUS, HEIGHT/2);
		rotateZ(PI/2);
		fill(128);
		for(int i=0; i<NUM_OF_UNIT; i++)
			drawUnit(unitList[i]);
	}
	
	// mouse event
	public void mouseMoved(){}
	public void mouseDragged(){}
	
	// class member
	private DataHandler dataHandler;
	private OneUnit[] unitList;
	
	
	// private method
	private void drawUnit(OneUnit unit){
		//System.out.println(unit.getDegreeX()+","+unit.getDegreeY());
		box(UNIT_RADIUS*2);
		translate(0,-UNIT_RADIUS,0);
		rotateX(-radians(unit.getDegreeX()));
		rotateZ(-radians(unit.getDegreeY()));
		translate(0,-UNIT_RADIUS,0);
	}
}
