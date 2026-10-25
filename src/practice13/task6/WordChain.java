package practice13.task6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordChain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = console.nextLine();

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNext()) {
                list.add(fileScanner.next());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
            return;
        }

        String[] words = new String[list.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = list.get(i);
        }

        StringBuilder result = getLine(words);
        if (result.length() == 0) {
            System.out.println("Составить цепочку из этих слов нельзя");
        } else {
            System.out.println(result);
        }
    }

    public static StringBuilder getLine(String[] words) {
        StringBuilder result = new StringBuilder();
        if (words.length == 0) {
            return result;
        }
        String[] chain = new String[words.length];
        boolean[] used = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            used[i] = true;
            chain[0] = words[i];
            if (buildChain(words, used, chain, 1)) {
                for (int k = 0; k < chain.length; k++) {
                    if (k > 0) {
                        result.append(' ');
                    }
                    result.append(chain[k]);
                }
                return result;
            }
            used[i] = false;
        }
        return result;
    }

    private static boolean buildChain(String[] words, boolean[] used, String[] chain, int position) {
        if (position == words.length) {
            return true;
        }
        char last = lastLetter(chain[position - 1]);
        for (int i = 0; i < words.length; i++) {
            if (!used[i] && firstLetter(words[i]) == last) {
                used[i] = true;
                chain[position] = words[i];
                if (buildChain(words, used, chain, position + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private static char firstLetter(String word) {
        return word.toLowerCase().charAt(0);
    }

    private static char lastLetter(String word) {
        return word.toLowerCase().charAt(word.length() - 1);
    }
}
