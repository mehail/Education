package by.gstu.fais.artyugin.education.service.algorithmization;

import org.springframework.stereotype.Service;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Лабораторная работа 2
 * Программирование задач, содержащих алгоритмы разветвляющихся структур
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class AlgLaboratoryWork2 {

    /**
     * Вычисление значения с логикой условного ветвления
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    public double calculate(int x, int y) {
        return calculateFirstAddendum(x, y) + calculateSecondAddendum(x, y);
    }


    /**
     * Вычисление первого слагаемого
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    private double calculateFirstAddendum(int x, int y) {
        return pow((x + y), 2);
    }


    /**
     * Вычисление второго слагаемого с учетом логики ветвления
     *
     * @param x параметр x
     * @param y параметр y
     * @return результирующее значение
     */
    private double calculateSecondAddendum(int x, int y) {
        int condition = x * y;

        if (condition > 0) {
            //a = (x + y)^2 - sqrt(x * y)
            return -1 * sqrt((x * y));
        } else if (condition < 0) {
            //a = (x + y)^2 + sqrt(abs(x * y))
            return sqrt(abs(x * y));
        } else {
            //a = (x + y)^2 + 1
            return 1;
        }
    }

}
