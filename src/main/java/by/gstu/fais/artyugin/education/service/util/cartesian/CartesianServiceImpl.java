package by.gstu.fais.artyugin.education.service.util.cartesian;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

/**
 * Сервис декартового (картезианского) перемножения компонентов
 *
 * @author Mikhail Artyugin
 * @since 11.03.2022
 */
@Service
public class CartesianServiceImpl implements CartesianService {

    /**
     * {@inheritDoc}
     *
     * @param lists              содержит листы с компонентами продукта, участвующими в перемножении
     *                           Пример:
     *                           ["1", "2"] x ["A", "B"] = [["1", "A"], ["2", "A"], ["1", "B"], ["2", "B"]]
     * @param acceptEmptyElement флаг допустимости к перемножению компонентов с пустыми коллекциями
     *                           Пример true:
     *                           ["1", "2"] x ["A", "B"] x [] = [["1", "A"], ["2", "A"], ["1", "B"], ["2", "B"]]
     *                           (пустые коллекции не учитываются)
     *                           <p>
     *                           Пример false:
     *                           ["1", "2"] x ["A", "B"] x [] = []
     *                           (пустые коллекции учитываются и эквивалентны умножению на 0)
     */
    @Override
    public <T> List<List<T>> getCartesianProduct(@NonNull List<List<T>> lists, boolean acceptEmptyElement) {

        return isSingleList(lists)

                ? lists

                : lists.stream()
                .filter(list -> isCorrectToMultipleList(acceptEmptyElement, list))
                .map(this::toSingleElementLists)
                .reduce(this::multipleElementsFromLists)
                .orElse(Collections.emptyList());
    }


    /**
     * Перемножает элементы двух списков
     *
     * @param list0 первый список элементов
     * @param list1 второй список элементов
     * @param <T>   тип компоненты
     * @return декартово произведение элементов двух списков
     */
    private <T> List<List<T>> multipleElementsFromLists(List<List<T>> list0, List<List<T>> list1) {

        return list0.stream()
                .flatMap(inner1 -> list1.stream()
                        .map(inner2 -> Stream.of(inner1, inner2)
                                .flatMap(List::stream)
                                .toList()
                        )
                )
                .toList();
    }


    /**
     * Преобразует список с элементами в список с одноэлементными списками
     *
     * @param list компоненты продукта, участвующие в перемножении
     * @param <T>  тип компоненты
     * @return список с одноэлементными списками
     */
    private <T> List<List<T>> toSingleElementLists(List<T> list) {
        return list.stream()
                .map(Collections::singletonList)
                .toList();
    }


    /**
     * Проверка на отсутствие вариативности компонентов, в случае вариативности списка списков = 1
     * перемножение элементов не требуется и возвращает тот же список
     *
     * @param lists содержит листы с компонентами продукта, участвующими в перемножении
     * @param <T>   тип компоненты
     * @return флаг необходимости декартового перемножения элементов
     */
    private <T> boolean isSingleList(@NonNull List<List<T>> lists) {
        return lists.stream().allMatch(List::isEmpty);
    }


    /**
     * Проверка на пригодность к перемножению списка элементов
     *
     * @param acceptEmptyElement флаг допустимости к перемножению компонентов с пустыми коллекциями
     * @param list               содержит листы с компонентами продукта, участвующими в перемножении
     * @param <T>                тип компоненты
     * @return флаг пригодности к перемножению
     */
    private <T> boolean isCorrectToMultipleList(boolean acceptEmptyElement, List<T> list) {
        return nonNull(list) && (!acceptEmptyElement || !list.isEmpty());
    }

}
