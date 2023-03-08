package by.gstu.fais.artyugin.education.service.oop.lab5;

import java.util.List;

/**
 * Прямоугольник
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
public class Rectangle extends Polygon{

    public Rectangle(List<Integer> lengthsSides, Colour colour) {

        super(lengthsSides, colour);

        if (lengthsSides.size() != 4 ||
                lengthsSides.stream().anyMatch(l -> l <= 0) ||
                !isRectangle(lengthsSides)
        ) throw new IllegalArgumentException("Polygon is not a rectangle");
    }

    private boolean isRectangle(List<Integer> lengthsSides) {

        return lengthsSides.get(0).equals(lengthsSides.get(3)) &&
                lengthsSides.get(2).equals(lengthsSides.get(4));
    }

    @Override
    double calculateArea() {

        return lengthsSides.get(0) * lengthsSides.get(1);
    }

    @Override
    public int compareTo(Polygon o) {

        double a0 = this.calculateArea();
        double a1 = o.calculateArea();

        return Double.compare(a0, a1);
    }

    @Override
    public String toString() {

        String message = String.format("Triangle: lengthsSides = %s, colour = %s, area = %s, ",
                lengthsSides, colour, calculateArea());

        return colour == Colour.RED
                ? message + " perimeter = " +  calculatePerimeter()
                : message;
    }
}
