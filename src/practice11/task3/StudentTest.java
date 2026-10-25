package practice11.task3;

import java.util.Calendar;

public class StudentTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2006);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.DAY_OF_MONTH, 14);
        Student student = new Student("Сергей", "Орлов", "КВБО-11-25", cal.getTime());

        System.out.println(student);
        System.out.println("Короткий формат: " + student.formatBirthDate(Student.SHORT));
        System.out.println("Средний формат:  " + student.formatBirthDate(Student.MEDIUM));
        System.out.println("Полный формат:   " + student.formatBirthDate(Student.FULL));
    }
}
