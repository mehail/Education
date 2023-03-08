package by.gstu.fais.artyugin.education.service.oop.lab5;

import java.util.List;

/**
 * треугольник
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
public class Triangle extends Polygon{

    public Triangle(List<Integer> lengthsSides, Colour colour) {

        super(lengthsSides, colour);

        if (lengthsSides.size() != 3 ||
                lengthsSides.stream()
                .anyMatch(l -> l <= 0)
        ) throw new IllegalArgumentException("Polygon is not a triangle");
    }

    @Override
    double calculateArea() {

        double p = lengthsSides.stream()
                .mapToInt(Integer::intValue)
                .sum() / 2;

        return Math.sqrt(p *
                (p - lengthsSides.get(0)) *
                (p - lengthsSides.get(1)) *
                (p - lengthsSides.get(2))
        );
    }

    @Override
    public int compareTo(Polygon o) {
        double a0 = this.calculateArea();
        double a1 = o.calculateArea();

        return Double.compare(a0, a1);
    }

    public boolean isRightTriangle() {
        List<Integer> sortedLengths = lengthsSides.stream()
                .sorted()
                .toList();

        double gip2 = Math.pow(sortedLengths.get(0), 2);
        double firstCat2 = Math.pow(sortedLengths.get(1), 2);
        double secondCat2 = Math.pow(sortedLengths.get(2), 2);

        return gip2 == firstCat2 + secondCat2;
    }

    @Override
    public String toString() {

        String message = String.format("Triangle: lengthsSides = %s, area = %s", lengthsSides, calculateArea());

        return colour == Colour.RED ? message + " colour = RED" : message;
    }
}
