package by.gstu.fais.artyugin.education.service.oop.lab1;

import by.gstu.fais.artyugin.education.service.util.table.processor.TableProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Лабораторная работа 1.4
 * <p>
 * Разработка и использование методов класса
 *
 * @author Mikhail Artyugin
 * @since 25.02.2023
 */
@Service
@RequiredArgsConstructor
public class OopWork1part4 {

    private final TableProcessorService tableProcessorService;

    public String calculate() {


        List<List<String>> results = Program.getData().stream()
                .map(Program::calculate)
                .map(result -> List.of(
                                result.data.xValue.toPlainString(),
                                result.data.yValue.toPlainString(),
                                result.data.zValue.toPlainString(),
                                result.calculateResult().toPlainString()
                        )
                )
                .toList();

        return tableProcessorService.toTable(
                List.of("xValue", "yValue", "zValue", "result"),
                results
        );
    }

    private class Program {

        private record Data(BigDecimal xValue, BigDecimal yValue, BigDecimal zValue) {
        }

        record Result(Data data, BigDecimal calculateResult) {
        }

        static List<Data> getData() {

            return List.of(
                    new Data(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3")),
                    new Data(new BigDecimal("1.1"), new BigDecimal("2.1"), new BigDecimal("3.1"))
            );
        }


        static Result calculate(Data data) {

            BigDecimal result = getNumerator(data)
                    .divide(getAbsDivider(data), RoundingMode.HALF_EVEN);

            return new Result(data, result.setScale(4, RoundingMode.HALF_EVEN));
        }

        private static BigDecimal getNumerator(Data data) {
            double sin = Math.sin(data.xValue.doubleValue());
            BigDecimal sinBigDecimal = BigDecimal.valueOf(sin);

            BigDecimal sum = data.xValue
                    .add(data.zValue);
            double cosNumerator = Math.cos(sum.doubleValue());
            BigDecimal cosBigDecimal = BigDecimal.valueOf(cosNumerator);

            return cosBigDecimal.pow(2)
                    .add(sinBigDecimal);
        }

        private static BigDecimal getAbsDivider(Data data) {

            double cosDivider = Math.cos(data.xValue.pow(3).doubleValue());
            BigDecimal cosDividerBigDecimal = BigDecimal.valueOf(cosDivider);

            BigDecimal divider = cosDividerBigDecimal.subtract(
                    data.yValue.pow(2).multiply(BigDecimal.valueOf(2))
            );

            return BigDecimal.valueOf(Math.abs(divider.doubleValue()));
        }
    }


}
