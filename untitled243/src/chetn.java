import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class chetn {
    private static final Logger log = LogManager.getLogger(chetn.class.getName());

    public static void main(String[] args) {
        log.info("Программа запущена");

        Scanner input = new Scanner(System.in);

        System.out.print("Введите число n (от 1 до 4): ");
        int n = input.nextInt();

        int sum = 0;

        // Определяем максимальное и минимальное число для n-значных чисел
        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);

        // Суммируем все четные числа от min до max
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.printf("ОШИБКА: сумма четных чисел не была посчитана для числа " + n);
        System.out.printf("   ", n, sum);
        System.out.printf(" Сумма всех четных %d-значных чисел равна: %d", n, sum);
        System.out.printf("    ", n, sum);
        log.error("Ошибка");
        log.info("Программа работает");
    }
}