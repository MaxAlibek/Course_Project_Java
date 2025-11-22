package itpu.uz.alibek.controller;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.entity.Product;

import java.util.List;

/**
 * Thin layer between the UI (Console, Web, etc.) and the service layer.
 * It converts service exceptions to controller level exceptions and
 * exposes high level use-cases like "find" and "cost".
 */
public interface ProductController<T extends Product> {

    /**
     * Returns all products from the underlying data source.
     */
    List<T> listAll() throws ControllerException;

    /**
     * Finds products by the given criteria.
     */
    List<T> find(SearchCriteria criteria) throws ControllerException;

    /**
     * Calculates the total cost of all products that match the given criteria.
     * Mirrors the optional "cost" command from the assignment.
     */
    double totalCost(SearchCriteria criteria) throws ControllerException;
}
