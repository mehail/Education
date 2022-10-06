package by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO Алгоритмизация. Лабораторная работа 6. Для прямоугольной матрицы
 *
 * @author Mikhail Artyugin
 * @since 05.10.2022
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlgLab6RectangularMatrixResponseDto {
    private int[][] array;
    private int max;
    private int min;
}
