package by.gstu.fais.artyugin.education.comtroller.api.v1;

import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab4.AlgLab4RequestDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab5.AlgLab5RequestDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab5.AlgLab5ResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6.AlgLab6RectangularMatrixResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6.AlgLab6SquareMatrixResponseDto;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6RectangularMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6SquareMatrixResponse;
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
    public ResponseEntity<String> laboratoryWork1(
            @Parameter(description = "Параметр x") @RequestParam int x,
            @Parameter(description = "Параметр y") @RequestParam int y
    ) {

        return ResponseEntity.ok(String.valueOf(service.laboratoryWork1(x, y)));
    }


    @PostMapping("/2")
    @Operation(
            summary = "Лабораторная работа №2",
            description = "Программирование задач, содержащих алгоритмы разветвляющихся структур"
    )
    public ResponseEntity<String> laboratoryWork2(
            @Parameter(description = "Параметр x") @RequestParam int x,
            @Parameter(description = "Параметр y") @RequestParam int y
    ) {

        return ResponseEntity.ok(String.valueOf(service.laboratoryWork2(x, y)));
    }


    @PostMapping("/3")
    @Operation(
            summary = "Лабораторная работа №3",
            description = "Программирование циклических структур"
    )
    public ResponseEntity<String> laboratoryWork3(
            @Parameter(description = "Параметр m") @RequestParam int m,
            @Parameter(description = "Параметр nMinValue") @RequestParam int nMinValue,
            @Parameter(description = "Параметр nMaxValue") @RequestParam int nMaxValue,
            @Parameter(description = "Параметр step") @RequestParam int step
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
                    content = @Content(schema = @Schema(implementation = AlgLab4RequestDto.class)))
            @RequestBody AlgLab4RequestDto numbers
    ) {

        return ResponseEntity.ok(service.laboratoryWork4(numbers.getNumbers()));
    }


    @PostMapping("/5")
    @Operation(
            summary = "Лабораторная работа №5",
            description = "Программирование задач, содержащих в себе пользовательские функции"
    )
    public ResponseEntity<AlgLab5ResponseDto> laboratoryWork5(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "DTO Алгоритмизация. Лабораторной работы 5", required = true,
                    content = @Content(schema = @Schema(implementation = AlgLab5RequestDto.class)))
            @RequestBody AlgLab5RequestDto request
    ) {

        int[] source = request.getArray();
        int[] swap = service.laboratoryWork5(source);

        return ResponseEntity.ok(new AlgLab5ResponseDto(source, swap));
    }


    @PostMapping("/6-rectangular-matrix")
    @Operation(
            summary = "Лабораторная работа №6. Прямоугольная Матрица",
            description = "Программирование задач по работе с многомерными массивами. Прямоугольная матрица"
    )
    public ResponseEntity<AlgLab6RectangularMatrixResponseDto> laboratoryWork6RectangularMatrix(
            @Parameter(description = "Высота матрицы") @RequestParam int height,
            @Parameter(description = "Ширина матрицы") @RequestParam int width
    ) {

        AlgLab6RectangularMatrixResponse response = service.laboratoryWork6RectangularMatrix(height, width);

        return ResponseEntity.ok(
                new AlgLab6RectangularMatrixResponseDto(
                        response.getArray(),
                        response.getMin(),
                        response.getMax()
                )
        );
    }

    @PostMapping("/6-square-matrix")
    @Operation(
            summary = "Лабораторная работа №6. Прямоугольная Матрица",
            description = "Программирование задач по работе с многомерными массивами. Квадратная матрица"
    )
    public ResponseEntity<AlgLab6SquareMatrixResponseDto> laboratoryWork6SquareMatrix(
            @Parameter(description = "Порядок матрицы") @RequestParam int order
    ) {

        AlgLab6SquareMatrixResponse response = service.laboratoryWork6SquareMatrix(order);

        return ResponseEntity.ok(
                new AlgLab6SquareMatrixResponseDto(
                        response.getArray(),
                        response.getCountPositive()
                )
        );
    }

}
