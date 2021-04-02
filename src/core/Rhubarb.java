package core;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;


public class Rhubarb extends PApplet {

    public static void main(String[] args) {
        PApplet.main("core.Rhubarb", args);
    }


    SoundFile masterFile;
    int samplingRate;
    int frameRate;
    int fifthFrame;
    int conversionTo1080Scale;
    PImage image;

    public void settings() {
        size(800, 800);
    }

    public void setup() {

        masterFile = new SoundFile(this, "C:\\Users\\user\\Documents\\Image-Line\\FL Studio\\Projects\\Sexy Fence Builders Master.wav");
        // masterFile.play();

        samplingRate = masterFile.sampleRate();
        frameRate = 60;
        frameRate(frameRate);

        background(0);
//        conversionTo1080Scale=(int)((1080^2)/(800^2)*(1.9));
        conversionTo1080Scale = 1;

        System.out.println("width: " + width + " height: " + height);


    }

    public float[] getTapestryCoordinatesForFrame(int frameCount, int radius) {

        float a = (float) 0.1;

        int catalyst = 2;

        float t = radians(frameCount / catalyst * conversionTo1080Scale);
        float x = a * t * radius * cos(frameCount * conversionTo1080Scale);
        float y = a * t * radius * sin(frameCount * conversionTo1080Scale);//sin(frameCount)*sin(frameCount)*sin(frameCount);

        return new float[]{x, y};
    }


    public void draw() {
        if (frameCount < 1001) {
            pieceChooser(Title.DANCE_QUANTUM_RHUBARB);
        }else exit();
    }

    public void pieceChooser(Title title) {
        int cx;
        int cy;
        double sinSizeBoost;
        int spiralRadius = 250 * conversionTo1080Scale;

        int finalFrame;
        int startFrame;
        int swellSpeed;
        int wave;
        String fileSuffix;

        switch (title) {
            case RHUBARB_NUCLEUS:
                cx = width / 2;
                cy = height / 2;
                sinSizeBoost = 8 * ((sin(radians(frameCount)) + 1) / 2) * conversionTo1080Scale;
                if (frameCount % 11 == 0) {
                    if (frameCount > 600) {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (4 + sinSizeBoost) * conversionTo1080Scale, frameCount);
                    } else {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, 4 * frameCount / 600 * conversionTo1080Scale, frameCount);
                    }

                } else {
                    new TapestryBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (20 - sinSizeBoost * 2) * conversionTo1080Scale, frameCount);
                    new BlackBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (12 - sinSizeBoost * 2) * conversionTo1080Scale, frameCount);
                }
                break;
            case QUANTUM_RHUBARB:
                cx = width / 2;
                cy = height / 2;
                sinSizeBoost = 8 * ((sin(radians(frameCount)) + 1) / 2);
                if (frameCount % 11 == 0) {
                    if (frameCount > 600) {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (4 + sinSizeBoost), frameCount);
                    } else {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, 4 * frameCount / 600, frameCount);
                    }

                } else {
                    new TapestryBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (20), frameCount);
                    new BlackBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (12), frameCount);
                }
                break;
            case PEARL_CROSS:
                cx = width / 2;
                cy = height / 2;
                sinSizeBoost = 8 * ((sin(radians(frameCount)) + 1) / 2);
                if (frameCount % 11 == 0) {
                    if (frameCount > 600) {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, (int) (4 + sinSizeBoost), frameCount);
                    } else {
                        new CrystalBlob((int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[0] + cx, (int) getTapestryCoordinatesForFrame(frameCount, spiralRadius)[1] + cy, 4 * frameCount / 600, frameCount);
                    }
                    fifthFrame = frameCount + 4;
                }
                break;
            case DANCE_PEARL_CROSS:
                finalFrame = 2499;
                startFrame = 0;
                swellSpeed = 20;//20 = happy medium
                wave = (int) ((sin((frameCount / (float) swellSpeed)) + 1.000) / 2.000 * finalFrame + 1.000) + startFrame;
                fileSuffix = padLeftZeros(String.valueOf(wave), 5);
                image = loadImage("C:\\Users\\user\\IdeaProjects\\GenerativeArt\\output\\PEARL_CROSS_800\\frame" + fileSuffix + ".png");
                image(image, 0, 0);
                break;
            case DANCE_QUANTUM_RHUBARB:
                finalFrame = 2499;
                startFrame = 0;
                swellSpeed = 20;//20 = happy medium
                wave = (int) ((sin((frameCount / (float) swellSpeed)) + 1.000) / 2.000 * finalFrame + 1.000) + startFrame;
                fileSuffix = padLeftZeros(String.valueOf(wave), 5);
                image = loadImage("C:\\Users\\user\\IdeaProjects\\GenerativeArt\\output\\QUANTUM_RHUBARB_800\\frame" + fileSuffix + ".png");
                image(image, 0, 0);
                break;
            case DANCE_RHUBARB_NUCLEUS:
                finalFrame = 2499;
                startFrame = 0;
                swellSpeed = 20;//20 = happy medium
                wave = (int) ((sin((frameCount / (float) swellSpeed)) + 1.000) / 2.000 * finalFrame + 1.000) + startFrame;
                fileSuffix = padLeftZeros(String.valueOf(wave), 5);
                image = loadImage("C:\\Users\\user\\IdeaProjects\\GenerativeArt\\output\\RHUBARB_NUCLEUS_800\\frame" + fileSuffix + ".png");
                image(image, 0, 0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title.toString());
        }
      //  saveFrame("output/" + title.toString() + "_" + width + "/frame#####.png");
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    enum Title {
        RHUBARB_NUCLEUS,
        QUANTUM_RHUBARB,
        PEARL_CROSS,
        DANCE_PEARL_CROSS,
        DANCE_RHUBARB_NUCLEUS,
        DANCE_QUANTUM_RHUBARB
    }

    class Blob {
        private int r;
        private int g;
        private int b;

        private int x;
        private int y;
        private int z;

        public Blob(int r, int g, int b, int x, int y, int z) {
            setR(r);
            setG(g);
            setB(b);
            setX(x);
            setY(y);
            setZ(z * conversionTo1080Scale);
        }

        public void pasteCircle(int frameCount) {
            int everyNFrames = 1;

            if (frameCount % everyNFrames == 0) {
                noStroke();
                fill(r, g, b);
                ellipse(x, y, z, z);
            }
        }

        public void pasteEquilateralTriangle(int frameCount) {
            int everyNFrames = 1;
            if (frameCount % everyNFrames == 0) {
                noStroke();
                fill(r, g, b);
                int r = z;
                int spinDampening = 3;
                triangle(x + r * cos(radians(150 + frameCount / spinDampening)),
                        y + r * sin(radians(150 + frameCount / spinDampening)),
                        x + r * cos(radians(270 + frameCount / spinDampening)),
                        y + r * sin(radians(270 + frameCount / spinDampening)),
                        x + r * cos(radians(30 + frameCount / spinDampening)),
                        y + r * sin(radians(30 + frameCount / spinDampening)));
            }
        }


        void printAttributes(int frameCount) {
            int everyNFrames = 99;
            if (frameCount % everyNFrames == 0) {
                System.out.println(" r = " + getR() + " g = " + getG() + " b = " + getB() + " x = " + getX() + " y = " + getY() + " z = " + getZ());
            }
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

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }


    }

    class TapestryBlob extends Blob {
        public TapestryBlob(int x, int y, int z, int frameCount) {
            super(255, (int) random(255), 150, x, y, z);
            pasteCircle(frameCount);
        }
    }

    class BlackBlob extends Blob {
        public BlackBlob(int x, int y, int z, int frameCount) {
            super(0, 0, 0, x, y, z);
            pasteEquilateralTriangle(frameCount);
        }

    }

    class CrystalBlob extends Blob {
        public CrystalBlob(int x, int y, int z, int frameCount) {
            super(199, 227, 220, x, y, z);
            pasteCircle(frameCount + 180);
        }

    }


}










