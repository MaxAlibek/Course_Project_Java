package itpu.uz.alibek.service;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.entity.Product;

import java.util.List;

public interface ProductService<T extends Product> {

    /**
     * Returns all products that match the given criteria.
     *
     * @param criteria search criteria, must not be {@code null}
     */
    List<T> find(SearchCriteria criteria) throws ServiceException;

    /**
     * Returns all products from the underlying data source.
     */
    List<T> findAll() throws ServiceException;

    /**
     * Calculates the total cost of all products that match the given criteria.
     * This corresponds to the optional "cost" command from the assignment.
     *
     * @param criteria search criteria, if {@code null} the cost of all products is returned
     */
    double totalCost(SearchCriteria criteria) throws ServiceException;
}
