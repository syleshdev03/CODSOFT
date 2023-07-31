import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Word_Counter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter '0' to enter text manually or '1' to provide a file: ");
        int choice = scan.nextInt();
        scan.nextLine();

        String txt = " ";

        if (choice == 0) {
            System.out.println("Enter the text: ");
            txt = scan.nextLine();
        } else if (choice == 1) {
            System.out.println("Enter the file name: ");
            String filename = scan.nextLine();
            try {
                File file = new File(filename);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    txt += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting the program.");
            System.exit(1);
        }

        int word_Count = countWords(txt);
        System.out.println("Total words: " + word_Count);

        getUniqueWords(txt);
        getWordFrequency(txt);
    }

    public static int countWords(String txt) {
        String[] words = txt.split("\\s+");
        return words.length;
    }

    public static void getUniqueWords(String txt) {
        String[] words = txt.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Unique words: " + wordCountMap.size());
    }

    public static void getWordFrequency(String txt) {
        String[] words = txt.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}