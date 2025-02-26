public class ShapeFactory {
    private static final int MAX_TOTAL_SHAPES = 5;
    private static int totalShapes = 0;

    public static Shape createShape(String shapeType) {
        if (totalShapes >= MAX_TOTAL_SHAPES) {
            throw new IllegalStateException("Cannot create more than " + MAX_TOTAL_SHAPES + " shapes in total");
        }

        Shape shape = null;
        switch (shapeType) {
            case "Circle":
                shape = new Circle();
                break;
            case "Square":
                shape = new Square();
                break;
            case "Rectangle":
                shape = new Rectangle();
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }

        totalShapes++;
        return shape;
    }

    public static int getTotalShapes() {
        return totalShapes;
    }
}
