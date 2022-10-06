package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6RectangularMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6SquareMatrixResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис логики лабораторных работ по предмету
 * "Основы алгоритмизации и программирования на языках высокого уровня"
 * Вариант 1
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
@AllArgsConstructor
public class AlgorithmizationService {

    private final AlgLaboratoryWork1 laboratoryWork1;
    private final AlgLaboratoryWork2 laboratoryWork2;
    private final AlgLaboratoryWork3 laboratoryWork3;
    private final AlgLaboratoryWork4 laboratoryWork4;
    private final AlgLaboratoryWork5 laboratoryWork5;
    private final AlgLaboratoryWork6 laboratoryWork6;

    /**
     * Лабораторная работа 1: вычислить значение с линейной логикой
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double laboratoryWork1(int x, int y) {
        return laboratoryWork1.calculate(x, y);
    }

    /**
     * Лабораторная работа 2: вычислить значение с логикой условного ветвления
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double laboratoryWork2(int x, int y) {
        return laboratoryWork2.calculate(x, y);
    }


    /**
     * Лабораторная работа 3: вычислить значение с использованием циклов
     *
     * @param m         параметр x
     * @param nMinValue параметр y
     * @param nMaxValue параметр y
     * @param step      параметр y
     * @return результирующее значение
     */
    public String laboratoryWork3(int m, int nMinValue, int nMaxValue, int step) {
        return laboratoryWork3.calculate(m, nMinValue, nMaxValue, step);
    }


    /**
     * Лабораторная работа 4: вычислить значение с использованием одномерных массивов
     *
     * @param numbers параметр x
     * @return результирующее значение
     */
    public String laboratoryWork4(double[] numbers) {
        return laboratoryWork4.calculate(numbers);
    }


    /**
     * Лабораторная работа 5: поменять местами максимальный и минимальный элементы массива
     *
     * @param source исходный массив
     * @return измененный массив
     */
    public int[] laboratoryWork5(int[] source) {
        return laboratoryWork5.swapMinMaxElements(source);
    }


    /**
     * Лабораторная работа 6: найти наибольший и наименьший элементы двумерного массива
     *
     * @param height высота матрицы
     * @param width  ширина матрицы
     * @return {@link AlgLab6RectangularMatrixResponse}
     */
    public AlgLab6RectangularMatrixResponse laboratoryWork6RectangularMatrix(int height, int width) {

        int[][] array = laboratoryWork6.getRandomArray(height, width);

        int minArrayValue = laboratoryWork6.getMinArrayValue(array);
        int maxArrayValue = laboratoryWork6.getMaxMatrixValue(array);

        return new AlgLab6RectangularMatrixResponse(array, minArrayValue, maxArrayValue);
    }


    /**
     * Лабораторная работа 6: подсчитать количество положительных чисел, лежащих выше главной диагонали
     *
     * @param order порядок матрицы
     * @return {@link AlgLab6SquareMatrixResponse}
     */
    public AlgLab6SquareMatrixResponse laboratoryWork6SquareMatrix(int order) {

        int[][] array = laboratoryWork6.getRandomArray(order, order);

        List<Integer> valueAboveMainDiagonal = laboratoryWork6.getValueAboveMainDiagonal(array);

        int countPositive = laboratoryWork6.getCountPositive(valueAboveMainDiagonal);

        return new AlgLab6SquareMatrixResponse(array, countPositive);
    }

}
