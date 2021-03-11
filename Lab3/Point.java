package Lab3;

public class Point extends Graph {
    protected int x = 0, y = 0;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.moveTo(this.x + dx, this.y + dy);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Точка: x=%d, y=%d, цвет %s", this.x, this.y, this.color));
    }

}
