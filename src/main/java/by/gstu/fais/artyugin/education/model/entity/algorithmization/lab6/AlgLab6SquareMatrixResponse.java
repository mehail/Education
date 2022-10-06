package by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Алгоритмизация. Лабораторная работа 6. Для квадратной матрицы
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@AllArgsConstructor
public class AlgLab6SquareMatrixResponse {
    private int[][] array;
    private int countPositive;
}
