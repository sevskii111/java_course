package Lab5;

public class MyWindow implements Movable {
    private int x, y;

    public MyWindow(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(String.format("MyWindow moved to (%d,%d)", this.x, this.y));
    }
}
