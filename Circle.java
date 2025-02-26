public class Circle implements Shape {
    private static final String SHAPE_TYPE = "Circle";
    private static int counter = 0;
    private static final int MAX_INSTANCES = 2;

    public Circle() {
        if (counter >= MAX_INSTANCES) {
            throw new IllegalStateException("Cannot create more than " + MAX_INSTANCES + " instances of " + SHAPE_TYPE);
        }
        counter++;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    public static int getCounter() {
        return counter;
    }
}
