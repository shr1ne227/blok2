package practice14.task1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SplitString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        Pattern separator = Pattern.compile("[\\s,;]+");
        String[] parts = separator.split(text);

        for (String part : parts) {
            if (!part.equals("")) {
                System.out.println(part);
            }
        }
    }
}
