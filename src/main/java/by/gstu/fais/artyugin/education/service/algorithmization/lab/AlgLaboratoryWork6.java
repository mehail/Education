package by.gstu.fais.artyugin.education.service.algorithmization.lab;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Лабораторная работа 6
 * <p>
 * Программирование задач по работе с многомерными массивами
 * Задан двухмерный массив (матрица) вещественных чисел.
 * 1. Найти наибольший и наименьший элементы матрицы
 * 2. Подсчитать количество положительных чисел, лежащих выше главной диагонали квадратной матрицы
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class AlgLaboratoryWork6 {

    private static final String ERROR_MESSAGE = "Ошибка обхода матрицы";


    /**
     * Получение значений выше главной диагонали квадратной матрицы
     *
     * @param matrix матрица
     * @return значения выше главной диагонали квадратной матрицы
     */
    public List<Integer> getValueAboveMainDiagonal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int heightIndex = 0; heightIndex < matrix.length - 1; heightIndex++) {
            int[] row = matrix[heightIndex];
            for (int widthIndex = 0; widthIndex < row.length - heightIndex - 1; widthIndex++) {
                result.add(row[widthIndex]);
            }
        }

        return result;
    }


    /**
     * Расчет количества положительных значений
     *
     * @param values список значений
     * @return количество положительных значений
     */
    public int getCountPositive(List<Integer> values) {

        return (int) values.stream()
                .filter(n -> n > 0)
                .count();
    }


    /**
     * Получение максимального значения матрицы
     *
     * @param matrix матрица
     * @return максимальное значение
     */
    public int getMaxMatrixValue(int[][] matrix) {

        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }


    /**
     * Получение минимального значения матрицы
     *
     * @param matrix матрица
     * @return минимальное значение матрицы
     */
    public int getMinArrayValue(int[][] matrix) {

        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .min()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }


        /**
         * Генерация матрицы со случайными значениями
         *
         * @param height высота матрицы
         * @param width  ширина матрицы
         * @return матрицы
         */
        public int[][] getRandomArray(int height, int width) {

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
        return ThreadLocalRandom.current().nextInt();
    }

}
