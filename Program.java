import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program{
    private ArrayList<String> words;
    private Map<String, Integer> wordFrequency;
    private String longestWord;

    public Program() {
        words = new ArrayList<>();
        wordFrequency = new HashMap<>();
        longestWord = "";

    }

    private void loadFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                this.words.add(word);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        }
    }

    private void calculateWordFrequency() {
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            System.out.println("Фрукт: " + word + ", Коллличество: " + frequency);
        }
    }

    private void findLongestWord() {
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }


    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void printWords()
    {

        for (String word: words)
        {
            System.out.println(word);

        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public static void main(String[] args) {
        Program prog = new Program();
        prog.loadFromFile("input.txt");
        //prog.printWords();
        System.out.println();
        System.out.print("Всего фруктов: ");
        System.out.println(prog.getWords().size());
        System.out.println();
        System.out.println("Разбивка по количеству: ");
        prog.calculateWordFrequency();

        System.out.println();
        System.out.print("Самый 'длинный' фрукт: ");

        prog.findLongestWord();
        System.out.println(prog.longestWord);


    }

}