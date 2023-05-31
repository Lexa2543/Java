import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("test2");

        HashMap<String, Integer> frequencies = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);
            String wordSeparator = "\\P{L}+"; // определяем разделитель слов, который исключает только буквы
            Pattern pattern = Pattern.compile(wordSeparator);
            scanner.useDelimiter(pattern);
            // считываем каждое слово и добавляем в HashMap
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (!word.isBlank()) { // игнорируем пустые слова
                    frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // выводим полученные данные
        for (String word : frequencies.keySet())
        {
            // проверяем, что слово содержит только русские буквы и повторяется больше одного раза
            if (word.matches("\\p{IsCyrillic}+") && frequencies.get(word) > 1) {
                System.out.printf("%s : %d\n", word, frequencies.get(word));
            }
        }
    }
}

