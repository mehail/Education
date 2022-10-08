package by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Алгоритмизация. Экзаменационное задание 3. Правонарушение
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Getter
@ToString
@AllArgsConstructor
public class AlgExam3Offense {
    private String lastName;
    private String name;
    private Integer yearOfBirth;
    private String offense;
    private Integer sumPenalty;
}
