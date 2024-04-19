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
        prog.printWords();
//        calculateWordFrequency();
//        findLongestWord();

    }

}