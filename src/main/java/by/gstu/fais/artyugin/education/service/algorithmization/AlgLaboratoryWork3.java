package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.exception.CalculateException;
import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import by.gstu.fais.artyugin.education.service.util.table.processor.TableProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private static final String FINAL_MESSAGE = "Значение m = %d\nНачальное значение n, nMinValue = %d\n" +
            "Конечное значение n, nMaxValue = %d\nШаг перемещения по диапазону n, step = %d\n%s";

    private static final String PATTERN_ERROR_MESSAGE =
            "Введенные значения не соответствуют заданному условию: n >= m > 0 или step == 0";

    private static final String RANGE_ERROR_MESSAGE =
            "Введенные значения не соответствуют заданному условию: nMinValue + step > nMaxValue";

    private static final String ARITHMETIC_ERROR_MESSAGE = "Арифметическая ошибка";

    private final BigDecimalService bigDecimalService;
    private final TableProcessorService tableProcessorService;

    /**
     * Вычисление значения с использованием циклов
     *
     * @param m         параметр m
     * @param nMinValue начало диапазона параметра n
     * @param nMaxValue конец диапазона параметра n
     * @param step      шаг перемещения по диапазону n
     * @return результирующее значение
     */
    public String calculate(int m, int nMinValue, int nMaxValue, int step) {

        if (nMinValue + step > nMaxValue) throw new CalculateException(RANGE_ERROR_MESSAGE);
        if (nMinValue < m || m <= 0 || step == 0) throw new CalculateException(PATTERN_ERROR_MESSAGE);

        List<List<String>> matrix = getMatrix(m, nMinValue, nMaxValue, step);
        String table = tableProcessorService.toTable(matrix);

        return String.format(FINAL_MESSAGE, m, nMinValue, nMaxValue, step, table);
    }


    /**
     * Подготавливает матрицу значений
     *
     * @param m         параметр m
     * @param nMinValue начало диапазона параметра n
     * @param nMaxValue конец диапазона параметра n
     * @param step      шаг перемещения по диапазону n
     * @return матрица значений
     */
    private List<List<String>> getMatrix(int m, int nMinValue, int nMaxValue, int step) {

        List<List<String>> matrix = IntStream.range(nMinValue, nMaxValue + 1)
                .filter(n -> n % step == 0)
                .boxed()
                .map(n -> calculateAtomicValue(m, n))
                .collect(Collectors.toList());

        matrix.add(0, List.of("Параметр n", "Результирующее значение"));

        return matrix;
    }

    /**
     * Вычисление атомарных значений
     *
     * @param m параметр m
     * @param n параметр n
     * @return результирующее значение
     */
    private List<String> calculateAtomicValue(int m, int n) {

        String resultValue;

        try {
            BigDecimal value = calculateFormula(m, n);
            resultValue = bigDecimalService.toStringFormat(value);
        } catch (Exception e) {
            resultValue = ARITHMETIC_ERROR_MESSAGE;
        }

        return List.of(String.valueOf(n), resultValue);
    }


    /**
     * Вычисление значения по заданной формуле
     *
     * @param m параметр m
     * @param n параметр n
     * @return результирующее значение
     */
    private BigDecimal calculateFormula(int m, int n) {

        BigDecimal nFactorial = bigDecimalService.toBigDecimal(calculateFactorial(n));
        BigDecimal mFactorial = bigDecimalService.toBigDecimal(calculateFactorial(m));
        BigDecimal nmFactorial = bigDecimalService.toBigDecimal(calculateFactorial(n - m));

        BigDecimal divisor = mFactorial.subtract(nmFactorial);

        return bigDecimalService.divide(nFactorial, divisor);
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
