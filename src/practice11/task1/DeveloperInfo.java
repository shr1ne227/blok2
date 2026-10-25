package practice11.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DeveloperInfo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Calendar received = Calendar.getInstance();
        received.set(Calendar.YEAR, 2026);
        received.set(Calendar.MONTH, Calendar.OCTOBER);
        received.set(Calendar.DAY_OF_MONTH, 25);
        received.set(Calendar.HOUR_OF_DAY, 9);
        received.set(Calendar.MINUTE, 0);
        received.set(Calendar.SECOND, 0);

        Date submitted = new Date();

        System.out.println("Разработчик: Дубовецкий");
        System.out.println("Задание получено: " + sdf.format(received.getTime()));
        System.out.println("Задание сдано:    " + sdf.format(submitted));
    }
}
