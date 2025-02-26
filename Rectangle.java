public class Rectangle implements Shape {
    private static final String SHAPE_TYPE = "Rectangle";
    private static int counter = 0;
    private static final int MAX_INSTANCES = 2;

    public Rectangle() {
        if (counter >= MAX_INSTANCES) {
            throw new IllegalStateException("Cannot create more than " + MAX_INSTANCES + " instances of " + SHAPE_TYPE);
        }
        counter++;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    public static int getCounter() {
        return counter;
    }
}
