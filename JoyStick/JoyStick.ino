#define numJoy 3

class OneUnit{
  public:
    OneUnit(int _rX, int _rY){
      rX = _rX;
      rY = _rY;
      pinMode(rX, INPUT);
      pinMode(rY, INPUT);
    }
    
    void printXY(){
      int tmp;
      tmp = readX();
      Serial.print(tmp); Serial.print(",");
      tmp = readY();
      Serial.print(tmp); Serial.print(",");
    }
      
    int readX(){ delay(10); return analogRead(rX); }
    int readY(){ delay(10); return analogRead(rY); }
  
    int rX;
    int rY;
};

OneUnit* joy[numJoy];

void setup(){
  Serial.begin(19200);
  joy[0] = new OneUnit(A0, A1);
  joy[1] = new OneUnit(A2, A3);
  joy[3] = new OneUnit(A4, A5);
}


void loop(){
  for (int i=0; i<numJoy; i++)
    joy[i] -> printXY();
  Serial.println();
}


