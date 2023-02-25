package by.gstu.fais.artyugin.education.service.oop.lab;

import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Лабораторная работа 1
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
@RequiredArgsConstructor
public class OopWork1 {

    private static final String ERROR_MESSAGE = "Значение a не может быть равным 0";

    private final BigDecimalService bigDecimalService;


    public String calculate(double aValue, double xValue) {

        BigDecimal a = bigDecimalService.toBigDecimal(aValue);

        if (a.compareTo(BigDecimal.ZERO) == 0) return ERROR_MESSAGE;

        BigDecimal x = bigDecimalService.toBigDecimal(xValue);

        BigDecimal numerator = x.add(a.pow(2));
        BigDecimal divider = bigDecimalService.toBigDecimal("1.4").multiply(a);

        BigDecimal result = numerator.divide(divider, RoundingMode.HALF_EVEN)
                .subtract(x);

        return result.toPlainString();
    }

}
