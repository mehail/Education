package by.gstu.fais.artyugin.education.comtroller.api.v1;

import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab4.AlgLab4RequestDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab5.AlgLab5RequestDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab5.AlgLab5ResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6.AlgLab6RectangularMatrixResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab6.AlgLab6SquareMatrixResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab7.AlgLab7ResponseDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab8.AlgLab8RequestDto;
import by.gstu.fais.artyugin.education.model.dto.algorithmization.lab8.AlgLab8ResponseDto;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6RectangularMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab6.AlgLab6SquareMatrixResponse;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab7.AlgLab7Response;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab8.AlgLab8Response;
import by.gstu.fais.artyugin.education.service.algorithmization.AlgorithmizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
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
            summary = "Лабораторная работа №1. Программирование задач, содержащих алгоритмы линейной структуры",
            description = "Вычисление значения с линейной логикой"
    )
    public String laboratoryWork1(
            @Parameter(description = "Параметр x") @RequestParam int x,
            @Parameter(description = "Параметр y") @RequestParam int y
    ) {

        return String.valueOf(service.laboratoryWork1(x, y));
    }


    @PostMapping("/2")
    @Operation(
            summary = "Лабораторная работа №2. Программирование задач, содержащих алгоритмы разветвляющихся структур",
            description = "Вычисление значения с логикой условного ветвления"
    )
    public String laboratoryWork2(
            @Parameter(description = "Параметр x") @RequestParam int x,
            @Parameter(description = "Параметр y") @RequestParam int y
    ) {

        return String.valueOf(service.laboratoryWork2(x, y));
    }


    @PostMapping("/3")
    @Operation(
            summary = "Лабораторная работа №3. Программирование циклических структур",
            description = "Вычисление значения с использованием циклов."
    )
    public String laboratoryWork3(
            @Parameter(description = "Параметр m, nMinValue >= m > 0") @RequestParam int m,
            @Parameter(description = "Параметр nMinValue, nMinValue + step > nMaxValue") @RequestParam int nMinValue,
            @Parameter(description = "Параметр nMaxValue, nMinValue + step > nMaxValue") @RequestParam int nMaxValue,
            @Parameter(description = "Параметр step, step != 0") @RequestParam int step
    ) {

        return service.laboratoryWork3(m, nMinValue, nMaxValue, step);
    }


    @PostMapping("/4")
    @Operation(
            summary = "Лабораторная работа №4. Программирование задач по работе с одномерными массивами при " +
                    "адресации элементов массива",
            description = "Вычисление значения с использованием одномерных массивов"
    )
    public String laboratoryWork4(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "DTO Алгоритмизация. Лабораторной работы 4", required = true,
                    content = @Content(schema = @Schema(implementation = AlgLab4RequestDto.class)))
            @RequestBody AlgLab4RequestDto numbers
    ) {

        return service.laboratoryWork4(numbers.getNumbers());
    }


    @PostMapping("/5")
    @Operation(
            summary = "Лабораторная работа №5. Программирование задач, содержащих в себе пользовательские функции",
            description = "Меняет местами максимальный и минимальный элементы массива"
    )
    public AlgLab5ResponseDto laboratoryWork5(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "DTO Алгоритмизация. Лабораторной работы 5", required = true,
                    content = @Content(schema = @Schema(implementation = AlgLab5RequestDto.class)))
            @RequestBody AlgLab5RequestDto request
    ) {

        int[] source = request.getArray();
        int[] swap = service.laboratoryWork5(source);

        return new AlgLab5ResponseDto(source, swap);
    }


    @PostMapping("/6/rectangular")
    @Operation(
            summary = "Лабораторная работа №6. Программирование задач по работе с многомерными массивами",
            description = "Находит наибольший и наименьший элементы прямоугольного двумерного массива"
    )
    public AlgLab6RectangularMatrixResponseDto laboratoryWork6RectangularMatrix(
            @Parameter(description = "Высота матрицы") @RequestParam int height,
            @Parameter(description = "Ширина матрицы") @RequestParam int width
    ) {

        AlgLab6RectangularMatrixResponse response = service.laboratoryWork6RectangularMatrix(height, width);

        return new AlgLab6RectangularMatrixResponseDto(
                response.getArray(),
                response.getMin(),
                response.getMax()
        );
    }


    @PostMapping("/6/square")
    @Operation(
            summary = "Лабораторная работа №6. Программирование задач по работе с многомерными массивами",
            description = "Получение значений выше главной диагонали квадратной матрицы"
    )
    public AlgLab6SquareMatrixResponseDto laboratoryWork6SquareMatrix(
            @Parameter(description = "Порядок матрицы") @RequestParam int order
    ) {

        AlgLab6SquareMatrixResponse response = service.laboratoryWork6SquareMatrix(order);

        return new AlgLab6SquareMatrixResponseDto(response.getArray(), response.getCountPositive());
    }


    @PostMapping("/7")
    @Operation(
            summary = "Лабораторная работа №7. Обработка символьной информации",
            description = "Подсчитать количество слов и после каждого поставить запятую"
    )
    public AlgLab7ResponseDto laboratoryWork6SquareMatrix(
            @Parameter(description = "Обрабатываемая строка") @RequestParam String inputString
    ) {

        AlgLab7Response response = service.laboratoryWork7(inputString);

        return new AlgLab7ResponseDto(response.getCountWords(), response.getChangedString());
    }


    @PostMapping("/8")
    @Operation(
            summary = "Лабораторная работа №8. Написание программ с использованием файлов",
            description = "Пишет и вычитывает значения из файлов"
    )
    public AlgLab8ResponseDto laboratoryWork8(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "DTO Алгоритмизация. Лабораторной работы 8", required = true,
                    content = @Content(schema = @Schema(implementation = AlgLab8RequestDto.class)))
            @RequestBody AlgLab8RequestDto request
    ) {

        AlgLab8Response response = service.laboratoryWork8(request.getStrings());

        return new AlgLab8ResponseDto(response.getFirstFileValues(), response.getSecondFileValues());
    }

}
