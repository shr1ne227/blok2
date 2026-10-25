package practice11.task4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFromInput {
    public static int readNumber(Scanner sc, String question, int min, int max) {
        System.out.print(question);
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number >= min && number <= max) {
                    return number;
                }
            } else {
                sc.next();
            }
            System.out.print("Введите число от " + min + " до " + max + ": ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = readNumber(sc, "Год: ", 1, 9999);
        int month = readNumber(sc, "Месяц (1-12): ", 1, 12);
        int day = readNumber(sc, "Число: ", 1, 31);
        int hours = readNumber(sc, "Часы (0-23): ", 0, 23);
        int minutes = readNumber(sc, "Минуты (0-59): ", 0, 59);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Объект Date: " + sdf.format(date));
        System.out.println("Date.toString(): " + date);
        System.out.printf("Объект Calendar: год %d, месяц %d, число %d, %02d:%02d%n",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
    }
}
