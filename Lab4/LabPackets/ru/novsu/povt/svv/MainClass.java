package ru.novsu.povt.svv;

import ru.novsu.povt.svv.graphics.*;

public class MainClass {
    public static void main(String[] args) {
        Background bg = new Background(Color.None, Texture.Stone);
        bg.draw();
        Point point = new Point(1, 2);
        point.draw();
        Rectangle rec = new Rectangle(1,5,3,4);
        rec.draw();
        Ellipse el = new Ellipse(0,0,1,2);
        el.draw();
        Circle circ = new Circle(5, 5, 5);
        circ.draw();
        circ.move(1, 1);
        circ.draw();
        circ.moveTo(0, 0);
        circ.draw();
        circ.setR(3);
        circ.draw();
        circ.setColor(Color.Green);
        circ.draw();
    }
    
}
