package practice13.task4;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Артикул: " + id + "\n"
                + "Описание: " + description + "\n"
                + "Цвет: " + color + "\n"
                + "Размер: " + size + "\n";
    }
}
