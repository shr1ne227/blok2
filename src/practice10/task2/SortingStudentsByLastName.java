package practice10.task2;

import practice10.task1.Student;

import java.util.Comparator;

public class SortingStudentsByLastName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}
