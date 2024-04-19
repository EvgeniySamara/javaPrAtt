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

    public FileLoader(String filePath) {
        words = new ArrayList<>();
        wordFrequency = new HashMap<>();
        longestWord = "";

        loadFromFile(filePath);
        calculateWordFrequency();
        findLongestWord();
    }

    private void loadFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                words.add(word);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
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

    public ArrayList<String> getWords() {
        return words;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public String getLongestWord() {
        return longestWord;
    }
}