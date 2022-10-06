package by.gstu.fais.artyugin.education.service.util.decimal;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Сервис обработки дробных значений
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public interface BigDecimalService {

    /**
     * Преобразует дробное число в BigDecimal
     *
     * @param value дробное число
     * @return {@link BigDecimal}
     */
    BigDecimal toBigDecimal(double value);


    /**
     * Преобразует дробное значение в строковом представлении в BigDecimal
     *
     * @param value дробное число в строковом представлении
     * @return {@link BigDecimal}
     */
    BigDecimal toBigDecimal(String value);


    /**
     * Делит одно значение на другое с заданной точностью
     *
     * @param divisible делимое
     * @param divisor   делитель
     * @return частное
     */
    BigDecimal divide(BigDecimal divisible, BigDecimal divisor);


    /**
     * Округление значения с заданной точностью
     *
     * @param value округляемое значение
     * @return округленное значение
     */
    BigDecimal scale(BigDecimal value);


    /**
     * Преобразует числовое значение к заданному формату
     *
     * @param value числовое значение
     * @return числовое значение в строковом представлении
     */
    String toStringFormat(BigDecimal value);

}
