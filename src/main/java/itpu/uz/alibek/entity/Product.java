
package itpu.uz.alibek.entity;

public abstract class Product {
    private final String name;
    private final String brand;
    private final double price;
    private final String color;

    protected Product(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return String.format("Product[name='%s', brand='%s', price=%.2f, color='%s']",
                name, brand, price, color);
    }
}
