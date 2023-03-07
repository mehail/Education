package by.gstu.fais.artyugin.education.service.oop.lab3;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

/**
 * Класс Массив
 *
 * @author Mikhail Artyugin
 * @since 04.03.2023
 */
@Slf4j
public class ArrayHolder {

    @Getter
    @Setter
    private Integer[] array;


    public ArrayHolder(Integer[] array) {
        if (array.length < 2) throw new IllegalArgumentException("The array must contain at least 3 elements");
        this.array = array;
    }

    public String print() {
        String value = Arrays.toString(array);
        log.info(value);
        return value;
    }

    public int calculateSumPositiveElementsAfterSecondMax() {
        return Arrays.stream(array, getIndexSecondMax() + 1, array.length)
                .filter(element -> element > 0).mapToInt(i -> i)
                .sum();
    }

    private Integer getIndexSecondMax() {

        int firstMax = array[0];
        int indexFirstMax = 0;

        Integer secondMax = null;
        Integer indexSecondMax = null;

        for (int i = 1; i < array.length; i++) {

            int element = array[i];

            if (element > firstMax) {
                secondMax = firstMax;
                indexSecondMax = indexFirstMax;
                firstMax = element;
                indexFirstMax = i;
            } else {
                if (isNull(secondMax) || element > secondMax){
                    secondMax = element;
                    indexSecondMax = i;
                }
            }

        }

        return indexSecondMax;
    }

    private List<Integer> getIndexesMin() {

        record Pair<T> (T element, T index){}

        List<Pair<Integer>> pairsMin = IntStream.range(0, array.length)
                .mapToObj(i -> new Pair<>(array[i], i))
                .sorted(Comparator.comparing(p0 -> p0.element))
                .toList();

        Integer min = pairsMin.get(0).element;

        return pairsMin.stream()
                .filter(pair -> !pair.element.equals(min))
                .map(pair -> pair.index)
                .sorted()
                .toList();
    }

    public int calculateIndexLeftMin() {
        return getIndexesMin().get(0);
    }

    public int calculateIndexRightMin() {
        List<Integer> indexesMin = getIndexesMin();
        return indexesMin.get(indexesMin.size() - 1);
    }

}

