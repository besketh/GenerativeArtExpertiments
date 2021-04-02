//package core;
//
//import processing.core.PApplet;
//import processing.sound.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Main extends PApplet {
//
//    public static void main(String[] args) {
//        PApplet.main("core.Main", args);
//    }
//
//    SoundFile masterFile;
//    SoundFile bassFile;
//    SoundFile kickFile;
//    SoundFile snareFile;
//    SoundFile hatsFile;
//
//    Amplitude masterAmplitude;
//    Amplitude bassAmplitude;
//    Amplitude kickAmplitude;
//    Amplitude snareAmplitude;
//    Amplitude hatsAmplitude;
//
//    int bassModFrameCount;
//    int kickModFrameCount;
//    int snareModFrameCount;
//    int hatsModFrameCount;
//
//
//    int audioSamplingRate;
//    int videoSamplingRate;
//
//    boolean goingRightWards;
//
//    int x;
//
//
//    public void settings() {
//        //   fullScreen(P3D);
//        size(800, 800);
//        frameRate(240);
//
//
//    }
//
//    public void setup() {
//        masterFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Projects\\Sexy Fence Builders Master.wav");
//        bassFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Audio\\Rendered\\mid bass (consolidated) - Part_1.wav");
//        kickFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Audio\\Recorded\\Sexy Fence Builders_2021-03-07 15-54-44_kick - Part_1.wav");
//        snareFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Audio\\Recorded\\Sexy Fence Builders_2021-03-07 15-56-29_snare - Part_1.wav");
//        hatsFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Audio\\Recorded\\Sexy Fence Builders_2021-03-07 15-56-29_hats - Part_1.wav");
//
//        masterAmplitude = new Amplitude(this);
//        masterAmplitude.input(masterFile);
//
//        bassAmplitude = new Amplitude(this);
//        bassAmplitude.input(bassFile);
//
//        kickAmplitude = new Amplitude(this);
//        kickAmplitude.input(kickFile);
//
//        snareAmplitude = new Amplitude(this);
//        snareAmplitude.input(snareFile);
//
//        hatsAmplitude = new Amplitude(this);
//        hatsAmplitude.input(hatsFile);
//
//        audioSamplingRate = masterFile.sampleRate();
//        videoSamplingRate = 60;
//
//        bassModFrameCount = 0;
//        kickModFrameCount = 0;
//        snareModFrameCount = 0;
//        hatsModFrameCount = 0;
//
//        masterFile.play();
//
//        goingRightWards = true;
//
//        background(0);
//
//        x = 0;
//    }
//
//
//    public float[] getSpiralCoordinatesForFrameCount(int frameCount, int radius) {
//
//        int cx;
//        int cy;
//        float a = (float) 0.1;
//
//
//        cx = width / 2;
//        cy = height / 2;
//
//        float t = radians(frameCount);
//        float x = cx + a * t * radius * cos(frameCount);
//        float y = cy + a * t * radius * sin(frameCount)*sin(frameCount)*sin(frameCount)*sin(frameCount);
//
//
//
//
//        float[] coordinatesXY = new float[]{x, y};
//
//        return coordinatesXY;
//    }
//
//    public float scalingFloat(float input, float lowerBoundary, float upperBoundary, int scale) {
//
//        float output;
//        if (input < 0.01) output = (float) 0.01;
//        else if (input > 0.1) output = (float) 0.1;
//        else output = input;
//
//        return output;
//    }
//
//
//    public void draw() {
//
//
//        float masterAmplitude = this.masterAmplitude.analyze();
//        float bassAmplitude = bassFile.read(audioSamplingRate / videoSamplingRate * frameCount);
//        float kickAmplitude = kickFile.read(audioSamplingRate / videoSamplingRate * frameCount);
//        float snareAmplitude = snareFile.read(audioSamplingRate / videoSamplingRate * frameCount);
//        float hatsAmplitude = hatsFile.read(audioSamplingRate / videoSamplingRate * frameCount);
//
////        y = (int) (Math.toDegrees(Math.acos(amplitude)));
////        if (frameCount % 2 == 0) {
////            fill(random(150), 0, random(150));
////        }
////        if (frameCount % 99 == 0) {
////
////        }
//
//        if (x > 800) {
//            goingRightWards = false;
//            if (frameCount % 99 == 0) {
//
//                System.out.println("left");
//            }
//        } else if (x < 0) {
//            goingRightWards = true;
//            if (frameCount % 99 == 0) {
//
//                System.out.println("right");
//            }
//        }
//
//
//        double appearanceThreshold = 0.00;
//
////        if (goingRightWards) x = x + 2;
////        else x = x - 2;
//
//
////        if (bassAmplitude > appearanceThreshold) {
////            new BassBlob((int) getSpiralCoordinatesForFrameCount(bassModFrameCount / 2, 300)[0] - 200, (int) getSpiralCoordinatesForFrameCount(bassModFrameCount / 2, 300)[1] - 200, (int) (bassAmplitude * 25 + 25), frameCount);
////            bassModFrameCount++;
////        }
////        if (kickAmplitude > appearanceThreshold) {
////            new KickBlob((int) getSpiralCoordinatesForFrameCount(kickModFrameCount / 2, 300)[0] + 200, (int) getSpiralCoordinatesForFrameCount(kickModFrameCount / 2, 300)[1] + 200, (int) (kickAmplitude * 25 + 25), frameCount);
////            kickModFrameCount++;
////        }
////       if (snareAmplitude > appearanceThreshold) {
////           new SnareBlob((int) getSpiralCoordinatesForFrameCount(snareModFrameCount / 2, 300)[0] - 200, (int) getSpiralCoordinatesForFrameCount(snareModFrameCount / 2, 300)[1] + 200, (int) (snareAmplitude * 25 + 25), frameCount);
////           snareModFrameCount++;
////       }
//        if (hatsAmplitude > appearanceThreshold) {
//            new HatsBlob((int) getSpiralCoordinatesForFrameCount(hatsModFrameCount, 300)[0], (int) getSpiralCoordinatesForFrameCount(hatsModFrameCount, 300)[1] - 400, (int) (25), frameCount);
//            hatsModFrameCount++;
//        }
//
//    }
//
//
//    class InstrumentBlob {
//        public InstrumentBlob(int r, int g, int b, int x, int y, int z) {
//            setR(r);
//            setG(g);
//            setB(b);
//            setX(x);
//            setY(y);
//            setZ(z);
//        }
//
//        public int getR() {
//            return r;
//        }
//
//        public void setR(int r) {
//            this.r = r;
//        }
//
//        public int getG() {
//            return g;
//        }
//
//        public void setG(int g) {
//            this.g = g;
//        }
//
//        public int getB() {
//            return b;
//        }
//
//        public void setB(int b) {
//            this.b = b;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public void setX(int x) {
//            this.x = x;
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public void setY(int y) {
//            this.y = y;
//        }
//
//        public int getZ() {
//            return z;
//        }
//
//        public void setZ(int z) {
//            this.z = z;
//        }
//
//        private int r;
//        private int g;
//        private int b;
//
//        private int x;
//        private int y;
//        private int z;
//
//
//        public void paste(int frameCount) {
//            int everyNFrames = 1;
//
//            if (frameCount % everyNFrames == 0) {
//                noStroke();
//                fill(r, g, b);
//                ellipse(x, y, z, z);
//            }
//        }
//
//
//        void printAttributes(int frameCount) {
//            int everyNFrames = 99;
//            if (frameCount % everyNFrames == 0) {
//                System.out.println(" r = " + getR() + " g = " + getG() + " b = " + getB() + " x = " + getX() + " y = " + getY() + " z = " + getZ());
//            }
//        }
//
//    }
//
//    class MasterBlob extends InstrumentBlob {
//        public MasterBlob(int x, int y, int z, int frameCount) {
//            super((int) (random(150)), 1, (int) (random(150)), x, y, z);
//            paste(frameCount);
//        }
//    }
//
//
//    class BassBlob extends InstrumentBlob {
//        public BassBlob(int x, int y, int z, int frameCount) {
//            super((int) (random(150)), (int) (random(150)), 1, x, y, z);
//            paste(frameCount);
//        }
//    }
//
//
//    class KickBlob extends InstrumentBlob {
//        public KickBlob(int x, int y, int z, int frameCount) {
//            super(1, (int) (random(150)), (int) (random(150)), x, y, z);
//            paste(frameCount);
//        }
//    }
//
//
//    class SnareBlob extends InstrumentBlob {
//        public SnareBlob(int x, int y, int z, int frameCount) {
//            super((int) (random(150)), 1, (int) (random(150)), x, y, z);
//            paste(frameCount);
//        }
//    }
//
//
//    class HatsBlob extends InstrumentBlob {
//        public HatsBlob(int x, int y, int z, int frameCount) {
//
//            super((int) 255, (int) random(255), 150, x, y, z);
//            paste(frameCount);
//        }
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
