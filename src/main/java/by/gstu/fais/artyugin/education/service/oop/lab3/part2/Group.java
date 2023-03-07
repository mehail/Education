package by.gstu.fais.artyugin.education.service.oop.lab3.part2;

import java.util.Comparator;
import java.util.List;

/**
 * Описание класса
 *
 * @author Mikhail Artyugin
 * @since 07.03.2023
 */
public record Group(String groupName, List<Student> students) {


    public List<Student> excellentStudent() {

        return studentsByAverageMark(10);
    }

    public List<Student> losers() {

        return studentsByAverageMark(3);
    }

    public List<Student> studentsByFirstName() {

        return students.stream()
                .sorted(Comparator.comparing(Student::lastName))
                .toList();
    }

    private List<Student> studentsByAverageMark(double averageMark) {

        return students.stream()
                .filter(student -> student.calculateAverageMark() < averageMark)
                .toList();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append(groupName).append("\n");

        for (int i = 0; i < students.size(); i++) {

            Student student = students.get(i);

            result.append(i).append(" ")
                    .append(student.firstName()).append(" ")
                    .append(student.lastName()).append(" ")
                    .append(",средний бал = ").append(student.calculateAverageMark());
        }

        return result.toString();
    }

}
