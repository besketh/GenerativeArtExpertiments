package core;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class DonutsFloating extends PApplet {

    public static void main(String[] args) {
        PApplet.main("core.DonutsFloating", args);
    }


    int frameRate;
    ArrayList<Colour> colours = new ArrayList<>();
    int granularity;
    PImage image;

    public void settings() {
        size(1080, 1080, P3D);
    }

    public void setup() {

        image = loadImage("C:\\Users\\user\\Desktop\\20210106_142906.jpg");
        frameRate = 60;
        frameRate(frameRate);
        granularity = 360;
        for (int i = 0; i < granularity; i++) {
//            colours.add(new Colour(randomInt(0), randomInt(0), randomInt(0)));
            colours.add(new Colour(0));
        }


    }

    public void draw() {
        if (frameCount < 3601) {
            pieceChooser(Title.DONUT_FLOATING, true);
        } else exit();
    }

    public void pieceChooser(Title title, Boolean save) {
        switch (title) {


            case DONUT_FLOATING:


                background(135,206,235);
//                image(image,0,height-image.height);
                translate(width / 2, height / 2+(float) 0.025 * (float) frameCount, +(float) 0.25 * (float) frameCount);
                rotateX(radians((float) 0.0275 * (float) frameCount + (float)62.5));
                rotateY(radians((float) 0.032 * (float) frameCount));



                new Donut(185, colours);

//                translate(0, 0, 0);
//                translate(width / 5, -height / 5, 0);
//                rotateX(radians(0));
//                rotateX(radians(-(float) 1 * (float) frameCount));
//                new Donut(15,colours);


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title.toString());
        }
        if (save) saveFrame("output/" + title.toString() + "_" + width + "/frame#####.png");
    }

    enum Title {
        DONUT_FLOATING
    }


    class Colour {
        public Colour(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public Colour(int rgb) {
            this.r = rgb;
            this.g = rgb;
            this.b = rgb;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        private int r;
        private int g;
        private int b;

    }

    class Location {

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Location(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }

        private float x;
        private float y;
        private float z;
    }

    public int randomInt(int upperLimit) {
        return (int) random(upperLimit);
    }

    class Orientation {
        public Orientation(float xRotation, float yRotation, float zRotation) {
            this.xRotation = xRotation;
            this.yRotation = yRotation;
            this.zRotation = zRotation;
        }

        public Orientation() {
            this.xRotation = 0;
            this.yRotation = 0;
            this.zRotation = 0;
        }


        public float getxRotation() {
            return xRotation;
        }

        public void setxRotation(float xRotation) {
            this.xRotation = xRotation;
        }

        public float getyRotation() {
            return yRotation;
        }

        public void setyRotation(float yRotation) {
            this.yRotation = yRotation;
        }

        public float getzRotation() {
            return zRotation;
        }

        public void setzRotation(float zRotation) {
            this.zRotation = zRotation;
        }

        private float xRotation;
        private float yRotation;
        private float zRotation;
    }


    class Donut {
        private Location location;
        private Orientation orientation;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Orientation getOrientation() {
            return orientation;
        }

        public void setOrientation(Orientation orientation) {
            this.orientation = orientation;
        }

        public ArrayList<Circle> getCircles() {
            return circles;
        }

        public void setCircles(ArrayList<Circle> circles) {
            this.circles = circles;
        }

        private ArrayList<Circle> circles;

        public Donut(int granularity, ArrayList<Colour> colours) {
            this.location = new Location(width / 2, height / 2, 0);
            this.orientation = new Orientation(0, 0, (float) 0.25 * (float) frameCount);
            circles = new ArrayList<>();

            int radius = 281;
            for (int i = 0; i < granularity; i++) {


                float cPhase = radians((float) 360 / granularity * (float) i);
                Circle circle = new Circle(new Colour(0), new Location(radius, 0, 0), new Orientation(0, cPhase, 0), radius);
                circles.add(circle);
                int gap = 10;
                if (i>gap ||i<granularity-gap) {
                    circles.get(i).show();

                }


            }


        }

    }

    class Circle {
        private Colour colour;
        private Location location;
        private Orientation orientation;
        private int radius;
        private int strokeWeight;

        public Circle(Colour colour, Location location, Orientation orientation, int radius) {
            this.colour = colour;
            this.location = location;
            this.orientation = orientation;
            this.radius = radius;
            this.strokeWeight = 5;
        }

        public Colour getColour() {
            return colour;
        }

        public void setColour(Colour colour) {
            this.colour = colour;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Orientation getOrientation() {
            return orientation;
        }

        public void setOrientation(Orientation orientation) {
            this.orientation = orientation;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public int getStrokeWeight() {
            return strokeWeight;
        }

        public void setStrokeWeight(int strokeWeight) {
            this.strokeWeight = strokeWeight;
        }

        public void show() {

            pushMatrix();
            noFill();

            stroke(colour.getR(), colour.getG(), colour.getB());
            strokeWeight(strokeWeight);


            rotateX(orientation.xRotation);
            rotateY(orientation.yRotation);
            rotateZ(orientation.zRotation);


            translate(location.x, location.y, location.z);

            circle(0, 0, radius);
            popMatrix();


        }


    }


}









