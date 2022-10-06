package by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO Алгоритмизация. Лабораторная работа 6. Для квадратной матрицы
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@AllArgsConstructor
public class AlgLab6SquareMatrixResponseDto {
    private int[][] array;
    private int countPositive;
}
