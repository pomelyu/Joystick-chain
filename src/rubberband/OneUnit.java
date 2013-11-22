package rubberband;

public class OneUnit {
	
	// constant variable
	private static float MAX_DEGREE_X = Global.MAX_DEGREE_X;
	private static float MIN_DEGREE_X = Global.MIN_DEGREE_X;
	private static float MAX_DEGREE_Y = Global.MAX_DEGREE_Y;
	private static float MIN_DEGREE_Y = Global.MIN_DEGREE_Y;
	
	// public method
	public OneUnit(){}
	public void disableUnit(){ isAble = false; }
	public float getDegreeX(){ return (isAble) ? degreeX: 0; }
	public float getDegreeY(){ return (isAble) ? degreeY: 0; }
	
	public void updateXY(int x, int y){
		// TODO add filter to smooth the result;
		valueX = x;
		valueY = y;
		degreeX = MIN_DEGREE_X + valueX*(MAX_DEGREE_X-MIN_DEGREE_X)/1024;
		degreeY = MIN_DEGREE_Y + valueY*(MAX_DEGREE_Y-MIN_DEGREE_Y)/1024;
	}
	
	// class member
	private boolean isAble = true; // Enable or disable this Unit 
	private float   degreeX = 0;
	private	float   degreeY = 0;
	private int     valueX  = 512;
	private int     valueY  = 512;
	
	// private method
		
}
