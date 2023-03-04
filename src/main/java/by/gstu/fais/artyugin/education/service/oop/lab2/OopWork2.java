package by.gstu.fais.artyugin.education.service.oop.lab2;

import by.gstu.fais.artyugin.education.service.util.cartesian.CartesianService;
import by.gstu.fais.artyugin.education.service.util.table.processor.TableProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Лабораторная работа 2
 * <p>
 * Конструкторы и свойства классов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OopWork2 {

    private static final String RESULT_MESSAGE = """
                        
            Rectangles:
            %s
                                
            Compare rectangles:
            %s
              
            Move right:
            %s
                        
            Turn:
            %s
            """;

    private static final String TRANSFORM_MESSAGE = """
            - before = %s
            - after  = %s
            """;

    private record RectangleByNumber(int number, Rectangle rectangle) {
    }

    private record Pair<T>(T p0, T p1) {
    }

    private final CartesianService cartesianService;
    private final TableProcessorService tableProcessorService;


    public String process() {

        List<Rectangle> rectangles;

        try {
            rectangles = List.of(
                    new Rectangle(),
                    new Rectangle(new Rectangle.Point(0, 0), new Rectangle.Point(2, -2)),
                    new Rectangle(new Rectangle.Point(0, 0), new Rectangle.Point(1, -2)),
                    new Rectangle(new Rectangle.Point(0, 5), new Rectangle.Point(1, 3))
            );
        } catch (Exception e) {
            return e.getMessage();
        }

        return processRectangle(rectangles);
    }


    public String processRectangle(List<Rectangle> rectangles) {

        if (rectangles.isEmpty()) return "No valid rectangle";

        List<RectangleByNumber> rectangleByNumbers = IntStream.range(0, rectangles.size())
                .mapToObj(n -> new RectangleByNumber(n, rectangles.get(n)))
                .toList();

        return String.format(
                RESULT_MESSAGE,
                getTableView(rectangleByNumbers),
                getCompareResult(rectangleByNumbers),
                getMovedRectangles(rectangleByNumbers),
                getTurnRectangles(rectangleByNumbers)
        );
    }


    private String getMovedRectangles(List<RectangleByNumber> rectangleByNumbers) {

        Rectangle rectangle = rectangleByNumbers.iterator().next().rectangle();
        Rectangle movedRectangle = rectangle.copy().move(1, Rectangle.DIRECTION.RIGHT);

        return String.format(TRANSFORM_MESSAGE, rectangle, movedRectangle);
    }

    private String getTurnRectangles(List<RectangleByNumber> rectangleByNumbers) {

        Rectangle rectangle = rectangleByNumbers.iterator().next().rectangle();
        Rectangle turnedRectangle = rectangle.copy().turn();

        return String.format(TRANSFORM_MESSAGE, rectangle, turnedRectangle);
    }


    private String getTableView(List<RectangleByNumber> rectangleByNumbers) {

        List<String> header =
                List.of("#", "Top left corner", "Bottom right corner", "Area", "Is a square");

        List<List<String>> views = rectangleByNumbers.stream()
                .map(this::toTableViewCreate)
                .toList();

        return tableProcessorService.toTable(header, views);
    }


    private String getCompareResult(List<RectangleByNumber> rectangleByNumbers) {

        return cartesianService.getCartesianProduct(
                        List.of(
                                rectangleByNumbers,
                                rectangleByNumbers
                        ),
                        false
                ).stream()
                .map(l -> new Pair<>(l.get(0), l.get(1)))
                .filter(pair -> !pair.p0.equals(pair.p1))
                .map(this::compare)
                .collect(Collectors.joining("\n"));
    }


    private String compare(Pair<RectangleByNumber> pair) {

        String message = "- rectangle#%s in rectangle#%s = %b";

        RectangleByNumber first = pair.p0;
        RectangleByNumber second = pair.p1;
        boolean isInner = Rectangle.isInner(first.rectangle, second.rectangle);

        return String.format(message, first.number, second.number, isInner);
    }


    private List<String> toTableViewCreate(RectangleByNumber rectangleByNumber) {

        Rectangle rectangle = rectangleByNumber.rectangle;

        String square = rectangle.isSquare()
                ? "square"
                : "";

        return List.of(
                String.valueOf(rectangleByNumber.number),
                rectangle.getTopLeftCorner().toString(),
                rectangle.getBottomRightCorner().toString(),
                rectangle.getArea().toString(),
                square
        );
    }

}
