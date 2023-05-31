import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class suma {
    private static final Logger logger = LogManager.getLogger(suma.class);

    public static void main(String[] args) {
        logger.info("Программа запущена");

        Scanner input = new Scanner(System.in);
        System.out.print("Введите целое число n: ");
        int n = input.nextInt();
        System.out.print("Введите действительное число x: ");
        double x = input.nextDouble();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += Math.cos(Math.pow(x, i)) / i;
        }
        {

            System.out.printf("Сумма %d членов ряда равна: %.3f", n, sum   );
            System.out.printf("            "  );
        }
        logger.error("Ошибка");
        logger.info("Программа работает");
    }

}