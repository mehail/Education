package by.gstu.fais.artyugin.education.comtroller.api.v1;

import by.gstu.fais.artyugin.education.model.dto.algorithmization.AlgLab4Dto;
import by.gstu.fais.artyugin.education.service.algorithmization.AlgorithmizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер API Основы алгоритмизации и программирования на языках высокого уровня
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Tag(name = "Algorithmization", description = "Основы алгоритмизации и программирования на языках высокого уровня")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/stage1/algorithmization")
public class AlgorithmizationController {

    private final AlgorithmizationService service;


    @PostMapping("/1")
    @Operation(
            summary = "Лабораторная работа №1",
            description = "Изучение основных понятий и приёмов работы со средой разработки." +
                    "Программирование задач, содержащих алгоритмы линейной структуры"
    )
    public ResponseEntity<String> laboratoryWork1(@Parameter(description = "Параметр X") @RequestParam int x,
                                                  @Parameter(description = "Параметр Y") @RequestParam int y) {

        return ResponseEntity.ok(String.valueOf(service.laboratoryWork1(x, y)));
    }


    @PostMapping("/2")
    @Operation(
            summary = "Лабораторная работа №2",
            description = "Программирование задач, содержащих алгоритмы разветвляющихся структур"
    )
    public ResponseEntity<String> laboratoryWork2(@Parameter(description = "Параметр X") @RequestParam int x,
                                                  @Parameter(description = "Параметр Y") @RequestParam int y) {

        return ResponseEntity.ok(String.valueOf(service.laboratoryWork2(x, y)));
    }


    @PostMapping("/3")
    @Operation(
            summary = "Лабораторная работа №3",
            description = "Программирование циклических структур"
    )
    public ResponseEntity<String> laboratoryWork3(
            @Parameter(description = "Параметр M") @RequestParam int m,
            @Parameter(description = "Параметр N") @RequestParam int nMinValue,
            @Parameter(description = "Параметр N") @RequestParam int nMaxValue,
            @Parameter(description = "Параметр N") @RequestParam int step
    ) {

        return ResponseEntity.ok(service.laboratoryWork3(m, nMinValue, nMaxValue, step));
    }


    @PostMapping("/4")
    @Operation(
            summary = "Лабораторная работа №4",
            description = "Программирование задач по работе с одномерными массивами при адресации элементов массива"
    )
    public ResponseEntity<String> laboratoryWork4(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "DTO Алгоритмизация. Лабораторной работы 4", required = true,
                    content = @Content(schema = @Schema(implementation = AlgLab4Dto.class))
            )
            @RequestBody AlgLab4Dto numbers) {

        return ResponseEntity.ok(service.laboratoryWork4(numbers.getNumbers()));
    }

}
