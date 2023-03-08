package by.gstu.fais.artyugin.education.service.oop.lab5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Многоугольник
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Polygon implements Comparable<Polygon> {

    public enum Colour {
        WHITE, RED
    }

    protected List<Integer> lengthsSides;
    protected Colour colour;

    abstract double calculateArea();

    protected int calculatePerimeter() {
        return lengthsSides.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
