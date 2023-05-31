import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class treyg {
    private static final Logger demoLogger = LogManager.getLogger(treyg.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demoLogger.info("Программа запущена.");

        System.out.print("Введите радиус описанной окружности: ");
        double R = scanner.nextDouble();
        System.out.print("Введите угол A в градусах: ");
        double A = Math.toRadians(scanner.nextDouble());
        double a = 2 * R * Math.sin(A);

        System.out.print("Введите угол B в градусах: ");
        double B = Math.toRadians(scanner.nextDouble());
        double b = 2 * R * Math.sin(B);
        double C = Math.PI - A - B;
        double c = 2 * R * Math.sin(C);

        System.out.println("Сторона a: " + a);
        System.out.println("Сторона b: " + b);
        System.out.println("Сторона c: " + c);
        demoLogger.error("Ошибка");
        demoLogger.info("Программа работает");
    }
}