package by.gstu.fais.artyugin.education.service.util.table.processor;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

/**
 * Сервис формирование табличных представлений
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Service
public class TableProcessorServiceImpl implements TableProcessorService {

    /**
     * Количество символов смещения значения в колонке влево
     */
    private static final int PADDING_LEFT_RIGHT = 2;


    /**
     * {@inheritDoc}
     *
     * @param data матрица значений
     */
    public String toTable(List<List<String>> data) {

        if (isNull(data) ||
                data.isEmpty() ||
                isUnSymmetricMatrix(data) ||
                data.stream().anyMatch(List::isEmpty)
        ) return null;

        AsciiTable table = new AsciiTable();
        addHeader(data, table);
        addBody(data, table);

        return table.render();
    }

    /**
     * {@inheritDoc}
     *
     * @param head шапка матрицы
     * @param data матрица значений
     */
    @Override
    public String toTable(List<String> head, List<List<String>> data) {

        List<List<String>> lists = Stream.concat(
                        Stream.of(head),
                        data.stream()
                )
                .toList();

        return toTable(lists);
    }


    /**
     * Проверяет на несимметричность передаваемую матрицу
     *
     * @param data матрица значений
     * @return boolean
     */
    private boolean isUnSymmetricMatrix(List<List<String>> data) {

        int headerSize = data.get(0).size();

        return data.stream()
                .anyMatch(row -> row.size() != headerSize);
    }


    /**
     * Добавление шапки таблицы
     *
     * @param data  передаваемые значения
     * @param table табличное представление
     */
    private void addHeader(List<List<String>> data, AsciiTable table) {
        table.addRule();
        table.addRow(data.get(0));
        table.setTextAlignment(TextAlignment.CENTER);
        table.addRule();
    }

    /**
     * Добавление тела таблицы
     *
     * @param data  передаваемые значения
     * @param table табличное представление
     */
    private void addBody(List<List<String>> data, AsciiTable table) {

        if (data.size() == 1) return;

        for (int i = 1; i < data.size(); i++) {
            table.addRow(data.get(i))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setPaddingLeftRight(PADDING_LEFT_RIGHT);
        }

        table.addRule();
    }

}
