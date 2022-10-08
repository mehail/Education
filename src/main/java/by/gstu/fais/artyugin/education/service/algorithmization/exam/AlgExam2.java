package by.gstu.fais.artyugin.education.service.algorithmization.exam;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис логики экзаменационной работы. Задание 2
 * Работа со строками.
 * Удалить символы '?', стоящие после 'a', и подсчитать общее количество 'Р', 'О'
 *
 * @author Mikhail Artyugin
 * @since 08.10.2022
 */
@Service
@AllArgsConstructor
public class AlgExam2 {

    private static final String PATTERN_REPLACE = "а?";
    private static final String PATTERN_O = "О";
    private static final String PATTERN_P = "Р";
    private static final String RESULT_MESSAGE = "Введенная строка: %s\n" +
            "Строка с удаленным символом '?' после символа 'а': %s\n" +
            "Количество символов 'О' в строке: %d\n" +
            "Количество символов 'Р' в строке: %d";


    /**
     * Экзаменационное задание 2.
     * Удаляет символы '?', стоящие после 'a', и подсчитать общее количество 'Р', 'О'
     *
     * @param inputString вводимая строк
     * @return строковое представление решения
     */
    public String process(String inputString) {

        return String.format(
                RESULT_MESSAGE,
                inputString,
                replaceLastCharPattern(inputString),
                getIndexOf(inputString, PATTERN_O).size(),
                getIndexOf(inputString, PATTERN_P).size()
        );
    }


    /**
     * Удаляет последний из строки вхождения последнего символа паттерна
     *
     * @param inputString вводимая строка
     * @return обработанная строка
     */
    private String replaceLastCharPattern(String inputString) {

        List<Integer> indexes = getIndexOf(inputString, PATTERN_REPLACE);

        List<Integer> collect = indexes.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder(inputString);

        for (Integer i : collect) {
            result.deleteCharAt(i + PATTERN_REPLACE.length() - 1);
        }

        return result.toString();
    }


    /**
     * Возвращает индексы вхождения подстроки в строку
     *
     * @param inputString вводимая строка
     * @param substring   подстрока
     * @return индексы вхождений
     */
    private List<Integer> getIndexOf(String inputString, String substring) {

        List<Integer> indexes = new ArrayList<>();

        int index = inputString.indexOf(substring);
        while (index >= 0) {
            indexes.add(index);
            index = inputString.indexOf(substring, index + 1);
        }

        return indexes;
    }

}
