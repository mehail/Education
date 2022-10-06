package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Лабораторная работа 1
 * <p>
 * Изучение основных понятий и приёмов работы со средой разработки.
 * Программирование задач, содержащих алгоритмы линейной структуры.
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
@AllArgsConstructor
public class AlgLaboratoryWork1 {

    private final BigDecimalService bigDecimalService;

    /**
     * Вычисление значения с линейной логикой
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double calculate(int x, int y) {

        BigDecimal calculateFirstMultiple = bigDecimalService.toBigDecimal(calculateFirstMultiple(x, y));
        BigDecimal secondMultiple = bigDecimalService.toBigDecimal(calculateSecondMultiple(x, y));

        BigDecimal result = calculateFirstMultiple.multiply(secondMultiple);

        return result.doubleValue();
    }


    /**
     * Вычислить первый множитель
     *
     * @param x параметр x
     * @param y параметр y
     * @return первый множитель
     */
    private static double calculateSecondMultiple(int x, int y) {
        return sin(x) + exp((x + y));
    }


    /**
     * Вычислить второй множитель
     *
     * @param x параметр x
     * @param y параметр y
     * @return второй множитель
     */
    private double calculateFirstMultiple(int x, int y) {
        return log(pow(y, -1 * sqrt(abs(x))));
    }

}
