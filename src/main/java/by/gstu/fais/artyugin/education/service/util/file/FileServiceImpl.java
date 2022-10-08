package by.gstu.fais.artyugin.education.service.util.file;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с файлами
 *
 * @author Mikhail Artyugin
 * @since 06.10.2022
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * {@inheritDoc}
     *
     * @param filePath полный путь к файлу, включая его имя
     */
    @Override
    @SneakyThrows
    public List<String> readFile(String filePath) {

        Path path = Paths.get(filePath);

        return Files.readAllLines(path);
    }


    /**
     * {@inheritDoc}
     *
     * @param relativePath относительный путь
     * @return
     */
    @SneakyThrows
    public List<String> readByRelativePath(String relativePath) {

        try (InputStream inp = new ClassPathResource(relativePath).getInputStream()) {
            return new BufferedReader(new InputStreamReader(inp))
                    .lines().collect(Collectors.toList());
        }

    }


    /**
     * {@inheritDoc}
     *
     * @param data     записываемые данные
     * @param filePath директория файл
     * @param fileName название файла
     */
    @Override
    @SneakyThrows
    public void writeFile(List<String> data, String filePath, String fileName) {

        checkPath(filePath);
        Path path = Paths.get(filePath + fileName);

        Files.write(path, data);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getProjectDir() {
        return System.getProperty("user.dir");
    }


    /**
     * {@inheritDoc}
     *
     * @param path структура каталогов
     */
    private void checkPath(String path) {
        new File(path).mkdirs();
    }

}
