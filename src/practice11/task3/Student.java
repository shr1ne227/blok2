package practice11.task3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    public static final String SHORT = "dd.MM.yy";
    public static final String MEDIUM = "d MMM yyyy";
    public static final String FULL = "EEEE, d MMMM yyyy";

    private String firstName;
    private String lastName;
    private String group;
    private Date birthDate;

    public Student(String firstName, String lastName, String group, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String formatBirthDate(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(birthDate);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", группа " + group
                + ", дата рождения " + formatBirthDate(MEDIUM);
    }
}
