#define numJoy 8

int pinX = A0;
int pinY = A1;

int s0 = 2;
int s1 = 3;
int s2 = 4;

int valueX = 512;
int valueY = 512;

void setup(){
  Serial.begin(19200);
  pinMode(pinX, INPUT);
  pinMode(pinY, INPUT);
  pinMode(s0, OUTPUT);
  pinMode(s1, OUTPUT);
  pinMode(s2, OUTPUT);
}


void loop(){
  for (int i=0; i<numJoy; i++){
    digitalWrite(s0, bitRead(i,0));
    digitalWrite(s1, bitRead(i,1));
    digitalWrite(s2, bitRead(i,2));
    valueX = analogRead(pinX);
    valueY = analogRead(pinY);
    Serial.print(valueX); Serial.print(",");
    Serial.print(valueY); Serial.print(",");
    delay(10);
  }
  Serial.println();
}


