import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class natyr {
    private static final Logger demoLogger = LogManager.getLogger(natyr.class.getName());

    public static void main(String[] args) {
        demoLogger.info("Программа запущена");
        Scanner input = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        long number = input.nextLong();
        input.close();
        long reversedNumber = 0;
        while (number != 0) // запускаем цикл, пока число number не станет равным нулю
        {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;// делим число number на 10, чтобы убрать последнюю цифру
        }
        if (reversedNumber > Integer.MAX_VALUE)
        {

            System.out.println("Переполнение!");
        } else {
            // выводим число с обратным порядком цифр
            System.out.println("Число с обратным порядком цифр: " + (int) reversedNumber);
        }
        demoLogger.error("Ошибка");
        demoLogger.info("Программа работает");
    }
}
