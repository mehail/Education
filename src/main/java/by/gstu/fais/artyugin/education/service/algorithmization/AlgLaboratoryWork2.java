package by.gstu.fais.artyugin.education.service.algorithmization;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab2.AlgLab2Response;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Лабораторная работа 2
 * <p>
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
     * @return {@link AlgLab2Response}
     */
    public AlgLab2Response calculate(int x, int y) {
        int condition = x * y;

        String formula = getFormula(condition);
        double result = calculateFirstAddendum(x, y) + calculateSecondAddendum(x, y, condition);

        return new AlgLab2Response(formula, result);
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
     * @param x         параметр x
     * @param y         параметр y
     * @param condition условие выбора
     * @return результирующее значение
     */
    private double calculateSecondAddendum(int x, int y, int condition) {

        if (condition > 0) {
            return -1 * sqrt((x * y));
        } else if (condition < 0) {
            return sqrt(abs(x * y));
        } else {
            return 1;
        }

    }


    /**
     * Получение строкового представления формулы
     *
     * @param condition условие выбора
     * @return строковое представления формулы
     */
    private String getFormula(int condition) {

        if (condition > 0) {
            return "a = (x + y)^2 - sqrt(x * y)";
        } else if (condition < 0) {
            return "a = (x + y)^2 + sqrt(abs(x * y))";
        } else {
            return "a = (x + y)^2 + 1";
        }

    }

}
