import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final int[][] A; // матрица A
    private final int[][] B; // матрица B
    private final int[][] C; // матрица C
    private final int m; // количество строк матрицы A
    private final int n; // количество строк матрицы B и количество столбцов матрицы A
    private final int k; // количество столбцов матрицы B
    private int currentRow = 0, currentColumn = 0; // переменные для отслеживания текущей строки и столбца
    private final Lock lock = new ReentrantLock(); // создание объекта Lock для синхронизации потоков

    public Main(int[][] A, int[][] B) {
        this.A = A;
        this.B = B;
        this.m = A.length;
        this.n = B.length;
        this.k = B[0].length;
        this.C = new int[m][k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        System.out.print("Введите количество строк матрицы A: ");
        m = in.nextInt();
        System.out.print("Введите количество столбцов матрицы A: ");
        n = in.nextInt();
        int[][] A = new int[m][n];
        System.out.println("Введите элементы матрицы A: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = in.nextInt();
            }
        }
        System.out.print("Введите количество строк матрицы B: ");
        m = in.nextInt();
        System.out.print("Введите количество столбцов матрицы B: ");
        n = in.nextInt();
        int[][] B = new int[m][n];
        System.out.println("Введите элементы матрицы B: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = in.nextInt();
            }
        }
        Main main = new Main(A, B);
        main.multiply(2); // перемножение матриц в 2 потока
    }

    public void multiply(int p) { // метод, который перемножает матрицы в p потоков
        Thread[] threads = new Thread[p];
        for (int i = 0; i < p; i++) { // создание и запуск потоков
            threads[i] = new Thread(() -> {
                while (true) { // бесконечный цикл
                    lock.lock(); // блокировка Lock
                    int row = currentRow++; // получение текущей строки
                    int column = currentColumn; // получение текущего столбца
                    lock.unlock(); // разблокировка Lock
                    if (row >= m) { // если все строки были обработаны, то прервать цикл
                        return;
                    }
                    if (C[row][column] == 0) { // проверка, не рассчитывается ли элемент в данный момент
                        int sum = 0; // переменная для хранения суммы
                        for (int i1 = 0; i1 < n; i1++) { // перемножение элементов матрицы
                            sum += A[row][i1] * B[i1][column];
                        }
                        C[row][column] = sum; // запись значения в матрицу C
                    }
                    lock.lock(); // блокировка Lock
                    if (column < k - 1) { // если столбцы не закончились, то перейти к следующему столбцу
                        currentRow--;
                        currentColumn++;
                    } else { // иначе перейти к следующей строке и первому столбцу
                        currentColumn = 0;
                    }
                    lock.unlock(); // разблокировка Lock
                    try {
                        Thread.sleep(10); // задержка в выполнении вычислений
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start(); // запуск потока
        }
        for (int i = 0; i < p; i++) { // ожидание завершения всех потоков
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saveResult(); // сохранение результата в файл
        printResult(); // вывод результата
    }

    private void saveResult() { // метод для сохранения матрицы результата в файл
        File file = new File("result");
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    writer.write(C[i][j] + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printResult() { // метод для вывода матрицы результата в консоль
        System.out.println("Result:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
