package by.gstu.fais.artyugin.education.service.util.file;

import java.util.List;

/**
 * Сервис работы с файлами
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
public interface FileService {

    /**
     * Чтение из файла
     *
     * @param filePath полный путь к файлу, включая его имя
     * @return список строк
     */
    List<String> readFile(String filePath);


    /**
     * Чтение файла по относительному пути
     *
     * @param relativePath относительный путь
     * @return содержимое файла
     */
    List<String> readByRelativePath(String relativePath);


    /**
     * Запись в файл
     *
     * @param data     записываемые данные
     * @param filePath директория файл
     * @param fileName название файла
     */
    void writeFile(List<String> data, String filePath, String fileName);


    /**
     * Получение текущей директории проекта
     *
     * @return директория проекта
     */
    String getProjectDir();

}
