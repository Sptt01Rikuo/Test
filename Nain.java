public class Nain {
    public static void main(String[] args) {
        try {
            Shape shape1 = ShapeFactory.createShape("Circle");
            shape1.draw();

            Shape shape2 = ShapeFactory.createShape("Square");
            shape2.draw();

            Shape shape3 = ShapeFactory.createShape("Rectangle");
            shape3.draw();

            Shape shape4 = ShapeFactory.createShape("Circle");
            shape4.draw();

            Shape shape5 = ShapeFactory.createShape("Square");
            shape5.draw();

            // This will throw an exception because the total number of shapes exceeds 5
            Shape shape6 = ShapeFactory.createShape("Rectangle");
            shape6.draw();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total shapes created: " + ShapeFactory.getTotalShapes());
        System.out.println("Total Circles created: " + Circle.getCounter());
        System.out.println("Total Squares created: " + Square.getCounter());
        System.out.println("Total Rectangles created: " + Rectangle.getCounter());
    }
}
