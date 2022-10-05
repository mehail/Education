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
public class BigDecimalServiceImpl implements BigDecimalService{

    /**
     * Преобразует дробное число в BigDecimal
     *
     * @param value дробное число
     */
    public BigDecimal toBigDecimal(double value) {

        return toBigDecimal(Double.toString(value));
    }


    /**
     * Преобразует дробное значение в строковом представлении в BigDecimal
     *
     * @param value дробное число в строковом представлении
     */
    public BigDecimal toBigDecimal(String value) {

        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }


    /**
     * Делит одно значение на другое с заданной точностью
     *
     * @param divisible делимое
     * @param divisor   делитель
     * @return частное
     */
    public BigDecimal divide(BigDecimal divisible, BigDecimal divisor) {

        return divisible.divide(divisor, MathContext.DECIMAL64);
    }


    /**
     * Округление значения с заданной точностью
     *
     * @param value округляемое значение
     * @return округленное значение
     */
    public BigDecimal scale(BigDecimal value) {

        return value.setScale(2, RoundingMode.HALF_EVEN);
    }


    /**
     * Преобразует числовое значение к заданному формату
     *
     * @param value числовое значение
     * @return числовое значение в строковом представлении
     */
    public String toStringFormat(BigDecimal value) {
        return scale(value).toPlainString();
    }

}
