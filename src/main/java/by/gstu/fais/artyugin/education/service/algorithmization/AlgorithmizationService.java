package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3.AlgExam3Response;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab2.AlgLab2Response;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6RectangularMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6SquareMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab7.AlgLab7Response;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab8.AlgLab8Response;
import by.gstu.fais.artyugin.education.service.algorithmization.exam.AlgExam1;
import by.gstu.fais.artyugin.education.service.algorithmization.exam.AlgExam2;
import by.gstu.fais.artyugin.education.service.algorithmization.exam.AlgExam3;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork1;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork2;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork3;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork4;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork5;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork6;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork7;
import by.gstu.fais.artyugin.education.service.algorithmization.lab.AlgLaboratoryWork8;
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
    private final AlgLaboratoryWork7 laboratoryWork7;
    private final AlgLaboratoryWork8 laboratoryWork8;
    private final AlgExam1 algExam1;
    private final AlgExam2 algExam2;
    private final AlgExam3 algExam3;


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
    public AlgLab2Response laboratoryWork2(int x, int y) {
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
    public String laboratoryWork4(int[] numbers) {
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


    /**
     * Лабораторная работа 7: подсчитывает количество слов и после каждого поставить запятую
     *
     * @param inputString введенная строка
     * @return {@link AlgLab7Response}
     */
    public AlgLab7Response laboratoryWork7(String inputString) {

        return laboratoryWork7.process(inputString);
    }


    /**
     * Лабораторная работа 8: работа с файлами
     *
     * @param strings массив строк
     * @return {@link AlgLab8Response}
     */
    public AlgLab8Response laboratoryWork8(List<String> strings) {

        return laboratoryWork8.process(strings);
    }


    /**
     * Экзаменационное задание 1.
     * В каждом столбце матрицы найти максимальный элемент и вычислить произведение этих элементов
     *
     * @param height высота матрицы
     * @param width  ширина матрицы
     * @return строковое представление решения
     */
    public String exam1(int height, int width) {

        return algExam1.process(height, width);
    }


    /**
     * Экзаменационное задание 2.
     * Удаляет символы '?', стоящие после 'a', и подсчитать общее количество 'Р', 'О'
     *
     * @param inputString вводимая строка
     * @return строковое представление решения
     */
    public String exam2(String inputString) {

        return algExam2.process(inputString);
    }


    /**
     * Экзаменационное задание 3.
     * Работа со структурами и файлами
     *
     * @param year минимальный год рождения правонарушителя
     * @return {@link AlgExam3Response}
     */
    public AlgExam3Response exam3(int year) {

        return algExam3.process(year);
    }

}
