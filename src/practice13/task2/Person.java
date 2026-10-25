package practice13.task2;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Person(String lastName) {
        this(lastName, null, null);
    }

    private static boolean hasValue(String s) {
        return s != null && !s.isEmpty();
    }

    public String getShortName() {
        StringBuilder sb = new StringBuilder(lastName);
        if (hasValue(firstName)) {
            sb.append(' ').append(firstName.charAt(0)).append('.');
        }
        if (hasValue(middleName)) {
            if (!hasValue(firstName)) {
                sb.append(' ');
            }
            sb.append(middleName.charAt(0)).append('.');
        }
        return sb.toString();
    }
}
