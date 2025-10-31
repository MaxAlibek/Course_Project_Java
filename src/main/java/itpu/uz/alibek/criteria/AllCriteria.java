
package itpu.uz.alibek.criteria;

import itpu.uz.alibek.entity.Product;
import java.util.Arrays;
import java.util.List;

public class AllCriteria implements SearchCriteria {
    private final List<SearchCriteria> list;
    public AllCriteria(List<SearchCriteria> list){ this.list=list; }
    public static AllCriteria of(SearchCriteria... cs){ return new AllCriteria(Arrays.asList(cs)); }
    @Override public boolean matches(Product p){
        for(SearchCriteria c: list) if(!c.matches(p)) return false;
        return true;
    }
}
