package by.gstu.fais.artyugin.education.service.oop.lab5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Лабораторная работа 5
 * <p>
 * Наследование
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
public class OopWork5 {

    public String process(List<Polygon> polygons) {

        String message = """
                Rectangles:
                %s
                
                Triangles:
                %s
                """;

        List<Rectangle> rectangles = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();

        for (Polygon polygon : polygons) {
            if (polygon.getLengthsSides().size() == 4) {
                rectangles.add((Rectangle) polygon);
            } else {
                triangles.add((Triangle) polygon);
            }
        }

        String sortedRectanglesAsString = rectangles.stream()
                .sorted()
                .map(Rectangle::toString)
                .collect(Collectors.joining("\n"));



        String sortedTrianglesAsString = triangles.stream()
                .sorted()
                .map(Triangle::toString)
                .collect(Collectors.joining("\n"));

        return String.format(message, sortedRectanglesAsString, sortedTrianglesAsString);
    }

}
