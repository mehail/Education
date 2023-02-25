package by.gstu.fais.artyugin.education.service.util.table.processor;

import java.util.List;

/**
 * Сервис преобразования матрицы значений к табличному виду в строковом представлении
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
public interface TableProcessorService {

    /**
     * Преобразует матрицу значений к табличному виду в строковом представлении
     *
     * @param data матрица значений
     * @return значения в табличном виде в строковом представлении
     */
    String toTable(List<List<String>> data);

    /**
     * Преобразует матрицу значений к табличному виду в строковом представлении
     *
     * @param head шапка матрицы
     * @param data матрица значений
     * @return значения в табличном виде в строковом представлении
     */
    String toTable(List<String> head, List<List<String>> data);

}
