import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class perepoln {
    private static final Logger demoLogger = LogManager.getLogger(perepoln.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demoLogger.info("Программа запущена");

        System.out.print("Введите первое целое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int b = scanner.nextInt();
        int sum = a + b;   // вычисляем сумму чисел

        if (sum > 32767) // проверяем, не превышает ли сумма максимальное значение для типа int
        {

            System.out.println("Переполнение! Сумма больше 32767");
            demoLogger.error("Ошибка");
            demoLogger.info("Программа работает");
        } else
        {
            System.out.println("Сумма равна " + sum);
            demoLogger.error("Ошибка");
            demoLogger.info("Программа работает");
        }

    }
}