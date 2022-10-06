package by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Алгоритмизация. Лабораторная работа 6. Для прямоугольной матрицы
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@AllArgsConstructor
public class AlgLab6RectangularMatrixResponse {
    private int[][] array;
    private int max;
    private int min;
}
