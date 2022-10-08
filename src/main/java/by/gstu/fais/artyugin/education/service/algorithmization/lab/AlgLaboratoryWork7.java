package by.gstu.fais.artyugin.education.service.algorithmization.lab;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab7.AlgLab7Response;
import org.springframework.stereotype.Service;

/**
 * Лабораторная работа 7
 * <p>
 * Обработка символьной информации.
 * Подсчитать количество слов и после каждого поставить запятую
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class AlgLaboratoryWork7 {

    /**
     * Разделитель введенной строки
     */
    private static final String INPUT_SPLITERATOR = " ";

    /**
     * Разделитель преобразованной строки
     */
    private static final String OUTPUT_DELIMITER = ", ";

    /**
     * Шаблон определения лишних пробелов
     */
    private static final String REG_EX = "\\s+";


    /**
     * Обработка введенной строки
     *
     * @param inputString введенная строка
     * @return {@link AlgLab7Response}
     */
    public AlgLab7Response process(String inputString) {

        String trimmedString = trim(inputString);

        String[] words = trimmedString.split(INPUT_SPLITERATOR);
        String resultString = String.join(OUTPUT_DELIMITER, words);

        return new AlgLab7Response(words.length, resultString);
    }


    /**
     * Убирает лишние пробелы в строке
     *
     * @param string обрабатываемая строка
     * @return String
     */
    private String trim(String string) {

        return string.replaceAll(REG_EX, INPUT_SPLITERATOR);
    }

}
