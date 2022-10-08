package by.gstu.fais.artyugin.education.model.dto.algorithmization.exam3;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3.AlgExam3Offense;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * DTO Алгоритмизация. Экзаменационное задание 3. Ответ
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Getter
@ToString
@AllArgsConstructor
public class AlgExam3ResponseDto {
    private List<AlgExam3Offense> allOffense;
    private List<AlgExam3Offense> youngViolators;
}
