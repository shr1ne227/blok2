package practice8.task7;

import java.util.Scanner;

public class Factorization {
    public static void factorize(int n, int divisor) {
        if (n == 1) {
            return;
        }
        if (divisor * divisor > n) {
            System.out.print(n + " ");
            return;
        }
        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            factorize(n / divisor, divisor);
        } else {
            factorize(n, divisor + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите натуральное число n > 1: ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Нужно ввести целое число: ");
        }
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println("Число должно быть больше 1");
            return;
        }
        System.out.print("Простые множители: ");
        factorize(n, 2);
        System.out.println();
    }
}
