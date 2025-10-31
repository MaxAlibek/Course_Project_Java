
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Product;

public interface SearchCriteria {
    boolean matches(Product p);
}
