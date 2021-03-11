package ru.novsu.povt.svv.graphics;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Circle extends Ellipse {

    public Circle() {
        super();
    }

    public Circle(int x, int y, int r) {
        super(x, y, r, r);
    }

    public Circle(int x, int y, Color color, int r) {
        super(x, y, color, r, r);
    }

    public void setR(int r) {
        this.f1 = this.f2 = r;
    }

    public void setF1(int f1) throws NotImplementedException {
        throw new NotImplementedException("Can't change f1 for Circle");
    }

    public void setF2(int f2) throws NotImplementedException {
        throw new NotImplementedException("Can't change f2 for Circle");
    }

    @Override
    public void draw() {
        System.out.println(String.format("Круг: x=%d, y=%d, R=%d, цвет %s", this.x, this.y, this.f1, this.color));
    }
}
