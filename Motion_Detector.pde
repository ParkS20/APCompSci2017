import processing.video.*;
import processing.sound.*;
SoundFile file;
 
Capture cam;
Capture cam2;
int count=1;
PImage myImg=null;
PImage myImg2=null;
 
void setup() {
  frameRate(1000);
  file = new SoundFile(this, "/Users/parks20/Documents/Processing/libraries/sound/src/processing/sound/alarm.mp3"); 
  size(600, 300);
  cam = new Capture(this, 320, 240, 30);
  cam.start();
    cam2 = new Capture(this, 320, 240, 30);
  cam2.start();
 
}
 
void draw() {
 
  if(count<2){
  if(cam.available()) {
    cam.read();
    myImg=cam;
    count++;
  }
  }else{
    if(cam2.available()) {
    cam2.read();
    myImg2=cam2;
 
  }
  }
  if(myImg!=null && myImg2!=null){
         image(myImg, 0, 0,200,200);
         image(myImg2, 300, 0,200,200);
          loadPixels();
          myImg.loadPixels();
          myImg2.loadPixels();
          
          int change = 0;
          int threshold = 100;//YOU WILL NEED TO TWEAK
                            //VALUE COULD BE MUCH HIGHER
          
        //no need to look at all pixels
        //a sample of 200 should do
      for (int i = 0; i < 200 && count >1; i++) {
          float r = red(myImg.pixels[i]);
          float r2 = red(myImg2.pixels[i]);
          if((r+40)<r2 || (r-40)>r2){
             change ++; 
          }
            
          //you may want to compare r to r2
 
 
      }//for loop ended
      if(change>threshold){
        System.out.println("Motion Detected!");
        
        myImg2 = null; 
        myImg = null; 
        count = 0; 
        file.play(); 
      }
           //once change is greater than threshold
          //println - motion has been detected
          //when motion is detected you will wan to :
          //1)set myImg and myImg2 equal to null 
          //2) set count = 0
 
          //extra credit --> play a sound when motion is detected
 
 
 
 
 
          updatePixels();
 
 
 
}
 
}//end of draw
