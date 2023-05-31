import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("test2");
        HashMap<String, Integer> linkFrequencies = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);
            String lineSeparator = "\\R"; // определяем разделитель строк
            Pattern pattern = Pattern.compile(lineSeparator);
            scanner.useDelimiter(pattern);
            String urlRegex = "(?i)\\b(?:https?|ftp)://\\S+(?:\\b|$)"; // определяем регулярное выражение для поиска ссылок
            while (scanner.hasNext()) {
                String line = scanner.next();
                Pattern urlPattern = Pattern.compile(urlRegex);
                Matcher matcher = urlPattern.matcher(line);
                while (matcher.find()) {
                    String url = matcher.group();
                    linkFrequencies.put(url, linkFrequencies.getOrDefault(url, 0) + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // выводим полученные данные в файл
        try (PrintStream out = new PrintStream("test1")) {
            for (String url : linkFrequencies.keySet())
            {
                out.printf("%s : %d\n", url, linkFrequencies.get(url));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}