import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class para {
    private static final Logger LOG = LogManager.getLogger(para.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOG.info("Программа запущена");

        System.out.print("Введите число a: ");
        int a = scanner.nextInt();

        System.out.print("Введите число b: ");
        int b = scanner.nextInt();

        System.out.print("Введите число c: ");
        int c = scanner.nextInt();

        if ((a == -b) || (a == -c) || (b == -c)){ // проверяем, существует ли хотя бы одна пара противоположных чисел

            System.out.println("Существует хотя бы одна пара противоположных чисел.");
            LOG.error("Ошибка");
            LOG.info("Программа работает");
        } else {
            System.out.println("Нет пар противоположных чисел.");
            LOG.error("Ошибка");
            LOG.info("Программа работает");
        }

    }
}
