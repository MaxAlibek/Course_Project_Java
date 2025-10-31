
package itpu.uz.alibek.dao;

import itpu.uz.alibek.criteria.SearchCriteria;
import itpu.uz.alibek.entity.Product;
import itpu.uz.alibek.exception.DataAccessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCsvDAO<T extends Product> implements ProductDAO<T> {

    private final String resourcePath;

    protected AbstractCsvDAO(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    protected abstract T parse(String[] parts) throws IllegalArgumentException;

    @Override
    public List<T> find(SearchCriteria criteria) throws DataAccessException {
        List<T> res = new ArrayList<>();
        for(T t: findAll()) if(criteria.matches(t)) res.add(t);
        return res;
    }

    @Override
    public List<T> findAll() throws DataAccessException {
        try (InputStream in = getClass().getResourceAsStream(resourcePath)) {
            if (in == null) throw new DataAccessException("Resource not found: " + resourcePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                List<T> list = new ArrayList<>();
                String line;
                boolean header = true;
                while ((line = br.readLine()) != null) {
                    if (header) { header = false; continue; }
                    if (line.isBlank()) continue;
                    String[] parts = line.split("[;,]");
                    list.add(parse(parts));
                }
                return list;
            }
        } catch (IOException | IllegalArgumentException e) {
            throw new DataAccessException("Failed to read " + resourcePath, e);
        }
    }
}
