
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Footwear;
import itpu.uz.alibek.entity.Product;

public class FootwearCriteria implements SearchCriteria {
    private final Integer euSizeEquals;
    private final String typeEquals;

    public FootwearCriteria(Integer euSizeEquals, String typeEquals) {
        this.euSizeEquals = euSizeEquals;
        this.typeEquals = typeEquals;
    }

    @Override public boolean matches(Product p) {
        if(!(p instanceof Footwear f)) return false;
        if(euSizeEquals!=null && !euSizeEquals.equals(f.getEuSize())) return false;
        if(typeEquals!=null && !typeEquals.equalsIgnoreCase(f.getType())) return false;
        return true;
    }
}
