package practice14.task7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static boolean isValid(String password) {
        boolean allowed = Pattern.matches("[A-Za-z0-9_]{8,}", password);
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        return allowed && hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        if (isValid(password)) {
            System.out.println("Пароль соответствует требованиям");
        } else {
            System.out.println("Пароль не соответствует требованиям");
        }
    }
}
