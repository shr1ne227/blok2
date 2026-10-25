package practice9.task1;

public class Student implements Comparable<Student> {
    private int id;
    private String lastName;
    private String firstName;

    public Student(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Student other) {
        if (id > other.id) {
            return 1;
        } else if (id < other.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName;
    }
}
