
package itpu.uz.alibek.entity;

public class Apparel extends Product {
    private final String size; // S,M,L,XL or numeric
    private final String material; // cotton, wool, etc.
    private final String category; // t-shirt, hoodie, jeans, etc.

    public Apparel(String name, String brand, double price, String color, String size, String material, String category) {
        super(name, brand, price, color);
        this.size = size;
        this.material = material;
        this.category = category;
    }
    public String getSize() { return size; }
    public String getMaterial() { return material; }
    public String getCategory() { return category; }
}
