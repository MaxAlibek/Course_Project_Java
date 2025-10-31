
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Product;

public class PriceRange implements SearchCriteria {
    private final double min, max;
    public PriceRange(double min, double max){ this.min=min; this.max=max; }
    @Override public boolean matches(Product p){ return p.getPrice()>=min && p.getPrice()<=max; }
}
