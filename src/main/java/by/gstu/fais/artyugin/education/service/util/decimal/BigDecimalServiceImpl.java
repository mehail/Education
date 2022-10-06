package by.gstu.fais.artyugin.education.service.util.decimal;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Сервис обработки дробных значений
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class BigDecimalServiceImpl implements BigDecimalService {

    /**
     * {@inheritDoc}
     *
     * @param value дробное число
     */
    @Override
    public BigDecimal toBigDecimal(double value) {

        return toBigDecimal(Double.toString(value));
    }


    /**
     * {@inheritDoc}
     *
     * @param value дробное число в строковом представлении
     */
    @Override
    public BigDecimal toBigDecimal(String value) {

        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }


    /**
     * {@inheritDoc}
     *
     * @param divisible делимое
     * @param divisor   делитель
     */
    @Override
    public BigDecimal divide(BigDecimal divisible, BigDecimal divisor) {

        return divisible.divide(divisor, MathContext.DECIMAL64);
    }


    /**
     * {@inheritDoc}
     *
     * @param value округляемое значение
     */
    @Override
    public BigDecimal scale(BigDecimal value) {

        return value.setScale(2, RoundingMode.HALF_EVEN);
    }


    /**
     * {@inheritDoc}
     *
     * @param value числовое значение
     */
    @Override
    public String toStringFormat(BigDecimal value) {
        return scale(value).toPlainString();
    }

}
