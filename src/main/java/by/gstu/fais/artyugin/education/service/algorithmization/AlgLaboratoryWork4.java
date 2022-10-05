package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.exception.CalculateException;
import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Лабораторная работа 4
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

    private final BigDecimalService bigDecimalService;

    /**
     * Вычисление значения с использованием одномерных массивов
     *
     * @param numbers числовая последовательность
     * @return результирующее значение
     */
    public String calculate(double[] numbers) {
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
     * @param bDoubles массив дробных чисел
     * @return результирующий массив
     */
    private double[] fillArray(double[] bDoubles) {
        double[] aDoubles = new double[bDoubles.length];

        for (int i = 0; i < bDoubles.length; i++) {
            int index = i == 0
                    ? bDoubles.length - 1
                    : i - 1;

            aDoubles[i] = calculateNewValue(bDoubles[i], bDoubles[index]);
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
    private double calculateNewValue(double b0, double b1) {
        BigDecimal b0bD = bigDecimalService.toBigDecimal(b0);
        BigDecimal b1bD = bigDecimalService.toBigDecimal(b1);

        BigDecimal divisor = bigDecimalService.divide(b0bD, b1bD);

        return bigDecimalService.divide(BigDecimal.ONE, divisor).doubleValue();
    }

}
