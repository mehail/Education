package by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Алгоритмизация. Экзаменационное задание 3. Ответ
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Getter
@ToString
@AllArgsConstructor
public class AlgExam3Response {
    private List<AlgExam3Offense> allOffense;
    private List<AlgExam3Offense> youngViolators;
}
