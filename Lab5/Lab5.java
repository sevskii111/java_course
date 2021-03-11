package Lab5;

public class Lab5 {
    public static void swapXY(Movable object) throws NullPointerException {
        if (object == null)
            throw new NullPointerException("Object is not created");

        int oldX = object.getX();
        int oldY = object.getY();
        System.out.println(String.format("Old coords: (%d, %d)", oldX, oldY));
        object.moveTo(oldY, oldX);
        int newX = object.getX();
        int newY = object.getY();
        System.out.println(String.format("New coords: (%d, %d)", newX, newY));
    }

    public static void main(String[] args) {
        Movable movables[] = new Movable[4];
        movables[0] = new MyWindow(0, 5);
        movables[1] = new Point(1, 6);
        // movables[2] = new Rectangle(2, 7, 1, 1);
        movables[3] = new Circle(3, 8, 1);
        for (int i = 0; i < 4; i++) {
            try
            {
                swapXY(movables[i]);
            }
            catch (NullPointerException ex)
            {
                System.out.println("Error while swapping coordinates.");
                ex.printStackTrace();

            }
        }
    }

}
