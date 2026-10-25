package practice13.task1;

public class StringMethods {
    public static void processString(String s) {
        System.out.println("Исходная строка: " + s);
        System.out.println("Последний символ: " + s.charAt(s.length() - 1));
        System.out.println("Заканчивается на \"!!!\": " + s.endsWith("!!!"));
        System.out.println("Начинается с \"I like\": " + s.startsWith("I like"));
        System.out.println("Содержит \"Java\": " + s.contains("Java"));
        int position = s.indexOf("Java");
        System.out.println("Позиция \"Java\": " + position);
        System.out.println("Замена 'a' на 'o': " + s.replace('a', 'o'));
        System.out.println("Верхний регистр: " + s.toUpperCase());
        System.out.println("Нижний регистр: " + s.toLowerCase());
        if (position != -1) {
            System.out.println("Вырезанная подстрока: " + s.substring(position, position + 4));
        }
    }

    public static void main(String[] args) {
        processString("I like Java!!!");
    }
}
