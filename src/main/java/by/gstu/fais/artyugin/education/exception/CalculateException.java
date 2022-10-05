package by.gstu.fais.artyugin.education.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Ошибка вычислений
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@AllArgsConstructor
public class CalculateException extends RuntimeException {
    private final String message;
}
