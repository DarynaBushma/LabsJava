package view;
import model.Shape;

public class View {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        System.out.println("--------------------------------------------------");
    }
}