package practice14.task2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExactString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        Pattern expected = Pattern.compile("abcdefghijklmnopqrstuv18340");
        boolean correct = expected.matcher(text).matches();
        System.out.println(correct);
    }
}
