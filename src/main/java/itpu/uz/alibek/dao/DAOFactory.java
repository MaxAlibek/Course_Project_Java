
package itpu.uz.alibek.dao;

import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Footwear;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
    private static final Map<Class<?>, Object> registry = new HashMap<>();
    static {
        registry.put(Apparel.class, new ApparelCsvDAO());
        registry.put(Footwear.class, new FootwearCsvDAO());
    }
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type){ return (T) registry.get(type); }
}
