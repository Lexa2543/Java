import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class coss {
    private static final Logger demoLogger = LogManager.getLogger(coss.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demoLogger.info("Программа запущена");
        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите значение y: ");
        double y = scanner.nextDouble();
        double result = Math.cos(x) / (Math.PI - 2 * x) + 16 * x * Math.cos(x * y) - 2; // вычисляем значение выражения и сохраняем его в переменную result
        System.out.println("Результат вычисления выражения: " + result);  // выводим результат на экран
        demoLogger.info("Результат вычисления выражения: " + result);
        demoLogger.error("Ошибка");
        demoLogger.info("Программа работает");

    }
}