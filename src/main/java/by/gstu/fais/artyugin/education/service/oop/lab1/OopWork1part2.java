package by.gstu.fais.artyugin.education.service.oop.lab1;

import by.gstu.fais.artyugin.education.service.util.decimal.BigDecimalService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Лабораторная работа 1.2
 * <p>
 * Программирование разветвляющихся алгоритмов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
public class OopWork1part2 {

    private final BigDecimal rightBorderRange;
    private final BigDecimal leftBorderRange;

    private final BigDecimalService bigDecimalService;

    public OopWork1part2(BigDecimalService bigDecimalService) {
        this.bigDecimalService = bigDecimalService;
        this.rightBorderRange = BigDecimal.ZERO;
        this.leftBorderRange = bigDecimalService.toBigDecimal(-5);
    }


    public String calculate(double xValue, double zValue) {

        BigDecimal z = bigDecimalService.toBigDecimal(zValue);
        BigDecimal x = bigDecimalService.toBigDecimal(xValue);

        return calc(z, x).toPlainString();
    }

    private BigDecimal calc(BigDecimal z, BigDecimal x) {

        if (isFirstCondition(z)) {
            return x.pow(2).add(z);
        } else if (isSecondCondition(z)) {
            return bigDecimalService.toBigDecimal(2.5).multiply(z);
        } else {
            BigDecimal numerator = x.pow(3).add(bigDecimalService.toBigDecimal(1.3));
            return numerator.divide(z, RoundingMode.HALF_EVEN);
        }

    }

    private boolean isSecondCondition(BigDecimal z) {
        return z.compareTo(leftBorderRange) <= 0;
    }

    private boolean isFirstCondition(BigDecimal z) {
        return z.compareTo(leftBorderRange) > 0 &&
                z.compareTo(rightBorderRange) <= 0;
    }

}
