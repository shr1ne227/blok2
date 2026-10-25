package practice10.task3;

import practice10.task1.Student;
import practice10.task2.SortingStudentsByGPA;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeStudentLists {
    public static ArrayList<Student> mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
        if (list.size() <= 1) {
            return list;
        }
        int middle = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>();
        ArrayList<Student> right = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < middle) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        return merge(mergeSort(left, comparator), mergeSort(right, comparator), comparator);
    }

    public static ArrayList<Student> merge(ArrayList<Student> a, ArrayList<Student> b, Comparator<Student> comparator) {
        ArrayList<Student> result = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.size() && bIndex < b.size()) {
            if (comparator.compare(a.get(aIndex), b.get(bIndex)) <= 0) {
                result.add(a.get(aIndex));
                aIndex++;
            } else {
                result.add(b.get(bIndex));
                bIndex++;
            }
        }
        while (aIndex < a.size()) {
            result.add(a.get(aIndex));
            aIndex++;
        }
        while (bIndex < b.size()) {
            result.add(b.get(bIndex));
            bIndex++;
        }
        return result;
    }

    public static void printList(String title, ArrayList<Student> list) {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + list.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> group1 = new ArrayList<>();
        group1.add(new Student("Иван", "Иванов", "Программная инженерия", 1, "КВБО-11-25", 4.2));
        group1.add(new Student("Пётр", "Сидоров", "Программная инженерия", 1, "КВБО-11-25", 3.7));
        group1.add(new Student("Елена", "Попова", "Программная инженерия", 1, "КВБО-11-25", 5.0));
        group1.add(new Student("Ольга", "Морозова", "Программная инженерия", 1, "КВБО-11-25", 4.4));

        ArrayList<Student> group2 = new ArrayList<>();
        group2.add(new Student("Анна", "Петрова", "Информатика", 2, "ИКБО-02-24", 4.9));
        group2.add(new Student("Алексей", "Смирнов", "Информатика", 2, "ИКБО-02-24", 3.9));
        group2.add(new Student("Мария", "Кузнецова", "Информатика", 2, "ИКБО-02-24", 4.6));

        printList("Первый список:", group1);
        printList("Второй список:", group2);

        Comparator<Student> byGpa = new SortingStudentsByGPA();
        ArrayList<Student> sorted1 = mergeSort(group1, byGpa);
        ArrayList<Student> sorted2 = mergeSort(group2, byGpa);
        ArrayList<Student> all = merge(sorted1, sorted2, byGpa);

        printList("Общий отсортированный список (по баллу, по убыванию):", all);
    }
}
