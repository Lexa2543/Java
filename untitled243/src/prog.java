import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class prog {

    private static final Logger demoLogger = LogManager.getLogger(prog.class.getName());

    public static void main(String[] args) {

        System.out.print("Программа запущена");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину отрезка: ");
        double length = scanner.nextDouble();

        System.out.print("Введите номер единицы измерения (1 — дециметр, 2 — километр, 3 — метр, 4 — миллиметр, 5 — сантиметр): ");
        int unit = scanner.nextInt();

        double lengthInMeters;

        switch (unit) {
            case 1:
                lengthInMeters = length / 10.0;
                break;
            case 2:
                lengthInMeters = length * 1000.0;
                break;
            case 3:
                lengthInMeters = length;
                break;
            case 4:
                lengthInMeters = length / 1000.0;
                break;
            case 5:
                lengthInMeters = length / 100.0;
                break;
            default:
                System.out.print("Ошибка! Неверный номер единицы измерения.");
                return;
        }

        System.out.print("Длина отрезка в метрах: " + lengthInMeters + " м.");

        demoLogger.error("Ошибка");
        demoLogger.info("Программа работает");
    }
}
