package by.gstu.fais.artyugin.education.model.dto.algorithmization.lab8;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * DTO Алгоритмизация. Лабораторная работа 8
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Getter
@AllArgsConstructor
public class AlgLab8ResponseDto {
    private List<String> firstFileValues;
    private List<String> secondFileValues;
}
