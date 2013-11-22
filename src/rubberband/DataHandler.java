package rubberband;

import processing.core.PApplet;
import processing.serial.Serial;
import java.lang.String;

public class DataHandler {
	
	// constant variable
	private static String PORT_NAME  = Global.PORT_NAME;
	private static int    BRAUD_RATE = Global.BRAUD_RATE;
	private static int 	  NUM_OF_STRING = 2*Global.NUM_OF_UNIT;
	
	// public method
	public DataHandler(RubberBand rubber){
		arduinoPort = new Serial(rubber, PORT_NAME, BRAUD_RATE);
	}
	
	public int updateData(OneUnit[] unitList){
		String inStr = arduinoPort.readStringUntil('\n');
		if (inStr != null){
			//System.out.println(inStr);
			String[] inStrArr = inStr.split(",");
			if (inStrArr.length == NUM_OF_STRING + 1){
				for(int i=0; i<Global.NUM_OF_UNIT; i++){
					int x = Integer.parseInt(inStrArr[2*i]);
					int y = Integer.parseInt(inStrArr[2*i+1]);
					unitList[i].updateXY(x, y);
				}
				return 1;
			}
			else
				return -1;
		}
		else
			return -1;
	}
	
	// class member
	private Serial arduinoPort;	
	
	// private method
	private float decodeFloat(String inString) {
	    byte [] inData = new byte[4];
	    if (inString.length() == 8) {
	      inData[0] = (byte) PApplet.unhex(inString.substring(0, 2));
	      inData[1] = (byte) PApplet.unhex(inString.substring(2, 4));
	      inData[2] = (byte) PApplet.unhex(inString.substring(4, 6));
	      inData[3] = (byte) PApplet.unhex(inString.substring(6, 8));
	    }
	    int intbits = (inData[3] << 24) | ((inData[2] & 0xff) << 16) | ((inData[1] & 0xff) << 8) | (inData[0] & 0xff);
	    return Float.intBitsToFloat(intbits);
	}
}
