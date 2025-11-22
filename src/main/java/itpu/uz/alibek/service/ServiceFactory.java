package itpu.uz.alibek.service;

import itpu.uz.alibek.dao.ApparelCsvDAO;
import itpu.uz.alibek.dao.FootwearCsvDAO;
import itpu.uz.alibek.dao.ProductDAO;
import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Footwear;
import itpu.uz.alibek.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple registry-based factory for service objects.
 * It hides the wiring between DAO and Service layers.
 */
public final class ServiceFactory {

    private static final Map<Class<? extends Product>, ProductService<?>> registry = new HashMap<>();

    static {
        // In a bigger application this wiring could be done via DI container.
        register(Apparel.class, new CsvProductService<>(new ApparelCsvDAO()));
        register(Footwear.class, new CsvProductService<>(new FootwearCsvDAO()));
    }

    private ServiceFactory() {
    }

    private static <T extends Product> void register(Class<T> type, ProductService<T> service) {
        registry.put(type, service);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Product> ProductService<T> getService(Class<T> productType) {
        ProductService<?> service = registry.get(productType);
        if (service == null) {
            throw new IllegalArgumentException("No service registered for " + productType);
        }
        return (ProductService<T>) service;
    }
}
