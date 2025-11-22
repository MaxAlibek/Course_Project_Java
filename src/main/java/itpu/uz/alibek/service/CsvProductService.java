package itpu.uz.alibek.service;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.dao.ProductDAO;
import itpu.uz.alibek.entity.Product;
import itpu.uz.alibek.exception.DataAccessException;

import java.util.List;

/**
 * Default implementation of {@link ProductService} that uses a {@link ProductDAO}
 * as a data source (CSV files in this project).
 */
public class CsvProductService<T extends Product> implements ProductService<T> {

    private final ProductDAO<T> dao;

    public CsvProductService(ProductDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public List<T> find(SearchCriteria criteria) throws ServiceException {
        try {
            return dao.find(criteria);
        } catch (DataAccessException e) {
            throw new ServiceException("Failed to search products", e);
        }
    }

    @Override
    public List<T> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Failed to load all products", e);
        }
    }

    @Override
    public double totalCost(SearchCriteria criteria) throws ServiceException {
        List<T> products;
        if (criteria == null) {
            products = findAll();
        } else {
            products = find(criteria);
        }
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
