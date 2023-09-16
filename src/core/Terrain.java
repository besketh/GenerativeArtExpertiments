package core;

import processing.core.PApplet;


public class Terrain extends PApplet {

    public static void main(String[] args) {
        PApplet.main("core.Terrain", args);
    }

    int scl, cols, rows, w, h;
    float[][] topTerrain;
    float[][] bottomTerrain;

    public void setup() {
        scl = 20;
        w = 2080;
        h = 2080;
        cols = w / scl;
        rows = h / scl;
        topTerrain = new float[cols][rows];
        bottomTerrain = new float[cols][rows];


    }


    public void settings() {
        size(1080, 1080, P3D);
    }


    public void draw() {
        if (frameCount < 6600) {


            float flying = (float) (-frameCount * 0.1);
            float yoff = flying;

            for (int y = 0; y < rows; y++) {
                float xoff = 0;
                for (int x = 0; x < cols; x++) {
                    topTerrain[x][y] = map(noise(xoff, yoff), 0, 1, -100, 100);
                    xoff += 0.2;
                }
                yoff += 0.2;
            }


            background(0);
            stroke(255);
            noFill();

            translate(width / 2, height / 2);
            rotateX(PI / 3);
            translate(-w / 2, -h / 2);
            for (int y = 0; y < rows - 1; y++) {
                beginShape(TRIANGLE_STRIP);
                for (int x = 0; x < cols; x++) {
                    vertex(x * scl, y * scl, topTerrain[x][y]);
                    vertex(x * scl, (y + 1) * scl, topTerrain[x][y + 1]);
                }
                endShape();
            }

            //saveFrame("output/" + "terrain" + "_" + width + "/frame#####.png");
        } else exit();

    }
}










