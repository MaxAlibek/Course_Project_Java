
package itpu.uz.alibek.entity;

public class Footwear extends Product {
    private final int euSize; // EU size (e.g., 42)
    private final String type; // sneakers, boots, sandals

    public Footwear(String name, String brand, double price, String color, int euSize, String type) {
        super(name, brand, price, color);
        this.euSize = euSize;
        this.type = type;
    }
    public int getEuSize() { return euSize; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("Footwear[name='%s', brand='%s', price=%.2f, color='%s', euSize=%d, type='%s']",
                getName(), getBrand(), getPrice(), getColor(), euSize, type);
    }
}
