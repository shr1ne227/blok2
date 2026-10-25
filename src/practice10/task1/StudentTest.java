package practice10.task1;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("Сергей", "Орлов", "Программная инженерия", 1, "КВБО-11-25", 4.5);
        System.out.println(student);
        System.out.println("Имя: " + student.getFirstName());
        System.out.println("Фамилия: " + student.getLastName());
        System.out.println("Специальность: " + student.getSpecialty());
        System.out.println("Курс: " + student.getCourse());
        System.out.println("Группа: " + student.getGroup());
        student.setCourse(2);
        student.setGpa(4.8);
        System.out.println("После изменения курса и балла:");
        System.out.println(student);
    }
}
