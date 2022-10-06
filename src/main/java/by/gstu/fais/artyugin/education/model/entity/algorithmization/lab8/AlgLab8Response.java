package by.gstu.fais.artyugin.education.model.entity.algorithmization.lab8;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Алгоритмизация. Лабораторная работа 8
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Getter
@AllArgsConstructor
public class AlgLab8Response {
    private List<String> firstFileValues;
    private List<String> secondFileValues;
}
