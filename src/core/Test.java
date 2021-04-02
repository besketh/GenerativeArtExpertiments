package core;

import processing.core.PApplet;
import processing.core.PVector;
import processing.opengl.PGraphics3D;
import shapes3d.Tube;
import shapes3d.contour.Oval;
import shapes3d.path.Linear;
import shapes3d.path.Path;


public class Test extends PApplet {

    PGraphics3D pg;

    public static void main(String[] args) {
        PApplet.main("core.Test", args);
    }


    public void settings() {
        size(1080, 1080, P3D);
    }

    public void setup() {



    }

    public void draw() {
        PVector v1 = new PVector(width / 2, height / 2, 0);
        PVector v2 = new PVector(width / 4, height / 4, 0);
        Path path = new Linear(v1, v2, 10);
        Oval oval = new Oval(50, 50, 10);
        Tube tube = new Tube(path, oval);
        pg.beginDraw();
        tube.draw(pg);
        pg.endDraw();
    }


}




