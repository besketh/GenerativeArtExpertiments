package core;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

import java.util.ArrayList;


public class LetsGetSpherical extends PApplet {

    public static void main(String[] args) {
        PApplet.main("core.LetsGetSpherical", args);
    }

    PImage headshotImage;
    PImage symbol;
    SoundFile masterFile;
    int samplingRate;
    int frameRate;
    ArrayList<FunkyCircle> funkyCircles;

    public void settings() {
        size(1080, 1080, P3D);
    }

    public void setup() {

        headshotImage = loadImage("C:\\Users\\user\\Pictures\\IMG-20200826-WA0023_square.jpg");
        symbol = loadImage("C:\\Users\\user\\Pictures\\star.png");
        symbol.resize(width,height);
//        masterFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Projects\\Sexy Fence Builders Master.wav");
//        masterFile.play();
//
//        samplingRate = masterFile.sampleRate();
        frameRate = 60;
        frameRate(frameRate);

        funkyCircles = new ArrayList<>();

    }

    public void draw() {
        if (frameCount < 501) {
            pieceChooser(Title.LETS_GET_SPHERICAL, false);
        } else exit();

    }

    public void pieceChooser(Title title, Boolean save) {

        switch (title) {
            case LETS_GET_SPHERICAL:
                background(0);

                noFill();
                strokeWeight(1);

                FunkyCircle freshFunkyCircle = validateFreshFunkyCircle(funkyCircles, getFreshFunkyCircle(),symbol);
                if (freshFunkyCircle != null) funkyCircles.add(freshFunkyCircle);
                funkyCircles = validateFunkyCircles(funkyCircles);

                for (FunkyCircle funkyCircle : funkyCircles) {
                    funkyCircle.show();
                    funkyCircle.grow();
                    funkyCircle.dim();

                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title.toString());
        }
        if (save) saveFrame("output/" + title.toString() + "_" + width + "/frame#####.png");
    }

    enum Title {
        LETS_GET_SPHERICAL
    }


    public FunkyCircle validateFreshFunkyCircle(ArrayList<FunkyCircle> funkyCircles, FunkyCircle freshFunkyCircle) {
        for (FunkyCircle c : funkyCircles) {
            if (c != freshFunkyCircle) {
                float distanceBetweenFunkyCircles = dist(c.getX(), c.getY(), freshFunkyCircle.getX(), freshFunkyCircle.getY());
                if (distanceBetweenFunkyCircles < c.getRadius() + freshFunkyCircle.getRadius() + 2) {
                    return null;
                }
            }
        }
        if (freshFunkyCircle.isTouchingEdges()) freshFunkyCircle.setGrowing(false);


        return freshFunkyCircle;
    }



    public FunkyCircle validateFreshFunkyCircle(ArrayList<FunkyCircle> funkyCircles, FunkyCircle freshFunkyCircle, PImage image) {
        for (FunkyCircle c : funkyCircles) {
            if (c != freshFunkyCircle) {
                System.out.println(image.get(c.getX(),c.getY()));
//                if (image.get(c.getX(),c.getY())==0){
//                    return null;
//                }
                float distanceBetweenFunkyCircles = dist(c.getX(), c.getY(), freshFunkyCircle.getX(), freshFunkyCircle.getY());
                if (distanceBetweenFunkyCircles < c.getRadius() + freshFunkyCircle.getRadius() + 2) {
                    System.out.println("wrong");
                    return null;
                }

            }
        }
        if (freshFunkyCircle.isTouchingEdges()) freshFunkyCircle.setGrowing(false);


        return freshFunkyCircle;
    }



    public ArrayList<FunkyCircle> validateFunkyCircles(ArrayList<FunkyCircle> funkyCircles) {
        for (FunkyCircle c1 : funkyCircles) {
            if (c1.isTouchingEdges()) {
                c1.setGrowing(false);
            } else {
                for (FunkyCircle c2 : funkyCircles) {
                    if (c1 != c2) {
                        float distanceBetweenFunkyCircles = dist(c1.getX(), c1.getY(), c2.getX(), c2.getY());
                        if (distanceBetweenFunkyCircles < c1.getRadius() + c2.getRadius() + 2) {
                            c1.setGrowing(false);
                        }
                    }
                }
            }
        }
        return funkyCircles;
    }


    public FunkyCircle getFreshFunkyCircle() {
        int x = (int) random(width);
        int y = (int) random(height);
        return new FunkyCircle(x, y);


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

        private boolean isGrowing;
        private boolean isTouchingEdges;

        public boolean isTouchingEdges() {
            return (x + radius > width || x - radius < 0 || y + radius > height || y - radius < 0);
        }

        public void setTouchingEdges(boolean touchingEdges) {
            this.isTouchingEdges = touchingEdges;
        }

        public FunkyCircle(int x, int y) {
            this.x = x;
            this.y = y;
            this.radius = 1;
            this.isGrowing = true;
            this.isTouchingEdges = isTouchingEdges();
            this.r = 255;
            this.g = 255;
            this.b = 255;
            this.z=240;
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
                setZ(getZ() -1);

                setY(getY() +1);
        }

        public void show() {
            pushMatrix();
            translate(getX(), getY(), getZ());
            rotateY(getY()/5);
            noFill();
            stroke(getR(), getG(), getB());
            sphere(getRadius());
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

    }

}










