package by.gstu.fais.artyugin.education.service.oop.lab4;

import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

/**
 * Лабораторная работа 4
 * <p>
 * Обработка двумерных массивов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
public class OopWork4 {

    public record Pair<T>(T a, T b){}

    public String process(Pair<Matrix> matrixPair) {

        String message = """
                Count row without zero:
                a = %s
                b = %s
                
                maxDuplicateValuesA: %s
                
                matrixA:
                %s
                
                replaced duplicate values = %s
                matrixB:
                %s
                """;

        Matrix a = matrixPair.a;
        Matrix b = matrixPair.b;

        long countRowWithoutZeroA = a.countRowWithoutZero();
        long countRowWithoutZeroB = b.countRowWithoutZero();

        String maxDuplicateValuesA = "not calculated";
        boolean replaceB = false;

        if (countRowWithoutZeroA > countRowWithoutZeroB) {
            Integer maxDuplicateValues = a.maxDuplicateValues();
            maxDuplicateValuesA = nonNull(maxDuplicateValues)
                    ? String.valueOf(maxDuplicateValues)
                    : "not duplicated values";
        } else {
            b.replaceDuplicateValues();
            replaceB = true;
        }


        return String.format(message, countRowWithoutZeroA, countRowWithoutZeroB, maxDuplicateValuesA, a, replaceB, b);
    }

}
