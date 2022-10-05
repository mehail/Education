package by.gstu.fais.artyugin.education.service.algorithmization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис логики лабораторных работ по предмету
 * "Основы алгоритмизации и программирования на языках высокого уровня"
 * Вариант 1
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
@AllArgsConstructor
public class AlgorithmizationService {

    private final AlgLaboratoryWork1 laboratoryWork1;
    private final AlgLaboratoryWork2 laboratoryWork2;
    private final AlgLaboratoryWork3 laboratoryWork3;
    private final AlgLaboratoryWork4 laboratoryWork4;

    /**
     * Лабораторная работа 1: вычисление значения с линейной логикой
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double laboratoryWork1(int x, int y) {
        return laboratoryWork1.calculate(x, y);
    }

    /**
     * Лабораторная работа 2: вычисление значения с логикой условного ветвления
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double laboratoryWork2(int x, int y) {
        return laboratoryWork2.calculate(x, y);
    }


    /**
     * Лабораторная работа 3: вычисление значения с использованием циклов
     *
     * @param m параметр x
     * @param n параметр y
     * @return результирующее значение
     */
    public String laboratoryWork3(int m, int n) {
        return laboratoryWork3.calculate(m, n);
    }


    /**
     * Лабораторная работа 4: вычисление значения с использованием одномерных массивов
     *
     * @param numbers параметр x
     * @return результирующее значение
     */
    public String laboratoryWork4(double[] numbers) {
        return laboratoryWork4.calculate(numbers);
    }

}
