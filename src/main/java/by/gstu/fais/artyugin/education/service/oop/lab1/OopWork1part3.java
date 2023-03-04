package by.gstu.fais.artyugin.education.service.oop.lab1;

import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import by.gstu.fais.artyugin.education.service.util.table.processor.TableProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Лабораторная работа 1.3
 * <p>
 * Программирование циклических алгоритмов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
@RequiredArgsConstructor
public class OopWork1part3 {

    private final BigDecimalService bigDecimalService;
    private final TableProcessorService tableProcessorService;

    public String calculate(double leftBorderRange, double rightBorderRange, double stepValue) {

        BigDecimal rightBorder = bigDecimalService.toBigDecimal(rightBorderRange);
        BigDecimal leftBorder = bigDecimalService.toBigDecimal(leftBorderRange);
        BigDecimal step = bigDecimalService.toBigDecimal(stepValue);

        List<List<String>> result = getSteps(rightBorder, leftBorder, step).stream()
                .map(this::getResult)
                .filter(Objects::nonNull)
                .toList();

        return tableProcessorService.toTable(List.of("Значение", "Результат"), result);
    }

    private List<String> getResult(BigDecimal x) {

        double sin = Math.sin(x.doubleValue());
        BigDecimal numerator = bigDecimalService.toBigDecimal(sin)
                .add(bigDecimalService.toBigDecimal(3.7));

        double cos = Math.cos(x.pow(3).doubleValue());
        BigDecimal divider = bigDecimalService.toBigDecimal(cos)
                .subtract(bigDecimalService.toBigDecimal(2));
        BigDecimal absDivider = divider.abs(MathContext.DECIMAL64);

        try {
            String result = numerator
                    .divide(absDivider, RoundingMode.HALF_EVEN)
                    .toPlainString();
            return List.of(x.toPlainString(), result);
        } catch (ArithmeticException e) {
            return null;
        }

    }

    private List<BigDecimal> getSteps(BigDecimal rightBorder, BigDecimal leftBorder, BigDecimal step) {

        List<BigDecimal> values = new ArrayList<>();
        values.add(leftBorder);

        while (true) {
            BigDecimal temp = values.get(values.size() - 1).add(step);
            if (temp.compareTo(rightBorder) > 0) break;
            values.add(temp);
        }

        return values;
    }

}
