package by.gstu.fais.artyugin.education.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Swagger
 *
 * @author Mikhail Artyugin
 * @since 04.10.2022
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Учебный проект Михаила Артюгина, гр. ЗИС-22")
                        .description("Сервис демонстрации практических заданий")
                        .version("v1")
                        .contact(new Contact()
                                .email("mehailpost@gmail.com")
                                .name("Михаил Артюгин")
                        )
                );
    }

}
