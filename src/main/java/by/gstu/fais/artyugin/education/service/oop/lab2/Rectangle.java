package by.gstu.fais.artyugin.education.service.oop.lab2;

import lombok.Getter;
import lombok.ToString;
import lombok.With;

/**
 * Прямоугольник
 *
 * @author Mikhail Artyugin
 * @since 04.03.2023
 */
@Getter
@ToString
public class Rectangle {

    private static final String RESULT = "Левый верхний угол %s, Правый нижний угол %s, Площадь %s%s";
    private static final String ERROR = "Rectangle coordinates incorrectly [%s, %s]";

    @With
    public record Point(double x, double y) {
        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    public enum DIRECTION {TOP, RIGHT}

    private Point topLeftCorner;
    private Point bottomRightCorner;

    private final Double area;

    public Rectangle() {
        this(
                new Point(0, 0),
                new Point(1, -1)
        );
    }

    public Rectangle(Point topLeftCorner, Point bottomRightCorner) {

        boolean isCorrectTopBottom = topLeftCorner.x < bottomRightCorner.x &&
                topLeftCorner.y > bottomRightCorner.y;

        if (!isCorrectTopBottom) {
            throw new IllegalArgumentException(String.format(ERROR, topLeftCorner, bottomRightCorner));
        }

        this.topLeftCorner = topLeftCorner;
        this.bottomRightCorner = bottomRightCorner;
        this.area = calculateArea(topLeftCorner, bottomRightCorner);
    }

    private Double calculateArea(Point topLeftCorner, Point bottomRightCorner) {
        double width = getWidth(topLeftCorner, bottomRightCorner);
        double height = getHeight(topLeftCorner, bottomRightCorner);
        return width * height;
    }

    public boolean isSquare() {
        return getHeight(topLeftCorner, bottomRightCorner) == getWidth(topLeftCorner, bottomRightCorner);
    }

    public Rectangle move(double step, DIRECTION direction) {
        switch (direction) {
            case TOP -> {
                topLeftCorner = topLeftCorner.withY(topLeftCorner.y + step);
                bottomRightCorner = bottomRightCorner.withY(bottomRightCorner.y + step);
                return this;
            }
            case RIGHT -> {
                topLeftCorner = topLeftCorner.withX(topLeftCorner.x + step);
                bottomRightCorner = bottomRightCorner.withX(bottomRightCorner.x + step);
                return this;
            }
            default -> throw new IllegalArgumentException("Failed to relocate");
        }
    }

    public Rectangle turn() {
        Point newTopLeftPoint = new Point(
                topLeftCorner.x,
                topLeftCorner.y + getWidth(topLeftCorner, bottomRightCorner)
        );
        Point newBottomRightPont = new Point(
                topLeftCorner.x + getHeight(topLeftCorner, bottomRightCorner),
                topLeftCorner.y
        );

        topLeftCorner = newTopLeftPoint;
        bottomRightCorner = newBottomRightPont;

        return this;
    }


    public static boolean isInner(Rectangle rectangle0, Rectangle rectangle1) {

        boolean isInnerTopLeft = rectangle0.topLeftCorner.x >= rectangle1.topLeftCorner.x &&
                rectangle0.topLeftCorner.y <= rectangle1.topLeftCorner.y;

        boolean isInnerBottomRight = rectangle0.bottomRightCorner.x <= rectangle1.bottomRightCorner.x &&
                rectangle0.bottomRightCorner.y >= rectangle1.bottomRightCorner.y;

        return isInnerTopLeft && isInnerBottomRight;
    }


    private double getHeight(Point topLeftCorner, Point bottomRightCorner) {
        return Math.abs(bottomRightCorner.y - topLeftCorner.y);
    }

    private double getWidth(Point topLeftCorner, Point bottomRightCorner) {
        return Math.abs(bottomRightCorner.x - topLeftCorner.x);
    }

    public Rectangle copy() {
        return new Rectangle(this.topLeftCorner, this.bottomRightCorner);
    }
}
