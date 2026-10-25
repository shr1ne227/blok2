package practice8.task9;

import java.util.Scanner;

public class NoTwoZeros {
    public static int count(int zeros, int ones, boolean lastIsZero) {
        if (zeros == 0 && ones == 0) {
            return 1;
        }
        int result = 0;
        if (zeros > 0 && !lastIsZero) {
            result += count(zeros - 1, ones, true);
        }
        if (ones > 0) {
            result += count(zeros, ones - 1, false);
        }
        return result;
    }

    public static int readNumber(Scanner sc, String question) {
        System.out.print(question);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Нужно ввести целое число: ");
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = readNumber(sc, "Введите количество нулей a: ");
        int b = readNumber(sc, "Введите количество единиц b: ");
        if (a < 0 || b < 0) {
            System.out.println("Числа не могут быть отрицательными");
            return;
        }
        System.out.println("Количество последовательностей: " + count(a, b, false));
    }
}
