package practice13.task5;

public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(String phone) {
        if (phone.startsWith("+") && phone.length() > 11) {
            countryCode = phone.substring(1, phone.length() - 10);
            number = phone.substring(phone.length() - 10);
        } else if (phone.startsWith("8") && phone.length() == 11) {
            countryCode = "7";
            number = phone.substring(1);
        } else {
            throw new IllegalArgumentException("Неверный формат номера: " + phone);
        }
    }

    public String format() {
        return "+" + countryCode + number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
    }

    public static void main(String[] args) {
        String[] phones = {"+79175655655", "+104289652211", "89175655655", "12345"};
        for (int i = 0; i < phones.length; i++) {
            try {
                PhoneNumber phone = new PhoneNumber(phones[i]);
                System.out.println(phones[i] + " -> " + phone.format());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
