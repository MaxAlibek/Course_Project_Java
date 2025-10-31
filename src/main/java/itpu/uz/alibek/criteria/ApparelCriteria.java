
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Product;

public class ApparelCriteria implements SearchCriteria {
    private final String sizeEquals;
    private final String categoryEquals;
    private final String materialEquals;

    public ApparelCriteria(String sizeEquals, String categoryEquals, String materialEquals) {
        this.sizeEquals = sizeEquals;
        this.categoryEquals = categoryEquals;
        this.materialEquals = materialEquals;
    }

    @Override public boolean matches(Product p) {
        if(!(p instanceof Apparel a)) return false;
        if(sizeEquals!=null && !sizeEquals.equalsIgnoreCase(a.getSize())) return false;
        if(categoryEquals!=null && !categoryEquals.equalsIgnoreCase(a.getCategory())) return false;
        if(materialEquals!=null && !materialEquals.equalsIgnoreCase(a.getMaterial())) return false;
        return true;
    }
}
