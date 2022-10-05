package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.exception.CalculateException;
import by.gstu.fais.artyugin.education.service.util.BigDecimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Лабораторная работа 3
 * Программирование циклических структур
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
@AllArgsConstructor
public class AlgLaboratoryWork3 {

    private static final int MIN_FACTORIAL_VALUE = 1;
    private static final String PATTERN_ERROR_MESSAGE = "Введенные значения не соответствуют заданному условию: n >= m > 0";
    private static final String ARITHMETIC_ERROR_MESSAGE = "Введенные значения приводят к арифметическим ошибкам";

    private final BigDecimalService bigDecimalService;

    /**
     * Вычисление значения с использованием циклов
     *
     * @param m параметр m
     * @param n параметр n
     * @return результирующее значение
     */
    public String calculate(int m, int n) {

        if (n >= m && m > 0) {
            try {
                return String.valueOf(calculateFormula(m, n));
            } catch (Exception e) {
                throw new CalculateException(ARITHMETIC_ERROR_MESSAGE);
            }
        } else {
            throw new CalculateException(PATTERN_ERROR_MESSAGE);
        }

    }


    /**
     * Вычисление значения по заданной формуле
     *
     * @param m параметр m
     * @param n параметр n
     * @return результирующее значение
     */
    private double calculateFormula(int m, int n) {
        BigDecimal nFactorial = bigDecimalService.toBigDecimal(calculateFactorial(n));
        BigDecimal mFactorial = bigDecimalService.toBigDecimal(calculateFactorial(m));
        BigDecimal nmFactorial = bigDecimalService.toBigDecimal(calculateFactorial(n - m));

        BigDecimal divisor = mFactorial.subtract(nmFactorial);
        BigDecimal result = bigDecimalService.divide(nFactorial, divisor);

        return result.doubleValue();
    }


    /**
     * Вычисление факториала
     *
     * @param f число
     * @return факториал числа
     */
    public int calculateFactorial(int f) {

        return f <= MIN_FACTORIAL_VALUE
                ? MIN_FACTORIAL_VALUE
                : f * calculateFactorial(f - 1);
    }

}
