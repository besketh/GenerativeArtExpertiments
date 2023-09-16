package core;

import processing.core.PApplet;
import processing.core.PVector;


public class StochasticBlyat extends PApplet {

    private int rectX;
    private int rectY;
    private int rectH;
    private int rectW;

    private int circleRadius;
    private float circleAngle;
    PVector circleCenter;

    private float rotationIncrement;
    private float rotation;

    private float rotateEverything;

    private int rectColour;



    public static void main(String[] args) {
        PApplet.main("core.StochasticBlyat", args);
    }


    public void settings() {
        size(1080, 1080);
    }

    public void setup() {
        background(255);
        rectH=65;
        rectW = (int) (rectH*3.25);
        rectX =rectH;
        rectY =(height/2)+(rectH/2);
        circleRadius=(min(width,height)-(min(rectH,rectW)*10))/2;


        circleCenter = new PVector(width/2, height/2);

        //get the initial point
        //for you, this would be the initial location of the object
        PVector point = new PVector(rectW, rectH);

        //find the angle between the points
        float deltaX = circleCenter.x - point.x;
        float deltaY = circleCenter.y - point.y;
        circleAngle = atan2(deltaX, deltaY);

        //find the radius of the circle
//        circleRadius = (int) dist(circleCenter.x, circleCenter.y, point.x, point.y);

        ellipseMode(RADIUS);


        draw();

        rotationIncrement=2*PI/90;
        rotation=0;
        rotateEverything=0;
        rectColour=color(225,243,255);
    }

    public void draw() {


        pushMatrix();
//        translate(rectX+rectW/2,rectY+rectW/2);
//
//        translate(0,0);
        float x = circleCenter.x + cos(circleAngle)*circleRadius;
        float y = circleCenter.y + sin(circleAngle)*circleRadius;
        translate(x,y);
        rotate(rotation);
        if (frameCount != 0) {
            fill(205-100*abs(sin(degrees(((float) frameCount) /1000))),220-80*abs(sin(degrees(((float) frameCount)/1000))),255);
            rect(0 - rectW / 2, 0 - rectH / 2, rectW, rectH);
        }
        popMatrix();

        //draw the center point

        //find the point based on the angle




        //increment the angle to move the point
        circleAngle += PI/180   ;
        rotation +=rotationIncrement;
        translate(width/2,height/2);
        rotateEverything+=rotationIncrement;
//        rotate(-rotateEverything);

        //
    }








    public int getCircleYCoordinates(int x, int r, int centreX, int centreY){
        int y;
        y = (int) (sqrt((r^2-(x-centreX)^2))+centreY);
        return y;
    }


}




