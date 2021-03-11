package ru.novsu.povt.svv.graphics;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Ellipse extends Point {
    protected int f1 = 0, f2 = 0;

    public Ellipse() {
        super();
    }

    public Ellipse(int x, int y, int f1, int f2) {
        super(x, y);
        this.f1 = f1;
        this.f2 = f2;
    }

    public Ellipse(int x, int y, Color color, int f1, int f2) {
        super(x, y, color);
        this.f1 = f1;
        this.f2 = f2;
    }

    public void setF1(int f1) throws NotImplementedException{
        this.f1 = f1;
    }

    public void setF2(int f2) throws NotImplementedException{
        this.f2 = f2;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Элипс: x=%d, y=%d, F1=%d, F2=%d, цвет %s", this.x, this.y, this.f1, this.f2, this.color));
    }
}
