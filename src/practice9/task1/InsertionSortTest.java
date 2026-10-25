package practice9.task1;

public class InsertionSortTest {
    public static void insertionSort(Student[] list) {
        for (int i = 1; i < list.length; i++) {
            Student toInsert = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(toInsert) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = toInsert;
        }
    }

    public static void printArray(Student[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println("  " + list[i]);
        }
    }

    public static void main(String[] args) {
        Student[] iDNumber = {
                new Student(1045, "Иванов", "Иван"),
                new Student(1012, "Петрова", "Анна"),
                new Student(1078, "Сидоров", "Пётр"),
                new Student(1003, "Кузнецова", "Мария"),
                new Student(1056, "Смирнов", "Алексей"),
                new Student(1021, "Попова", "Елена")
        };
        System.out.println("До сортировки:");
        printArray(iDNumber);
        insertionSort(iDNumber);
        System.out.println("После сортировки вставками по номеру:");
        printArray(iDNumber);
    }
}
