package ru.novsu.povt.svv.graphics;

public class Rectangle extends Point {
    protected int w = 0, h = 0;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }

    public Rectangle(int x, int y, Color color, int w, int h) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.w = w;
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Прямоугольник: x=%d, y=%d, w=%d, h=%d, цвет %s", this.x, this.y, this.w, this.h, this.color));
    }
}
