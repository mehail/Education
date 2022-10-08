package by.gstu.fais.artyugin.education.service.algorithmization.exam;

import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import by.gstu.fais.artyugin.education.service.util.table.processor.TableProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

/**
 * Сервис логики экзаменационной работы. Задание 1
 * Прямоугольная матрица.
 * В каждом столбце матрицы найти максимальный элемент и вычислить произведение этих элементов
 *
 * @author Mikhail Artyugin
 * @since 08.10.2022
 */
@Service
@AllArgsConstructor
public class AlgExam1 {

    /**
     * Минимальное значение при генерации матрицы
     */
    private static final int MIN_VALUE = 0;

    /**
     * Максимальное значение при генерации матрицы
     */
    private static final int MAX_VALUE = 100;

    private static final String ERROR_MESSAGE = "Ошибка входных параметров";
    private static final String RESULT_MESSAGE =
            "Матрица:\n%s\n\nМаксимальные значения:\n%s\n\nПроизведение всех элементов: %s";

    /**
     * Сервис обработки дробных значений
     */
    private final BigDecimalService bigDecimalService;

    /**
     * Сервис преобразования матрицы значений к табличному виду в строковом представлении
     */
    private final TableProcessorService tableProcessorService;


    /**
     * Экзаменационное задание 1
     * В каждом столбце матрицы найти максимальный элемент и вычислить произведение этих элементов
     *
     * @param height высота матрицы
     * @param width  ширина матрицы
     * @return строковое представление решения
     */
    public String process(int height, int width) {

        if (height < 1 || width < 1) throw new IllegalArgumentException(ERROR_MESSAGE);

        int[][] matrix = getRandomArray(height, width);
        Integer[] maxValues = getMaxValuesFromColumn(matrix);
        BigDecimal product = calculateProduct(maxValues);

        return String.format(
                RESULT_MESSAGE,
                matrixToTable(matrix),
                maxValuesToTable(maxValues),
                product.toPlainString()
        );
    }


    /**
     * Преобразует матрицу максимальных значений к табличному виду в строковом представлении
     *
     * @param maxValues матрица
     * @return таблица в строковом представлении
     */
    private String maxValuesToTable(Integer[] maxValues) {

        int[] ints = Arrays.stream(maxValues)
                .mapToInt(n -> n)
                .toArray();

        return matrixToTable(new int[][]{ints});
    }


    /**
     * Преобразует исходную матрицу значений к табличному виду в строковом представлении
     *
     * @param matrix матрица
     * @return таблица в строковом представлении
     */
    private String matrixToTable(int[][] matrix) {

        List<List<String>> matrixList = Arrays.stream(matrix)
                .map(
                        row -> Arrays.stream(row)
                                .boxed()
                                .map(Object::toString)
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        List<String> header = IntStream.range(0, matrix[0].length)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());

        matrixList.add(0, header);

        return tableProcessorService.toTable(matrixList);
    }


    /**
     * Перемножает значения массива
     *
     * @param maxValues максимальные значения
     * @return произведение максимальных значений
     */
    private BigDecimal calculateProduct(Integer[] maxValues) {

        BigDecimal result = Arrays.stream(maxValues)
                .map(bigDecimalService::toBigDecimal)
                .reduce(BigDecimal.ONE, BigDecimal::multiply);

        return bigDecimalService.scale(result);
    }


    /**
     * Получает максимальные значения из колонок матрицы
     *
     * @param matrix матрица
     * @return максимальные значения
     */
    private Integer[] getMaxValuesFromColumn(int[][] matrix) {
        Integer[] maxValue = new Integer[matrix[0].length];

        for (int[] rows : matrix) {
            for (int columnIndex = 0; columnIndex < rows.length; columnIndex++) {
                Integer currentMinValue = maxValue[columnIndex];
                int currentValue = rows[columnIndex];
                if (isNull(currentMinValue) || currentMinValue < currentValue) {
                    maxValue[columnIndex] = currentValue;
                }
            }
        }

        return maxValue;
    }


    /**
     * Генерация матрицы со случайными значениями
     *
     * @param height высота матрицы
     * @param width  ширина матрицы
     * @return матрицы
     */
    private int[][] getRandomArray(int height, int width) {

        int[][] matrix = new int[height][width];

        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = getRandomValue();
            }
        }

        return matrix;
    }


    /**
     * Получение случайного целочисленного значения
     *
     * @return int
     */
    private int getRandomValue() {
        return ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE + 1);
    }

}
