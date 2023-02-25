package by.gstu.fais.artyugin.education.service.oop;

import by.gstu.fais.artyugin.education.service.oop.lab.OopWork1;
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

    private final OopWork1 work1;

    public String laboratoryWork1(double aValue, double xValue) {

        return work1.calculate(aValue, xValue);
    }

}
