import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) throws IOException {

        // Imports text file via File, FileInputStream, Scanner
        File initialFile = new File("duif.txt");
        FileInputStream inputStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(inputStream);

        // Arraylists to add words into
        List<String> words = new ArrayList();
        List<Integer> count = new ArrayList();

        // While-loop to find words
        while (scanner.hasNext()) {
            // Finds the next word available and removes symbols and numbers
            String nextWord = scanner.next().replaceAll("[^a-zA-Z0-9]", "");
            // Checks if the word is in the ArrayList
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);

            } else {
                words.add(nextWord);
                count.add(1);
            }
        }

        // Close scanner and inputStream
        scanner.close();
        inputStream.close();

        // Prints out how many times each word occurs
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " occured " + count.get(i) + " times");

        }
    }
}
