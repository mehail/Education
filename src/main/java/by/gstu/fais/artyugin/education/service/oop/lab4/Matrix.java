package by.gstu.fais.artyugin.education.service.oop.lab4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Матрица
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
@AllArgsConstructor
@NoArgsConstructor
public class Matrix {

    @Getter
    private List<List<Integer>> table;

    public long countRowWithoutZero() {

        return table.stream()
                .filter(row -> row.stream().noneMatch(e -> e.equals(0)))
                .count();
    }

    public void replaceDuplicateValues() {

        List<List<Integer>> accumulator = new ArrayList<>();
        Set<Integer> duplicateValues = getDuplicateValues();

        for (List<Integer> integers : table) {
            List<Integer> newRow = new ArrayList<>();
            for (Integer element : integers) {
                if (!duplicateValues.contains(element)) {
                    newRow.add(element);
                } else {
                    newRow.add(0);
                }
            }
            accumulator.add(newRow);
        }

        table = accumulator;
    }


    public Integer maxDuplicateValues() {

        Set<Integer> duplicateValues = getDuplicateValues();

        return table.stream()
                .flatMap(Collection::stream)
                .filter(duplicateValues::contains)
                .max(Integer::compareTo)
                .orElse(null);
    }

    private Set<Integer> getDuplicateValues() {

        List<Integer> flatValues = table.stream()
                .flatMap(Collection::stream)
                .toList();

        return flatValues.stream()
                .filter(i -> Collections.frequency(flatValues, i) > 1)
                .collect(Collectors.toSet());
    }


    @Override
    public String toString() {

        return table.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
