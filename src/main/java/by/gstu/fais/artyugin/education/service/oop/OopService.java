package by.gstu.fais.artyugin.education.service.oop;

import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part1;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part2;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part3;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Описание класса
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
@RequiredArgsConstructor
public class OopService {

    private final OopWork1part1 work1;
    private final OopWork1part2 work2;
    private final OopWork1part3 work3;
    private final OopWork1part4 work4;

    public String laboratoryWork1(double aValue, double xValue) {

        return work1.calculate(aValue, xValue);
    }

    public String laboratoryWork2(double xValue, double zValue) {

        return work2.calculate(xValue, zValue);
    }

    public String laboratoryWork3(double leftBorderRange, double rightBorderRange, double stepValue) {

        return work3.calculate(leftBorderRange, rightBorderRange, stepValue);
    }

    public String laboratoryWork4() {

        return work4.calculate();
    }

}
