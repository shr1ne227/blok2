package practice13.task2;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Иванов", "Иван", "Иванович"),
                new Person("Петрова", "Анна", null),
                new Person("Сидоров", "", "Петрович"),
                new Person("Кузнецов")
        };
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].getShortName());
        }
    }
}
