package practice13.task3;

public class AddressTest {
    public static void main(String[] args) {
        String[] commaAddresses = {
                "Россия, Московская область, Москва, проспект Вернадского, 78, 1, 15",
                "  Россия ,Ленинградская область,  Санкт-Петербург , Невский проспект,28 , 2 ,  101 ",
                "Беларусь, Минская область, Минск, улица Ленина, 5, 3, 12",
                "Казахстан, Алматинская область, Алматы, улица Абая, 10, 1, 7",
                "Россия, Москва, Тверская, 1"
        };
        String[] mixedAddresses = {
                "Россия; Московская область; Москва; Стромынка; 20; 1; 33",
                "Россия. Татарстан. Казань. улица Баумана. 44. 2. 8",
                "Россия, Свердловская область; Екатеринбург. улица Мира, 19; 4. 56",
                " Армения ;  Ереван ; Ереван ; улица Абовяна ; 3 ; 1 ; 9 "
        };

        System.out.println("Разбор через split() (разделитель - запятая):");
        for (int i = 0; i < commaAddresses.length; i++) {
            Address address = new Address();
            try {
                address.parseBySplit(commaAddresses[i]);
                System.out.println("  " + address);
            } catch (IllegalArgumentException e) {
                System.out.println("  Ошибка: " + e.getMessage());
            }
        }

        System.out.println("Разбор через StringTokenizer (разделители , . ;):");
        for (int i = 0; i < mixedAddresses.length; i++) {
            Address address = new Address();
            try {
                address.parseByTokenizer(mixedAddresses[i]);
                System.out.println("  " + address);
            } catch (IllegalArgumentException e) {
                System.out.println("  Ошибка: " + e.getMessage());
            }
        }
    }
}
