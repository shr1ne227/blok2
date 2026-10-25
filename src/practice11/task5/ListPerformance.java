package practice11.task5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {
    static final int SIZE = 100000;
    static final int OPERATIONS = 1000;

    public static long addToEnd(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    public static long insertToBeginning(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(0, i);
        }
        return System.nanoTime() - start;
    }

    public static long insertToMiddle(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(list.size() / 2, i);
        }
        return System.nanoTime() - start;
    }

    public static long removeFromBeginning(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATIONS; i++) {
            list.remove(0);
        }
        return System.nanoTime() - start;
    }

    public static long search(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATIONS; i++) {
            list.indexOf(SIZE - 1 - i);
        }
        return System.nanoTime() - start;
    }

    public static void printRow(String operation, long arrayTime, long linkedTime) {
        System.out.printf("%-28s %12.3f %12.3f%n", operation, arrayTime / 1000000.0, linkedTime / 1000000.0);
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.printf("%-28s %12s %12s%n", "Операция (время в мс)", "ArrayList", "LinkedList");
        printRow("Добавление в конец (" + SIZE + ")", addToEnd(arrayList), addToEnd(linkedList));
        printRow("Вставка в начало (" + OPERATIONS + ")", insertToBeginning(arrayList), insertToBeginning(linkedList));
        printRow("Вставка в середину (" + OPERATIONS + ")", insertToMiddle(arrayList), insertToMiddle(linkedList));
        printRow("Удаление из начала (" + OPERATIONS + ")", removeFromBeginning(arrayList), removeFromBeginning(linkedList));
        printRow("Поиск по образцу (" + OPERATIONS + ")", search(arrayList), search(linkedList));
    }
}
