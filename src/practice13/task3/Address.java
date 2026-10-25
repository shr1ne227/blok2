package practice13.task3;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    private void setParts(String[] parts) {
        if (parts.length != 7) {
            throw new IllegalArgumentException("В адресе должно быть 7 частей, а найдено " + parts.length);
        }
        country = parts[0].trim();
        region = parts[1].trim();
        city = parts[2].trim();
        street = parts[3].trim();
        house = parts[4].trim();
        building = parts[5].trim();
        apartment = parts[6].trim();
    }

    public void parseBySplit(String address) {
        setParts(address.split(","));
    }

    public void parseByTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;");
        String[] parts = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            parts[i] = tokenizer.nextToken();
            i++;
        }
        setParts(parts);
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Страна: '" + country + "', регион: '" + region + "', город: '" + city
                + "', улица: '" + street + "', дом: '" + house + "', корпус: '" + building
                + "', квартира: '" + apartment + "'";
    }
}
