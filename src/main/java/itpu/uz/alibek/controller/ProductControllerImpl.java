package itpu.uz.alibek.controller;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.entity.Product;
import itpu.uz.alibek.service.ProductService;
import itpu.uz.alibek.service.ServiceException;

import java.util.List;

/**
 * Default implementation of {@link ProductController} that simply delegates to a {@link ProductService}.
 */
public class ProductControllerImpl<T extends Product> implements ProductController<T> {

    private final ProductService<T> service;

    public ProductControllerImpl(ProductService<T> service) {
        this.service = service;
    }

    @Override
    public List<T> listAll() throws ControllerException {
        try {
            return service.findAll();
        } catch (ServiceException e) {
            throw new ControllerException("Failed to load products", e);
        }
    }

    @Override
    public List<T> find(SearchCriteria criteria) throws ControllerException {
        try {
            return service.find(criteria);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to search products", e);
        }
    }

    @Override
    public double totalCost(SearchCriteria criteria) throws ControllerException {
        try {
            return service.totalCost(criteria);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to calculate total cost", e);
        }
    }
}
