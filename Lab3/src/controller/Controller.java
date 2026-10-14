package controller;

import model.*;
import view.View;
import java.util.Arrays;
import java.util.Random;

public class Controller {
    private Shape[] shapes;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.shapes = generateShapes(10);
    }

    private Shape[] generateShapes(int size) {
        Shape[] generatedShapes = new Shape[size];
        String[] colors = {"Червоний", "Синій", "Зелений", "Жовтий", "Чорний", "Білий"};
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String color = colors[random.nextInt(colors.length)];
            int type = random.nextInt(3);

            switch (type) {
                case 0:
                    generatedShapes[i] = new Rectangle(color, random.nextDouble() * 10 + 2, random.nextDouble() * 10 + 2);
                    break;
                case 1:
                    generatedShapes[i] = new Circle(color, random.nextDouble() * 10 + 2);
                    break;
                case 2:
                    generatedShapes[i] = new Triangle(color, random.nextDouble() * 10 + 2, random.nextDouble() * 10 + 2);
                    break;
            }
        }
        return generatedShapes;
    }

    public void run() {
        view.printMessage("=== Вихідний масив фігур ===");
        view.printShapes(shapes);

        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.calcArea();
        }
        view.printMessage("Сумарна площа всіх фігур: " + String.format("%.2f", totalArea));

        double circlesArea = 0;
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                circlesArea += s.calcArea();
            }
        }
        view.printMessage("Сумарна площа всіх КІЛ: " + String.format("%.2f", circlesArea) + "\n");

        view.printMessage("=== Масив після сортування за ПЛОЩЕЮ (зростання) ===");
        Arrays.sort(shapes, new AreaComparator());
        view.printShapes(shapes);

        view.printMessage("=== Масив після сортування за КОЛЬОРОМ (алфавітний порядок) ===");
        Arrays.sort(shapes, new ColorComparator());
        view.printShapes(shapes);
    }
}