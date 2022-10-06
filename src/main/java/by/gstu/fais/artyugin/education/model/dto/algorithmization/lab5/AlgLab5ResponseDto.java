package by.gstu.fais.artyugin.education.model.dto.algorithmization.lab5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO Алгоритмизация. Лабораторная работа 5
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlgLab5ResponseDto {
    private int[] sourceArray;
    private int[] changedArray;
}
