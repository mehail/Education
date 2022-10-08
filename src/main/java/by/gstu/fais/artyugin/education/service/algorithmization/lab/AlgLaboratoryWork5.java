package by.gstu.fais.artyugin.education.service.algorithmization.lab;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * Лабораторная работа 5
 * <p>
 * Программирование задач, содержащих в себе пользовательские функции.
 * Поменять местами максимальный и минимальный элементы массива. Все элементы массива разные.
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class AlgLaboratoryWork5 {

    /**
     * Максимальная длина исходного массива
     */
    private static final int MAX_ARRAY_LENGTH = 50;

    private static final String ERROR_MESSAGE = "Исходный массив не соответствует заданным условиям: " +
            "количество элементов не превышает %s, все элементы уникальны";

    /**
     * Меняет местами максимальный и минимальный элементы массива
     *
     * @param sourceArray исходный массив
     * @return измененный массив
     */
    public int[] swapMinMaxElements(int[] sourceArray) {

        if (isIncorrectArray(sourceArray))
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MAX_ARRAY_LENGTH));

        if (sourceArray.length == 1) return sourceArray;

        int minValue = sourceArray[0];
        int indexMinValue = 0;

        int maxValue = sourceArray[0];
        int indexMaxValue = 0;


        for (int i = 1; i < sourceArray.length; i++) {
            int currentElement = sourceArray[i];

            if (currentElement < minValue) {
                minValue = currentElement;
                indexMinValue = i;
            }

            if (currentElement > maxValue) {
                maxValue = currentElement;
                indexMaxValue = i;
            }
        }

        return swap(sourceArray, indexMinValue, indexMaxValue);
    }


    /**
     * Проверяет массив на соответствие заданию
     *
     * @param array проверяемый массив
     * @return boolean
     */
    private boolean isIncorrectArray(int[] array) {

        return isNull(array) ||
                array.length == 0 ||
                array.length > MAX_ARRAY_LENGTH ||
                isAllElementsMiscellaneous(array);
    }


    /**
     * Меняет местами элементы массива
     *
     * @param array  исходный массив
     * @param index0 первый индекс
     * @param index1 второй индекс
     * @return измененный массив
     */
    private int[] swap(int[] array, int index0, int index1) {

        int[] swapArray = Arrays.copyOf(array, array.length);

        swapArray[index0] = array[index1];
        swapArray[index1] = array[index0];

        return swapArray;
    }


    /**
     * Проверяет, что все элемента массива уникальны
     *
     * @param array проверяемый массив
     * @return boolean
     */
    private boolean isAllElementsMiscellaneous(int[] array) {

        Set<Integer> uniqValues = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());

        return array.length != uniqValues.size();
    }

}
