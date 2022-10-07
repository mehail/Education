package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.exception.CalculateException;
import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Лабораторная работа 4
 * <p>
 * Программирование задач по работе с одномерными массивами при адресации элементов массива
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
@AllArgsConstructor
public class AlgLaboratoryWork4 {

    private static final String FORMAT_ERROR_MESSAGE = "Введенное значение не соответствует указанному шаблону ввода";
    private static final String ARITHMETIC_ERROR_MESSAGE = "Арифметическая ошибка";

    /**
     * Сервис обработки дробных значений
     */
    private final BigDecimalService bigDecimalService;

    /**
     * Вычисление значения с использованием одномерных массивов
     *
     * @param numbers числовая последовательность
     * @return результирующее значение
     */
    public String calculate(int[] numbers) {
        try {
            double[] result = fillArray(numbers);

            return Arrays.toString(result);
        } catch (NumberFormatException e) {
            throw new CalculateException(FORMAT_ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            throw new CalculateException(ARITHMETIC_ERROR_MESSAGE);
        }
    }


    /**
     * Получение массива результирующих значений на основе введенной строки
     *
     * @param ints массив дробных чисел
     * @return результирующий массив
     */
    private double[] fillArray(int[] ints) {
        double[] aDoubles = new double[ints.length];

        for (int i = 0; i < ints.length; i++) {
            int index = i == 0
                    ? ints.length - 1
                    : i - 1;

            aDoubles[i] = calculateNewValue(ints[i], ints[index]);
        }

        return aDoubles;
    }


    /**
     * Вычисление значения согласно формуле
     *
     * @param b0 первое опорное значение
     * @param b1 второе опорное значение
     * @return результирующее значение
     */
    private double calculateNewValue(int b0, int b1) {
        BigDecimal b0bD = bigDecimalService.toBigDecimal(b0);
        BigDecimal b1bD = bigDecimalService.toBigDecimal(b1);

        BigDecimal divisor = bigDecimalService.divide(b0bD, b1bD);

        return bigDecimalService.divide(BigDecimal.ONE, divisor).doubleValue();
    }

}
