package by.gstu.fais.artyugin.education.service.oop.lab3.part2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Лабораторная работа 3 часть 2
 * <p>
 * Обработка одномерных массивов
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
public class OopWork3p2 {

    public String process(Group group) {

        String result = """
                Students by firstName:
                %s
                
                count loser = %d
                
                Excellent students:
                %s
                """;

        String studentsByFirstNameAsString = listToString(group.studentsByFirstName());

        int looserCount = group.losers().size();

        List<Student> excellentStudents = group.excellentStudent();

        String excellentStudentsAsString = excellentStudents.isEmpty()
                ? "- absent"
                : listToString(excellentStudents);

        return String.format(result, studentsByFirstNameAsString, looserCount, excellentStudentsAsString);
    }

    private String listToString(List<Student> studentsByFirstName) {

        return studentsByFirstName.stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
    }

}
