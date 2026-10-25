package practice10.task2;

import practice10.task1.Student;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber;

    @Override
    public int compare(Student a, Student b) {
        if (a.getGpa() < b.getGpa()) {
            return 1;
        } else if (a.getGpa() > b.getGpa()) {
            return -1;
        } else {
            return 0;
        }
    }

    public void setArray() {
        iDNumber = new Student[7];
        iDNumber[0] = new Student("Иван", "Иванов", "Программная инженерия", 1, "КВБО-11-25", 4.2);
        iDNumber[1] = new Student("Анна", "Петрова", "Информатика", 2, "ИКБО-02-24", 4.9);
        iDNumber[2] = new Student("Пётр", "Сидоров", "Программная инженерия", 1, "КВБО-11-25", 3.7);
        iDNumber[3] = new Student("Мария", "Кузнецова", "Прикладная математика", 3, "КМБО-05-23", 4.6);
        iDNumber[4] = new Student("Алексей", "Смирнов", "Информатика", 2, "ИКБО-02-24", 3.9);
        iDNumber[5] = new Student("Елена", "Попова", "Программная инженерия", 1, "КВБО-11-25", 5.0);
        iDNumber[6] = new Student("Дмитрий", "Волков", "Прикладная математика", 3, "КМБО-05-23", 4.1);
    }

    public void outArray() {
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println("  " + iDNumber[i]);
        }
    }

    public void quickSort() {
        quickSort(this);
    }

    public void quickSort(Comparator<Student> comparator) {
        quickSort(0, iDNumber.length - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator<Student> comparator) {
        if (low >= high) {
            return;
        }
        Student pivot = iDNumber[(low + high) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(iDNumber[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(iDNumber[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(low, j, comparator);
        quickSort(i, high, comparator);
    }

    public void mergeSort() {
        mergeSort(this);
    }

    public void mergeSort(Comparator<Student> comparator) {
        mergeSort(0, iDNumber.length - 1, comparator);
    }

    private void mergeSort(int left, int right, Comparator<Student> comparator) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(left, middle, comparator);
        mergeSort(middle + 1, right, comparator);
        merge(left, middle, right, comparator);
    }

    private void merge(int left, int middle, int right, Comparator<Student> comparator) {
        Student[] temp = new Student[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (comparator.compare(iDNumber[i], iDNumber[j]) <= 0) {
                temp[k] = iDNumber[i];
                i++;
            } else {
                temp[k] = iDNumber[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = iDNumber[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = iDNumber[j];
            j++;
            k++;
        }
        for (k = 0; k < temp.length; k++) {
            iDNumber[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray();
        System.out.println("Исходный массив:");
        sorter.outArray();

        sorter.quickSort();
        System.out.println("Быстрая сортировка по баллу (по убыванию):");
        sorter.outArray();

        sorter.setArray();
        sorter.mergeSort();
        System.out.println("Сортировка слиянием по баллу (по убыванию):");
        sorter.outArray();

        sorter.quickSort(new SortingStudentsByLastName());
        System.out.println("Быстрая сортировка по фамилии:");
        sorter.outArray();
    }
}
