package itpu.uz.alibek.controller;

import itpu.uz.alibek.entity.Product;
import itpu.uz.alibek.service.ProductService;
import itpu.uz.alibek.service.ServiceFactory;

/**
 * Factory for controller instances. In real projects this responsibility
 * is usually taken by a DI container, but here we keep it explicit.
 */
public final class ControllerFactory {

    private ControllerFactory() {
    }

    public static <T extends Product> ProductController<T> createController(Class<T> productType) {
        ProductService<T> service = ServiceFactory.getService(productType);
        return new ProductControllerImpl<>(service);
    }
}
