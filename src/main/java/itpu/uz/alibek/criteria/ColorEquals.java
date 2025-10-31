
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Product;

public class ColorEquals implements SearchCriteria {
    private final String color;
    public ColorEquals(String color){ this.color = color; }
    @Override public boolean matches(Product p){ return p.getColor().equalsIgnoreCase(color); }
}
