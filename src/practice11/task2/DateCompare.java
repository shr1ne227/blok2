package practice11.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateCompare {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat full = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Date now = new Date();
        System.out.println("Текущее системное время: " + full.format(now));

        Scanner sc = new Scanner(System.in);
        Date userDate = null;
        while (userDate == null) {
            System.out.print("Введите дату в формате дд.мм.гггг: ");
            String text = sc.next();
            try {
                Date parsed = sdf.parse(text);
                if (sdf.format(parsed).equals(text)) {
                    userDate = parsed;
                } else {
                    System.out.println("Такой даты не существует, попробуйте ещё раз");
                }
            } catch (ParseException e) {
                System.out.println("Неверная дата, попробуйте ещё раз");
            }
        }

        Date today;
        try {
            today = sdf.parse(sdf.format(now));
        } catch (ParseException e) {
            today = now;
        }

        if (userDate.before(today)) {
            System.out.println(sdf.format(userDate) + " раньше сегодняшней даты " + sdf.format(today));
        } else if (userDate.after(today)) {
            System.out.println(sdf.format(userDate) + " позже сегодняшней даты " + sdf.format(today));
        } else {
            System.out.println("Введённая дата совпадает с сегодняшней");
        }
    }
}
