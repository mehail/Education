package by.gstu.fais.artyugin.education.comtroller.api.v1;

import by.gstu.fais.artyugin.education.service.theoretical.basis.TheoreticalBasisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер API Теоретические основы информационных систем
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Tag(name = "TheoreticalBasis", description = "Теоретические основы информационных систем")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/stage1/theoretical")
public class TheoreticalBasisController {

    /**
     * Сервис логики лабораторных работ по предмету
     * "Основы алгоритмизации и программирования на языках высокого уровня"
     * Вариант 1
     */
    private final TheoreticalBasisService service;


    @PostMapping("/lab/1")
    @Operation(
            summary = "Лабораторная работа №1. Перевод чисел из одной системы счисления в другую",
            description = "Перевод чисел из одной системы счисления в другую"
    )
    public String laboratoryWork1(
            @Parameter(description = "Конвертируемое число") @RequestParam String value,
            @Parameter(description = "Исходная система счисления, max=36") @RequestParam int sourceFoundation,
            @Parameter(description = "Целевая система счисления, max=36") @RequestParam int goalFoundation
    ) {

        return service.convertByFoundation(value, sourceFoundation, goalFoundation);
    }

}
