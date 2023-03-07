package by.gstu.fais.artyugin.education.service.oop.lab3.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

/**
 * Студент
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
@Getter
@AllArgsConstructor
public class Student {

    private final String firstName;

    private final String lastName;

    private final Map<String, List<Integer>> marks;

    public void addMark(String subject, Integer mark) {
        if (!marks.containsKey(subject)) marks.put(subject, new ArrayList<>());
        marks.get(subject).add(mark);
    }

    public double calculateAverageMark() {

        IntSummaryStatistics statistics = marks.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        return Math.round(statistics.getAverage());
    }

    public String lastName() {
        return lastName;
    }

    public String firstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", average mark = " + calculateAverageMark();
    }
}
