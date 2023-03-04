package by.gstu.fais.artyugin.education.service.util.cartesian;

import java.util.List;

/**
 * Сервис декартового (картезианского) перемножения компонентов
 *
 * @author Mikhail Artyugin
 * @since 11.03.2022
 */
public interface CartesianService {

    /**
     * Выполняет "склеивание" искомых компонентов продукта из матриц, в случае если один из компонентов продукта
     * имеет более одного варианта, то результирующий продукт должен содержать вариант с каждым из указанных элементов
     * Пример:
     * - компоненты [[1, 2], ["A"], [","]]
     * - результат перемножения [[1, "A", ","], [2, "A", ","]]
     *
     * @param lists              содержит листы компонентами продукта, участвующими в перемножении
     *                           Пример:
     *                           [1, 2] x ["A", "B"] = [[1, "A"], [2, "A"], [1, "B"], [2, "B"]]
     * @param acceptEmptyElement флаг допустимости к перемножению компонентов с пустыми коллекциями
     *                           Пример true:
     *                           [1, 2] x ["A", "B"] x [] = [[1, "A"], [2, "A"], [1, "B"], [2, "B"]]
     *                           (пустые коллекции не учитываются)
     *                           <p>
     *                           Пример false:
     *                           [1, 2] x ["A", "B"] x [] = []
     *                           (пустые коллекции учитываются и эквивалентны умножению на 0)
     * @return возвращает декартово (картезианское) перемножение всех элементов на все
     */
    <T> List<List<T>> getCartesianProduct(List<List<T>> lists, boolean acceptEmptyElement);

}
