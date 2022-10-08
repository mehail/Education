package by.gstu.fais.artyugin.education.service.algorithmization.exam;

import by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3.AlgExam3Offense;
import by.gstu.fais.artyugin.education.model.entity.algorithmization.exam3.AlgExam3Response;
import by.gstu.fais.artyugin.education.service.util.file.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервис логики экзаменационной работы. Задание 3
 * Работа со структурами и файлами.
 * Создать текстовый файл с данными в формате CSV, поля отделяются ';'
 * Структура: Правонарушение. Поля: фамилия нарушителя, год рождения, вид правонарушения, сумма штрафа
 * Задание: Вывести информацию о правонарушениях заданного вида в новый текстовый файл в порядке возрастания суммы
 * штрафа. Определить максимальный штраф среди нарушителей моложе указанного возраста.
 *
 * @author Mikhail Artyugin
 * @since 08.10.2022
 */
@Service
@AllArgsConstructor
public class AlgExam3 {

    private static final String CSV_PATH = "algorithmization/Offense.csv";

    /**
     * Директория временных файлов проекта
     */
    private static final String TEMP_DIRECTORY = "/temp/";
    private static final String NEW_FILE_NAME = "new.csv";

    /**
     * Разделитель значений CSV
     */
    private static final String SEPARATOR = ";";

    /**
     * Сервис работы с файлами
     */
    private final FileService fileService;


    /**
     * Экзаменационное задание 2.
     * Выполняет чтение CSV, парсинг, сортировку и запись по заданным правилам
     *
     * @param year Минимальный год рождения правонарушителя
     * @return {@link AlgExam3Response}
     */
    public AlgExam3Response process(int year) {

        List<AlgExam3Offense> offenses = getOffenses();

        fileService.writeFile(
                getSortedByTypeAndSumAsString(offenses),
                fileService.getProjectDir() + TEMP_DIRECTORY,
                NEW_FILE_NAME
        );

        return new AlgExam3Response(offenses, getOffenseYoungerThan(year, offenses));
    }


    /**
     * Получить отсортированные нарушения по типу и сумме
     *
     * @param offenses нарушения
     * @return отсортированный список нарушений
     */
    private List<String> getSortedByTypeAndSumAsString(List<AlgExam3Offense> offenses) {
        return sortedBySum(groupByOffense(offenses)).stream()
                .map(l -> String.join(SEPARATOR, l))
                .collect(Collectors.toList());
    }


    /**
     * Получение нарушений из файла
     *
     * @return список нарушений
     */
    private List<AlgExam3Offense> getOffenses() {

        return fileService.readByRelativePath(CSV_PATH).stream()
                .map(s -> s.split(SEPARATOR))
                .map(this::getOffenseFunction)
                .collect(Collectors.toList());
    }


    /**
     * Получение тех нарушений, где нарушители младше заданного года
     *
     * @param year     минимальный год рождения правонарушителя
     * @param offenses нарушения
     * @return список нарушений
     */
    private List<AlgExam3Offense> getOffenseYoungerThan(int year, List<AlgExam3Offense> offenses) {

        return offenses.stream()
                .filter(of -> of.getYearOfBirth() > year)
                .collect(Collectors.toList());
    }


    /**
     * Сортировка нарушений по сумме
     *
     * @param offenses нарушения
     * @return список сортированных нарушений в строковом представлении
     */
    private List<List<String>> sortedBySum(List<List<AlgExam3Offense>> offenses) {

        List<List<String>> result = new ArrayList<>();

        for (List<AlgExam3Offense> algExam3Offenses : offenses) {
            List<List<String>> collect2 = algExam3Offenses.stream()
                    .sorted(Comparator.comparing(AlgExam3Offense::getSumPenalty))
                    .map(of -> List.of(
                            of.getLastName(), of.getName(), of.getYearOfBirth().toString(), of.getOffense(), of.getSumPenalty().toString())
                    ).collect(Collectors.toList());

            result.addAll(collect2);
        }

        return result;
    }


    /**
     * Группировка нарушений по типам
     *
     * @param offenses нарушения
     * @return список со сгруппированными нарушениями
     */
    private List<List<AlgExam3Offense>> groupByOffense(List<AlgExam3Offense> offenses) {

        Map<String, List<AlgExam3Offense>> collect =
                offenses.stream().collect(Collectors.groupingBy(AlgExam3Offense::getOffense));

        return collect.values().stream()
                .map(algExam3Offenses -> algExam3Offenses.stream()
                        .sorted(Comparator.comparing(AlgExam3Offense::getSumPenalty))
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toList());
    }


    /**
     * Преобразует массив в сущность нарушения
     *
     * @param array массив
     * @return {@link AlgExam3Offense}
     */
    private AlgExam3Offense getOffenseFunction(String[] array) {

        return new AlgExam3Offense(
                array[0],
                array[1],
                Integer.parseInt(array[2]),
                array[3],
                Integer.parseInt(array[4])
        );
    }

}
