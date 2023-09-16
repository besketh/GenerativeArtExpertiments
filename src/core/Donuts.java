package core;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;


public class Donuts extends PApplet {

    public static void main(String[] args) {
        PApplet.main("core.Donuts", args);
    }

    PImage headshotImage;
    PImage symbol;
    SoundFile masterFile;
    int samplingRate;
    int frameRate;
    FunkyCircle c;
    FunkyCircle c2;
    float angleDeg;
    FunkyCircle[] history = new FunkyCircle[1000];


    public void settings() {
        size(1080, 1080, P3D);
    }

    public void setup() {

//        masterFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Projects\\Sexy Fence Builders Master.wav");
//        masterFile.play();
//
//        samplingRate = masterFile.sampleRate();
        frameRate = 60;
        frameRate(frameRate);


        c = new FunkyCircle(width / 2, height / 2, 0, 150, 0);
        c2 = new FunkyCircle(width / 2, height / 2, 0, 300, 0);
        angleDeg = 0;


    }

    public void draw() {

        if (frameCount < 2001) {
            pieceChooser(Title.DONUT_II, false);
//            pieceChooser(Title.DONUT_II, false);
        } else exit();

    }

    public void pieceChooser(Title title, Boolean save) {


        switch (title) {
            case DONUT:

                translate(width / 2, height / 2 + angleDeg);

                rotateX(radians((float) (angleDeg * 2)));
                rotateZ(radians((float) (angleDeg / 2)));
                rotateY(radians(angleDeg));

                angleDeg += 0.5;

                if (frameCount % 2 != 0) {

                    background(255);
                }

                noFill();
                strokeWeight(3);

                for (int i = 0; i < (int) (100); i++) {
                    c.show();
                    c.setZ(c.getZ() + 2);
                    c.setPhase((radians(c.getPhase() + (float) i * 10)));
                }

                break;
            case DONUT_II:

                translate(width / 2, height / 2 + angleDeg);

//                rotateX(radians((float) (angleDeg * 2)));
//                rotateZ(radians((float) (angleDeg / 2)));
//                rotateY(radians(angleDeg));

                angleDeg += 0.6;


                noFill();
                strokeWeight(2);

                for (int i = 0; i < (int) (100); i++) {
                    c2.show();
                    c2.setZ(c2.getZ() + 2);
                    c2.setPhase((radians(c2.getPhase() + (float) i * 10)));
                }


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title.toString());
        }
        if (save) saveFrame("output/" + title.toString() + "_" + width + "/frame#####.png");
    }

    enum Title {
        DONUT,
        DONUT_II
    }


    class FunkyCircle {
        private int x;
        private int y;

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        private int z;

        private int radius;

        private int r;
        private int g;
        private int b;
        private float phase;

        private boolean isGrowing;

        public FunkyCircle(int x, int y, int z, int radius, int phase) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.isGrowing = true;
            this.r = 230;
            this.g = 0;
            this.b = 126;
            this.z = z;
            this.phase = phase;
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

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public boolean isGrowing() {
            return isGrowing;
        }

        public void setGrowing(boolean growing) {
            isGrowing = growing;
        }

        public void grow() {
            if (isGrowing())
                setRadius(getRadius() + 1);
        }

        public void show() {
            pushMatrix();
            noFill();
            stroke(getR(), getG(), getB());
            rotateY(getPhase());
            circle(150, 0, getRadius());
            popMatrix();

        }

        public void dim() {
            if (frameCount % 4 == 0) {

                if (getR() > 0) {
                    setR(getR() - 1);
                }
                if (getG() > 0) {
                    setG(getG() - 1);
                }
                if (getB() > 0) {
                    setB(getB() - 1);

                }


            }


        }

        public float getPhase() {
            return phase;
        }

        public void setPhase(float phase) {
            this.phase = phase;
        }
    }

}










