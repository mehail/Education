package by.gstu.fais.artyugin.education.service.theoretical.basis;

import by.gstu.fais.artyugin.education.service.theoretical.basis.lab1.ThBasisLaboratoryWork1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис логики лабораторных работ по предмету
 * "Теоретические основы информационных систем"
 *
 * @author Mikhail Artyugin
 * @since 14.10.2022
 */
@Service
@AllArgsConstructor
public class TheoreticalBasisService {

    private final ThBasisLaboratoryWork1 lab1;


    /**
     * Преобразование числа из одной системы счисления в другую
     *
     * @param value            строковое значение
     * @param sourceFoundation исходная система счисления
     * @param goalFoundation   целевая система счисления
     * @return результирующее значение
     */
    public String convertByFoundation(String value, int sourceFoundation, int goalFoundation) {

        return lab1.convertByFoundation(value, sourceFoundation, goalFoundation);
    }

}
