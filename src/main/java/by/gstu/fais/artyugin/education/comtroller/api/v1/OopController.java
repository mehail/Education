package by.gstu.fais.artyugin.education.comtroller.api.v1;

import by.gstu.fais.artyugin.education.service.oop.OopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер API Объектно ориентированное программирование
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Tag(name = "OOP", description = "Объектно ориентированное программирование")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/stage2/oop")
public class OopController {

    /**
     * Сервис логики лабораторных работ по предмету
     * "Объектно ориентированное программирование"
     * Вариант 1
     */
    private final OopService service;


    @PostMapping("/lab/1/1")
    @Operation(
            summary = "Лабораторная работа №1",
            description = "Программирование линейных алгоритмов"
    )
    public String laboratoryWork1p1(
            @Parameter(description = "Число a") @RequestParam Double aValue,
            @Parameter(description = "Число x") @RequestParam Double xValue
    ) {

        return service.laboratoryWork1p1(aValue, xValue);
    }


    @PostMapping("/lab/1/2")
    @Operation(
            summary = "Лабораторная работа №1",
            description = "Программирование разветвляющихся алгоритмов"
    )
    public String laboratoryWork1p2(
            @Parameter(description = "Число x") @RequestParam Double xValue,
            @Parameter(description = "Число z") @RequestParam Double zValue
    ) {

        return service.laboratoryWork1p2(xValue, zValue);
    }


    @PostMapping("/lab/1/3")
    @Operation(
            summary = "Лабораторная работа №1",
            description = "Программирование циклических алгоритмов"
    )
    public String laboratoryWork1p3(
            @Parameter(description = "Левая граница диапазона") @RequestParam Double leftBorderRange,
            @Parameter(description = "Правая граница диапазон") @RequestParam Double rightBorderRange,
            @Parameter(description = "Щаг") @RequestParam Double stepValue
    ) {

        return service.laboratoryWork1p3(leftBorderRange, rightBorderRange, stepValue);
    }


    @PostMapping("/lab/1/4")
    @Operation(
            summary = "Лабораторная работа №1",
            description = "Разработка и использование методов класса"
    )
    public String laboratoryWork1p4() {

        return service.laboratoryWork1p4();
    }


    @PostMapping("/lab/2")
    @Operation(
            summary = "Лабораторная работа №2",
            description = "Конструкторы и свойства классов"
    )
    public String laboratoryWork2() {

        return service.laboratoryWork2();
    }
}
