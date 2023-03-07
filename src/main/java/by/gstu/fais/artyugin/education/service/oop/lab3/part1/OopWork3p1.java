package by.gstu.fais.artyugin.education.service.oop.lab3.part1;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Лабораторная работа 3 часть 1
 * <p>
 * Обработка одномерных массивов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
public class OopWork3p1 {

    public record Arr(ArrayHolder a,
                      ArrayHolder b,
                      int index) {
    }

    public String process(Arr arr) {

        try {
            ArrayHolder arrayHolderA = arr.a();
            ArrayHolder arrayHolderB = arr.b();

            Integer[] arrayA = arrayHolderA.getArray();
            Integer[] arrayB = arrayHolderB.getArray();

            int index = arr.index();
            int[] arrayC = mixArrays(arrayHolderA, arrayHolderB);

            String message = "index out of range ";

            if (index >= arrayA.length) return message + "A";
            if (index >= arrayB.length) return message + "B";
            if (index >= arrayC.length) return message + "C";

            double result = calculate(
                    arrayA[index],
                    arrayB[index],
                    arrayC[index]
            );

            return String.valueOf(result);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }

    private int[] mixArrays(ArrayHolder a, ArrayHolder b) {

        return Stream.concat(
                        Arrays.stream(b.getArray(), b.calculateIndexLeftMin(), b.getArray().length),
                        Arrays.stream(a.getArray(), a.calculateIndexRightMin(), a.getArray().length)
                )
                .mapToInt(n -> n)
                .toArray();
    }

    private double calculate(int a, int b, int c) {

        double sinA = Math.sin(a);
        double cosC = Math.cos(c);

        double numerator = 2 * sinA + 3 * Math.pow(cosC, 3);
        int divider = a + b;

        return Math.round(numerator / divider);
    }

}
