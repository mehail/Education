package by.gstu.fais.artyugin.education.service.algorithmization.lab;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.lab8.AlgLab8Response;
import by.gstu.fais.artyugin.education.service.util.file.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Лабораторная работа 8
 * <p>
 * Написание программ с использованием файлов.
 * Создать текстовый файл из 5 строк,
 * прочитать созданный файл и получить новый файл из строк все цифры переписать в новый файл.
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Service
public class AlgLaboratoryWork8 {

    /**
     * Директория временных файлов проекта
     */
    private static final String TEMP_DIRECTORY = "/temp/";

    /**
     * Название первого файла
     */
    private static final String FIRST_FILE_NAME = "firstFile.txt";

    /**
     * Название второго фала
     */
    private static final String SECOND_FILE_NAME = "secondFile.txt";

    private final FileService fileService;
    private final String directory;


    public AlgLaboratoryWork8(FileService fileService) {
        this.fileService = fileService;
        this.directory = fileService.getProjectDir() + TEMP_DIRECTORY;
    }


    /**
     * Пишет и вычитывает значения из файлов
     *
     * @param inputValues вводимые строковые значения
     * @return {@link AlgLab8Response}
     */
    public AlgLab8Response process(List<String> inputValues) {

        List<String> firstFile = createFirstFile(inputValues);
        List<String> result = createSecondFile(firstFile);

        return new AlgLab8Response(firstFile, result);
    }


    /**
     * Запись и вычитывание первого файла со всеми значениями
     *
     * @param strings записываемые строки
     * @return список записанных строк
     */
    private List<String> createFirstFile(List<String> strings) {

        fileService.writeFile(strings, directory, FIRST_FILE_NAME);

        return fileService.readFile(directory + "/" + FIRST_FILE_NAME);
    }


    /**
     * Запись второго файла с числовыми значениями
     *
     * @param strings записываемые строки
     * @return числовые значения
     */
    private List<String> createSecondFile(List<String> strings) {

        List<String> numbers = strings.stream()
                .filter(this::isNumber)
                .collect(Collectors.toList());

        fileService.writeFile(numbers, directory, SECOND_FILE_NAME);

        return numbers;
    }


    /**
     * Проверка строки соответствие числовому значению
     *
     * @param value проверяемое значение
     * @return boolean
     */
    private boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
