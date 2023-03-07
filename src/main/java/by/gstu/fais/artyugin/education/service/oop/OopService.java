package by.gstu.fais.artyugin.education.service.oop;

import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part1;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part2;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part3;
import by.gstu.fais.artyugin.education.service.oop.lab1.OopWork1part4;
import by.gstu.fais.artyugin.education.service.oop.lab2.OopWork2;
import by.gstu.fais.artyugin.education.service.oop.lab3.OopWork3;
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

    private final OopWork1part1 work1p1;
    private final OopWork1part2 work1p2;
    private final OopWork1part3 work1p3;
    private final OopWork1part4 work1p4;

    private final OopWork2 work2;
    private final OopWork3 work3;

    public String laboratoryWork1p1(double aValue, double xValue) {

        return work1p1.calculate(aValue, xValue);
    }

    public String laboratoryWork1p2(double xValue, double zValue) {

        return work1p2.calculate(xValue, zValue);
    }

    public String laboratoryWork1p3(double leftBorderRange, double rightBorderRange, double stepValue) {

        return work1p3.calculate(leftBorderRange, rightBorderRange, stepValue);
    }

    public String laboratoryWork1p4() {

        return work1p4.calculate();
    }

    public String laboratoryWork2() {

        return work2.process();
    }

    public String laboratoryWork3(OopWork3.Arr arr) {

        try {
            return work3.process(arr);
        } catch (IndexOutOfBoundsException  e) {
            return e.getMessage();
        }

    }

}
