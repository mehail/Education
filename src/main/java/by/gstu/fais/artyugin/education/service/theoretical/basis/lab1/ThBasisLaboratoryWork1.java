package by.gstu.fais.artyugin.education.service.theoretical.basis.lab1;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Лабораторная работа 1
 * <p>
 * Перевод чисел из одной системы счисления в другую
 *
 * @author Mikhail Artyugin
 * @since 15.10.2022
 */
@Service
public class ThBasisLaboratoryWork1 {

    private static final char START_CHAR = '0';
    private static final char NEGATIVE_CHAR = '-';
    private static final int DECIMAL_FOUNDATION = 10;
    private static final int MIN_FOUNDATION = 2;
    private static final int MAX_FOUNDATION = 36;
    private static final String INCORRECT_INPUT = "Основание не должно быть в диапазоне [%d, %d]";
    private static final String INCORRECT_CHAR = "Некорректный ввод, для основания %d доступны символы: %s";


    /**
     * Преобразование числа из одной системы счисления в другую
     *
     * @param input            строковое значение
     * @param sourceFoundation исходная система счисления
     * @param goalFoundation   целевая система счисления
     * @return результирующее значение
     */
    public String convertByFoundation(String input, int sourceFoundation, int goalFoundation) {

        if (sourceFoundation == goalFoundation) return input;

        boolean isNegative = input.charAt(0) == NEGATIVE_CHAR;
        String absValue = getAbs(input, isNegative);

        validateInput(absValue, sourceFoundation);

        StringBuilder absResult = divisionOnFoundation(
                toDecimal(absValue, sourceFoundation),
                BigInteger.valueOf(goalFoundation),
                new StringBuilder()
        );

        return restoreSign(absResult, isNegative);
    }


    /**
     * Восстанавливает знак значения
     *
     * @param abs        модуль числа
     * @param isNegative флаг отрицательного хзначения
     * @return восстановленное значение
     */
    private String restoreSign(StringBuilder abs, boolean isNegative) {

        return isNegative
                ? abs.insert(0, NEGATIVE_CHAR).toString()
                : abs.toString();
    }


    /**
     * Возвращает модуль числа
     *
     * @param input      число
     * @param isNegative флаг отрицательного значения
     * @return модуль числа
     */
    private String getAbs(String input, boolean isNegative) {

        return isNegative
                ? input.substring(1)
                : input;
    }


    /**
     * Деление числа на основание для нахождения остатка от деления
     *
     * @param number         десятичное число
     * @param goalFoundation основание целевой системы счисления
     * @param accumulator    промежуточный результат
     * @return результирующее значение
     */
    private StringBuilder divisionOnFoundation(BigInteger number, BigInteger goalFoundation, StringBuilder accumulator) {

        addRemainderOfDivisions(number, goalFoundation, accumulator);

        return number.compareTo(goalFoundation) >= 0
                ? divisionOnFoundation(number.divide(goalFoundation), goalFoundation, accumulator)
                : removeFirstZero(accumulator);
    }


    /**
     * Добавление значений в аккумулятор
     *
     * @param number         обрабатываемое значение
     * @param goalFoundation основание целевой системы счисления
     * @param accumulator    аккумулятор
     */
    private void addRemainderOfDivisions(BigInteger number, BigInteger goalFoundation, StringBuilder accumulator) {

        int remainder = number.remainder(goalFoundation).intValue();
        Character character = getAlphabet(goalFoundation.intValue()).get(remainder);
        accumulator.insert(0, character);
    }


    /**
     * Удаление первого нулевого символа
     *
     * @param value строковое значение
     * @return результирующее значение
     */
    private StringBuilder removeFirstZero(StringBuilder value) {

        int firstChIndex = 0;

        return value.charAt(firstChIndex) == START_CHAR
                ? value.deleteCharAt(firstChIndex)
                : value;
    }


    /**
     * Преобразование строки в десятичное значение
     *
     * @param value      число в строковом представлении
     * @param foundation основание системы счисления
     * @return десятичное значение
     */
    private BigInteger toDecimal(String value, int foundation) {

        List<Integer> charsAsIntegers = charsToIntegers(getCharacters(value));

        return sumUpRanks(charsAsIntegers, foundation);
    }


    /**
     * Разложение строки на коллекцию символов
     *
     * @param value число в строковом представлении
     * @return список символов
     */
    private List<Character> getCharacters(String value) {

        return value.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }


    /**
     * Суммирует составные компоненты поразрядно
     *
     * @param charsAsIntegers символы в числовом представлении
     * @param foundation      основание системы счисления
     * @return суммы символов поразрядно
     */
    private BigInteger sumUpRanks(List<Integer> charsAsIntegers, int foundation) {

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < charsAsIntegers.size(); i++) {
            Integer integer = charsAsIntegers.get(charsAsIntegers.size() - 1 - i);

            result = result.add(
                    BigInteger.valueOf(integer).multiply(
                            BigInteger.valueOf(foundation).pow(i)
                    )
            );
        }

        return result;
    }


    /**
     * Проверяет вводимое значение на корректность
     *
     * @param value      число в строковом представлении
     * @param foundation основание системы счисления
     */
    private void validateInput(String value, int foundation) {

        if (foundation < MIN_FOUNDATION || foundation > MAX_FOUNDATION) {
            throw new IllegalArgumentException(String.format(INCORRECT_INPUT, MIN_FOUNDATION, MAX_FOUNDATION));
        }

        List<Character> alphabet = getAlphabet(foundation);
        List<Character> chars = getCharacters(value);
        if (!new HashSet<>(alphabet).containsAll(chars))
            throw new IllegalArgumentException(String.format(INCORRECT_CHAR, foundation, alphabet));
    }


    /**
     * Получение перечня допустимых значений для основания системы счисления
     *
     * @param foundation основание системы счисления
     * @return набор допустимых значений
     */
    private List<Character> getAlphabet(int foundation) {

        List<Character> result = new ArrayList<>();

        for (int i = 0; i < foundation; i++) {
            char ch = (char) (START_CHAR + getOffset(i));
            result.add(ch);
        }

        return result;
    }


    /**
     * Преобразует символы в индексы в системе счисления
     *
     * @param chars символы
     * @return индексы символов в системе счисления
     */
    private List<Integer> charsToIntegers(List<Character> chars) {

        return chars.stream()
                .map(Integer::valueOf)
                .map(this::charToInt)
                .collect(Collectors.toList());
    }


    /**
     * Получение офсета в зависимости от того, является число символом или десятичным значением [0..9]
     *
     * @param i индекс
     * @return смещение
     */
    private int getOffset(int i) {

        return (i < DECIMAL_FOUNDATION)
                ? i
                : i + getOffsetNumberZeroToChar();
    }


    /**
     * Преобразует числовое значение символов в его индекс в системе счисления
     *
     * @param n числовое представление символа
     * @return индекс символа в системе счисления
     */
    private int charToInt(int n) {

        int i = n - START_CHAR;

        return n < START_CHAR + 10
                ? i
                : i - getOffsetNumberZeroToChar();
    }


    /**
     * Получение смещение от 'A' до '9'
     *
     * @return смещение
     */
    private int getOffsetNumberZeroToChar() {

        return 'A' - '9' - 1;
    }

}
