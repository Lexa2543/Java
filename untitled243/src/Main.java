import java.util.Scanner;
import org.apache.logging.log4j.*;
import java.util.Date;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger demoLogger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        demoLogger.info("Программа запущена");

        System.out.println("Введите координаты первой вершины (x1,y1): ");
        double x1 = scanner.nextDouble(); // считываем координату x первой вершины
        double y1 = scanner.nextDouble(); // считываем координату y первой вершины

        System.out.println("Введите координаты второй вершины (x2,y2): ");
        double x2 = scanner.nextDouble(); // считываем координату x второй вершины
        double y2 = scanner.nextDouble(); // считываем координату y второй вершины

        System.out.println("Введите координаты третьей вершины (x3,y3): ");
        double x3 = scanner.nextDouble(); // считываем координату x третьей вершины
        double y3 = scanner.nextDouble(); // считываем координату y третьей вершины

        double a = distance(x1, y1, x2, y2); // вычисляем длину стороны a
        double b = distance(x2, y2, x3, y3); // вычисляем длину стороны b
        double c = distance(x3, y3, x1, y1); // вычисляем длину стороны c

        double p = (a + b + c) / 2; // вычисляем полупериметр треугольника
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c)); // вычисляем площадь
        double perimeter = a + b + c;

        System.out.println("Периметр треугольника: " + perimeter);
        System.out.println("Площадь треугольника: " + area);

        demoLogger.info("Программа успешно завершена");
        demoLogger.error("Ошибка");
        demoLogger.info("Программа работает");

    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}