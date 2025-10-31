
package itpu.uz.alibek.dao;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.entity.Product;
import itpu.uz.alibek.exception.DataAccessException;

import java.util.List;

public interface ProductDAO<T extends Product> {
    List<T> find(SearchCriteria criteria) throws DataAccessException;
    List<T> findAll() throws DataAccessException;
}
